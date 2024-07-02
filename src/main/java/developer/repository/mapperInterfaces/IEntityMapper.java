package developer.repository.mapperInterfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IEntityMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}