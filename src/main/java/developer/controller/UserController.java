package developer.controller;

import developer.model.Student;
import developer.model.Teacher;
import developer.model.User;
import developer.service.implement.UserService;
import developer.service.interfaces.IUserService;
import developer.repository.mapperImplement.UserMapper;

import java.util.List;
import java.util.UUID;

public class UserController {
    private final IUserService userService;

    public UserController() {
        this.userService = new UserService(new UserMapper());
    }

    public void createStudent(Student student) {
        student.setId(
                "US-"+ UUID.randomUUID().toString()
        );
        student.setStudentId(
                "ST-"+UUID.randomUUID().toString()
        );
        student.setRole(
                "student"
        );
        userService.createStudent(student);
        System.out.println("Created student: " + student.getName());
    }

    public void createTeacher(Teacher teacher) {
        teacher.setId(
                "US-"+ UUID.randomUUID().toString()
        );
        teacher.setTeacherId(
                "TC-"+UUID.randomUUID().toString()
        );
        teacher.setRole(
                "teacher"
        );
        userService.createTeacher(teacher);
        System.out.println("Created teacher: " + teacher.getName());
    }

    public User getUser(String id) {
        return userService.getUser(id);
    }

    public void updateUser(User user) {
        userService.updateUser(user);
    }

    public void deleteUser(String id) {
        userService.deleteUser(id);
        System.out.println("Delete successfully");
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}