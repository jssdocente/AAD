/**
 * Creación de ficheros y ficheros temporales
 */
package tema1.claseFile;

import tema1.Contants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Openwebinars
 *
 */
public class A_CreacionFicheros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {

			String path = Paths.get(Contants.ClaseFile.pathbase, "nuevo.txt").toString();
			File f = new File(path);
			f.createNewFile();
			
			File temp = File.createTempFile("temporal", ".tmp");
			System.out.println(temp.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
