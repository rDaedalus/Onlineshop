package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Result;

import model.Product;
import net.proteanit.sql.DbUtils;

public class DataManager {
	Connection connection;
	PreparedStatement pst;
	ResultSet rs;

	public Connection connectDb() {

		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/onlineshop";
			String username = "Daedalus";
			String password = "1Casiowatch";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, username, password);
		} catch (ClassNotFoundException | SQLException e) {

		}
		return connection;

	}

	public String prepAdd(Connection con, Product product) {
		try {

			pst = con
					.prepareStatement("insert into product(product_name,product_price,product_qnty)values(?,?,?)");
			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getProductPrice());
			pst.setInt(3, product.getQnty());

			int k = pst.executeUpdate();
			if (k == 1) {
				JOptionPane.showMessageDialog(null, "Record Addedd");

			} else {
				JOptionPane.showMessageDialog(null, "Record not Added");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public String prepUpdate(Connection con, Product product) {

		try {

			pst = con
					.prepareStatement(
							"update product set product_name= ?,product_price=?,product_qnty=? where product_id =?");

			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getProductPrice());
			pst.setInt(3, product.getQnty());
			pst.setInt(4, product.getProductId());
			int k = pst.executeUpdate();
			if (k == 1) {
				JOptionPane.showMessageDialog(null, "Record Update");

			} else {
				JOptionPane.showMessageDialog(null, "Record not Updated");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public String prepDelete(Connection con, Product product) {

		try {

			pst = con
					.prepareStatement("delete from product where product_id =?");
			pst.setInt(1, product.getProductId());
			int k = pst.executeUpdate();
			if (k == 1) {
				JOptionPane.showMessageDialog(null, "Record Delete");

			} else {
				JOptionPane.showMessageDialog(null, "Record not Delete");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public TableModel table_load(Connection con) {
		try {
			pst = con.prepareStatement("select * from product");
			rs = pst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DbUtils.resultSetToTableModel(rs);
	}

	public Product prepSearch(Connection con, Product product) {
		Product p1 = new Product();
		try {

			pst = con
					.prepareStatement("select product_name,product_price,product_qnty from product where product_id = ?");
			
			pst.setInt(1, product.getProductId());
			rs = pst.executeQuery();

			if (rs.next() == true) {
				p1.setProductName(rs.getString(1));
				p1.setProductPrice(rs.getInt(2));
				p1.setQnty(rs.getInt(3));
			} else {
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return p1;

	}

}
