import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sellerProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private static String user;
	private static String pass;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sellerProfile frame = new sellerProfile(user, pass);
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
	public sellerProfile(String user, String pass) {
		
		this.user = user;
        this.pass = pass;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1054, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 53, 202));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("/fb_small_logo.png")).getImage();
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
			            sellerProfile.this.setVisible(false);
			        }
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				selectProfile sProf = new selectProfile(user, pass);
				sellerProfile.this.setVisible(false);
	            sProf.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setBounds(464, 452, 110, 41);
		contentPane.add(btnNewButton_1);
		lblNewLabel.setIcon(new ImageIcon(images));
		lblNewLabel.setBounds(12, 20, 60, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("marketplace");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(81, 22, 139, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("My Dashboard");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(444, 114, 150, 32);
		contentPane.add(lblNewLabel_3);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProducts.setBounds(92, 207, 146, 58);
		contentPane.add(btnProducts);
		
		JLabel lblNewLabel_4 = new JLabel("Verification Status :");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(791, 115, 172, 31);
		contentPane.add(lblNewLabel_4);
		
		JButton btnMyRating = new JButton("My Rating");
		btnMyRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMyRating.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMyRating.setBounds(88, 355, 150, 58);
		contentPane.add(btnMyRating);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\kalli\\OneDrive - National University\\Pictures\\solidBackground.png"));
		lblNewLabel_5.setBounds(22, 26, 1040, 598);
		contentPane.add(lblNewLabel_5);
		
	}
}
