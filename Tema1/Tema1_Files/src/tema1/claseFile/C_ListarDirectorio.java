/**
 * Listar el contenido de un directorio
 */
package tema1.claseFile;

import tema1.Contants;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author Openwebinars
 */
public class C_ListarDirectorio {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String path = Paths.get(Contants.ClaseFile.pathbase, "nuevo.txt").toString();
        File f = new File(path);

        if (f.isDirectory()) {
            //Manejando la lista como String[]
            System.out.println("Como lista de String");
            List<String> lista = Arrays.asList(f.list());
            lista.forEach(System.out::println);

            //Manejando la lista como File[]
            System.out.println("\nComo lista de File");
            List<File> listaFiles = Arrays.asList(f.listFiles());

            //forma como "aconseja java", en forma de llamada a método directamente sin instanciar.
            listaFiles
                    .stream()
                    .map(File::getName)
                    .forEach(System.out::println);

            //esta forma funcional es equivalente a esta forma imperativa
            listaFiles.forEach((file) -> {
                System.out.println(file.getName());
            });

            //Forma tipo como firma de método, se entiende mejor
            listaFiles
                    .stream()
                    .map(file -> file.getName())
                    .forEach(s -> System.out.println(s));

        } else {
            System.out.println("No es un directorio!!!");
        }


    }

}
