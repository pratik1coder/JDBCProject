import java.sql.*;
import java.io.*;
public class readclobdemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		Reader r=null;
		FileWriter fr=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			st=cn.createStatement();
			String sql="select resume from employees where email='john.doe@foo.com'";
			rs=st.executeQuery(sql);
			File f=new File("resume_from_db.txt");
			fr=new FileWriter(f);
			if(rs.next()) {
				r=rs.getCharacterStream("resume");
				System.out.println("Reading resume from database....");
				System.out.println(sql);
				int ch;
				while((ch=r.read())>0) {
					fr.write(ch);
				}
			}
			System.out.println("\nSaved to file:"+f.getAbsolutePath());
			System.out.println("\nCompleted successfully!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
