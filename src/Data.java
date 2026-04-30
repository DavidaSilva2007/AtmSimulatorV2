import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Data {
    private static final String FILE_PATH = "data.json";

    public void saveUsers(ArrayList<User> users) {
        JSONArray jsonUsers = new JSONArray();

        for (User user : users) {
            JSONObject jsonUser = new JSONObject();
            jsonUser.put("username", user.getUsername());
            jsonUser.put("PIN", user.getPIN());
            jsonUser.put("balance", user.getBalance());

            JSONArray jsonTransactions = new JSONArray();
            for (String transaction : user.getTransactions()) {
                jsonTransactions.put(transaction);
            }
            jsonUser.put("transactions", jsonTransactions);

            jsonUsers.put(jsonUser);
        }

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(jsonUsers.toString(2));
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return users;
        }

        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            JSONArray jsonUsers = new JSONArray(content);

            for (int i = 0; i < jsonUsers.length(); i++) {
                JSONObject jsonUser = jsonUsers.getJSONObject(i);

                String username = jsonUser.getString("username");
                int PIN = jsonUser.getInt("PIN");
                double balance = jsonUser.getDouble("balance");

                User user = new User(username, PIN, balance);
                JSONArray jsonTransaction = jsonUser.getJSONArray("transactions");

                for (int j = 0; j < jsonTransaction.length(); j++) {
                    user.getTransactions().add(jsonTransaction.getString(j));
                }
                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return users;
    }
}