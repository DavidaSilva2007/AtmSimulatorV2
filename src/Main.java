public class Main {
    public static void main(String[] args) {
        User newUser = new User(123);
        System.out.println(newUser.getBalance());
        System.out.println(newUser.checkPassword(123));
    }
}
