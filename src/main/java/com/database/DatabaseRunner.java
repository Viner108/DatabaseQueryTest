package com.database;

import com.database.dao.UserDaoInEmptyTable;
import com.database.entity.User;

import java.util.Optional;

public class DatabaseRunner {
    public static void main(String[] args) {
        UserDaoInEmptyTable userDao = UserDaoInEmptyTable.getInstance();
        Optional<User> user = userDao.findById(1L);
        System.out.println(user);
    }
}
