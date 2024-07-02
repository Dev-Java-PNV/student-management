package developer.views;

import developer.controller.UserController;
import developer.model.Student;
import developer.model.Teacher;
import developer.model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView() {
        this.userController = new UserController();
    }
    public void displayUsers() {
        List<User> users = userController.getAllUsers();
        System.out.println("All users:");
        System.out.println("-".repeat(90));
        System.out.printf("%-10s | %-30s | %-30s | %-10s%n", "ID", "Name", "Email", "Password");
        System.out.println("-".repeat(90));
        for (User user : users) {
            System.out.printf("%-10s | %-30s | %-30s | %-10s%n",
                    truncate(user.getId(),10), truncate(user.getName(),30), truncate(user.getEmail(),30), truncate(user.getPassword(),30));
        }
        System.out.println("-".repeat(90));
    }

    public void createStudent() {
        Scanner scanner = new Scanner(System.in);

        Student newStudent = new Student();

        System.out.println("Enter Student Name: ");
        newStudent.setName(scanner.nextLine());

        System.out.println("Enter Student Email: ");
        newStudent.setEmail(scanner.nextLine());

        System.out.println("Enter Student Password: ");
        newStudent.setPassword(scanner.nextLine());

        userController.createStudent(newStudent);
    }

    public void createTeacher() {
        Scanner scanner = new Scanner(System.in);

        Teacher newTeacher = new Teacher();

        System.out.println("Enter Teacher Name: ");
        newTeacher.setName(scanner.nextLine());

        System.out.println("Enter Teacher Email: ");
        newTeacher.setEmail(scanner.nextLine());

        System.out.println("Enter Teacher Password: ");
        newTeacher.setPassword(scanner.nextLine());

        userController.createTeacher(newTeacher);
    }

    private static String truncate(String str, int v) {
        if (str.length() > v) {
            return str.substring(0, v - 3) + "...";
        } else {
            return str;
        }
    }
}
