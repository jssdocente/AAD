/**
 * 
 */
package tema1.flujos.entrada.bytes.fileinput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjemploFileInputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileInputStream fIn = null;
		
		try {
			Path path = Paths.get(tema1.Contants.Flujos.In.pathbase,"primero.dat");
			fIn = new FileInputStream(path.toFile());
			int c;
			while ((c = fIn.read()) != -1) 
				System.out.println(c);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fIn != null)
				try {
					fIn.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
		}
		
		

	}

}
