import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

public class InventoryManagementSystem {

    private static ArrayList<Item> inventory = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Remove Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    viewItems();
                    break;
                case 3:
                    updateItemQuantity(scanner);
                    break;
                case 4:
                    removeItem(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Item newItem = new Item(nextId++, name, quantity, price);
        inventory.add(newItem);
        System.out.println("Item added successfully!");
    }

    private static void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("No items in the inventory.");
        } else {
            System.out.println("\n--- Inventory Items ---");
            for (Item item : inventory) {
                System.out.println(item);
            }
        }
    }

    private static void updateItemQuantity(Scanner scanner) {
        System.out.print("Enter the item ID to update: ");
        int id = scanner.nextInt();
        Item item = findItemById(id);

        if (item != null) {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            item.setQuantity(newQuantity);
            System.out.println("Item quantity updated successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void removeItem(Scanner scanner) {
        System.out.print("Enter the item ID to remove: ");
        int id = scanner.nextInt();
        Item item = findItemById(id);

        if (item != null) {
            inventory.remove(item);
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }

    private static Item findItemById(int id) {
        for (Item item : inventory) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
