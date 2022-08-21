package jdbcExample.db;

import jdbcExample.db.manager.UserManager;
import jdbcExample.db.model.User;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserManager userManager = new UserManager();

        try {
//            User user = new User("Hayk", "Manukyan", "haykmanukyan2003@gmail.com", "password12356");
//            userManager.addUser(user);
//            System.out.println(user);

            List<User> allUsers = userManager.getAllUsers();
            for (User users : allUsers) {
                System.out.println(users);
            }

            System.out.println();

            userManager.deleteUserById(10);
            allUsers = userManager.getAllUsers();
            for (User users : allUsers) {
                System.out.println(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
