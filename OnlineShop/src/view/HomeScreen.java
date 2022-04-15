package view;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class HomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField proNameTxtbox;
	private JTextField proIdTxtbox;
	private JTextField proPriceTxtbox;
	private JTextField qntyTxtbox;
	Connection connection = null;
	DataManager dataManager = new DataManager();
	private JTable table;

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

	

		JButton updateBtn = new JButton("Update");

		updateBtn.setBounds(47, 384, 89, 23);
		panel.add(updateBtn);

		JLabel lblNewLabel_1 = new JLabel("Product Information");
		lblNewLabel_1.setBounds(20, 70, 153, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Product Name");
		lblNewLabel_2.setBounds(10, 113, 89, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Product ID");
		lblNewLabel_3.setBounds(10, 359, 76, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(20, 138, 46, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Qty");
		lblNewLabel_5.setBounds(20, 163, 46, 14);
		panel.add(lblNewLabel_5);

		proNameTxtbox = new JTextField();
		proNameTxtbox.setBounds(119, 110, 89, 20);
		panel.add(proNameTxtbox);
		proNameTxtbox.setColumns(10);

		proIdTxtbox = new JTextField();
		proIdTxtbox.setBounds(119, 356, 86, 20);
		panel.add(proIdTxtbox);
		proIdTxtbox.setColumns(10);

		proPriceTxtbox = new JTextField();
		proPriceTxtbox.setBounds(119, 135, 86, 20);
		panel.add(proPriceTxtbox);
		proPriceTxtbox.setColumns(10);

		qntyTxtbox = new JTextField();
		qntyTxtbox.setBounds(119, 160, 86, 20);
		panel.add(qntyTxtbox);
		qntyTxtbox.setColumns(10);

		JButton deleteBtn = new JButton("Delete");

		deleteBtn.setBounds(119, 198, 89, 23);
		panel.add(deleteBtn);

		JButton AddBttn = new JButton("Add");
		AddBttn.setBounds(10, 198, 89, 23);
		panel.add(AddBttn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 70, 489, 348);
		panel.add(scrollPane);

		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(dataManager.table_load(connection));
		AddBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = new Product();
				product.setProductName(proNameTxtbox.getText());
				product.setProductPrice(Integer.parseInt(proPriceTxtbox.getText()));
				product.setQnty(Integer.parseInt(qntyTxtbox.getText()));
				dataManager.prepAdd(connection, product);
				table.setModel(dataManager.table_load(connection));
			}
		});

		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = new Product();
				product.setProductName(proNameTxtbox.getText());
				product.setProductPrice(Integer.parseInt(proPriceTxtbox.getText()));
				product.setQnty(Integer.parseInt(qntyTxtbox.getText()));
				product.setProductId(Integer.parseInt(proIdTxtbox.getText()));
				dataManager.prepUpdate(connection, product);
				table.setModel(dataManager.table_load(connection));
			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = new Product();
				product.setProductId(Integer.parseInt(proIdTxtbox.getText()));
				dataManager.prepDelete(connection, product);
				table.setModel(dataManager.table_load(connection));
			}

		});
		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(172, 384, 89, 23);
		panel.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = new Product();
				dataManager.prepSearch(connection, product);
				product.setProductId(Integer.parseInt(proIdTxtbox.getText()));
			Product p1	 = dataManager.prepSearch(connection, product);
			proNameTxtbox.setText(p1.getProductName());
			proPriceTxtbox.setText(String.valueOf(p1.getProductPrice()));
			qntyTxtbox.setText(String.valueOf(p1.getQnty()));
			}
		});

	}
}
