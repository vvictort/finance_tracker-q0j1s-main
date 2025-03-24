package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.User;

public class testUser {
    User myUser;
    List<Row> emptyList;

    @BeforeEach
    void runBefore() {
        myUser = new User(null, null, null);

        emptyList = new ArrayList<>();
    }

    @Test
    void testInital() {
        myUser = new User("CK", "Apples12!!", "Christine Kang");
        assertEquals("CK", myUser.getUserId());
        assertEquals("Apples12!!", myUser.getPassword());
        assertEquals("Christine Kang", myUser.getName());
        assertEquals(null, myUser.getloggedInfo());
    }

    @Test
    void testChangeName() {
        myUser.changeName("Matilda");
        assertEquals("Matilda", myUser.getName());

        myUser.changeName("Snoopy");
        myUser.changeName("Snoopy");
        assertEquals("Snoopy", myUser.getName());
    }

    @Test
    void testChangePW() {
        myUser.changePassword("Matilda'sChocolateCake");
        assertEquals("Matilda'sChocolateCake", myUser.getPassword());

        myUser.changePassword("ApplesNOranges");
        myUser.changePassword("ApplesNOranges");
        assertEquals("ApplesNOranges", myUser.getPassword());
    }

    @Test
    void testChangeId() {
        myUser.changeID("loveSleep");
        assertEquals("loveSleep", myUser.getUserId());

        myUser.changeID("loveFood");
        myUser.changeID("loveFood");
        assertEquals("loveFood", myUser.getUserId());
    }
}
