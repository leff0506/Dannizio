package database;

import java.sql.*;

public class DBHandler {
	private Connection con;
	private Statement st;

	public DBHandler(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dannizio", "root", "");
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Connection getCon() {
		return con;
	}
	public Statement getSt() {
		return st;
	}
	
	
}
