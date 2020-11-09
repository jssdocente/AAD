package tema1.flujos.serializable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 EJEMPLO PARA LEER Y ESCRIBIR UNA CLASE, A TRAVÉS DE LA SERIALIZACIÓN.
 Puntos a tener en cuenta:
 a) Creo una clase, que implemente Serializable, y override metodo toString()
 b) Abro flujo de salida, de tipo ObjectOutputStream.
 c) Guardo cada instancia de la clase, con writeObject
 d) Para leer, leo con readObject, pero no sé que tipo es, por tanto, readObject devuelve Object
    Para saber si he terminado de leer el fichero, no tengo forma, por lo que lo mejor es a través de la Excepcion
    EOFException.
 */
public class EjemploLeerEscribirClase {

    public static void main(String[] args) {

    }

    public static void save(List<MiClaseSerializable> lista, String fichero) throws IOException {

        if (!Files.exists(Paths.get(fichero))) {
            Files.createDirectories(Paths.get(fichero).getParent());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {

            for (MiClaseSerializable instancia: lista){
                oos.writeObject(instancia);
            }

            System.out.println("Elementos guardados correctamente.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error guardar Elementos");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.err.println("Error guardar Elementos");
        }

    }

    public static List<MiClaseSerializable> load(String fichero) throws FileNotFoundException {

        if (!Files.exists(Paths.get(fichero))) {
            throw new FileNotFoundException();
        }

        List<MiClaseSerializable> lista = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(fichero))) {

            Object obj=null;
            do {
                obj = oos.readObject();

                if (obj instanceof MiClaseSerializable) {
                    lista.add((MiClaseSerializable)obj);
                }

            } while (obj!=null);

            System.out.println("Elementos cargados correctamente.");

        } catch (EOFException eof) {
            //hemos llegado al final del fichero

        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.err.println("Error cargar Elementos");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error cargar Elementos");
        }

        return lista;

    }

}
