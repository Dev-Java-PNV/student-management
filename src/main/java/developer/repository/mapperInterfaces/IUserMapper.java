package developer.repository.mapperInterfaces;

import developer.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IUserMapper {
    User mapRow(ResultSet rs) throws SQLException;
}