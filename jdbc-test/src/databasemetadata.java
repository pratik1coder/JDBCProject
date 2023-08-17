import java.sql.*;
public class databasemetadata {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			DatabaseMetaData dbmd=cn.getMetaData();
			System.out.println("Product name:"+dbmd.getDatabaseProductName());
			System.out.println("Product name:"+dbmd.getDatabaseProductVersion());
			System.out.println();
			System.out.println("JDBC driver name:"+dbmd.getDriverName());
			System.out.println("JDBC Driver version:"+dbmd.getDriverVersion());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
