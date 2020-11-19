package tema2.ejemplos.querys.dao.extendido;

import java.sql.*;

public class ProductDAOmdb implements ProductDAO {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3307/jdbc_dao";
    static final String DB_USER = "root";
    static final String DB_PASS = "123456";

    private void registerDriver() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println("ERROR: failed to load MySQL JDBC driver.");
            e.printStackTrace();
        }
    }

    @Override
    public void insert(ProductDTO product) {
        Connection conn = null;
        try {
            registerDriver();
            // abrir la conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
            registerDriver();
            // abrir la conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            try (PreparedStatement ps = conn.prepareStatement("delete from producto where id = ?")) {
                // indicar el ID que buscamos
                ps.setInt(1, id);

                // ejecutar la consulta
                rowsaffected = ps.executeUpdate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsaffected;
    }

    @Override
    public ProductDTO read(Integer id) {
        Connection conn = null;
        ProductDTO product = null;

        try {
            registerDriver();
            // abrir la conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return product;
    }
}