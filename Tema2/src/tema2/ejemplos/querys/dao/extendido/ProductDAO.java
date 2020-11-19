package tema2.ejemplos.querys.dao.extendido;

public interface ProductDAO {
    public void insert(ProductDTO product);
    public void update(ProductDTO product);
    public int delete(Integer id);
    public ProductDTO read(Integer id);
}