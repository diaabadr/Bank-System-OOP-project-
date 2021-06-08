import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBase_connection {

	  private static final String host ="127.0.0.1";
	    private static final String dp_name ="accounts";
	    private static final String User_Name ="root";
	    private static final String password ="";
	    private static final int port=3306;

	    private static Connection connection ;
	    public static Connection getConnection() {
	    	
	    	try {
	    		connection =  DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", host, port, dp_name)
	                    , User_Name, password);
	    		
	    	} catch(SQLException se)
	    	{se.printStackTrace();
	    		
	    	}
	    	return connection;
	    }
	    
	    public static boolean CheckConnection() {

	    	Connection con;
			con =DataBase_connection.getConnection();	
				if(con==null) {
					
					return false;
				}else 
					return true;

	    	
	    }
	    
	    
	
}
