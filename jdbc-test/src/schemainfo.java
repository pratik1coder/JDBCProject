import java.sql.*;
public class schemainfo {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		String catalog=null;
		String tableNamePattern=null;
		String columnNamePattern=null;
		String schemaPattern=null;
		String[] types=null;
		
		Connection cn=null;
		ResultSet rs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			DatabaseMetaData dbmd=cn.getMetaData();
			System.out.println("List of tables.");
			System.out.println("---------------");
			rs=dbmd.getTables(catalog, schemaPattern, tableNamePattern, types);
			while(rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
			System.out.println("\nList of columns.");
			System.out.println("----------------");
			rs=dbmd.getColumns(catalog, schemaPattern, "employees", columnNamePattern);
			while(rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
