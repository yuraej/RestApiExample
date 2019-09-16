package tests;

import adapters.UserListAdapter;
import models.UsersList;

public class RequresTests {

    public static void main(String[] args) {
        UsersList list = new UserListAdapter().get();
        System.out.println(list);
        System.out.println(list.getData().get(1).getEmail());
    }
}
