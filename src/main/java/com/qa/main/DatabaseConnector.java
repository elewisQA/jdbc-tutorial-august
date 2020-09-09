package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.utils.DatabaseConfiguration;

public class DatabaseConnector {
    private Connection conn;

    private Statement st;

    public DatabaseConnector() throws SQLException {
        conn = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USER,
                DatabaseConfiguration.PASSWORD);
    }

    public void createActor(String forename, String surname) throws SQLException {
        st.executeUpdate(String.format("INSERT INTO actor (`first_name`, `last_name`)" + " VALUES ('%s', '%s')",
                forename, surname));
    }

    public void readAllActors() throws SQLException {
        String sql = "SELECT * FROM actor";
        this.st = conn.createStatement();
        ResultSet rs = this.st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }

    public void updateActor() throws SQLException {

    }

    public void deleteActor() throws SQLException {

    }

}
