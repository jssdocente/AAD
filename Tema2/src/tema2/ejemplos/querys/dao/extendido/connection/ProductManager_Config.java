package tema2.ejemplos.querys.dao.extendido.connection;

public class ProductManager_Config {

    public static void main(String[] args) throws Exception {

        ProductDAO product = null;

        //Leemos la configuracion, para ver qué Implementación cargar
        String dbuse = ProductManagerConfig.readConfig("dao_db");

        if (dbuse.equalsIgnoreCase("mariadb"))
            product = new ProductDAOmdb();
        else if (dbuse.equalsIgnoreCase("mysql"))
            product = new ProductDAOmsql();
        else
            throw new Exception("Implmentación de Producto no encontrada");

        try {
            // agregar nuevo producto
            product.insert(new ProductDTO(100, "Arroz", 1.50));

            // obtener el producto con ID = 100
            ProductDTO p = product.read(100);
            System.out.println(p);

            // eliminar el producto con ID = 100
            product.delete(100);

        } catch (Exception ex) {
            System.out.println("Errores en el procesamiento");
            ex.printStackTrace();
        }
    }

    private static class ProductManagerConfig {

        public static String readConfig(String propname) {
            return tema2.ejemplos.config.ConfigUtil.readProperty("config_dao.properties", propname);
        }

    }
}