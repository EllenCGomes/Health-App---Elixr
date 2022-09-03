package healthtrack.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	public static ConnectionManager instance;
	
	private ConnectionManager() {}
	
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	public Connection getConnection(){
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM92174", "220602");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
