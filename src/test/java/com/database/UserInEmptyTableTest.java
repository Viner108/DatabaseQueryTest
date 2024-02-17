package com.database;

import com.database.dao.UserDaoInEmptyTable;
import com.database.entity.User;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("user")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserInEmptyTableTest {
    private UserDaoInEmptyTable userDao;
    @BeforeAll
    void init() {
        System.out.println("Before all: " + this);
    }

    @BeforeEach
    void prepare() {
        System.out.println("Before each: " + this);
        this.userDao= UserDaoInEmptyTable.getInstance();
    }

    @Test
    @DisplayName("searching for user by id in an empty table")
    void findUserByIdInEmptyTable(){
        System.out.println("Test findUserByIdInEmptyTable start");
        Optional<User> user = userDao.findById(1L);
        assertTrue(user.isEmpty());
    }

    @Test
    @DisplayName("searching for all users in an empty table")
    void findAllUserInEmptyTable(){
        System.out.println("Test findAllUserInEmptyTable start");
        List<User> user = userDao.findAll();
        assertTrue(user.isEmpty());
    }
    @Test
    @DisplayName("counting the number of rows in an empty table")
    void findCountRows(){
        System.out.println("Test findCountRows start");
        Integer rows = userDao.findCountRows();
        assertEquals(0,rows);
    }
    @AfterEach
    void deleteDataFromDatabase() {
        System.out.println("After each: " + this);
    }

    @AfterAll
    void closeConnectionPool() {
        System.out.println("After all: " + this);
    }
}
