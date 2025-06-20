import java.util.HashMap;
import java.util.Scanner;

public class LoginSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> users = new HashMap<>();
        boolean isLoggedIn = false;
        String currentUser = "";

        while (true) {
            System.out.println("\n=== Simple Login System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Access Secured Page");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUser = sc.nextLine();
                    if (users.containsKey(regUser)) {
                        System.out.println("Username already exists.");
                        break;
                    }
                    System.out.print("Enter password: ");
                    String regPass = sc.nextLine();
                    users.put(regUser, regPass);
                    System.out.println("User registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String logUser = sc.nextLine();
                    System.out.print("Enter password: ");
                    String logPass = sc.nextLine();
                    if (users.containsKey(logUser) && users.get(logUser).equals(logPass)) {
                        isLoggedIn = true;
                        currentUser = logUser;
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    if (isLoggedIn) {
                        System.out.println("Welcome to the secured page, " + currentUser + "!");
                    } else {
                        System.out.println("Access denied. Please login first.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
