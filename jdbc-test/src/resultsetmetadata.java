import java.sql.*;
public class resultsetmetadata {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			st=cn.createStatement();
			rs=st.executeQuery("select * from employees");
			ResultSetMetaData rsmd=rs.getMetaData();
			int cc=rsmd.getColumnCount();
			System.out.println("Column count="+cc+"\n");
			for(int i=1;i<=cc;i++)
			{
				System.out.println("Column name:"+rsmd.getColumnName(i));
				System.out.println("Coulmn type name:"+rsmd.getColumnTypeName(i));
				System.out.println("Is nullable:"+rsmd.isNullable(i));
				System.out.println("Is auto increment:"+rsmd.isAutoIncrement(i)+"\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
