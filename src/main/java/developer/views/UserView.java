package developer.views;

import developer.controller.UserController;
import developer.model.Student;
import developer.model.Teacher;
import developer.model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final UserController userController;
    private static final Scanner scanner = new Scanner(System.in);
    public UserView() {
        this.userController = new UserController();
    }
    private void readStudentData(){
        List<User> users = userController.getAllUsers();

        System.out.println("*".repeat(20));
        System.out.println("Student Data:");
        System.out.println("*".repeat(20));

        System.out.println("-".repeat(150));
        System.out.printf("%-40s | %-30s | %-30s | %-20s | %-30s%n", "ID", "Name", "Email", "Password","Role");
        System.out.println("-".repeat(150));
        for (User user : users) {
            if (user.getRole().equals("student")) {
                System.out.printf("%-40s | %-30s | %-30s | %-20s | %-30s%n",
                        (user.getId()), truncate(user.getName(),30), truncate(user.getEmail(),30), truncate(user.getPassword(),30), truncate(user.getRole(),30));
            }
        }
        System.out.println("-".repeat(150));

    }
    private void readTeacherData(){
        List<User> users = userController.getAllUsers();

        System.out.println("*".repeat(20));
        System.out.println("Teacher Data:");
        System.out.println("*".repeat(20));

        System.out.println("-".repeat(150));
        System.out.printf("%-40s | %-30s | %-30s | %-20s | %-30s%n", "ID", "Name", "Email", "Password","Role");
        System.out.println("-".repeat(150));
        for (User user : users) {
            if (user.getRole().equals("teacher")) {
                System.out.printf("%-40s | %-30s | %-30s | %-20s | %-30s%n",
                        (user.getId()), truncate(user.getName(),30), truncate(user.getEmail(),30), truncate(user.getPassword(),30), truncate(user.getRole(),30));
            }
        }
        System.out.println("-".repeat(150));

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
    private void readListIdUser(){
        List<User> users = userController.getAllUsers();
        System.out.println("*".repeat(20));
        System.out.println("List Id Of Users Data:");
        System.out.println("*".repeat(20));

        System.out.println("-".repeat(115));
        System.out.printf("%-50s | %-30s%n", "ID", "Name");
        System.out.println("-".repeat(115));
        for (User user : users) {
            System.out.printf("%-50s |%-30s%n",
                    (user.getId()), truncate(user.getName(),30));
        }
        System.out.println("-".repeat(115));
    }
    private void updateUserData() {
        readListIdUser();
        System.out.println("Enter Student ID: ");
        String Id = scanner.nextLine();
        User user = getByID(Id);
        if (user==null){
            return;
        }
        updateChoice(user);
    }
    private void updateStudentData() {
        readStudentData();
        System.out.println("Enter Student ID: ");
        String Id = scanner.nextLine();
        User user = getByID(Id);
        if (user==null){
            return;
        }
        updateChoice(user);
    }
    private User getByID(String Id){
        User user = userController.getUser(Id);
        if (user == null) {
            System.out.println("User not found!");
            return null;
        }
        System.out.println("*".repeat(20));
        System.out.println("Student By ID is :"+ Id);
        System.out.println("*".repeat(20));
        System.out.printf("%-10s | %-30s | %-30s | %-20s | %-30s%n",
                truncate(user.getId(),10), truncate(user.getName(),30), truncate(user.getEmail(),30), truncate(user.getPassword(),30), truncate(user.getRole(),30));
        return user;
    }
    private void updateTeacherData() {
        readTeacherData();
        System.out.println("Enter Student ID: ");
        String Id = scanner.nextLine();
        User user = getByID(Id);
        if (user==null){
            return;
        }
        updateChoice(user);
    }
    private void updateChoice(User user){
        boolean exit = false;
        while (!exit) {
            int choice = getUpdateChoice();
            switch (choice) {
                case 1:
                    updateAll(user);
                    break;
                case 2:
                    updateName(user);
                    break;
                case 3:
                    updateEmail(user);
                    break;
                case 4:
                    updatePassword(user);
                    break;
                case 5:
                    updateRole(user);
                    break;
                case 6:
                    getByID(user.getId());
                    break;
                case 0:
                    exit = true;
                    System.out.println("Goodbye!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static int getUpdateChoice() {
        System.out.println("Choose an option to update:");
        System.out.println("1. Update All");
        System.out.println("2. Update Name");
        System.out.println("3. Update Email");
        System.out.println("4. Update Password");
        System.out.println("5. Update Role");
        System.out.println("6. Detail Info Updated");
        System.out.println("0. Exit");
        return scanner.nextInt();
    }
    private void updateAll(User user) {
        scanner.nextLine();
        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Student Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Student Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter Student Role: ");
        String role = scanner.nextLine();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        userController.updateUser(user);
        System.out.println("User updated successfully.");
    }
    private void updateName(User user) {
        scanner.nextLine();
        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        user.setName(name);
        userController.updateUser(user);
        System.out.println("Name updated successfully.");
    }
    private void updateEmail(User user) {
        scanner.nextLine();
        System.out.println("Enter Student Email: ");
        String email = scanner.nextLine();
        user.setEmail(email);
        userController.updateUser(user);
        System.out.println("Email updated successfully.");
    }
    private void updatePassword(User user) {
        scanner.nextLine();
        System.out.println("Enter Student Password: ");
        String password = scanner.nextLine();
        user.setPassword(password);
        userController.updateUser(user);
        System.out.println("Password updated successfully.");
    }
    private void updateRole(User user) {
        scanner.nextLine();
        System.out.println("Enter Student Role: ");
        String role = scanner.nextLine();
        user.setRole(role);
        userController.updateUser(user);
        System.out.println("Role updated successfully.");
    }
    private void deleteUser(){
        readListIdUser();
        System.out.println("Enter User ID: ");
        String Id = scanner.nextLine();
        userController.deleteUser(Id);
    }
    private void deleteStudent(){
        readStudentData();
        System.out.println("Enter Student ID: ");
        String Id = scanner.nextLine();
        userController.deleteUser(Id);
    }
    private void deleteTeacher(){
        readTeacherData();
        System.out.println("Enter Teacher ID: ");
        String Id = scanner.nextLine();
        userController.deleteUser(Id);
    }
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isNext = true;
        do {
            System.out.println("-".repeat(115));
            System.out.println("1. Display All User");
            System.out.println("2. Display Student");
            System.out.println("3. Display Teacher");
            System.out.println("4. Add Student");
            System.out.println("5. Add Teacher");
            System.out.println("6. Update User");
            System.out.println("7. Update Student");
            System.out.println("8. Update Teacher");
            System.out.println("9. Delete User");
            System.out.println("10. Delete Student");
            System.out.println("11. Delete Teacher");
            System.out.println("0. Exit");
            System.out.println("-".repeat(115));

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("*".repeat(20));
                    System.out.println("Good Bye!!");
                    System.out.println("*".repeat(20));
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
                    createStudent();
                    break;
                case 5:
                    createTeacher();
                    break;
                case 6:
                    updateUserData();
                    break;
                case 7:
                    updateStudentData();
                    break;
                case 8:
                    updateTeacherData();
                    break;
                case 9:
                    deleteUser();
                    break;
                case 10:
                    deleteStudent();
                    break;
                case 11:
                    deleteTeacher();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

            if (choice != 0) {
                System.out.print("Press Enter to continue or type any other key to exit!!");
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    isNext = false;
                    System.out.println("*".repeat(20));
                    System.out.println("Good Bye!!");
                    System.out.println("*".repeat(20));
                }
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
