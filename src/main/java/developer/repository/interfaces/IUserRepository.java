package developer.repository.interfaces;

import developer.model.Student;
import developer.model.Teacher;
import developer.model.User;

import java.util.List;

public interface IUserRepository {
    void save(User user);
    void update(User user);
    User findById(String id);
    List<User> findAll();
    void delete(String id);
    void saveStudent(Student student);
    void saveTeacher(Teacher teacher);
}