package com.database.dao;

import com.database.entity.Row;
import com.database.entity.User;
import com.database.until.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RowDao {
    private static final RowDao INSTANCE = new RowDao();

    private static final String FIND_ALL_SQL = """
            SELECT id,
            string
            from idandstring
            """;
    public List<Row> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Row> rows = new ArrayList<>();
            while (resultSet.next()) {
                rows.add(buildRow(resultSet));
            }
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static Row buildRow(ResultSet resultSet) throws SQLException {
        return new Row(
                resultSet.getLong("id"),
                resultSet.getString("string")
        );
    }
    public static RowDao getInstance() {
        return INSTANCE;
    }
}
