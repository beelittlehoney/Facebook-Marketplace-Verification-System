import java.sql.*;

public class dbDisplayTable {

	public static void main(String[] args) {
		
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "user";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "";
		String f1, f2;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url + dbName, userName, password);
			String query = "Select * FROM user";
			System.out.println("Connected to the database\n");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				f1 = rs.getString(1);
				f2 = rs.getString(2);
				System.out.println(f1 + " " + f2);
			}
			connection.close();
			System.out.println("\nDisconnected from database");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
