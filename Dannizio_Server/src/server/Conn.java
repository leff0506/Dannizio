package server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import database.DBHandler;
import parser.XMLParser;
import ui.UI;

public class Conn implements Runnable{
	private Client client;
	private boolean isAlive=true;
	private UI ui;
	private XMLParser parser;
	private DBHandler dbh ;
	public Conn(Client client,UI ui,DBHandler dbh) {
		super();
		this.client = client;
		this.ui=ui;
		this.dbh=dbh;
		parser=new XMLParser();
		Thread th = new Thread(this);
		th.start();
	}


	@Override
	public void run() {
		String input;
		while(isAlive) {
			try {
				input = client.in().readLine();
				ui.log(client.getSocket().getInetAddress()+" : "+input);
				command(input);
			}catch(java.net.SocketException e) {
				isAlive=false;
				ui.log("out: "+client.getSocket().getLocalAddress().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void command(String str) {
		parser.setInput(str);
		if(parser.getName().equals("sign_in")) {
			signIn(parser);
		}
	}
	private void signIn(XMLParser parser) {
		String query ="SELECT * from users where login = '"+parser.get("login")+"' and password = '"+parser.get("password")+"'";
		ResultSet res;
		try {
			res =dbh.getSt().executeQuery(query);
			if(res.next()) {
				send("logged");
			}else {
				send("unlogged");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			send("unlogged");
		}
	}
	
	private void send(String str) {
		client.out().println(str);
	}

}