import java.sql.*;
public class jdbcpreparedstatements {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			ps=cn.prepareStatement("select * from employees where salary>=? and department=?");
			ps.setDouble(1,100000);
			ps.setString(2,"HR");
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+","+rs.getString("last_name")+","+rs.getString("first_name")+","+rs.getString("email")+","+rs.getString("department")+","+rs.getDouble("salary"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
