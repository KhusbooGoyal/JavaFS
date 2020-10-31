import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sel {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");
			
			PreparedStatement stmt=con.prepareStatement("insert into HR.EMP values(?,?,?)");
			stmt.setInt(1,101);//1 specifies the first parameter in the query  
			stmt.setString(2,"Ratan");
			stmt.setString(3,"25.5");
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			  
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
