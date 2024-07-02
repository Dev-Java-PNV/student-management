package developer.repository.interfaces;

import developer.model.Course;
import developer.model.Enrollment;
import developer.model.Student;

import java.util.List;

public interface IEnrollmentRepository {
    void enrollStudent(Student student, Course course);
    Enrollment getEnrollment(int id);
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(int id);
    List<Enrollment> getAllEnrollments();
}
