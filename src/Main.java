import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int menuChoice;
        do {
            // Start menu
            System.out.println();
            System.out.println("-- Welcome to ATM Simulator --");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Logout");
            System.out.print("Enter option: ");

            // Input for options above
            menuChoice = scanner.nextInt();
            scanner.nextLine();

            // Login menu
            switch (menuChoice) {
                case 1:
                    // Log in
                    System.out.print("Please enter username: ");
                    String usernameInput = scanner.nextLine();

                    System.out.print("Please enter password: ");
                    int passwordInput = scanner.nextInt();

                    User user = findUser(users, usernameInput);

                    if (user != null && user.checkPassword(passwordInput)) {
                        System.out.println("Successful Login");
                        Menu menu = new Menu();
                        menu.menu(user);
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    delay(1);
                    break;
                case 2:
                    // Create account
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();

                    if (findUser(users, newUsername) != null) {
                        System.out.println("This username is already in use.");
                        delay(1);
                        break;
                    }

                    System.out.print("Enter new password: ");
                    int newPassword = scanner.nextInt();

                    users.add(new User(newUsername, newPassword));
                    System.out.println("New account has been created.");
                    delay(1);
                    break;
                case 3:
                    // Exiting
                    System.out.print("Exiting.");
                    delay(0.3);
                    System.out.print(".");
                    delay(0.3);
                    System.out.println("."); // Add delay for dots
                    delay(0.3);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (menuChoice != 3);
    }

    public static User findUser(ArrayList<User> users, String username) {
        for (User user: users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void delay(double delaySeconds) {
        try {
            Thread.sleep((long) (delaySeconds * 1000)); // Input is converted to seconds not milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupt flag
        }
    }
}