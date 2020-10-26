/**
 * 
 */
package tema1.claseFiles;

import tema1.Contants;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Openwebinars
 *
 */
public class B_CopiarBorrarMover {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path pathbase = Paths.get(Contants.ClaseFiles.pathbase,"files");

		//Creamos una ruta para crear un fichero
		Path p = Paths.get(pathbase.toString(), "fichero.txt");
		
		//Creamos un fichero, y abrimos el flujo de texto para escribir
		BufferedWriter bw = Files.newBufferedWriter(p);
		bw.write("Curso de Java 8 para programadores Java en www.openwebinars.net");
		bw.close();
		
		//Copiamos el fichero
		Path copia = Paths.get(pathbase.toString(), "fichero_copiado.txt");
		Files.copy(p, copia, StandardCopyOption.REPLACE_EXISTING);
		
		//Lo movemos fuera del directorio
		Files.move(copia, Paths.get(pathbase.toString(),"out", "copiado.txt"), StandardCopyOption.REPLACE_EXISTING);
		
		//Lo eliminamos
		Files.deleteIfExists(Paths.get(pathbase.toString(), "copiado.txt"));
		
		
		

	}

}
