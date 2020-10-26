
package tema1.flujos.salida.caracteres.buffered;

import tema1.Contants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploBufferedWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedWriter bw = null;

		List<String> quijote = Arrays.asList(new String[] { "En un lugar de la Mancha,",
				"de cuyo nombre no quiero acordarme,", "no ha mucho tiempo que vivía un hidalgo",
				"de los de lanza en astillero,", "adarga antigua, rocín flaco y galgo corredor." });

		try {
			bw = new BufferedWriter(new FileWriter(Paths.get(Contants.Flujos.Out.pathbase, "quijote.txt").toFile()));
			for (String s : quijote) {
				bw.write(s);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
