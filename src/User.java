public class User {
    private double  balance;
    private int password;

    public User(int password) {
        this.balance = 1000;
        this.password = password;
    }

    private int getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean checkPassword(int inputPassword) {
        return password == inputPassword;
    }
}
