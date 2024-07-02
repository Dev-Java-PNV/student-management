package developer.repository.mapperImplement;

import developer.model.Course;
import developer.model.Enrollment;
import developer.model.Student;
import developer.repository.mapperInterfaces.IEnrollmentMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentMapper implements IEnrollmentMapper {
    @Override
    public Enrollment mapRow(ResultSet rs, Student student, Course course) throws SQLException {
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentId(rs.getInt("enrollment_id"));

        // Set student details
        student.setStudentId(rs.getString("student_id")); // Assuming student_id is retrieved from ResultSet
        enrollment.setStudent(student);

        // Set course details
        course.setCourseId(rs.getInt("course_id")); // Assuming course_id is retrieved from ResultSet
        enrollment.setCourse(course);

        return enrollment;
    }
}
