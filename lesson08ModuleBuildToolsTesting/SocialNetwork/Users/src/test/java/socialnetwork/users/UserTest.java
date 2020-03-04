package ru.sbertech.javaschoolrnd.d1zab.SocialNetwork.Users.src.test.java.socialnetwork.users;

import org.junit.Test;
import ru.sbertech.javaschoolrnd.d1zab.lesson08ModuleBuildToolsTesting.SocialNetwork.Users.src.main.java.socialnetwork.users.Gender;
import ru.sbertech.javaschoolrnd.d1zab.lesson08ModuleBuildToolsTesting.SocialNetwork.Users.src.main.java.socialnetwork.users.User;

import static org.junit.Assert.*;

public class UserTest {
    User user = new User();

    @Test
    public void getsetName() throws Exception {
        user.setName("Ivan");
        assertEquals(user.getName(), "Ivan");
    }

    @Test
    public void getsetAge() throws Exception {
        user.setAge(100);
        assertEquals(user.getAge(), 100);
    }

    @Test
    public void getsetGender() throws Exception {
        user.setGender(Gender.MALE);
        assertEquals(user.getGender(), Gender.MALE);
    }

    @Test
    public void getsetInfo() throws Exception {
        user.setInfo("Test info");
        assertEquals(user.getInfo(), "Test info");
    }
}