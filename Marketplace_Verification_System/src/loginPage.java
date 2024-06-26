import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.management.loading.PrivateClassLoader;
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
import java.security.PublicKey;

import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;

public class loginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JTextField textField;

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
		
		JLabel lblNewLabel_4 = new JLabel("Please login your account");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(375, 168, 249, 50);
		contentPane.add(lblNewLabel_4);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().equals("Email")) {
					txtEmail.setForeground(new Color(0, 0, 0));
					txtEmail.setText("");					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().equals("")) {
					txtEmail.setForeground(new Color(218, 218, 218));
					txtEmail.setText("Email");
				}
			}
		});
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(305, 262, 364, 56);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String user = txtEmail.getText();
				String pass = passwordField.getText();
				
				Connection connection = null;
				
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "user";
				String driver = "com.mysql.cj.jdbc.Driver";
				String userName = "root";
				String password = "";
				
				try {
					Class.forName(driver);
					connection = DriverManager.getConnection(url + dbName, userName, password);
					String query = "Select * FROM user WHERE username = ? AND password = ?";
					PreparedStatement ps = connection.prepareStatement(query);
			        ps.setString(1, user);
			        ps.setString(2, pass);
			        
			        ResultSet rs = ps.executeQuery();
					
			        if (rs.next()) {
			        	selectProfile sProf = new selectProfile(user, pass);
			        	sProf.setVisible(true);
			            loginPage.this.setVisible(false);
			        } else {
			            JOptionPane.showMessageDialog(btnNewButton, "Invalid Login");
			        }
			        rs.close();
			        ps.close();
			        connection.close();
			        
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(432, 470, 110, 41);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("Password")) {
					passwordField.setForeground(new Color(0, 0, 0));
					passwordField.setEchoChar('●');
					passwordField.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().equals("")) {
					passwordField.setForeground(new Color(218, 218, 218));
					passwordField.setText("Password");
					passwordField.setEchoChar((char)0);
				}
			}
		});
		passwordField.setBounds(305, 357, 364, 50);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(453, 490, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(305, 262, 364, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\kalli\\OneDrive - National University\\Pictures\\custombackground.png"));
		lblNewLabel_5.setBounds(-101, 0, 1141, 782);
		contentPane.add(lblNewLabel_5);
		
	}
}
