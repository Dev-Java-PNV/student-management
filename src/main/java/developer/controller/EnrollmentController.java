package developer.controller;

import developer.model.Course;
import developer.model.Enrollment;
import developer.model.Student;
import developer.service.interfaces.IEnrollmentService;

import java.util.List;

public class EnrollmentController {
    private final IEnrollmentService enrollmentService;

    public EnrollmentController(IEnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public void enrollStudent(Student student, Course course) {
        enrollmentService.enrollStudent(student, course);
    }

    public Enrollment getEnrollment(int id) {
        return enrollmentService.getEnrollment(id);
    }

    public void updateEnrollment(Enrollment enrollment) {
        enrollmentService.updateEnrollment(enrollment);
    }

    public void deleteEnrollment(int id) {
        enrollmentService.deleteEnrollment(id);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
}