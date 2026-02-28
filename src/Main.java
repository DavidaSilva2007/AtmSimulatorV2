import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        // Start menu
        System.out.println("-- Welcome to ATM Simulator --");
        System.out.println();
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Logout");
        System.out.print("Enter option: ");

        // Input for options above
        int menuChoice = scanner.nextInt();
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
                break;
        }
    }

    public static User findUser(ArrayList<User> users, String username) {
        for (User user: users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}