package TrabajoFiles.functional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class SampleReadFiles {

    public static void main(String[] args) {
        String filename="";

        leerAllBytes(filename);

        leerAllLines(filename);

        readAndFiltering(filename);
    }

    public static void leerAllBytes (String filename) {

        //Lee todos los bytes a la vez
        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerAllLines (String filename) {

        //Lee todos los bytes a la vez
        try {
            //Por defecto utiliza el encoding UTF-8.
            //Todas las lineas son leidas y el fichero es cerrado. Me soluciona mucho.
            List<String> lines = Files.readAllLines(Paths.get(filename));

            for (String line: lines) {
               //proceso cada linea
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndFiltering (String filename) {

        //Otro método muy interesante de la clase Files es lines, que me permite leer las lineas como si fuera un Stream.
        try {
            //Por defecto utiliza el encoding UTF-8.
            //Todas las lineas son leidas y el fichero es cerrado. Me soluciona mucho.
            Stream<String> lines = Files.lines(new File(filename).toPath());  //stream<String>
//            Files.lines(Paths.get(filename));

            //Procesamiento normal
            Files.lines(new File(filename).toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .forEach(s -> System.out.println(s));

            //Procesamiento con Expresiones Regulares
            Files.lines(new File(filename).toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.matches("[0-9]{3,}"))
                    .forEach(s -> System.out.println(s));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
