
import java.sql.*;

public class MySQLExampleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String query ="select * from customers;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6523506","sql6523506","1VXyRrnUC6");  
			
			System.out.println("Connection Success"+c);
		
			/*Statement stmt = c.createStatement();
	         String sql = "CREATE TABLE COMPANY " +
	            "(ID INT PRIMARY KEY     NOT NULL," +
	            " NAME           TEXT    NOT NULL, " +
	            " AGE            INT     NOT NULL, " +
	            " ADDRESS        CHAR(50), " +
	            " SALARY         REAL)";
	         stmt.executeUpdate(sql);
	         stmt.close();*/
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("Total Columns are:"+rsmd.getColumnCount());
			
			int count = rsmd.getColumnCount();
			
			for (int i = 1; i <= count; i++) {
				System.out.println("The column Name is : "+i+" "+rsmd.getColumnName(i)+" Type is :"+rsmd.getColumnTypeName(i));	
			}
			
			while (rs.next()) {
				
				System.out.println("Customer Number is:"+rs.getInt(1)+" Name is :"+rs.getString(2));
			}
			stmt.close();
			
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
