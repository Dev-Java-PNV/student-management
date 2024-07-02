package developer;

import developer.views.UserView;

public class Main {
    public static void main(String[] args) {

        UserView userView = new UserView();
        userView.createStudent();
        userView.createTeacher();
        userView.displayUsers();

    }
}