package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	private static int width;
	private static int height;
	//gl worker area
	private static ImagePanel button_sign_up_Worker;
	private static ImagePanel button_sign_in_Worker;
	private static ImagePanel workerP;
	private static ImagePanel menuWorker;
	private static ImagePanel worker_back;
	//	
	
	//sign_in area
	private static ImagePanel sign_inP;
	private static ImagePanel sign_inArea;
	private static MyTF login;
	private static MyPF pass;
	private static ImagePanel button_sign_in_submit;
	private static ImagePanel sign_in_back;
	//	
	
	
	//sign_up area
	private static ImagePanel sign_upP;
	private static ImagePanel sign_upArea;
	private static MyTF loginUp;
	private static MyPF passUp;
	private static MyPF passRepUp;
	private static Client client;
	private static ImagePanel button_sign_up_submit;
	private static ImagePanel sign_up_back;
	//
	
	//gl  area
	private static ImagePanel glP;
	private static ImagePanel gl_user;
	private static ImagePanel gl_worker;
	//
	
	//worker place
	private static ImagePanel workPlaceP;
	private static ImagePanel workPlace_back;
	private static ImagePanel menu_area_workPlace;
	private static ImagePanel button_addToMenu;
	//
	
	//add to menu area
	private static ImagePanel addToMenuP;
	private static ImagePanel addToMenu_back;
	//
	
	//bounds
	private static int back_width = 100;
	private static int back_height = 50;
	//
	public GUI() {
		uploadPhotos();
		createClient();
		init();
		initGl();
		initWorker();
		initSign_in();
		initSign_up();
		setContent(glP);
		frame.repaint();
		
	}
	public static void workPlace() {
		initAddToMenuArea();
		workPlaceP = new ImagePanel();
		workPlaceP.setBounds(0,0,width,height);
		workPlaceP.setImage(PhotosDB.getPhoto("main_bg"));
		workPlaceP.setLayout(null);
		
		workPlace_back = new ImagePanel();
		workPlace_back.setBounds(0,0,back_width,back_height);
		workPlace_back.setImage(PhotosDB.getPhoto("back"));
		workPlace_back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setContent(glP);
				
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
		menu_area_workPlace = new ImagePanel();
		menu_area_workPlace.setSize(300,400);
		menu_area_workPlace.setLocation(width/2-menu_area_workPlace.getWidth()/2,height/2-menu_area_workPlace.getHeight()/2);
		menu_area_workPlace.setBackground(new Color(255,0,0,200));
		menu_area_workPlace.setLayout(null);
		
		button_addToMenu  = new ImagePanel();
		int margin_left=10;
		int margin_top=10;
		int margin_right=10;
		int widthAutho=menu_area_workPlace.getWidth()-margin_left-margin_right;
		int heightAutho=50;
		button_addToMenu.setBounds(margin_left,margin_top,widthAutho,heightAutho);
		button_addToMenu.setBackground(new Color(0,255,0));
		button_addToMenu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				button_addToMenu.setBackground(new Color(0,255,0));
				setContent(addToMenuP);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				button_addToMenu.setBackground(new Color(0,255,0));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				button_addToMenu.setBackground(new Color(0,255,255));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		menu_area_workPlace.add(button_addToMenu);
		workPlaceP.add(menu_area_workPlace);
		workPlaceP.add(workPlace_back);
		
		setContent(workPlaceP);
	}
	private static void initAddToMenuArea() {
		addToMenuP = new ImagePanel();
		addToMenuP.setLayout(null);
		addToMenuP.setBounds(0,0,width,height);
		addToMenuP.setImage(PhotosDB.getPhoto("main_bg"));
		
		
		addToMenu_back = new ImagePanel();
		addToMenu_back.setBounds(0,0,back_width,back_height);
		addToMenu_back.setImage(PhotosDB.getPhoto("back"));
		addToMenu_back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setContent(workPlaceP);
				
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
		addToMenuP.add(addToMenu_back);
		
	}
//	public static void updateWorkPlace() {
//		
//	}
	private void createClient() {
		client = new Client("localhost",7777,this);
	}
	public static void setContent(JPanel to) {
		
		frame.setContentPane(to);
		frame.repaint();
	}
	private void initGl() {
		glP = new ImagePanel();
		glP.setBounds(0,0,width,height);
		glP.setImage(PhotosDB.getPhoto("main_bg"));
		glP.setLayout(null);
		
		gl_user =new ImagePanel();
		gl_user.setSize(100,50);
		gl_user.setLocation(width/2 - gl_user.getWidth()-50,height/2 - gl_user.getHeight()/2);
		
		gl_user.setImage(PhotosDB.getPhoto("user"));
		glP.add(gl_user);
		
		gl_worker =new ImagePanel();
		gl_worker.setSize(100,50);
		gl_worker.setLocation(width/2 +50,height/2 - gl_worker.getHeight()/2);
		gl_worker.setImage(PhotosDB.getPhoto("user"));
		gl_worker.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setContent(workerP);
				
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
		glP.add(gl_worker);
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
		
		
		button_sign_in_submit = new ImagePanel();
		button_sign_in_submit.setSize(80,50);
		button_sign_in_submit.setLocation(sign_inArea.getWidth()-button_sign_in_submit.getWidth(), sign_inArea.getHeight()-button_sign_in_submit.getHeight());
		
		button_sign_in_submit.setImage(PhotosDB.getPhoto("submit"));
		button_sign_in_submit.addMouseListener(new MouseListener() {
			
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
		pass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = "sign_in{login:"+login.getText()+",password:"+pass.getText()+"}";
				client.send(query);
				pass.setText("");
				login.setText("");
				
			}
		});
		sign_in_back = new ImagePanel();
		sign_in_back.setBounds(0,0,back_width,back_height);
		sign_in_back.setImage(PhotosDB.getPhoto("back"));
		sign_in_back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setContent(workerP);
				
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
		
		sign_inArea.add(button_sign_in_submit);
		sign_inArea.add(login);
		sign_inArea.add(pass);
		sign_inP.add(sign_in_back);
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
		
		button_sign_up_submit = new ImagePanel();
		button_sign_up_submit.setSize(80,50);
		button_sign_up_submit.setLocation(sign_upArea.getWidth()-button_sign_up_submit.getWidth(), sign_upArea.getHeight()-button_sign_up_submit.getHeight());
		
		button_sign_up_submit.setImage(PhotosDB.getPhoto("submit"));
		button_sign_up_submit.addMouseListener(new MouseListener() {
			
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
		sign_up_back = new ImagePanel();
		sign_up_back.setBounds(0,0,back_width,back_height);
		sign_up_back.setImage(PhotosDB.getPhoto("back"));
		sign_up_back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setContent(workerP);
				
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
		
		sign_upArea.add(button_sign_up_submit);
		sign_upArea.add(loginUp);
		sign_upArea.add(passUp);
		sign_upArea.add(passRepUp);
		sign_upP.add(sign_upArea);
		sign_upP.add(sign_up_back);
	}

	private void init() {
		frame = new JFrame("Dannizio");
		frame.setSize(900,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		
		ImagePanel p = new ImagePanel();
		p.setLayout(null);
	
		setContent(p);
		
		frame.setVisible(true);
		
		width = p.getWidth();
		height = p.getHeight();
	}
	private void initWorker() {
		workerP = new ImagePanel();
		workerP.setBounds(0,0,width,height);
		workerP.setImage(PhotosDB.getPhoto("main_bg"));
		workerP.setLayout(null);
		
		menuWorker = new ImagePanel();
		menuWorker.setLayout(null);
		menuWorker.setSize(200,400);
		menuWorker.setLocation(0,height-menuWorker.getHeight()-40);
		menuWorker.setBackground(new Color(250, 0, 0, 150));
		workerP.add(menuWorker);
		
		
		
	
		
		button_sign_in_Worker = new ImagePanel();
		{
			int margin_left=10;
			int margin_top=10;
			int margin_right=10;
			int widthAutho=menuWorker.getWidth()-margin_left-margin_right;
			int heightAutho=50;
			
			button_sign_in_Worker.setBackground(new Color(0,255,0));
			button_sign_in_Worker.setSize(widthAutho,heightAutho);
			button_sign_in_Worker.setLocation(margin_left,margin_top);
			button_sign_in_Worker.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					button_sign_in_Worker.setBackground(new Color(0,255,0));
					setContent(sign_inP);
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					button_sign_in_Worker.setBackground(new Color(0,255,0));
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					button_sign_in_Worker.setBackground(new Color(0,255,255));
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
				}
			});
		}
		button_sign_up_Worker = new ImagePanel();
		{
			int margin_left=10;
			int margin_top=10+button_sign_in_Worker.getHeight()+button_sign_in_Worker.getY();
			int margin_right=10;
			int widthAutho=menuWorker.getWidth()-margin_left-margin_right;
			int heightAutho=50;
			button_sign_up_Worker.setBackground(new Color(0,255,0));
			button_sign_up_Worker.setSize(widthAutho,heightAutho);
			button_sign_up_Worker.setLocation(margin_left,margin_top);
			button_sign_up_Worker.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					setContent(sign_upP);
					button_sign_up_Worker.setBackground(new Color(0,255,0));
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					button_sign_up_Worker.setBackground(new Color(0,255,0));
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					button_sign_up_Worker.setBackground(new Color(0,255,255));
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			menuWorker.add(button_sign_up_Worker);
		}
		worker_back  = new ImagePanel();
		worker_back.setBounds(0,0,back_width,back_height);
		worker_back.setImage(PhotosDB.getPhoto("back"));
		worker_back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setContent(glP);
				
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
		menuWorker.add(button_sign_in_Worker);
		workerP.add(worker_back);
		
		
	}
	private void uploadPhotos() {
		PhotosDB.upload("./img/intro/bg.jpg", "main_bg");
		PhotosDB.upload("./img/gl/submit.png", "submit");
		PhotosDB.upload("./img/gl/user.png", "user");
		PhotosDB.upload("./img/gl/back.png", "back");
	}
}
