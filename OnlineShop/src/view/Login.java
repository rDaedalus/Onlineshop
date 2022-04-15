package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userTextbox;
	private JPasswordField userPasswordTextBox;
	private LoginController loginController = new LoginController();

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton LoginBtn = new JButton("Login");
		LoginBtn.setBounds(656, 276, 89, 23);
		contentPane.add(LoginBtn);

		userTextbox = new JTextField();
		userTextbox.setBounds(625, 146, 138, 20);
		contentPane.add(userTextbox);
		userTextbox.setColumns(10);

		userPasswordTextBox = new JPasswordField();
		userPasswordTextBox.setBounds(625, 224, 141, 20);
		contentPane.add(userPasswordTextBox);

		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userTextbox.getText();
				String userPass = userPasswordTextBox.getText();
				loginController.login(userName, userPass);
				dispose();
				HomeScreen homeScreen = new HomeScreen();
				
			}
		});
	}
}