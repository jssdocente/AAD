/**
 * 
 */
package tema1.claseFiles;

import tema1.Contants;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Openwebinars
 *
 */
public class D_Directorios {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//String userhome= System.getProperty("user.home");
		String pathbase = Contants.ClasePath.pathbase;
		Files.createDirectories(Paths.get(pathbase,"files", "subdir2"));

		for (int i = 0; i < 10; i++) {
			Path directoryPath = Paths.get(pathbase,"temp_" + i);
			if (Files.exists(directoryPath))
				Files.deleteIfExists(directoryPath);

			Files.createDirectory(directoryPath);
		}

		//recorremos el directorio que acabamos de crear
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(pathbase));

		//forma imperativa
//		for(Path p : directoryStream)
//			System.out.println(p.getFileName());

		//forma funcional
		directoryStream
				.forEach(path -> System.out.println(path.getFileName()));
	}

}
