package developer.controller;

import developer.model.Course;
import developer.repository.mapperImplement.CourseMapper;
import developer.service.implement.CourseService;
import developer.service.interfaces.ICourseService;

import java.util.List;
import java.util.UUID;

public class CourseController {
    private final ICourseService courseService;

    public CourseController() {
        this.courseService = new CourseService(new CourseMapper());
    }

    public void createCourse(Course course) {
        courseService.createCourse(course);
    }

    public Course getCourse(String id) {
        return courseService.getCourse(id);
    }

    public void updateCourse(Course course) {
        courseService.updateCourse(course);
    }

    public void deleteCourse(String id) {
        courseService.deleteCourse(id);
    }

    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
}