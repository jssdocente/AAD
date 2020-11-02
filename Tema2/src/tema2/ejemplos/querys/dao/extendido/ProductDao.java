package tema2.ejemplos.querys.dao.extendido;

public interface ProductDao {
    public void insert(Product product);
    public void update(Product product);
    public void delete(Integer id);
    public Product read(Integer id);
}