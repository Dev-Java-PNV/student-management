package developer.repository.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IEntityMapper<T> {
    T map(ResultSet rs) throws SQLException;
}
