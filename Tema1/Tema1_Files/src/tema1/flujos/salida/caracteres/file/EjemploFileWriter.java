/**
 * 
 */
package caracteres.file;

import tema1.Contants;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Openwebinars
 *
 */
public class EjemploFileWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileWriter fw = null;
		String intro = "En un lugar de La Mancha, de cuyo nombre no quiero acordarme";
		
		try {
			fw = new FileWriter(Paths.get(Contants.Flujos.Out.pathbase,"introquijote.txt").toFile());
			for(char c : intro.toCharArray())
				fw.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
