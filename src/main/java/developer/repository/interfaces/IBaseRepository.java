package developer.repository.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IBaseRepository<T> {
    List<T> getAll() throws SQLException;
}
