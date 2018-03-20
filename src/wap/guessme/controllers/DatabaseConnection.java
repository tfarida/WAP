package wap.guessme.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DatabaseConnection {
	private static DatabaseConnection instance;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/db_wap";
	private String username = "root";
	private String password = "titin";
	

	private DatabaseConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful!");
		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DatabaseConnection getInstance() throws SQLException { //static 
		if (instance == null) {
			instance = new DatabaseConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DatabaseConnection();
		}

		return instance;
	}

	/*public static void main(String args[]) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    System.out.println(f.format(new Date()));
		    
			//Date d = new Date();
			String s =  f.format(new Date()); //d.toLocaleString();
			System.out.println(s);
					
			getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
}
