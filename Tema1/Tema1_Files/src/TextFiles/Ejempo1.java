package TextFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Ejempo1 {

    public static void main(String[] args) {

        System.out.println("Reading File from Java code");
        //Name of the file
        String fileName = "palabras.txt";
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
}
