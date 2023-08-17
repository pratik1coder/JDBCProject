import java.sql.*;
public class increasesalaries {

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
			int incr=10000;
			System.out.println("Salaries before\n");
			while(rs.next()) {
				System.out.println(rs.getDouble("salary"));
			}
			cs=cn.prepareCall("{call increase_salaries_for_department(?,?)}");
			cs.setString(1,dept);
			cs.setDouble(2,incr);
			System.out.println("Calling stored procedure increase_salaries_for_department("+dept+","+incr+")");
			cs.execute();
			System.out.println("Finished calling stored procedure.");
			System.out.println("\nSalaries after");
			rs=st.executeQuery("select * from employees where department='engineering'");
			while(rs.next()) {
				System.out.println(rs.getDouble("salary"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
