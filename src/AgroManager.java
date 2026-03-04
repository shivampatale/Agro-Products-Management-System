import java.util.Scanner;

public class AgroManager {
    public static void main(String[] args) {
        ProductServiceImpl service = new ProductServiceImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("...MAIN MENU...");
        System.out.println("1. Add Product\n2. List Products\n3. Find Product\n4. Delete Product\n5. Update Product");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Product p = new Product(107, "Crop Protector", 2000.0, 30); // Example: Add a product
                service.add(p);
                break;
            case 2:
                service.findAll().forEach(System.out::println); //Example: find all products
                break;
            case 3:
                System.out.println(service.find(102)); // Example: find Seeds
                break;
            case 4:
                service.delete(107); // Example: delete Organic Compost
                break;
            case 5:
                Product updated = new Product(102, "Pesticides", 1300.0, 55); //Example: it update Database
                service.update(102, updated);
                break;
            default:
                System.out.println("Invalid choice"); //Example: if user give the input value other than option's provided
        }
    }
}
