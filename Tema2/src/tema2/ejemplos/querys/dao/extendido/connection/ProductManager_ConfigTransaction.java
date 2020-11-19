package tema2.ejemplos.querys.dao.extendido.connection;

import java.sql.Connection;

public class ProductManager_ConfigTransaction {

    public static void main(String[] args) throws Exception {

        ProductDAO product = null;
        Connection cnn = null;

                //Leemos la configuracion, para ver qué Implementación cargar
        String dbuse = ProductManagerConfig.readConfig("dao_db");

        if (dbuse.equalsIgnoreCase("mariadb")) {
            product = new ProductDAOmdb();
            cnn = DBMariadbConnection.getConnection();
        }
        else if (dbuse.equalsIgnoreCase("mysql")) {
            product = new ProductDAOmsql();
            cnn = DBMySqlConnection.getConnection();
        }
        else {
            throw new Exception("Implmentación de Producto no encontrada");
        }


        cnn.setAutoCommit(false);

        try {
            // agregar nuevo producto
            product.insert(new ProductDTO(100, "Arroz", 1.50));

            // obtener el producto con ID = 100
            ProductDTO p = product.read(100);
            System.out.println(p);

            if (1==1)
                throw new Exception("La transacción se tiene que deshacer");

            // eliminar el producto con ID = 100
            product.delete(100);

            cnn.commit();

        } catch (Exception ex) {
            cnn.rollback();
            System.out.println("Errores en el procesamiento");
            ex.printStackTrace();

        } finally {
            cnn.setAutoCommit(true);
        }
    }

    private static class ProductManagerConfig {

        public static String readConfig(String propname) {
            return tema2.ejemplos.config.ConfigUtil.readProperty("config_dao.properties", propname);
        }

    }
}