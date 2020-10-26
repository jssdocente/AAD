package tema1._ejemplos.practica.functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class SampleFileUtils {

    public static void main(String[] args) {
        Path path = Paths.get(".");

        recursivelyListingFiles(path.toString());
    }

    public static void recursivelyListingFiles(String folder) {

        //Lee todos los bytes a la vez
        try {
            Files.walk(Paths.get(folder))
                    .filter(path -> path.toFile().isFile())
                    .forEach(f-> System.out.println(f));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recursivelyDeletingAllFoldersAndFiles(String folder) {

        //Lee todos los bytes a la vez
        try {
            Files.walk(Paths.get(folder))
                    .sorted(Comparator.reverseOrder())  //Stream<Path>
                    .map(path -> path.toFile())
                    .forEach(file -> file.delete());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
