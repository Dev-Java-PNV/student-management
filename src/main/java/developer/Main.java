package developer;

import developer.views.CourseView;
import developer.views.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }
    public static void showMenu(){
        System.out.println("1. User View");
        System.out.println("2. Course View");
        System.out.println("0. Exit");
        boolean isNext = true;
        Scanner scanner = new Scanner(System.in);
        while(isNext){
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    UserView userView = new UserView();
                    userView.showMenu();
                    break;
                case 2:
                    CourseView courseView = new CourseView();
                    courseView.showMenu();
                    break;
                case 0:
                    System.out.println("*".repeat(20));
                    System.out.println("See you next time!!");
                    System.out.println("*".repeat(20));
                    isNext = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;

            }
        }
    }
}