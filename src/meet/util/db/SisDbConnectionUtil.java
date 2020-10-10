package meet.util.db;
import java.sql.*;

public class SisDbConnectionUtil {
	private static boolean  isDriverLoaded=false;
	
	static{
					try{  
						Class.forName("com.mysql.jdbc.Driver");  
						isDriverLoaded=true;
				}
				catch(ClassNotFoundException e){
						System.out.println("ERROR : driver Class Not Found ");
					}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection con = null;
		 if(isDriverLoaded) {
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		 }
	return con;
	}
	
	//close connection
	
	public static void closeConnection(Connection con) throws SQLException {
		
		if(con!=null) {
			con.close();
		}
		
	}
	
}
