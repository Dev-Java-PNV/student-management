package developer.service.implement;

import developer.model.Course;
import developer.repository.implement.CourseRepository;
import developer.repository.interfaces.ICourseRepository;
import developer.repository.mapperImplement.CourseMapper;
import developer.service.interfaces.ICourseService;

import java.util.List;

public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;

    public CourseService(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course getCourse(String id) {
        return courseRepository.findById(Integer.parseInt(id));
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.update(course);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.delete(Integer.parseInt(id));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
