package tema2.ejemplos.querys.dao.extendido.connection;

public class ProductManager {

    public static void main(String[] args) {

        ProductDAO product = new ProductDAOmsql();

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
}