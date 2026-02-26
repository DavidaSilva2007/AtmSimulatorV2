import java.util.ArrayList;

public class User {
    private String username;
    private int password;
    private double  balance;
    private ArrayList<String> transactions;

    public User(String username, int password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public boolean checkPassword(int input) {
        return password == input;
    }

    public boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        } else {
            balance += amount;
            return true;
            // Add transaction Array
        }
    }

    public boolean withdraw(int amount) {
        if (amount <= 0) {
            return false;
        } else {
            balance -= amount;
            return true;
            // Add transaction Array
        }
    }

    private void addTransaction(String type, int amount) {
        // Use date and time, maybe there are libraries to do it for me?
    }
}
