package TrabajoFiles;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class EjemploFiles {

    public static void main(String[] args) {
        ListaFicheros();
    }

    public static void ListaFicheros() {

        File f = new File(".");
        for (File file: f.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else {
                System.out.println("--- folder: " + file.getName() + " ----");
                Arrays.stream(file.listFiles())
                        .forEach(s-> System.out.println(s));
                System.out.println("-----");
            }
        }
    }
}
