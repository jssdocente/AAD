package tema1.ConfigFiles;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {

    public static void main(String[] args) {
        String cnfgfile = "config.properties";

        //Leyendo propertys
        ReadConfig readConfig = new ReadConfig();

        String prop = readConfig.readProperty(cnfgfile,"user");
        System.out.println("Valor prop: " + prop);

    }

    public String readProperty(String propfile, String propName) {
        String result ="";
        Properties prop = new Properties();

        try {
            InputStream inputStream =  getClass().getClassLoader().getResourceAsStream(propfile);

            if (inputStream!=null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file " + propfile + " no  encontrado en classpath");
            }

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
