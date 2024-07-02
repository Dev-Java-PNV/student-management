package developer.repository.mapperInterfaces;

import developer.model.Course;
import developer.model.Enrollment;
import developer.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IEnrollmentMapper {
    Enrollment mapRow(ResultSet rs, Student student, Course course) throws SQLException;
}
