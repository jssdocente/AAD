package tema1.nio.apiStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author Openwebinars
 *
 */
public class A_List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//forma extendida, que permite depuración
		System.out.printf("---- FORMA EXTENDIDA ------- \n");
		try (Stream<Path> stream = Files.list(Paths.get(System.getProperty("user.home")))) {
		    stream
		        .map(path -> {
					return path.toFile().getName();
				})
		        .filter(path -> {
		        	if (path.startsWith("."))
		        		return false;
		        	return true;
				})
		        .sorted()
		        .forEach(System.out::println);
		} catch (IOException e) {			
			e.printStackTrace();
		}

		//forma resumida, NO permite depuración
		System.out.printf("---- FORMA RESUMIDA ------- \n");
		try (Stream<Path> stream = Files.list(Paths.get(System.getProperty("user.home")))) {
			stream
					.map(path -> path.toFile().getName())
					.filter(itemName -> !itemName.startsWith("."))
					.sorted()
					.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
