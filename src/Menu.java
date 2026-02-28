import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void menu(User user) {
        int menuChoice;

        do {
            System.out.println("-- ATM Menu --");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
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
                    break;
                case 3:
                    // Balance
                    System.out.println("Your balance: $" + user.getBalance());
                    break;
                case 4:
                    // Transaction history
                    System.out.println("Transactions:");
                    for (String i: user.getTransactions()) {
                        System.out.println(i);
                    }
                    break;
                case 5:
                    // Log out
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid menu choice, please try again.");
            }

        } while (menuChoice != 5);
    }
}