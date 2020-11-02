package tema1._ejemplos.practica.imperative;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploFiles {

    public static void main(String[] args) {
        String filename = "palabras.txt";

        readAllLinesines("palabras.txt");  //ruta relativa, es como si ponemos ./palabras.txt.
        readAllLinesines("./palabras.txt");  //ruta relativa, es como si ponemos ./palabras.txt.
        ListaFicheros();
    }

    public static void readAllLinesines(String filename) {

        System.out.println("Reading File from Java code");


        /* Opciones para indicar la ruta.
        * ruta relativa desde la ubicación de la clase: Ejempo1.class.getResource("/resources/palabras.txt");
        * ruta relativa, pero delegamos la ubicación en el fichero pasado como parámetro.
        *        De este forma, java busca desde la raiz del proyecto /src/...
        *
        * ruta absoluta: Se incluye la ruta completa. NUNCA
        * */
        try {

            //Create object of FileReader
            FileReader inputFile = new FileReader(filename);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                System.out.printf("Linea leida:  %s \n",line);

                String[] words = line.split(" ");

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
