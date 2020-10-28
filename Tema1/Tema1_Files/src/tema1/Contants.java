package tema1;

import java.io.File;
import java.nio.file.Paths;

public class Contants {
    public static class Flujos {
        public static class In {
            public static final String pathbase = Paths.get(".","res","flujos","in").toString();
        }
        public static class Out {
            public static final String pathbase = Paths.get(".","res","flujos","out").toString();
        }
    }
    public static class ClaseFile {
        public static final String pathbase = Paths.get(".","res","flujos","claseFile").toString();
    }
    public static class ClaseFiles {
        public static final String pathbase = Paths.get(".","res","flujos","claseFiles").toString();
    }
    public static class ClasePath {
        public static final String pathbase = Paths.get(".","res","clasePath").toString();
    }
    public static class nioApiStream {
        public static final String pathbase = Paths.get(".","res","nioApiStream").toString();
    }
    public static class Ejemplos {
        public static class Practica {
            public static final String pathbase = Paths.get(".","res","_ejemplos","practica").toString();

            public static class Funcional {
                public static final String pathbase = Paths.get(".","res","_ejemplos","practica","functional").toString();
            }
            public static class Imperative {
                public static final String pathbase = Paths.get(".","res","_ejemplos","practica","imperative").toString();
            }
        }
        public static class Real {
            public static class ServicioMeteorologico {
                public static final String pathbase = Paths.get(".","res","_ejemplos","real","servicio_meteorologico").toString();
            }
        }


    }
}
