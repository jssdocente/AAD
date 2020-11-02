/**
 * CLASE QUE IMPLEMENTA EL PATRÓN SINGLETON PARA OBTENER LA CONSULTA A LA BASE DE DATOS
 */
package tema2.ejemplos.rowset.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Jesus Garcia
 *
 */
public class DBConnection {
	
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc";
	public static final String USERNAME = "Jesus Garcia";
	public static final String PASSWORD = "12345678";
	
	private static Connection instance = null;
	
	private DBConnection() { }
	
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "Jesus Garcia");
			props.put("password", "12345678");
			instance = DriverManager.getConnection(JDBC_URL, props);
			instance.setAutoCommit(false);
		}
		
		return instance;
	}
	

}
