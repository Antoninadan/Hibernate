package com.mainacad.dao;

import com.mainacad.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    UserDAO userDAO = new UserDAO();
    List<User> users;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();

        User user = new User("ignatenko2207", "123456", "Alex",
                "Ignatenko", "test@email.com", "0967933438");

        users.add(user);
    }

//    @AfterEach
//    void tearDown() {
//        users.forEach(it -> UserDAO.delete(it));
//    }

    @Test
    void saveAndGetAndDelete() {


        User savedUser = userDAO.save(users.get(0));
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());

        User retrievedUser = userDAO.findOne(savedUser.getId());
        assertNotNull(retrievedUser);
        assertEquals("ignatenko2207", retrievedUser.getLogin());

        userDAO.delete(retrievedUser);

        User deletedUser = userDAO.findOne(savedUser.getId());
        assertNull(deletedUser);
    }
}