import java.sql.*;
import java.io.*;
import java.util.*;
public class connectiondemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Properties pr=new Properties();
			pr.load(new FileInputStream("demo.properties"));
			String user=pr.getProperty("user");
			String password=pr.getProperty("password");
			String dburl=pr.getProperty("dburl");
			System.out.println("Connecting to database....");
			System.out.println("Database URL:"+dburl);
			System.out.println("User:"+user);
			cn=DriverManager.getConnection(dburl,user,password);
			System.out.println("\nConnection Successful!\n");
			st=cn.createStatement();
			rs=st.executeQuery("select * from employees");
			while(rs.next()) {
				System.out.println(rs.getString("last_name")+","+rs.getString("first_name"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
