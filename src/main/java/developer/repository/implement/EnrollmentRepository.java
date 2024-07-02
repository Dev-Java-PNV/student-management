package developer.repository.implement;

import developer.model.Course;
import developer.model.Enrollment;
import developer.model.Student;
import developer.repository.interfaces.IEnrollmentRepository;
import developer.repository.mapperImplement.EnrollmentMapper;
import developer.repository.mapperInterfaces.IEnrollmentMapper;
import developer.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository implements IEnrollmentRepository {
    private final Connection connection;
    private final IEnrollmentMapper enrollmentMapper;

    public EnrollmentRepository(Connection connection, IEnrollmentMapper enrollmentMapper) {
        this.connection = connection;
        this.enrollmentMapper = enrollmentMapper;
    }

    public EnrollmentRepository() {
        this.connection = DBConnector.getConnection();
        this.enrollmentMapper = new EnrollmentMapper();
    }

    @Override
    public void enrollStudent(Student student, Course course) {
        String sql = "INSERT INTO Enrollment (studentId, courseId) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, student.getStudentId());
            stmt.setInt(2, course.getCourseId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Enrollment getEnrollment(int id) {
        Enrollment enrollment = null;
        String sql = "SELECT * FROM Enrollment WHERE enrollmentId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                enrollment = enrollmentMapper.mapRow(rs, new Student(), new Course());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollment;
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        String sql = "UPDATE Enrollment SET studentId = ?, courseId = ? WHERE enrollmentId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, enrollment.getStudent().getStudentId());
            stmt.setInt(2, enrollment.getCourse().getCourseId());
            stmt.setInt(3, enrollment.getEnrollmentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEnrollment(int id) {
        String sql = "DELETE FROM Enrollment WHERE enrollmentId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM Enrollment";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = enrollmentMapper.mapRow(rs, new Student(), new Course());
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}
