import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        ArrayList<User> users = data.loadUsers();

        StartMenu startMenu =  new StartMenu();
        startMenu.start(users, data);
    }

    public static void delay(double delaySeconds) {
        try {
            Thread.sleep((long) (delaySeconds * 1000)); // Input is converted to seconds not milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupt flag
        }
    }

    public static void bigGap() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}