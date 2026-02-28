import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void menu(User user) {
        int menuChoice;

        do {
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
                case 2:
                    // Withdraw
                    System.out.print("Enter deposit amount: ");

                    double withdrawAmount = scanner.nextDouble();

                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("Successfully deposit.");
                    } else {
                        System.out.println("Deposit failed.");
                    }
                case 3:
                    System.out.println("Your balance: $" + user.getBalance());
                    // Balance
                case 4:
                    break;
                    // Transaction history
                case 5:
                    System.out.println("Logging out.");
                    // Log out
                default:
                    System.out.println("Invalid menu choice, please try again.");
            }

        } while (menuChoice != 5);
    }
}