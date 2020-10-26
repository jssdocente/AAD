/**
 * Verificar si un File corresponde a un fichero, o un directorio
 */
package tema1.claseFile;

import tema1.Contants;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author Openwebinars
 *
 */
public class B_Tipos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String path = Paths.get(Contants.ClaseFile.pathbase, "nuevo.txt").toString();
		File f = new File(path);
		
		if (f.isFile()) 
			System.out.println("Es un fichero");
		else if (f.isDirectory())
			System.out.println("Es un directorio");
		else
			System.out.println("No es ni un fichero ni un directorio");

	}

}
