package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	static Scanner sc;
	static DatabaseConnector db;

    public static void main(String[] args) throws SQLException {
        db = new DatabaseConnector();
        System.out.println("Connected to Sakila...");
        sc = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
        	System.out.println("\n-----------------------");
        	System.out.println("Please Enter Operation:");
        	String input = sc.nextLine();
        	switch (input.toUpperCase()) {
        		case "SELECT": select(); break;
        		case "INSERT": insert(); break;
        		case "UPDATE": update(); break;
        		case "DELETE": delete(); break;
        		case "EXIT": loop = false; break;
        	}
        }
        System.out.println("Exiting...");
    }
    
    public static void select() throws SQLException {
    	db.readAllActors();
    	return;
    }
    
    public static void insert() throws SQLException {
    	System.out.print("\nEnter actor's first-name: ");
    	String fname = sc.nextLine();
    	System.out.print("\nEnter actor's second-name: ");
    	String sname = sc.nextLine();
    	System.out.println("\n");
    	System.out.println(fname + " " + sname);
    	db.createActor(fname, sname);
    }
    
    public static void update() throws SQLException {
    	System.out.print("\nEnter actor's (current) forname: ");
    	String fname = sc.nextLine();
    	System.out.print("\nEnter actor's (current) surname: ");
    	String sname = sc.nextLine();
    	System.out.print("\nEnter actor's (new) forname: ");
    	String newName = sc.nextLine();
    	db.updateActorForename(fname, sname, newName);
    }
    
    public static void delete() throws SQLException {
    	System.out.print("\nEnter actor's first-name: ");
    	String fname = sc.nextLine();
    	System.out.print("\nEnter actor's second-name: ");
    	String sname = sc.nextLine();
    	System.out.println("\n");
    	db.deleteActor(fname, sname);
    } 

}
