package tests;

import adapters.UserListAdapter;
import models.User;
import models.UsersList;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ReqresTests {

    @Test
    public void testList() {
        UsersList expectedList = new UsersList();
        expectedList.setData(Arrays.asList(
                new User(1, "test", "", "", "")
        ));
        UsersList list = new UserListAdapter().get(1);
        assertEquals(list, expectedList);
    }
}
