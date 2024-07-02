package developer.service.implement;

import developer.model.Student;
import developer.model.Teacher;
import developer.model.User;
import developer.repository.implement.UserRepository;
import developer.repository.interfaces.IEntityMapper;
import developer.service.interfaces.IUserService;
import developer.repository.mapperImplement.UserMapper;

import java.util.List;

public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(IEntityMapper<User> userMapper) {
        this.userRepository = new UserRepository(userMapper);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createStudent(Student student) {
        userRepository.saveStudent(student);
    }

    @Override
    public void createTeacher(Teacher teacher) {
        userRepository.saveTeacher(teacher);
    }
}
