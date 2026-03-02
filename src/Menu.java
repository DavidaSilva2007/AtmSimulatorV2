import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void menu(User user) {
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

                    System.out.print("Enter deposit amount: ");

                    double depositAmount = scanner.nextDouble();

                    if (user.deposit(depositAmount)) {
                        System.out.println("Successfully deposit.");
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    backOption();
                    break;
                case 2:
                    // Withdraw
                    Main.bigGap();

                    System.out.print("Enter deposit amount: ");

                    double withdrawAmount = scanner.nextDouble();

                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("Successfully withdraw.");
                    } else {
                        System.out.println("Withdraw failed.");
                    }
                    backOption();
                    break;
                case 3:
                    // Balance
                    Main.bigGap();

                    System.out.println("Your balance: $" + user.getBalance());
                    backOption();
                    break;
                case 4:
                    // Transaction history
                    Main.bigGap();

                    System.out.println("Transactions:");
                    for (String i: user.getTransactions()) {
                        System.out.println(i);
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
                        System.out.println("PIN " + user.getPIN());
                    }
                    backOption();
                    break;
                case 6:
                    // Log out
                    Main.bigGap();

                    System.out.println("Logging out.");
                    backOption();
                    break;
                default:
                    Main.bigGap();

                    System.out.println("Invalid menu choice, please try again.");
                    Main.delay(1);
            }

        } while (menuChoice != 5);
    }

    public void backOption() {
        System.out.println();

        int backButton;

        System.out.print("Enter 1 to go back: ");
        backButton = scanner.nextInt();

        while (backButton != 1) {
            System.out.println("Invalid choice, try again.");
            backButton = scanner.nextInt();
        }
    }
}