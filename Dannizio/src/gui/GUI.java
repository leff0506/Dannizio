package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import imagework.ImagePanel;

public class GUI {
	private JFrame frame;
	private ImagePanel intro;
	private ImagePanel introMenu;
	private int width;
	private int height;
	private ImagePanel menu;
	private ImagePanel autho;
	public GUI() {
		init();
		addIntroMenu();
		addMenuButton();
		addAuthoButton();
		
		frame.repaint();
	}
	private void setContent(JPanel to) {
		
		frame.setContentPane(to);
		frame.repaint();
	}
	private void addMenuButton() {
		menu = new ImagePanel();
		final int margin_left=10;
		final int margin_top=10;
		final int margin_right=10;
		final int widthAutho=introMenu.getWidth()-margin_left-margin_right;
		final int heightAutho=50;
		menu.setBackground(new Color(0,255,0));
		menu.setSize(widthAutho,heightAutho);
		menu.setLocation(margin_left,margin_top);
		menu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				menu.setBackground(new Color(0,255,0));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				menu.setBackground(new Color(0,255,255));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		introMenu.add(menu);
		
	}
	private void addAuthoButton() {
		autho = new ImagePanel();
		final int margin_left=10;
		final int margin_top=10+menu.getHeight()+menu.getY();
		final int margin_right=10;
		final int widthAutho=introMenu.getWidth()-margin_left-margin_right;
		final int heightAutho=50;
		autho.setBackground(new Color(0,255,0));
		autho.setSize(widthAutho,heightAutho);
		autho.setLocation(margin_left,margin_top);
		autho.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				autho.setBackground(new Color(0,255,0));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				autho.setBackground(new Color(0,255,255));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		introMenu.add(autho);
		
	}
	private void addIntroMenu() {
		introMenu = new ImagePanel();
		introMenu.setLayout(null);
		introMenu.setSize(200,400);
		introMenu.setLocation(0,height-introMenu.getHeight()-40);
		introMenu.setBackground(new Color(250, 0, 0, 150));
		intro.add(introMenu);
		
	}
	private void init() {
		frame = new JFrame("Dannizio");
		frame.setSize(900,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		
		intro = new ImagePanel();
		intro.setLayout(null);
	
		try {
			intro.setImage(ImageIO.read(new File("./img/intro/bg.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setContent(intro);
		frame.setVisible(true);
		width = intro.getWidth();
		height = intro.getHeight();
	}
}
