package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import gui.GUI;
import parser.XMLParser;

public class Client {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private GUI gui;
	private XMLParser parser;
	public Client(String ip,int port,GUI gui) {
		parser = new XMLParser();
		
		this.gui=gui;
		try {
			socket = new Socket(ip,port);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			Thread th = new Thread(new Runnable() {
				
				@Override
				public void run() {
					String input;
					while(true) {
						try {
							input = in.readLine();
							
							if(input!=null) { 
									
								parser.setInput(input);
								JOptionPane.showMessageDialog(null,parser.getName());
								command();
							}
						}catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			});
			th.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void command() {
		
		if(parser.getName().equals("logged")) {
			GUI.workPlace();
		}
		
	}
	public BufferedReader in() {
		return in;
	}

	public PrintWriter out() {
		return out;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void send(String text) {
		if(!text.equals("")) {
			out.println(text);
		}
		
	}
}
