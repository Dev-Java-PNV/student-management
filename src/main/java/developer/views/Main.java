package developer.views;

import developer.views.components.ListUser;

public class Main {
    public static void main(String[] args) {
        ListUser listUserPage = new ListUser();
        listUserPage.displayUsers();
    }
}