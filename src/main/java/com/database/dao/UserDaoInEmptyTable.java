package com.database.dao;

import com.database.entity.User;
import com.database.until.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoInEmptyTable {
    private static final UserDaoInEmptyTable INSTANCE = new UserDaoInEmptyTable();
    private static final String FIND_BY_ID = """
            SELECT  id, 
            username,
            password
            from empty
            where id = ?
            """;
    private static final String FIND_ALL_SQL = """
            SELECT id,
            username,
            password
            from empty
            """;

    public Integer findCountRows() {
        List<User> users = findAll();
        return users.size();
    }

    public Optional<User> findById(Long id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildUser(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(buildUser(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static User buildUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("password")
        );
    }

    public static UserDaoInEmptyTable getInstance() {
        return INSTANCE;
    }

}
