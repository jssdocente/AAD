package tema2.ejemplos.querys.dao.extendido;

public class ProductManager {

    public static void main(String[] args) {

        ProductDAO product = new ProductDAOmsql();

        // agregar nuevo producto
        product.insert(new ProductDTO(100, "Arroz", 1.50));

        // obtener el producto con ID = 100
        ProductDTO p = product.read(100);
        System.out.println(p);

        // eliminar el producto con ID = 100
        product.delete(100);
    }

    private static class Config {

        public static String readConfig(String propname) {
            return  tema2.ejemplos.config.ConfigUtil.readProperty("",propname);
        }

    }
}