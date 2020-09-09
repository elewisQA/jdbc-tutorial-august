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
    	String sql = String.format("INSERT INTO actor (`first_name`, `last_name`)" + " VALUES ('%s', '%s')",
                forename.toUpperCase(), surname.toUpperCase());
        statement.executeUpdate(sql);
    }

    public void readAllActors() throws SQLException {
        String sql = "SELECT * FROM actor";
        this.statement = connection.createStatement();
        ResultSet results = this.statement.executeQuery(sql);

        while (results.next()) {
            System.out.println(String.format("%s %s", results.getString("first_name"), results.getString("last_name")));
        }
    }

    public void updateActorForename(String forename, String surname, String newForename) throws SQLException {
    	// Update forename of actor
    	String sql = String.format("UPDATE actor SET first_name = '%s' WHERE first_name = '%s' AND last_name = '%s';",
    			newForename.toUpperCase(), forename.toUpperCase(), surname.toUpperCase());
    	statement.executeUpdate(sql);

    }
    
    public void updateActorSurname(String forename, String surname, String newSurname) throws SQLException {
    	// Update surname of actor
    	String sql = String.format("UPDATE actor SET last_name = '%s' WHERE first_name = '%s' AND last_name = '%s';",
    			newSurname.toUpperCase(), forename.toUpperCase(), surname.toUpperCase());
    	statement.executeUpdate(sql);

    }

    public void deleteActor(String forename, String surname) throws SQLException {
    	String sql = String.format("DELETE FROM actor WHERE first_name = '%s' AND last_name = '%s';", forename.toUpperCase(), surname.toUpperCase());
    	statement.executeUpdate(sql);
    }

}
