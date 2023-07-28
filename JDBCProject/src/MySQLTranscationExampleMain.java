
import java.sql.*;

public class MySQLTranscationExampleMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String query1 ="insert into COMPANY values(10,'GFG',1,'12 Address',1212)";
		String query2 ="insert into COMPANY values(11,'GFG',1,'12 Address',1212)";
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6523506","sql6523506","1VXyRrnUC6");  
			

			c.setAutoCommit(false);
			
			
			Statement stmt = c.createStatement();
			stmt.executeUpdate(query1);
			
			
			int i = 100/0;
			stmt.executeUpdate(query2);
			
			c.commit();
			stmt.close();
			
	         c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("In Catch Exception..transaction will now rollback");
			c.rollback();
		} 

		

	}

}
