package developer.repository.mapperImplement;

import developer.model.Course;
import developer.repository.mapperInterfaces.ICourseMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements ICourseMapper {
    @Override
    public Course mapRow(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getInt("course_id"));
        course.setCourseName(rs.getString("course_name"));
        return course;
    }
}
