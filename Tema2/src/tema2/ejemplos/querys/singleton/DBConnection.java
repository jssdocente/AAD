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
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc_demo";
	
	private static Connection instance = null;
	
	private DBConnection() { }
	
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			Properties props = new Properties();
			props.put("user", readConfig("user"));
			props.put("password", readConfig("pass"));
			instance = DriverManager.getConnection(generateUrl(), props);
		}
		
		return instance;
	}


	private static String generateUrl() {

		String server= tema2.ejemplos.config.ConfigUtil.readProperty("","server");
		String db= tema2.ejemplos.config.ConfigUtil.readProperty("","db");
		String port= tema2.ejemplos.config.ConfigUtil.readProperty("","port");

		return String.format("jdbc:mysql://%s:%s/%s",server,port,db);

	}

	private static String readConfig(String propname) {
		return  tema2.ejemplos.config.ConfigUtil.readProperty("",propname);
	}
}
