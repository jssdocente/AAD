/**
 * 
 */
package tema1.flujos.salida.bytes.buffered;

import tema1.Contants;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Openwebinars
 *
 */
public class EjemploBufferedOutputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		byte[] buffer = new byte[1024*32]; 
		Arrays.fill(buffer, Byte.parseByte("1"));
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(Paths.get(Contants.Flujos.Out.pathbase,"buffered.dat").toFile()));
			bos.write(buffer);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
		}
		
		

	}

}
