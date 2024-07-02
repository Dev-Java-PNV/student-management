package developer.controller;

import developer.model.Course;
import developer.service.interfaces.ICourseService;

import java.util.List;

public class CourseController {
    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
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