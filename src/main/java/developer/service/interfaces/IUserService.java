package developer.service.interfaces;

import developer.model.Student;
import developer.model.Teacher;
import developer.model.User;

import java.util.List;

public interface IUserService {
    void createUser(User user);
    User getUser(String id);
    void updateUser(User user);
    void deleteUser(String id);
    List<User> getAllUsers();
    void createStudent(Student student);
    void createTeacher(Teacher teacher);
}