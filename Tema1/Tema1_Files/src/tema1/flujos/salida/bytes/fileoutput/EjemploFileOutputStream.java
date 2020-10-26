/**
 * 
 */
package tema1.flujos.salida.bytes.fileoutput;

import tema1.Contants;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 * @author Openwebinars
 *
 */
public class EjemploFileOutputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		OutputStream fOut = null;
		
		try {
			fOut = new FileOutputStream(Paths.get(Contants.Flujos.Out.pathbase,"primero.dat").toFile());
			for(int i = 0; i < 1000; i++) {
				fOut.write(i);
			}			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fOut != null)
				try {
					fOut.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
		}
		
		

	}

}
