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
    private void readStudentData(){
        List<User> users = userController.getAllUsers();

        System.out.println("*".repeat(20));
        System.out.println("Student Data:");
        System.out.println("*".repeat(20));

        System.out.println("-".repeat(115));
        System.out.printf("%-10s | %-30s | %-30s | %-20s | %-30s%n", "ID", "Name", "Email", "Password","Role");
        System.out.println("-".repeat(115));
        for (User user : users) {
            if (user.getRole().equals("student")) {
                System.out.printf("%-10s | %-30s | %-30s | %-20s | %-30s%n",
                        truncate(user.getId(),10), truncate(user.getName(),30), truncate(user.getEmail(),30), truncate(user.getPassword(),30), truncate(user.getRole(),30));
            }
        }
        System.out.println("-".repeat(115));

    }
    private void readTeacherData(){
        List<User> users = userController.getAllUsers();

        System.out.println("*".repeat(20));
        System.out.println("Teacher Data:");
        System.out.println("*".repeat(20));

        System.out.println("-".repeat(115));
        System.out.printf("%-10s | %-30s | %-30s | %-20s | %-30s%n", "ID", "Name", "Email", "Password","Role");
        System.out.println("-".repeat(115));
        for (User user : users) {
            if (user.getRole().equals("teacher")) {
                System.out.printf("%-10s | %-30s | %-30s | %-20s | %-30s%n",
                        truncate(user.getId(),10), truncate(user.getName(),30), truncate(user.getEmail(),30), truncate(user.getPassword(),30), truncate(user.getRole(),30));
            }
        }
        System.out.println("-".repeat(115));

    }
    private void readAllUserData() {
        List<User> users = userController.getAllUsers();
        System.out.println("*".repeat(20));
        System.out.println("All Users Data:");
        System.out.println("*".repeat(20));

        System.out.println("-".repeat(115));
        System.out.printf("%-10s | %-30s | %-30s | %-20s | %-30s%n", "ID", "Name", "Email", "Password","Role");
        System.out.println("-".repeat(115));
        for (User user : users) {
            System.out.printf("%-10s | %-30s | %-30s | %-20s | %-30s%n",
                    truncate(user.getId(),10), truncate(user.getName(),30), truncate(user.getEmail(),30), truncate(user.getPassword(),30), truncate(user.getRole(),30));
        }
        System.out.println("-".repeat(115));
    }

    private void createStudent() {
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

    private void createTeacher() {
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

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isNext = true;
        do {
            System.out.println("-".repeat(115));
            System.out.println("1. Display All User");
            System.out.println("2. Display Student");
            System.out.println("3. Display Teacher");
            System.out.println("4. Add User");
            System.out.println("5. Add Student");
            System.out.println("6. Add Teacher");
            System.out.println("7. Update User");
            System.out.println("8. Update Student");
            System.out.println("9. Update Teacher");
            System.out.println("10. Delete User");
            System.out.println("11. Delete Student");
            System.out.println("12. Delete Teacher");
            System.out.println("0. Exit");
            System.out.println("-".repeat(115));

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    isNext = false;
                    break;
                case 1:
                    readAllUserData();
                    break;
                case 2:
                    readStudentData();
                    break;
                case 3:
                    readTeacherData();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

            if (choice != 0) {
                System.out.print("Do you want to continue? (true/false): ");
                isNext = scanner.nextBoolean();
                scanner.nextLine();
            }
        } while (isNext);
        scanner.close();
    }

    private static String truncate(String str, int v) {
        if (str.length() > v) {
            return str.substring(0, v - 3) + "...";
        } else {
            return str;
        }
    }
}
