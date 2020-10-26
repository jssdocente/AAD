package TrabajoFiles.functional;

import TrabajoFiles.functional.util.FilesUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;

public class SampleReadWriteFiles {

    public static void main(String[] args) {
        String filename="palabras.txt";
        String content= "Juan\nMaria\nJose\n";

        try {
            String contentRead = FilesUtil.readTextFile(filename);

            FilesUtil.writeToTextFile("palabras2.txt",contentRead);
            FilesUtil.writeToTextFile("palabras2.txt",content);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    public static void readAndWriteFile (String filename, String content, OpenOption openOption) {

        //Lee todos los bytes a la vez
        try {
            Files.write(Paths.get(filename),content.getBytes(),openOption);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

