import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcupdate {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			st=cn.createStatement();
			rs=st.executeQuery("select * from employees where last_name='sai'");
			while(rs.next()) {
				System.out.println(rs.getString("last_name")+","+rs.getString("email"));
			}
			int r=st.executeUpdate("update employees set email='klm@gamil.com' where last_name='Pratik'");
			rs=st.executeQuery("select * from employees where last_name='pratik'");
			while(rs.next()) {
				System.out.println(rs.getString("last_name")+","+rs.getString("email"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
