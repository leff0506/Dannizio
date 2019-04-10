package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	public Client(String ip,int port) {
		
		try {
			socket = new Socket(ip,port);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
