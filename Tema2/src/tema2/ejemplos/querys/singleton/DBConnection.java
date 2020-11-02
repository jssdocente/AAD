/**
 * CLASE QUE IMPLEMENTA EL PATR�N SINGLETON PARA OBTENER LA CONSULTA A LA BASE DE DATOS
 */
package tema2.ejemplos.querys.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Jesus Garcia
 *
 */
public class DBConnection {
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc_demo1";
	
	private static Connection instance = null;
	
	private DBConnection() { }
	
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "user");
			props.put("password", "p@ssw0rd");
			instance = DriverManager.getConnection(JDBC_URL, props);
		}
		
		return instance;
	}
	

}
