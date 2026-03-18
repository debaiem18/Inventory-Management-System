import java.util.*;

public class ProductDAOImpl implements ProductDAO {
private List<Product> products;
public ProductDAOImpl() {
products = FileManager.loadProducts();
}
public void addProduct(Product product) {
products.add(product);
FileManager.saveProducts(products);
}
public List<Product> getAllProducts() {
return products;
}
public void updateProduct(int id, int quantity) {
for (Product p : products) {
if (p.getId() == id) {
p.setQuantity(quantity);
}
}
FileManager.saveProducts(products);
}
public void deleteProduct(int id) {
products.removeIf(p -> p.getId() == id);
FileManager.saveProducts(products);
}
}
