
import java.sql.*;

public class PostgresExampleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:postgresql://rosie.db.elephantsql.com/xtnqzadt","xtnqzadt","HUAHCUFMAY7PpblU434f4wcPPT_HiOKm");
			
			System.out.println("The DB connection is successful, "+c);
			
			/*stmt = c.createStatement();
	         String sql = "CREATE TABLE COMPANY " +
	            "(ID INT PRIMARY KEY     NOT NULL," +
	            " NAME           TEXT    NOT NULL, " +
	            " AGE            INT     NOT NULL, " +
	            " ADDRESS        CHAR(50), " +
	            " SALARY         REAL)";
	         stmt.executeUpdate(sql);
	         stmt.close();*/
			
			DatabaseMetaData dmd = c.getMetaData();
			
			System.out.println("Driver Name"+dmd.getDriverName());
			System.out.println("Driver VErsion"+dmd.getDriverVersion());
			System.out.println("DB Product Name"+dmd.getDatabaseProductName());

			String type []= {"TABLE"};
			ResultSet rs = dmd.getTables(null, null, null,type);
			
			while(rs.next()) {
				System.out.println("table :"+rs.getString(3));
			}
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
