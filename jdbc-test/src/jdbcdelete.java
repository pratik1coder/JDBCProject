import java.sql.*;

public class jdbcdelete {
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			st=cn.createStatement();
			int r=st.executeUpdate("delete from employees where last_name='SAI'");
			rs=st.executeQuery("select * from employees ");
			while(rs.next()) {
				System.out.println(rs.getString("last_name")+","+rs.getString("email"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
