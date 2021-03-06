package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.Clothing;
import modelLayer.Equipment;
import modelLayer.GunReplica;
import modelLayer.Product;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DBProduct implements IFDBProduct {

	private Connection con;

	public DBProduct() {
		con = DBConnection.getInstance().getDBCon();
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		return miscWhere("hidden = 0", "");
	}

	@Override
	public ArrayList<Product> searchProduct(String name) {
		return miscWhere("hidden = 0 AND name LIKE '%" + name + "%'", "");
	}

	@Override
	public Product getProductByID(int id) {
		return singleWhere("p.productID = " + id, "");
	}

	@Override
	public int insertProduct(Product product) throws Exception {
		int rc = -1;
		try {
			DBConnection.startTransaction();
			String type = null;
			String exQuery = "";
			String att1 = null;
			String att2 = null;
			if (product instanceof Equipment) {
				type = "Equipment";
				exQuery = "type, description)";
				att1 = ((Equipment) product).getType();
				att2 = ((Equipment) product).getDescription();
			} else if (product instanceof Clothing) {
				type = "Clothing";
				exQuery = "size, colour)";
				att1 = ((Clothing) product).getSize();
				att2 = ((Clothing) product).getColour();
			} else if (product instanceof GunReplica) {
				type = "GunReplica";
				exQuery = "fabric, calibre)";
				att1 = ((GunReplica) product).getFabric();
				att2 = ((GunReplica) product).getCalibre();
			}
			String query = "INSERT INTO PRODUCT "
					+ "(name, stock, purchasePrice, salesPrice, rentPrice, countryOrigin, minStock, supplierID, hidden, type) VALUES "
					+ "(?,    ?,     ?,             ?,          ?,         ?,             ?,        ?,          ?,      ?);";

			PreparedStatement stmt = con.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setQueryTimeout(5);
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getStock());
			stmt.setDouble(3, product.getPurchasePrice());
			stmt.setDouble(4, product.getSalesPrice());
			stmt.setDouble(5, product.getRentPrice());
			stmt.setString(6, product.getCountryOrigin());
			stmt.setInt(7, product.getMinStock());
			if (product.getSupplier() != null) {
				stmt.setInt(8, product.getSupplier().getId());
			} else {
				stmt.setNull(8, java.sql.Types.NULL);
			}
			stmt.setBoolean(9, product.isHidden());
			stmt.setString(10, type);
			rc = stmt.executeUpdate();
			ResultSet genRs = stmt.getGeneratedKeys();
			if (genRs.next()) {
				product.setId(genRs.getInt(1));
				if (!exQuery.isEmpty()) {
					exQuery = "INSERT INTO " + type + "(productID, " + exQuery
							+ " VALUES (?, ?, ?)";
					PreparedStatement stmt2 = con.prepareStatement(exQuery);
					stmt2.setInt(1, product.getId());
					stmt2.setString(2, att1);
					stmt2.setString(3, att2);
					rc += stmt2.executeUpdate();
					stmt2.close();
				}
			}
			stmt.close();
			DBConnection.commitTransaction();
		} catch (Exception e) {
			System.out.println("Error in inserting product - " + e);
			DBConnection.rollBackTransaction();
			e.printStackTrace();
		}
		return rc;
	}

	@Override
	public int updateProduct(Product product) {
		int rc = -1;
		try {

			String type = null;
			String exQuery = "";
			String att1 = null;
			String att2 = null;

			if (product instanceof Equipment) {
				type = "Equipment";
				exQuery = "type = ?, description = ?";
				att1 = ((Equipment) product).getType();
				att2 = ((Equipment) product).getDescription();
			} else if (product instanceof GunReplica) {
				type = "GunReplica";
				exQuery = "fabric = ?, calibre = ?";
				att1 = ((GunReplica) product).getFabric();
				att2 = ((GunReplica) product).getCalibre();
			} else if (product instanceof Clothing) {
				type = "Clothing";
				exQuery = "size = ?, colour = ?";
				att1 = ((Clothing) product).getSize();
				att2 = ((Clothing) product).getColour();
			}

			String query = "UPDATE PRODUCT SET" + " name = ?," + " stock = ?,"
					+ " purchasePrice = ?," + " salesPrice = ?,"
					+ " rentPrice = ?," + " countryOrigin = ?,"
					+ " minStock = ?," + " supplierID = ?," + " hidden = ?"
					+ " WHERE productID = ?; ";

			String query2 = " UPDATE " + type + " SET " + exQuery
					+ " WHERE productID = ?";

			if (type != null) {
				query += query2;
			}
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setQueryTimeout(5);
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getStock());
			stmt.setDouble(3, product.getPurchasePrice());
			stmt.setDouble(4, product.getSalesPrice());
			stmt.setDouble(5, product.getRentPrice());
			stmt.setString(6, product.getCountryOrigin());
			stmt.setInt(7, product.getMinStock());
			if (product.getSupplier() != null) {
				stmt.setInt(8, product.getSupplier().getId());
			} else {
				stmt.setNull(8, java.sql.Types.NULL);
			}
			stmt.setBoolean(9, product.isHidden());
			stmt.setInt(10, product.getId());
			if (type != null) {
				stmt.setString(11, att1);
				stmt.setString(12, att2);
				stmt.setInt(13, product.getId());
			}

			rc = stmt.executeUpdate();
			stmt.close();

		} catch (Exception e) {
			System.out.println("Error in update product - " + e);
			e.printStackTrace();
		}

		return rc;
	}

	@Override
	public int removeProduct(Product product) {
		int rp = -1;
		// String type = "";
		try {
			String query = "DELETE FROM PRODUCT WHERE productID = "
					+ product.getId() + "; ";
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rp = stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLServerException e) {
			// 547 foreign key error
			if (e.getErrorCode() == 547) {
				product.setHidden(true);
				rp = updateProduct(product);
				System.out.println("Product is now hidden");
			} else {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Delete exception in product table: " + e);
		}
		return rp;
	}

	private ArrayList<Product> miscWhere(String wQuery, String type) {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			String query = buildQuery(wQuery, type);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Product prod = buildProduct(rs);
				if (prod != null) {
					products.add(prod);
				}
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return products;
	}

	private Product singleWhere(String wQuery, String type) {
		Product product = null;
		try {
			String query = buildQuery(wQuery, type);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				product = buildProduct(rs);
			}

		} catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return product;
	}

	private Product buildProduct(ResultSet rs) {
		Product retP = null;
		try {
			String type = rs.getString("type");
			if (type == null) {
				type = "N/A";
			}
			if (type.equalsIgnoreCase("GunReplica")) {
				GunReplica product = new GunReplica();
				product.setCalibre(rs.getString("calibre"));
				product.setFabric(rs.getString("fabric"));
				retP = product;
			} else if (type.equalsIgnoreCase("Equipment")) {
				Equipment product = new Equipment();
				product.setType(rs.getString("type"));
				product.setDescription(rs.getString("description"));
				retP = product;
			} else if (type.equalsIgnoreCase("Clothing")) {
				Clothing product = new Clothing();
				product.setSize(rs.getString("size"));
				product.setColour(rs.getString("colour"));
				retP = product;

			} else {
				Product product = new Product();
				retP = product;
			}
			retP.setId(rs.getInt("productID"));
			retP.setName(rs.getString("name"));
			retP.setCountryOrigin(rs.getString("countryOrigin"));
			retP.setHidden(rs.getBoolean("hidden"));
			retP.setMinStock(rs.getInt("minStock"));
			retP.setPurchasePrice(rs.getDouble("purchasePrice"));
			retP.setRentPrice(rs.getDouble("rentPrice"));
			retP.setSalesPrice(rs.getDouble("salesPrice"));
			retP.setStock(rs.getInt("stock"));
		} catch (Exception e) {
			System.out.println("Error in building product - " + e);
			e.printStackTrace();
		}
		return retP;
	}

	private String buildQuery(String wQuery, String type) {
		String query = "SELECT p.*";
		String query2 = "";
		if (type.equalsIgnoreCase("Clothing")) {
			query += ", c.size, c.colour";
			query2 = " left join CLOTHING c on p.productID = c.productID";

		} else if (type.equalsIgnoreCase("Equipment")) {
			query += ", e.type, e.description";
			query2 = " left join EQUIPMENT e on p.productID = e.productID";
		} else if (type.equalsIgnoreCase("GunReplica")) {
			query += ", g.fabric, g.calibre";
			query2 = " left join GUNREPLICA g on p.productID = g.productID";
		} else if (type.isEmpty()) {
			query += ", c.size, c.colour, e.type, e.description, g.fabric, g.calibre";
			query2 = " left join CLOTHING c on p.productID = c.productID"
					+ " left join EQUIPMENT e on p.productID = e.productID"
					+ " left join GUNREPLICA g on p.productID = g.productID";
		}

		query += " FROM PRODUCT p " + query2;
		if (!wQuery.isEmpty() || !type.isEmpty()) {
			query += " WHERE ";
		}

		if (!wQuery.isEmpty()) {
			query += " " + wQuery;
		}
		if (!type.isEmpty()) {
			if (!wQuery.isEmpty()) {
				query += " AND";
			}
			if (type.equals("N/A")) {
				query += " p.type is null";
			} else {
				query += " p.type = '" + type + "'";
			}

		}

		// System.out.println(type + "= " + query);
		return query;
	}

	@Override
	public ArrayList<Product> getProductsByType(String type) {

		return miscWhere("", type);
	}
}
