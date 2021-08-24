 package AA;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DeliveryDBUtil {
public static List<Delivery> validate(String date){
		
		ArrayList<Delivery> delv = new ArrayList<>();
		
		//create DB connection
		String url = "jdbc:mysql://localhost:3306/afterpayment";
		String user = "root";
		String pass = "19970521";
		
		//validate
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url , user , pass);
			Statement stmt = con.createStatement();
			
			String sql = "select * from orders where date = '"+date+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				
				 int id = rs.getInt(1);
				 String name = rs.getString(2);
				 String dateU = rs.getString(3);
				 String address = rs.getString(4);
				 String TP = rs.getString(5);
		
				 Delivery d = new Delivery(id ,name ,dateU , address , TP);
				 
				 delv.add(d);	
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		
		return delv;
		
	}
	
}