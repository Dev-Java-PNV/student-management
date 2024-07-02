package developer.repository.interfaces;

import developer.model.Course;

import java.util.List;

public interface ICourseRepository {
    void save(Course course);
    Course findById(int id);
    void update(Course course);
    void delete(int id);
    List<Course> findAll();
}
