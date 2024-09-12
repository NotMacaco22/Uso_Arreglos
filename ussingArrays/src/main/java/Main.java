import models.inventory.Inventory;
import models.inventory.Product;
import models.registration.Registration;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exitFull = false;
        int opc;

        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        while (exitFull == false) {
            System.out.println("Select an Option");
            System.out.println("1. Test Mini-Inventory");
            System.out.println("2. Register of Students");
            System.out.println("3. Exit");
            System.out.print("Select an Option --> ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    main.miniInventory();
                    break;

                case 2:
                    main.registrationStudent();
                    break;

                case 3:
                    System.out.println("Goodbye");
                    exitFull = true;
                    break;
            }
        }
    }

    public void miniInventory() {
        Inventory inv = new Inventory();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        int opc;

        while (!exit) {

            System.out.println("~ Inventory System ~");
            System.out.println("1. Add a New Product");
            System.out.println("2. Edit a Product");
            System.out.println("3. Check Inventory");
            System.out.println("4. Exit");
            System.out.print("Select an option --> ");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    String name;
                    float price;
                    int quantity;

                    Product product = new Product();
                    System.out.println("Complete the next data.");
                    System.out.print("1. Name: ");
                    name = scanner.nextLine();
                    System.out.print("2. Price: ");
                    price = scanner.nextFloat();
                    System.out.print("3. Quantity: ");
                    quantity = scanner.nextInt();

                    product.setName(name);
                    product.setPrice(price);
                    product.setQuantity(quantity);
                    inv.addProduct(product);

                    System.out.println("~ Product Created ~");
                    System.out.println(product.toString());
                    break;

                case 2:
                    String search, newName, newPrice, newQuantity;

                    if (inv.isEmpty() != true) {
                        System.out.print("Enter the name of the Product: ");
                        search = scanner.nextLine();
                        System.out.print("1. Put the New Name (empty if still the same name): ");
                        newName = scanner.nextLine();
                        System.out.print("2. Put the New Price (empty if still the same price): ");
                        newPrice = scanner.nextLine();
                        System.out.print("3. Put the New Quantity (empty if still the same quantity): ");
                        newQuantity = scanner.nextLine();
                        inv.editingProducts(search, newName, newPrice, newQuantity);

                    } else {
                        System.out.println("The are no products to edit.");
                    }

                    break;

                case 3:
                    inv.getProducts();
                    break;

                case 4:
                    System.out.println("See you - Have a nice day :D");
                    exit = true;
                    break;

                default:
                    System.out.println("Not available option ~ Please try again.");
                    break;
            }
        }
    }

    public void registrationStudent() {
        Registration registration = new Registration();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Main Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Show Courses of Student by Name");
            System.out.println("3. Add Course to Student");
            System.out.println("4. Add Course");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    registration.addStudent(name, age);
                    break;
                case 2:
                    System.out.print("Student name: ");
                    String studentName = scanner.nextLine();
                    registration.showCoursesByStudentName(studentName);
                    break;
                case 3:
                    System.out.print("Student name: ");
                    String student = scanner.nextLine();
                    System.out.print("Course name: ");
                    String course = scanner.nextLine();
                    registration.addCourseToStudent(student, course);
                    break;
                case 4:
                    System.out.print("Course name: ");
                    String newCourse = scanner.nextLine();
                    registration.addCourse(newCourse);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (option != 5);
    }
}