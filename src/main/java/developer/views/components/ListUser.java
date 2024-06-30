package developer.views.components;

import developer.controller.UserController;
import developer.model.User;

import java.util.List;

public class ListUser {
    private final UserController userController;

    public ListUser() {
        this.userController = new UserController();
    }

    public void displayUsers() {
        List<User> users = userController.getAllUsers();
        System.out.println("All users:");
        for (User user : users) {
            System.out.println(user.getId() + ", " + user.getName());
        }
    }

}
