import java.sql.*;
import java.util.*;
public class transaction {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			cn.setAutoCommit(false);
			st=cn.createStatement();
			System.out.println("Salaries before.\n");
			rs=st.executeQuery("select * from employees where department='hr'");
			System.out.println("Show salaries for the department:HR");
			while(rs.next()) {
				System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(5)+" "+rs.getDouble(6));
			}
			rs=st.executeQuery("select * from employees where department='engineering'");
			System.out.println("\nShow salaries for the department:ENGINEERING");
			while(rs.next()) {
				System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(5)+" "+rs.getDouble(6));
			}
			st.executeUpdate("delete from employees where department='hr'");
			st.executeUpdate("update employees set salary=300000 where department='engineering'");
			System.out.println("\nTransaction steps are ready.\n");
			boolean ok=askUserIfOkToSave();
			if(ok) {
				cn.commit();
				System.out.println("\nTransaction COMMITTED.\n");
			}
			else {
				cn.rollback();
				System.out.println("\nTransaction ROLLED BACK.\n");
			}
			System.out.println("Salaries after.\n");
			rs=st.executeQuery("select * from employees where department='hr'");
			System.out.println("Show salaries for the department:HR");
			while(rs.next()) {
				System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(5)+" "+rs.getDouble(6));
			}
			rs=st.executeQuery("select * from employees where department='engineering'");
			System.out.println("\nShow salaries for the department:ENGINEERING");
			while(rs.next()) {
				System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(5)+" "+rs.getDouble(6));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static boolean askUserIfOkToSave() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Is it okay to save? yes/no:");
		String st=sc.next();
		if(st.equals("yes")) 
			return true;
		else
			return false;
	}

}
