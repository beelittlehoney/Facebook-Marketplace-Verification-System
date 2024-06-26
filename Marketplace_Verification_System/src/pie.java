import java.awt.EventQueue;

import javax.swing.*;

import com.mysql.cj.jdbc.JdbcConnection;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class pie {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pie window = new pie();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					showYear();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			private void showYear()throws SQLException {
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "user";
				String userName = "root";
				String password = "";
				
				try {
					Connection connect = DriverManager.getConnection(url+dbName, userName, password);
					PreparedStatement p = connect.prepareStatement("SELECT * FROM products");
					ResultSet r = p.executeQuery();
					while (r.next()) {
						String productName = r.getString(2);
						double price = r.getDouble(3);
						System.out.println(productName+" "+price);
					}
					r.close();
					p.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			private void showMonth(int year)throws SQLException {
				
			}
		});
		frame.setBounds(100, 100, 692, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

}
