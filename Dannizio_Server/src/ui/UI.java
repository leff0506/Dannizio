package ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class UI {
	private JFrame frame;
	private JPanel panel;
	private int width;
	private int height;
	private JTextPane text;
	public UI() {
		
		frame = new JFrame("Fishka_Server");
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		frame.add(panel);
		frame.setVisible(true);
		
		width = panel.getWidth();
		height = panel.getHeight();
		text = new JTextPane();
		text.setEditable(false);
		text.setBounds(20,20,width-40,height-40);
		panel.add(text);
		frame.repaint();
	}
	public void log(String str) {
		text.setText(text.getText()+str+"\n");
	}
}
