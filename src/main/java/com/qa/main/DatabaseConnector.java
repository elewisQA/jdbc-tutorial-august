package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.utils.DatabaseConfiguration;

public class DatabaseConnector {
    private Connection connection;

    private Statement statement;

    public DatabaseConnector() throws SQLException {
        connection = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USER,
                DatabaseConfiguration.PASSWORD);
    }

    public void createActor(String forename, String surname) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO actor (`first_name`, `last_name`)" + " VALUES ('%s', '%s')",
                forename, surname));
    }

    public void readAllActors() throws SQLException {
        String sql = "SELECT * FROM actor";
        this.statement = connection.createStatement();
        ResultSet results = this.statement.executeQuery(sql);

        while (results.next()) {
            System.out.println(String.format("%s %s", results.getString("first_name"), results.getString("last_name")));
        }
    }

    public void updateActor() throws SQLException {

    }

    public void deleteActor() throws SQLException {

    }

}
