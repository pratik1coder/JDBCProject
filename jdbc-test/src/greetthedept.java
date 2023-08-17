import java.sql.*;
public class greetthedept {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		CallableStatement cs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			String dept="Engineering";
			cs=cn.prepareCall("{call greet_the_department(?)}");
			cs.registerOutParameter(1,Types.VARCHAR);
			cs.setString(1,dept);
			System.out.println("Calling stored procedure greet_the_department("+dept+")");
			cs.execute();
			System.out.println("Finished calling stored procedure.");
			String res=cs.getString(1);
			System.out.println("\nThe result="+res);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
