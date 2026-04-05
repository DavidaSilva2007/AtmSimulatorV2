import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner = new Scanner(System.in);

    public void menu(User user, Data data, ArrayList<User> users) {
        int menuChoice;

        do {
            Main.bigGap();
            System.out.println("-- ATM Menu --");
            System.out.println();
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. About Me");
            System.out.println("6. Logout");
            System.out.print("Enter option: ");

            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    // Deposit
                    Main.bigGap();
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();

                    if (user.deposit(depositAmount)) {
                        System.out.println("Successfully deposit. New balance: $" + String.format("%.2f", user.getBalance()));
                        data.saveUsers(users);
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    backOption();
                    break;
                case 2:
                    // Withdraw
                    Main.bigGap();
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();

                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("Successfully withdraw. New balance: $s" + String.format("%.2f", user.getBalance()));
                        data.saveUsers(users);
                    } else if (withdrawAmount > user.getBalance()) {
                        System.out.println("Withdraw failed, insufficient funds.");
                    } else {
                        System.out.println("Withdraw failed.");
                    }
                    backOption();
                    break;
                case 3:
                    // Balance
                    Main.bigGap();
                    System.out.println("Your balance: $" + String.format("%.2f", user.getBalance()));
                    backOption();
                    break;
                case 4:
                    // Transaction history
                    Main.bigGap();
                    System.out.println("Transactions:");
                    System.out.println();
                    if (user.getTransactions().isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (String transaction: user.getTransactions()) {
                            System.out.println(transaction);
                        }
                    }
                    backOption();
                    break;
                case 5:
                    // About Me
                    Main.bigGap();
                    System.out.print("Please enter PIN for confirmation: ");
                    int PINInput = scanner.nextInt();

                    if (user.checkPIN(PINInput)) {
                        System.out.println("Username: " + user.getUsername());
                        System.out.println("PIN: " + user.getPIN());
                    } else {
                        System.out.println("Incorrect PIN.");
                    }
                    backOption();
                    break;
                case 6:
                    // Log out
                    Main.bigGap();
                    System.out.println("Logging out.");
                    Main.delay(1);
                    break;
                default:
                    Main.bigGap();
                    System.out.println("Invalid menu choice, please try again.");
                    Main.delay(1);
            }

        } while (menuChoice != 6);
    }

    public void backOption() {
        System.out.println();
        System.out.print("Enter 1 to go back: ");
        int backButton = scanner.nextInt();

        while (backButton != 1) {
            System.out.println("Invalid choice, try again.");
            backButton = scanner.nextInt();
        }
    }
}