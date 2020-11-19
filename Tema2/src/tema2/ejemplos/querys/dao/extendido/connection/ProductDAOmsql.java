package tema2.ejemplos.querys.dao.extendido.connection;

import java.sql.*;

public class ProductDAOmsql implements ProductDAO {

    @Override
    public void insert(ProductDTO product) {
        Connection conn = null;
        try {
            // abrir la conexion. Ahora solo necesito obtenerla de un punto común.
            conn = DBMySqlConnection.getConnection();

            try (Statement stmt = conn.createStatement()) {
                // enviar el commando insert
                stmt.executeUpdate("insert into Producto values ("
                        + product.getId() + ",'"
                        + product.getName() + "',"
                        + product.getPrice() + ");");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //ya no hace falta cerrar la conexión
        }
    }

    @Override
    public void update(ProductDTO product) {

    }

    @Override
    public int delete(Integer id) {
        Connection conn = null;
        int rowsaffected = 0;
        try {
            // abrir la conexion. Ahora solo necesito obtenerla de un punto común.
            conn = DBMySqlConnection.getConnection();

            try (PreparedStatement ps = conn.prepareStatement("delete from producto where id = ?")) {
                // indicar el ID que buscamos
                ps.setInt(1, id);

                // ejecutar la consulta
                rowsaffected = ps.executeUpdate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //ya no hace falta cerrar la conexión
        }

        return rowsaffected;
    }

    @Override
    public ProductDTO read(Integer id) {
        Connection conn = null;
        ProductDTO product = null;

        try {
            // abrir la conexion. Ahora solo necesito obtenerla de un punto común.
            conn = DBMySqlConnection.getConnection();

            // consulta select (selecciona el producto con ID especificado)
            try (PreparedStatement ps = conn.prepareStatement("select * from producto where id = ?")) {
                // indicar el ID que buscamos
                ps.setInt(1, id);
                // ejecutar la consulta
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // obtener cada una de la columnas y mapearlas a la clase Product
                        product = new ProductDTO(id,
                                rs.getString("name"),
                                rs.getDouble("price"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //ya no hace falta cerrar la conexión
        }
        return product;
    }
}