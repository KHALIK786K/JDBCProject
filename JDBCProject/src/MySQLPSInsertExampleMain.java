
import java.sql.*;

public class MySQLPSInsertExampleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6523506","sql6523506","1VXyRrnUC6");  
					
			PreparedStatement ps = c.prepareStatement("insert into COMPANY values(?,?,?,?,?)");
			ps.setInt(1, 103);
			ps.setString(2, "Company Name - Gfg");
			ps.setInt(3, 5);
			ps.setString(4, "Company Address - Gfg");
			ps.setInt(5, 12356);

			
			int i = ps.executeUpdate();
			/*ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("Total Columns are:"+rsmd.getColumnCount());
			
			int count = rsmd.getColumnCount();
			
			for (int i = 1; i <= count; i++) {
				System.out.println("The column Name is : "+i+" "+rsmd.getColumnName(i)+" Type is :"+rsmd.getColumnTypeName(i));	
			}
			
			while (rs.next()) {
				
				System.out.println("Customer Number is:"+rs.getInt(1)+" Name is :"+rs.getString(2));
			}*/
			System.out.println("Rows inserted are:"+i);
			ps.close();
			
	         c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		

	}

}
