/**
 * CLASE QUE IMPLEMENTA EL PATR�N SINGLETON PARA OBTENER LA CONSULTA A LA BASE DE DATOS
 */
package tema2.ejemplos.querys.dao.extendido.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Jesus Garcia
 *
 */
public class DBMariadbConnection {
	
	private static Connection instance = null;
	
	private DBMariadbConnection() { }
	
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			Properties props = new Properties();
			props.put("user", readConfig("maria.user"));
			props.put("password", readConfig("maria.pass"));

			//Como lo ejecutamos con la versión Java 1.8 no hace falta llamar a 'Class.forName(JDBC_DRIVER).newInstance();'
			instance = DriverManager.getConnection(generateUrl(), props);
		}
		
		return instance;
	}


	private static String generateUrl() {

		String server= readConfig("maria.server");
		String db= readConfig("maria.db");
		String port= readConfig("maria.port");

		//La URL se genera directamente desde aqui.
		return String.format("jdbc:mariadb://%s:%s/%s",server,port,db);

	}

	private static String readConfig(String propname) {
		return  tema2.ejemplos.config.ConfigUtil.readProperty("config_dao.properties",propname);
	}
}
