
import java.sql.*;

public class DBUtil {
	public static Connection getDBConnection() {
		Connection connection = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
       	 	String url="jdbc:oracle:thin:@localhost:1521:orcl";
       	 	String username="scott";
       	 	String password="Wipro123";
       	 	connection=DriverManager.getConnection(url,username,password);
       	 	
		}catch(Exception e){
			System.out.println(e.getMessage()+"connection failed");
		}
		return connection;
		
	}

}
