package developer.repository;

import developer.DBConnector;
import developer.repository.interfaces.IBaseRepository;
import developer.repository.interfaces.EntityMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseRepository<T> implements IBaseRepository<T> {
    protected String tableName;
    protected EntityMapper<T> entityMapper;

    public BaseRepository(String tableName, EntityMapper<T> entityMapper) {
        this.tableName = tableName;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<T> getAll() throws SQLException {
        List<T> entities = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                T entity = entityMapper.map(rs);
                entities.add(entity);
            }
        }
        return entities;
    }
}