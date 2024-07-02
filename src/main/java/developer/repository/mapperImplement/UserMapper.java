package developer.repository.mapperImplement;

import developer.model.User;
import developer.repository.interfaces.IEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IEntityMapper<User> {

    @Override
    public User map(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
