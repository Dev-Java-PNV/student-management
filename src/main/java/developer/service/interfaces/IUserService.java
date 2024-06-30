package developer.service.interfaces;

import java.util.List;

public interface IUserService<T> {
    List<T> getUserData();
}
