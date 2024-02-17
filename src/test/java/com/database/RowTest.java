package com.database;

import com.database.dao.RowDao;
import com.database.dao.UserDaoInEmptyTable;
import com.database.entity.Row;
import com.database.entity.User;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Tag("rows")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RowTest {
    private RowDao rowDao;
    @BeforeAll
    void init() {
        System.out.println("Before all: " + this);
    }

    @BeforeEach
    void prepare() {
        System.out.println("Before each: " + this);
        this.rowDao= RowDao.getInstance();
    }

//    @Test
//    @DisplayName("searching for user by id in an empty table")
//    void findUserByIdInEmptyTable(){
//        System.out.println("Test findUserByIdInEmptyTable start");
//        Optional<User> user = rowDao.findById(1L);
//        assertTrue(user.isEmpty());
//    }

    @Test
    @DisplayName("the table is not empty")
    void TableIsNotEmpty(){
        System.out.println("Test findAllRowInTable start");
        List<Row> user = rowDao.findAll();
        assertFalse(user.isEmpty());
    }

//    @Test
//    @DisplayName("counting the number of rows in an empty table")
//    void findCountRows(){
//        System.out.println("Test findCountRows start");
//        Integer rows = rowDao.findCountRows();
//        assertEquals(0,rows);
//    }
    @AfterEach
    void deleteDataFromDatabase() {
        System.out.println("After each: " + this);
    }

    @AfterAll
    void closeConnectionPool() {
        System.out.println("After all: " + this);
    }
}

