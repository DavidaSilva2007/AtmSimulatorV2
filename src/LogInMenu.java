import java.util.ArrayList;
import java.util.Scanner;

public class LogInMenu {
    public void login(ArrayList<User> users, Data data, Scanner scanner) {
        Main.bigGap();
        System.out.println("-- Login --");
        System.out.println();

        System.out.print("Please enter username: ");
        String usernameInput = scanner.nextLine();

        System.out.print("Please enter PIN: ");
        int PINInput = scanner.nextInt();
        scanner.nextLine();

        User user = findUser(users, usernameInput);

        System.out.println();

        if (user != null && user.checkPIN(PINInput)) {
            System.out.println("Login successful. Welcome, " + user.getUsername() + ".");
            Main.delay(1);
            MainMenu menu = new MainMenu();
            menu.menu(user, data, users);
        } else {
            System.out.println("Invalid username or PIN.");
            Main.delay(1);
        }
    }

    public void createAccount(ArrayList<User> users, Data data, Scanner scanner) {
        Main.bigGap();
        System.out.println("-- Create Account --");
        System.out.println();

        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();

        if (findUser(users, newUsername) != null) {
            System.out.println("This username is already in use.");
            Main.delay(1);
            return;
        }

        System.out.print("Enter new 4 digit PIN: ");
        int newPIN = scanner.nextInt();
        scanner.nextLine();

        while (newPIN < 1000 || newPIN > 9999) {
            System.out.println("Failed to create account, please only use 4 digits.");
            System.out.print("Enter new 4 digit PIN: ");
            newPIN = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println();

        users.add(new User(newUsername, newPIN));
        data.saveUsers(users);
        System.out.println("New account has been created.");
        Main.delay(1);
    }

    private User findUser(ArrayList<User> users, String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
