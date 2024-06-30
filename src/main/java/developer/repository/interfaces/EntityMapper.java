package developer.repository.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapper<V> {
    V map(ResultSet rs) throws SQLException;
}
