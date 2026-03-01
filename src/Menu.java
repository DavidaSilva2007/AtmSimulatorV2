import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void menu(User user) {
        int menuChoice;

        do {
            System.out.println();
            System.out.println("-- ATM Menu --");
            System.out.println();
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. About Me");
            System.out.println("5. Logout");

            System.out.print("Enter option: ");

            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    // Deposit
                    System.out.print("Enter deposit amount: ");

                    double depositAmount = scanner.nextDouble();

                    if (user.deposit(depositAmount)) {
                        System.out.println("Successfully deposit.");
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    Main.delay(1);
                    break;
                case 2:
                    // Withdraw
                    System.out.print("Enter deposit amount: ");

                    double withdrawAmount = scanner.nextDouble();

                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("Successfully deposit.");
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    Main.delay(1);
                    break;
                case 3:
                    // Balance
                    System.out.println("Your balance: $" + user.getBalance());
                    Main.delay(1);
                    break;
                case 4:
                    // Transaction history
                    System.out.println("Transactions:");
                    for (String i: user.getTransactions()) {
                        System.out.println(i);
                    }
                    Main.delay(1);
                    break;
                case 5:
                    // About
                    System.out.print("Please enter password for confirmation: ");

                    int passwordInput = scanner.nextInt();

                    if (user.checkPassword(passwordInput)) {
                        System.out.println("Username: " + user.getUsername());
                        System.out.println("Password " + user.getPassword());
                    }
                    Main.delay(1);
                    break;
                case 6:
                    // Log out
                    System.out.println("Logging out.");
                    Main.delay(1);
                    break;
                default:
                    System.out.println("Invalid menu choice, please try again.");
                    Main.delay(1);
            }

        } while (menuChoice != 5);
    }
}