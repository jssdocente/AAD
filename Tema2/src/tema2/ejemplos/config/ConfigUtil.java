package tema2.ejemplos.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtil {

    public static String readProperty(String propfile, String propName) {
        String result ="";
        Properties prop = new Properties();

        String propfileValue = propfile != "" ? propfile : "config.properties";

        Path path = Paths.get(".","res","config",propfileValue);
        if (!path.toFile().exists()) {
            //throw new FileNotFoundException("Fichero " + propfile + " no existe");
            return "";
        }


        try {
            //InputStream inputStream =  getClass().getClassLoader().getResourceAsStream(propfile);
            prop.load(new FileReader(path.toFile()));

            result= prop.getProperty(propName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

}
