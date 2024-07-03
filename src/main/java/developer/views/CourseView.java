package developer.views;

import developer.controller.CourseController;
import developer.model.Course;
import developer.model.Student;
import developer.model.User;

import java.util.List;
import java.util.Scanner;

public class CourseView {
    private final CourseController courseController;
    private static final Scanner scanner = new Scanner(System.in);
    public CourseView() {
        this.courseController = new CourseController();
    }
    private void readAllCourseData() {
        List<Course> data = courseController.getAllCourses();
        System.out.println("*".repeat(20));
        System.out.println("All Course Data:");
        System.out.println("*".repeat(20));

        System.out.println("-".repeat(115));
        System.out.printf("%-10s | %-30s%n", "ID", "Course Name");
        System.out.println("-".repeat(115));
        for (Course item : data) {
            System.out.printf("%-10s | %-30s%n",
                    (item.getCourseId()), (item.getCourseName()));
        }
        System.out.println("-".repeat(115));
    }
    private void createCourse() {

        Course newCourse = new Course();

        System.out.println("Enter Course Name: ");
        newCourse.setCourseName(scanner.nextLine());

        courseController.createCourse(newCourse);
    }
    private void updateCourseData() {
        readAllCourseData();
        System.out.println("Enter Course ID: ");
        String Id = scanner.nextLine();
        Course course = courseController.getCourse(Id);
        if (course==null){
            System.out.println("Course not found");
            return;
        }
        System.out.println("Change Course Name: ");
        String name = scanner.nextLine();
        course.setCourseName(name);
        courseController.updateCourse(course);
        System.out.println("Updated Course Successfully");
    }
    private void deleteCourse() {
        readAllCourseData();
        System.out.println("Enter Course ID: ");
        String Id = scanner.nextLine();
        Course course = courseController.getCourse(Id);
        if (course==null){
            System.out.println("Course not found");
            return;
        }
        courseController.deleteCourse(Id);
        System.out.println("Deleted Course Successfully");
    }
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isNext = true;
        do {
            System.out.println("-".repeat(90));
            System.out.println("1. Display All Course");
            System.out.println("2. Add Course");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("0. Exit");
            System.out.println("-".repeat(90));

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
                    readAllCourseData();
                    break;
                case 2:
                    createCourse();
                    break;
                case 3:
                    updateCourseData();
                    break;
                case 4:
                    deleteCourse();
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
        System.out.println("Home page");
        System.out.println("1. User View");
        System.out.println("2. Course View");
        System.out.println("0. Exit");
    }
}
