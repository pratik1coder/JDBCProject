import java.sql.*;
import java.io.*;
public class writeblobdemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection cn=null;
		PreparedStatement ps=null;
		FileInputStream fis=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			String sql="update employees set resume=? where email='john.doe@foo.com'";
			ps=cn.prepareStatement(sql);
			File f=new File("sample_resume.pdf");
			fis=new FileInputStream(f);
			ps.setBinaryStream(1,fis);
			System.out.println("Reading input file:"+f.getAbsolutePath());
			System.out.println("\nStoring resume in database:"+f);
			System.out.println(sql+"\n");
			ps.executeUpdate();
			System.out.println("Completed successfully!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
