package developer.repository;

import developer.model.User;
import developer.model.UserMapper;

public class UserRepository extends BaseRepository<User> {
    public UserRepository() {
        super("users", new UserMapper());
    }
}
