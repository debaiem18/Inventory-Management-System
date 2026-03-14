import java.util.List;

public interface ProductDAO {

    void addProduct(Product product);

    List<Product> getAllProducts();

    void updateProduct(int id, int quantity);

    void deleteProduct(int id);
}
