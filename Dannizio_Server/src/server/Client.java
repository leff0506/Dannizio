package server;

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
	public Client(Socket socket) {
		super();
		this.socket = socket;
		try {
			in=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
}
