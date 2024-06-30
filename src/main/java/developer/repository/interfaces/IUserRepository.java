package developer.repository.interfaces;

import developer.model.User;

public interface IUserRepository extends IBaseRepository<User> {
    User findByUsername(String username);
}
