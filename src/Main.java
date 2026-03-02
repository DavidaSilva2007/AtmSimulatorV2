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
            bigGap();
            System.out.println("-- Welcome to ATM Simulator --");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Logout");
            System.out.print("Enter Option: ");

            // Input for options above
            menuChoice = scanner.nextInt();
            scanner.nextLine();

            // Login menu
            switch (menuChoice) {
                case 1:
                    // Log in
                    System.out.print("Please enter username: ");
                    String usernameInput = scanner.nextLine();

                    System.out.print("Please enter PIN: ");
                    int PINInput = scanner.nextInt();

                    User user = findUser(users, usernameInput);

                    if (user != null && user.checkPIN(PINInput)) {
                        System.out.println("Successful Login");
                        Menu menu = new Menu();
                        menu.menu(user);
                    } else {
                        System.out.println("Invalid username or PIN.");
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

                    System.out.print("Enter new PIN: ");
                    int newPIN = scanner.nextInt();

                    users.add(new User(newUsername, newPIN));
                    System.out.println("New account has been created.");
                    delay(1);
                    break;
                case 3:
                    // Exiting
                    System.out.print("Exiting.");
                    delay(0.5);
                    System.out.print(".");
                    delay(0.5);
                    System.out.println(".");
                    delay(0.5);
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

    public static void bigGap() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}