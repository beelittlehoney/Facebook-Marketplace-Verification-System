import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;

public class selectProfile extends JFrame {

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
					selectProfile frame = new selectProfile(user, pass);
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
	public selectProfile(String user, String pass) {
        
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
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginPage lPage = new loginPage();
				selectProfile.this.setVisible(false);
	            lPage.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setBounds(464, 508, 110, 41);
		contentPane.add(btnNewButton_1);
		lblNewLabel.setIcon(new ImageIcon(images));
		lblNewLabel.setBounds(12, 20, 60, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("facebook");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(81, 22, 116, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("WELCOME TO FACEBOOK MARKETPLACE");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(218, 80, 602, 129);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel();
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "user";
        String userName = "root";
        String password = "";
        String query = "SELECT name FROM user WHERE username = ?";

        try {
            Connection connect = DriverManager.getConnection(url + dbName, userName, password);
            
            PreparedStatement p = connect.prepareStatement(query);
            p.setString(1, this.user);
            
            ResultSet r = p.executeQuery();
            
            if (r.next()) {
                String userNameFromDB = r.getString("name");
                lblNewLabel_4.setText("Welcome " + userNameFromDB + " Please select your profile");
            } else {
                lblNewLabel_4.setText("Welcome " + user + " Please select your profile");
            }
            
            r.close();
            p.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(223, 179, 592, 50);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Buyer");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				customerProfile custProf = new customerProfile();
				custProf.setVisible(true);
	            selectProfile.this.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(422, 284, 193, 68);
		contentPane.add(btnNewButton);
		
		JButton btnSeller = new JButton("Seller");
		btnSeller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sellerProfile sellProf = new sellerProfile(user, pass);
				sellProf.setVisible(true);
	            selectProfile.this.setVisible(false);
			}
		});
		btnSeller.setForeground(new Color(255, 255, 255));
		btnSeller.setBackground(new Color(0, 128, 255));
		btnSeller.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSeller.setBounds(422, 398, 193, 68);
		contentPane.add(btnSeller);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\kalli\\OneDrive - National University\\Pictures\\custombackground.png"));
		lblNewLabel_5.setBounds(-101, 0, 1141, 782);
		contentPane.add(lblNewLabel_5);
		
	}
}
