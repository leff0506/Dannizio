package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import client.Client;
import imagework.AnimPanel;
import imagework.ImagePanel;
import imagework.MyPF;
import imagework.MyTF;
import imagework.PhotosDB;

public class GUI {
	public static JFrame frame;
	private ImagePanel intro;
	private ImagePanel introMenu;
	private int width;
	private int height;
	//gl area
	private ImagePanel menu;
	private ImagePanel autho;
	//	
	
	//sign_in area
	private ImagePanel sign_inP;
	private ImagePanel sign_inArea;
	private MyTF login;
	private MyPF pass;
	private ImagePanel submit_sign_in;
	//	
	
	
	//sign_up area
	private ImagePanel sign_upP;
	private ImagePanel sign_upArea;
	private MyTF loginUp;
	private MyPF passUp;
	private MyPF passRepUp;
	private Client client;
	private ImagePanel submit_sign_up;
	//
	public GUI() {
		createClient();
		init();
		addIntroMenu();
		addSignInButton();
		addAuthoButton();
		initSign_in();
		initSign_up();
		frame.repaint();
		
	}
	private void createClient() {
		client = new Client("localhost",7777,this);
	}
	private void setContent(JPanel to) {
		
		frame.setContentPane(to);
		frame.repaint();
	}
	private void addSignInButton() {
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
				setContent(sign_upP);
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
	private void initSign_in(){
		sign_inP = new ImagePanel();
		sign_inP.setImage(PhotosDB.getPhoto("main_bg"));
		sign_inP.setBounds(0, 0, width, height);
		sign_inP.setLayout(null);
		sign_inArea = new ImagePanel();
		int w=300,h=250;
		int x=(width-w)/2,y=(height-h)/2;
		sign_inArea.setBounds(x,y,w,h);
		sign_inArea.setBackground(Color.RED);
		sign_inArea.setLayout(null);
		
		int margin_left=15;
		int margin_top=15;
		int margin_right=15;
		int h1=30;
		login = new MyTF();
		login.setBorder(BorderFactory.createEmptyBorder());
		login.setBackground(new Color(0,0,0,0));
		login.setLocation(margin_left, margin_top);
		login.setSize(w-margin_left-margin_right,h1);
		
		pass= new MyPF();
		pass.setEchoChar('*');
		pass.setLocation(margin_left, 2*margin_top+login.getHeight());
		pass.setBorder(BorderFactory.createEmptyBorder());
		pass.setSize(w-margin_left-margin_right,h1);
		pass.setBackground(new Color(0,0,0,0));
		
		
		submit_sign_in = new ImagePanel();
		submit_sign_in.setSize(80,50);
		submit_sign_in.setLocation(sign_inArea.getWidth()-submit_sign_in.getWidth(), sign_inArea.getHeight()-submit_sign_in.getHeight());
		PhotosDB.upload("./img/gl/submit.png", "submit");
		submit_sign_in.setImage(PhotosDB.getPhoto("submit"));
		submit_sign_in.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String query = "sign_in{login:"+login.getText()+",password:"+pass.getText()+"}";
				client.send(query);
				pass.setText("");
				login.setText("");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		sign_inArea.add(submit_sign_in);
		sign_inArea.add(login);
		sign_inArea.add(pass);
		sign_inP.add(sign_inArea);
	}
	private void initSign_up(){
		sign_upP = new ImagePanel();
		sign_upP.setImage(PhotosDB.getPhoto("main_bg"));
		sign_upP.setBounds(0, 0, width, height);
		sign_upP.setLayout(null);
		sign_upArea = new ImagePanel();
		int w=300,h=250;
		int x=(width-w)/2,y=(height-h)/2;
		sign_upArea.setBounds(x,y,w,h);
		sign_upArea.setBackground(Color.RED);
		sign_upArea.setLayout(null);
		
		int margin_left=15;
		int margin_top=15;
		int margin_right=15;
		int h1=30;
		loginUp = new MyTF();
		loginUp.setBorder(BorderFactory.createEmptyBorder());
		loginUp.setBackground(new Color(0,0,0,0));
		loginUp.setLocation(margin_left, margin_top);
		loginUp.setSize(w-margin_left-margin_right,h1);
		
		passUp= new MyPF();
		passUp.setEchoChar('*');
		passUp.setLocation(margin_left, 2*margin_top+login.getHeight());
		passUp.setBorder(BorderFactory.createEmptyBorder());
		passUp.setSize(w-margin_left-margin_right,h1);
		passUp.setBackground(new Color(0,0,0,0));
		
		passRepUp= new MyPF();
		passRepUp.setEchoChar('*');
		passRepUp.setLocation(margin_left, 3*margin_top+login.getHeight()+pass.getHeight());
		passRepUp.setBorder(BorderFactory.createEmptyBorder());
		passRepUp.setSize(w-margin_left-margin_right,h1);
		passRepUp.setBackground(new Color(0,0,0,0));
		
		submit_sign_up = new ImagePanel();
		submit_sign_up.setSize(80,50);
		submit_sign_up.setLocation(sign_upArea.getWidth()-submit_sign_up.getWidth(), sign_upArea.getHeight()-submit_sign_up.getHeight());
		PhotosDB.upload("./img/gl/submit.png", "submit");
		submit_sign_up.setImage(PhotosDB.getPhoto("submit"));
		submit_sign_up.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(passUp.getText().equals(passRepUp.getText())) {
					String query = "sign_up{login:"+loginUp.getText()+",password:"+passUp.getText()+"}";
					client.send(query);
					passUp.setText("");
					passRepUp.setText("");
					loginUp.setText("");
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		sign_upArea.add(submit_sign_up);
		sign_upArea.add(loginUp);
		sign_upArea.add(passUp);
		sign_upArea.add(passRepUp);
		sign_upP.add(sign_upArea);
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
				setContent(sign_inP);
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
		PhotosDB.upload("./img/intro/bg.jpg", "main_bg");
		intro.setImage(PhotosDB.getPhoto("main_bg"));
		intro.setLayout(null);
	
		setContent(intro);
		frame.setVisible(true);
		
		width = intro.getWidth();
		height = intro.getHeight();
	}
}
