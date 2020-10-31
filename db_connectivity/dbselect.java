import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class frametable {

	 public static JFrame f;
	 public static JScrollPane sp;
	 public static JTable jt;
	 public static JButton bt;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		f = new JFrame();
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from student");
			
			String col[] = {"Roll no","Name", "Marks"};
			String data[][] = new String[2][3];
			int c=0;
			
			while(rs.next()) {
				data[c][0] = String.valueOf(rs.getInt(1));
				data[c][1] = rs.getString(2);
				data[c][2] = String.valueOf(rs.getDouble(3));
				c++;
			}
			jt = new JTable(data,col);
			jt.setBounds(30,90,200,300);
			sp = new JScrollPane(jt);
			f.add(sp);
			
			//jt.setVisible(false);
					
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		sp.setBounds(10,10,370,200);
		
		bt = new JButton("Display the data");
		bt.setBounds(120,250,150,30);
		f.add(bt);
		
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				sp.setVisible(true);
				
			}			
		});
		
		sp.setVisible(false);
		f.setSize(500,400);
		f.setLayout(null);
		f.setVisible(true);
			
	}

}
