package developer.service.interfaces;

import developer.model.Course;

import java.util.List;

public interface ICourseService {
    void createCourse(Course course);
    Course getCourse(String id);
    void updateCourse(Course course);
    void deleteCourse(String id);
    List<Course> getAllCourses();
}