package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Product;

public class DataManager {
	Connection connection;
	PreparedStatement pst;

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
}
