package developer.controller;

import developer.model.User;
import developer.service.UserService;
import developer.service.interfaces.IUserService;

import java.util.List;

public class UserController {
    private final IUserService<User> userService;

    public UserController() {
        this.userService = new UserService();
    }

    public List<User> getAllUsers() {
        return userService.getUserData();
    }
}