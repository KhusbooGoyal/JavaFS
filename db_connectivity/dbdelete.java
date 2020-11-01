package List;

import java.sql.*;

public class sel {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");
			
			PreparedStatement stmt=con.prepareStatement("delete from HR.EMP where ROLL=?");
			stmt.setString(1,"104");
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted");  
			  
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
