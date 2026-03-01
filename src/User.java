import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User {
    private String username;
    private int PIN;
    private double  balance;
    private ArrayList<String> transactions;

    public User(String username, int PIN) {
        this.username = username;
        this.PIN = PIN;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public int getPIN() {
        return PIN;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public boolean checkPIN(int input) {
        return PIN == input;
    }

    public boolean deposit(double amount) {
        if (amount <= 0 && amount > balance) {
            return false;
        } else {
            balance += amount;
            addTransaction("Deposit", amount);
            return true;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        } else {
            balance -= amount;
            addTransaction("Withdraw", amount);
            return true;
        }
    }



    private void addTransaction(String type, double amount) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String record = now.format(customFormatter)
                + " | " + type
                + " | $" + amount
                + " | Balance: $" + balance;
        transactions.add(record);
    }
}