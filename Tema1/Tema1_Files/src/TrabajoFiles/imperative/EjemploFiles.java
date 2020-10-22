package TrabajoFiles.imperative;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class EjemploFiles {

    public static void main(String[] args) {
        String filename = "palabras.txt";

        readAllLinesines(filename);
        ListaFicheros();
    }

    public static void readAllLinesines(String filename) {

        System.out.println("Reading File from Java code");
        //Name of the file
        String fileName = filename;

        //URL res = Ejempo1.class.getResource("/resources/palabras.txt");
        try {

            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                System.out.printf("Linea leida:  %s \n",line);

                String[] words = line.split(" ");

                //con strems => programacion funcional
                Arrays.stream(words).forEach(s -> System.out.println(s));

                //forma imperativa
                for (String word: words) {
                    System.out.println(word);
                }

                System.out.println(line);
            }

            //Close the buffer reader
            bufferReader.close();

        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }

    }

    public static void ListaFicheros() {

        File f = new File(".");
        for (File file: f.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else {
                System.out.println("--- folder: " + file.getName() + " ----");

                for (File item : file.listFiles()) {
                    System.out.println(item);
                }
                System.out.println("-----");
            }
        }
    }
}
