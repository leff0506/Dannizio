package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import database.DBHandler;
import ui.UI;

public class DServer {
	private ServerSocket serv;
	private final int PORT = 7777;
	private boolean isRunning = true;
	private ArrayList<Conn> cons= new ArrayList<>();
	public static UI ui;
	private DBHandler dbh = new DBHandler();
	public DServer() {
		ui = new UI();
		start();
	}
	private void start() {
		try {
			serv = new ServerSocket(PORT);
			ui.log("server is running on port "+serv.getLocalPort());
			Socket user;
			while(isRunning) {
				user = serv.accept();
				ui.log("Connected : "+user.getInetAddress());
				cons.add(new Conn(new Client(user),ui,dbh));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
