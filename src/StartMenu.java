import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void start(ArrayList<User> users, Data data) {
        int menuChoice;

        do {
            Main.bigGap();
            System.out.println("-- Welcome to ATM Simulator --");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Logout");
            System.out.print("Enter Option: ");

            // Input for options above
            menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    LogInMenu logInMenu = new LogInMenu();
                    logInMenu.login(users, data, scanner);
                    break;
                case 2:
                    LogInMenu createMenu = new LogInMenu();
                    createMenu.createAccount(users, data, scanner);
                    break;
                case 3:
                    System.out.println("Exiting");
                    Main.delay(.5);
                    System.out.print(".");
                    Main.delay(.5);
                    System.out.print(".");
                    Main.delay(.5);
                    System.out.print(".");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    Main.delay(1);
            }
        } while (menuChoice != 3);
        scanner.close();
    }
}
