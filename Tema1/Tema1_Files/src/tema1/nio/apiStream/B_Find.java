/**
 * 
 */
package tema1.nio.apiStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Openwebinars
 *
 */
public class B_Find {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Path start = Paths.get(System.getProperty("user.home"),"ejemplo");
		Path pathStart = Paths.get(".","src");

		int maxDepth = 5;
		try (Stream<Path> stream = Files.find(pathStart, maxDepth, (path, attr) -> String.valueOf(path).endsWith(".txt"))) {
			stream
		        .sorted()
		        .map(String::valueOf)
		        .forEach(System.out::println);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
