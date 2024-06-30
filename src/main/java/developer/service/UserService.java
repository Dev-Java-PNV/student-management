package developer.service;

import developer.model.User;
import developer.repository.UserRepository;
import developer.service.interfaces.IUserService;

import java.util.List;

public class UserService implements IUserService<User> {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    @Override
    public List<User> getUserData() {
        try {
            return userRepository.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}