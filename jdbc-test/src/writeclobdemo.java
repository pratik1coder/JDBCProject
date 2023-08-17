import java.sql.*;
import java.io.*;
public class writeclobdemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection cn=null;
		PreparedStatement ps=null;
		FileReader fr=null;
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			String sql="update employees set resume=? where email='john.doe@foo.com'";
			ps=cn.prepareStatement(sql);
			File f=new File("sample_resume.txt");
			fr=new FileReader(f);
			ps.setCharacterStream(1,fr);
			System.out.println("Reading input file:"+f.getAbsolutePath());
			System.out.println("\nStoring resume in database:"+f);
			System.out.println(sql);
			ps.executeUpdate();
			System.out.println("\nCompleted Successfully!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
