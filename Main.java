import java.util.*;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return id + " | " + name + " | Qty: " + quantity + " | Price: " + price;
    }
}

class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    // Add Product
    void addProduct(Product p) {
        products.add(p);
        System.out.println("✅ Product added!");
    }

    // View Products
    void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("⚠ Inventory is empty!");
            return;
        }
        System.out.println("\n--- Inventory ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // Search Product by ID
    void searchProduct(int id) {
        for (Product p : products) {
            if (p.id == id) {
                System.out.println("🔍 Found: " + p);
                return;
            }
        }
        System.out.println("❌ Product not found!");
    }

    // Delete Product by ID
    void deleteProduct(int id) {
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product p = it.next();
            if (p.id == id) {
                it.remove();
                System.out.println("🗑 Product deleted!");
                return;
            }
        }
        System.out.println("❌ Product not found!");
    }
}

public class Main {   // ✅ Must match the file name (Main.java)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        while (true) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inv.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    inv.viewProducts();
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    inv.searchProduct(sid);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    inv.deleteProduct(did);
                    break;
                case 5:
                    System.out.println("👋 Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
