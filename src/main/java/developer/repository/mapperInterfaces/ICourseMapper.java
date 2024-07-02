package developer.repository.mapperInterfaces;

import developer.model.Course;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ICourseMapper {
    Course mapRow(ResultSet rs) throws SQLException;
}
