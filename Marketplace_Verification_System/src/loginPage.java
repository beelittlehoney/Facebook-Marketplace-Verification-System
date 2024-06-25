//Java Push Test - Kalli
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class loginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField txtPassword_1;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage frame = new loginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1054, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 53, 202));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPassword_1 = new JTextField();
		txtPassword_1.setForeground(new Color(218, 218, 218));
		txtPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword_1.setText("Password");
		txtPassword_1.setBounds(305, 355, 364, 50);
		contentPane.add(txtPassword_1);
		txtPassword_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("/fb_small_logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(images));
		lblNewLabel.setBounds(12, 20, 60, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("facebook");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(83, 38, 136, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to facebook");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_3.setBounds(234, 83, 580, 88);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Please log in your account");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(375, 168, 249, 50);
		contentPane.add(lblNewLabel_4);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(218, 218, 218));
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmail.setText("");
			}
		});
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setText("Email");
		txtEmail.setBounds(305, 262, 364, 56);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setForeground(new Color(150, 150, 150));
		btnNewButton.setBackground(new Color(53, 53, 202));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(432, 470, 110, 41);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 357, 364, 50);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(453, 490, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(305, 262, 364, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(305, 388, 96, 19);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\kalli\\OneDrive - National University\\Pictures\\custombackground.png"));
		lblNewLabel_5.setBounds(-101, 0, 1141, 782);
		contentPane.add(lblNewLabel_5);
		
	}
}
