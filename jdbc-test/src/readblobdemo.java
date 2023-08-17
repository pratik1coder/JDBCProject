import java.sql.*;
import java.io.*;
public class readblobdemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		InputStream in=null;
		FileOutputStream fos=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			st=cn.createStatement();
			String sql="select resume from employees where email='john.doe@foo.com'";
			rs=st.executeQuery(sql);
			File f=new File("resume_from_db.pdf");
			fos=new FileOutputStream(f);
			if(rs.next()) {
				in=rs.getBinaryStream("resume");
				System.out.println("Reading resume from database....");
				System.out.println(sql);
				byte buffer[]=new byte[1024];
				while(in.read(buffer)>0) {
					fos.write(buffer);
				}
				System.out.println("\nSaved to file:"+f.getAbsolutePath());
				System.out.println("\nCompleted successfully!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
