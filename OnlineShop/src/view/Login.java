package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import data.ProductManager;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

	private ProductManager productManager = new ProductManager();

	/**
	 * Launch the application.
	 */

	/**

		*/
	public Login() {

		
		contentPane = new JPanel();
		contentPane.setBorder(new Empt

		contentPane.setLayout(nul

		
		JPanel panel = new JPanel

		
		contentPane.add(panel);


			anel_1.setBounds(355, 11, 349, 415);
		contentPane.add(panel_1);

			sernameTextBox = new JTextField();
		usernameTextBox.setBounds(126, 148, 121, 20);
		panel_1.add(usernameTextBox);
		usernameTextBox.setColumns(10);

		JButton btnNewButton = new JButton("Login");

		btnNewButton.setBounds(139, 257, 89, 23);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(38, 151, 78, 14);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(35, 205, 81, 14);
		panel_1.add(lblNewLabel_1);

		userPasswordTextBox = new JPasswordField();
		userPasswordTextBox.setBounds(126, 202, 121, 20);
		panel_1.add(userPasswordTextBox);

		JLabel loginStatus = new JLabel("");
		loginStatus.setBounds(38, 309, 137, 14);
		panel_1.add(loginStatus);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button Click");
				String userName = usernameTextBox.getText();
				String userPass = userPasswordTextBox.getText();
				String status = loginController.login(userName, userPass);
				loginStatus.setText(status);
				if(e.getSource()==btnNewButton){
					contentPane.setVisible(false);
				HomeScreen myHomeScreen = new HomeScreen();
				}
				
			}
		});
	}

}
