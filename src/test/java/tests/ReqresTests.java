package tests

import adapters.UserListAdapter;
import adapters.UsersAdapter;
import models.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.testng.Assert.assertEquals;

public class ReqresTests extends BaseTest {

    private void inputUserData(String name, String job) {
        JobUser user = new UsersAdapter().post(new JobUser(name, job, "", ""));
        System.out.println(user);
    }

    @Test
    public void testList() throws FileNotFoundException {
        UsersList expectedList;
        expectedList = gson.fromJson(new FileReader("src/test/java/resources/expectedList.json"), UsersList.class);
        UsersList list = new UserListAdapter().get("users?page=1", 200);
        assertEquals(list, expectedList);
    }

    @Test
    public void createUser() {
        JobUser user = new UsersAdapter().post(new JobUser("name", "job", "", ""));
        System.out.println(user);
    }

// my tests

    @Test
    public void getListUsers() throws FileNotFoundException {
        UsersList expectedList;
        expectedList = gson.fromJson(new FileReader("src/test/java/resources/expectedListUsers.json"), UsersList.class);
        UsersList list = new UserListAdapter().get("users?page=2", 200);
        assertEquals(list, expectedList);
    }

    @Test
    public void getSingleUserData() throws FileNotFoundException {
        SingleUser user = new UsersAdapter().get("users/2", 200);
        SingleUser userData = gson.fromJson(new FileReader("src/test/java/resources/expectedSingleUserData.json"), SingleUser.class);
        assertEquals(user, userData);
    }

    @Test
    public void noFoundSingleUser() {
        SingleUser user = new UsersAdapter().get("users/23", 404);
        assertEquals("", "");
    }

    @Test
    public void getListUsersResource() throws FileNotFoundException {
        UsersList expectedList;
        expectedList = gson.fromJson(new FileReader("src/test/java/resources/expectedListResource.json"), UsersList.class);
        UsersList list = new UserListAdapter().get("unknown", 200);
        assertEquals(list, expectedList);
    }


    @Test
    public void getSingleResourceData() throws FileNotFoundException {
        SingleUser user = new UsersAdapter().get("unknown/2", 200);
        SingleUser userData = gson.fromJson(new FileReader("src/test/java/resources/expectedSingleResource.json"), SingleUser.class);
        assertEquals(user, userData);
    }

    @Test
    public void noFoundSingleResource() {
        SingleUser user = new UsersAdapter().get("unknown/23", 404);
        assertEquals("", "");
    }

    @Test
    public void createNewUsers() {
        inputUserData("morpheus", "leader");
    }

    @Test
    public void updateUsers() {
        UpdateUser user = new UsersAdapter().put(new UpdateUser("morpheus", "zion resident", ""));
        System.out.println(user);
    }

    @Test
    public void patchUsers() {
        UpdateUser user = new UsersAdapter().patch(new UpdateUser("morpheus", "zion resident", ""));
        System.out.println(user);
    }


    @Test
    public void deleteUser() {
        int responseCode = new UsersAdapter().delete("users/2");
        assertEquals(204, responseCode);
    }


    @Test
    public void registerSuccessful() throws FileNotFoundException {
        RegisterSuccessful user = new UsersAdapter().post(new RegisterSuccessful("eve.holt@reqres.in", "pistol", "", ""));
        RegisterSuccessful userData = gson.fromJson(new FileReader("src/test/java/resources/registerSuccessful.json"), RegisterSuccessful.class);
        assertEquals(userData, user);
    }

    @Test
    public void registerUnSuccessful() throws FileNotFoundException {
        RegisterUnSuccessful user = new UsersAdapter().post(new RegisterUnSuccessful("sydney@fife", ""));
        RegisterUnSuccessful userData = gson.fromJson(new FileReader("src/test/java/resources/registerUnSuccessful.json"), RegisterUnSuccessful.class);
        assertEquals(userData, user);
    }

    @Test
    public void loginSuccessful() throws FileNotFoundException {
        Login user = new UsersAdapter().loginSuccessful(new Login("eve.holt@reqres.in", "cityslicka"));
        Login userData = gson.fromJson(new FileReader("src/test/java/resources/loginSuccessful.json"), Login.class);
        assertEquals(userData, user);
    }

    @Test
    public void loginUnSuccessful() throws FileNotFoundException {
        Login user = new UsersAdapter().loginUnSuccessful(new Login("peter@klaven"));
        Login userData = gson.fromJson(new FileReader("src/test/java/resources/registerUnSuccessful.json"), Login.class);
        assertEquals(userData, user);
    }


    @Test
    public void testDelayedResponse() throws FileNotFoundException {
        UsersList expectedList;
        expectedList = gson.fromJson(new FileReader("src/test/java/resources/expectedList.json"), UsersList.class);
        UsersList list = new UserListAdapter().get("users?delay=3", 200);
        assertEquals(list, expectedList);
    }

}
