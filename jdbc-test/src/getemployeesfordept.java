import java.sql.*;
public class getemployeesfordept {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		CallableStatement cs=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			st=cn.createStatement();
			rs=st.executeQuery("select * from employees where department='engineering'");
			String dept="Engineering";
			cs=cn.prepareCall("{call get_employees_for_department(?)}");
			cs.setString(1,dept);
			System.out.println("Calling stored procedure get_employees_for_department("+dept+")");
			cs.execute();
			System.out.println("Finished calling stored procedure.\n");
			rs=cs.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+","+rs.getString("last_name")+","+rs.getString("first_name")+","+rs.getString("email")+","+rs.getString("department")+","+rs.getDouble("salary"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
