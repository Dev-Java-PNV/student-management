package developer.repository.implement;

import developer.DBConnector;
import developer.model.Course;
import developer.repository.interfaces.ICourseRepository;
import developer.repository.mapperInterfaces.ICourseMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements ICourseRepository {

    private final Connection connection;
    private final ICourseMapper courseMapper;

    public CourseRepository(ICourseMapper courseMapper) {
        this.connection = DBConnector.getConnection();
        this.courseMapper = courseMapper;
    }

    @Override
    public void save(Course course) {
        String sql = "INSERT INTO Course (courseName) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, course.getCourseName());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                course.setCourseId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course findById(int id) {
        String sql = "SELECT * FROM Course WHERE courseId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return courseMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Course course) {
        String sql = "UPDATE Course SET courseName = ? WHERE courseId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, course.getCourseName());
            statement.setInt(2, course.getCourseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Course WHERE courseId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Course";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Course course = courseMapper.mapRow(rs);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
