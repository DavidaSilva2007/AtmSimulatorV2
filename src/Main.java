import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Jack", 100));
        users.add(new User("Bob", 123));

        User jack = users.get(0);
        User bob = users.get(1);

        System.out.println(jack.getUsername());
        System.out.println(jack.getBalance());

        System.out.println(bob.getUsername());
        System.out.println(bob.getBalance());

        // Test deposits & withdrawals
        jack.deposit(500);
        jack.withdraw(200);

        bob.deposit(1000);

        // Print transaction history
        System.out.println("Jack Transactions:");
        for (String t : jack.getTransactions()) {
            System.out.println(t);
        }

        System.out.println("\nBob Transactions:");
        for (String t : bob.getTransactions()) {
            System.out.println(t);
        }


    }
}