package tema1._ejemplos.practica.functional;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SampleWriteFiles {

    public static void main(String[] args) {
        String filename="";
        String content= "Juan\nMaria\nJose\n";

        writeContentFile(filename,content);

    }

    public static void writeContentFile (String filename, String content) {

        //Lee todos los bytes a la vez
        try {
            Files.write(Paths.get(filename),content.getBytes(), StandardOpenOption.CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
