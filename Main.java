import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAOImpl();

        while (true) {

            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.println("Enter  the choice :");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    dao.addProduct(new Product(id, name, price, qty));
                    break;

                case 2:
                    for (Product p : dao.getAllProducts()) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();

                    dao.updateProduct(uid, newQty);
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    int did = sc.nextInt();

                    dao.deleteProduct(did);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
