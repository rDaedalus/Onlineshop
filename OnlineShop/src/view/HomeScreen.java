package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.DataManager;
import model.Product;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class HomeScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField proNameTxtbox;
	private JTextField proIdTxtbox;
	private JTextField proPriceTxtbox;
	private JTextField qntyTxtbox;
	Connection connection = null;
	DataManager dataManager = new DataManager();

	public HomeScreen() {
		connection = dataManager.connectDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 941, 446);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Inventory");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel.setBounds(10, 0, 198, 59);
		panel.add(lblNewLabel);

		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(220, 310, 89, 23);
		panel.add(searchBtn);

		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(121, 310, 89, 23);
		panel.add(updateBtn);

		table = new JTable();
		table.setBounds(394, 35, 489, 367);
		panel.add(table);

		JLabel lblNewLabel_1 = new JLabel("Product Information");
		lblNewLabel_1.setBounds(20, 70, 153, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Product Name");
		lblNewLabel_2.setBounds(35, 110, 89, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Product ID");
		lblNewLabel_3.setBounds(20, 344, 76, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(35, 160, 46, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Qty");
		lblNewLabel_5.setBounds(35, 191, 46, 14);
		panel.add(lblNewLabel_5);

		proNameTxtbox = new JTextField();
		proNameTxtbox.setBounds(121, 107, 89, 20);
		panel.add(proNameTxtbox);
		proNameTxtbox.setColumns(10);

		proIdTxtbox = new JTextField();
		proIdTxtbox.setBounds(106, 341, 86, 20);
		panel.add(proIdTxtbox);
		proIdTxtbox.setColumns(10);

		proPriceTxtbox = new JTextField();
		proPriceTxtbox.setBounds(121, 157, 86, 20);
		panel.add(proPriceTxtbox);
		proPriceTxtbox.setColumns(10);

		qntyTxtbox = new JTextField();
		qntyTxtbox.setBounds(122, 188, 86, 20);
		panel.add(qntyTxtbox);
		qntyTxtbox.setColumns(10);

		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(122, 367, 89, 23);
		panel.add(deleteBtn);

		JButton AddBttn = new JButton("Add");
		AddBttn.setBounds(22, 310, 89, 23);
		panel.add(AddBttn);
		AddBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = new Product();
				product.setProductName(proNameTxtbox.getText());
				product.setProductPrice(Integer.parseInt(proPriceTxtbox.getText()));
				product.setQnty(Integer.parseInt(qntyTxtbox.getText()));
				dataManager.prepAdd(connection, product);

			}
		});

	}
}
