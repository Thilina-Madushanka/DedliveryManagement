package BB;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import AA.Delivery;

public class DriverDBUtil {

	
public static List<Driver> getOrders(){
		
		ArrayList<Driver> dri = new ArrayList<>();
		
		//create DB connection
		String url = "jdbc:mysql://localhost:3306/afterpayment";
		String user = "root";
		String pass = "19970521";
		
		//validate
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url , user , pass);
			Statement stmt = con.createStatement();
			
			String sql = "select * from drivers d ,orders o where d.id = o.id";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				
				 int id = rs.getInt(1);
				 String name = rs.getString(2);
				 String time = rs.getString(3);
				
		
				 Driver d = new Driver(id ,name , time);
				 
				 dri.add(d);	
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		
		return dri;
		
	}
	
}
