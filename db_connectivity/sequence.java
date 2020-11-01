import java.sql.*;

public class sequences {
	   Connection con;
	   PreparedStatement ps;
	   sequences(){
	     con=null;
	       try
	       {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","123456");
	        System.out.println("connection done");
	       }
	       catch(Exception e)
	       {
	        System.out.println(e);
	       }
	      }
	      
	      void insertDB()
	      {
	       int t=0;
	       try
	       {
	        ps=con.prepareStatement("insert into HR.STUDENT values(HR.seq.nextval,?,?)");
	        
	        ps.setString(1,"KHUSBOO");
	        ps.setInt(2,22);
	        t=ps.executeUpdate();
	        //System.out.println("t is: "+t);
	        
	       }
	       catch(SQLException e)
	       {
	        e.printStackTrace();
	        //return "FAIL";
	       }
	      }
	     void displayDB()
	   {
	    try
	    {
	     ps=con.prepareStatement("select * from HR.STUDENT");
	     ResultSet rs=ps.executeQuery();  
	     while(rs.next()){  
	     System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));  
	     }  
	    }
	    catch(SQLException e)
	    {
	     e.printStackTrace();
	     //return "FAIL";
	    }
	    
	   }
	      public static void main(String[] args) {
	        sequences s = new sequences();
	        s.insertDB();
	        s.displayDB();
	      }
	   }