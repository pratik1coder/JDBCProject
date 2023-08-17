import java.sql.*;
public class getcontfordept {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		CallableStatement cs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			String dept="Engineering";
			cs=cn.prepareCall("{call get_count_for_department(?,?)}");
			cs.setString(1,dept);
			cs.registerOutParameter(2,Types.INTEGER);
			System.out.println("Calling stored procedure get_conut_for_department("+dept+",?)");
			cs.execute();
			System.out.println("Finished calling stored procedure.");
			int res=cs.getInt(2);
			System.out.println("\nThe count="+res);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
