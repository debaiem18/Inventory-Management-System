import java.io.*;
import java.util.*;

public class FileManager {

    private static final String FILE_NAME = "products.txt";

    public static void saveProducts(List<Product> products) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Product p : products) {
                writer.println(p.toString());
            }

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static List<Product> loadProducts() {

        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int qty = Integer.parseInt(data[3]);

                products.add(new Product(id, name, price, qty));
            }

        } catch (IOException e) {
            System.out.println("File not found, starting new inventory.");
        }

        return products;
    }
}
