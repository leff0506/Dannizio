package danik228;

import client.Client;
import gui.GUI;

public class Main {
	public static void main(String[] args) {
		Client cl = new Client("localhost",7777);
		GUI gui = new GUI();
	}
}
