package developer.service.implement;

import developer.model.Course;
import developer.model.Enrollment;
import developer.model.Student;
import developer.repository.implement.EnrollmentRepository;
import developer.repository.interfaces.IEnrollmentRepository;
import developer.service.interfaces.IEnrollmentService;

import java.util.List;

public class EnrollmentService implements IEnrollmentService {

    private final IEnrollmentRepository enrollmentRepository;

    public EnrollmentService() {
        this.enrollmentRepository = new EnrollmentRepository(); // Corrected instantiation
    }

    @Override
    public void enrollStudent(Student student, Course course) {
        enrollmentRepository.enrollStudent(student, course);
    }

    @Override
    public Enrollment getEnrollment(int id) {
        return enrollmentRepository.getEnrollment(id);
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        enrollmentRepository.updateEnrollment(enrollment);
    }

    @Override
    public void deleteEnrollment(int id) {
        enrollmentRepository.deleteEnrollment(id);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.getAllEnrollments();
    }
}