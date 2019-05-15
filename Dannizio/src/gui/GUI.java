package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import client.Client;
import imagework.AnimPanel;
import imagework.ImagePanel;
import imagework.MyPF;
import imagework.MyTF;
import imagework.PhotosDB;
import parser.Pizza;


public class GUI {
	
	
	public static JFrame frame;

	private static int width;
	private static int height;
	//gl worker area
	private static ImagePanel button_sign_up_Worker;
	private static ImagePanel button_sign_in_Worker;
	private	static JLabel sign_in_label;
	private	static JLabel sign_up_label;
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
	private static JLabel login_label_in;
	private static JLabel password_label_in;
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
	private static JLabel login_label_up;
	private static JLabel password_label_up;
	//
	
	//gl  area
	private static ImagePanel glP;
	private static ImagePanel gl_user;
	private static ImagePanel gl_worker;
	private static JLabel worker_label;
	private static JLabel user_label;
	//
	
	//user place
	private static ImagePanel userPlaceP;
	private static ImagePanel userPlace_back;
	private static ImagePanel menu_area_userPlace;
	private static ImagePanel button_seeMenu;
	private static JLabel seeMenu_label;
	private static ImagePanel button_basket;
	private static JLabel basket_label;
	//
	
	//menu place
	public static ImagePanel menuPlaceP;
	private static ImagePanel menu_back;
	private static ImagePanel menu_area;
	public static ArrayList<Pizza> pizzas=new ArrayList<>();
	private static final int HEIGHT_PIZZA=150;
	private static JScrollPane menu_area_s;
	private static int curPizza=0;
	private static ImagePanel next_button;
	//
	
	//worker place
	private static ImagePanel workPlaceP;
	private static ImagePanel workPlace_back;
	private static ImagePanel menu_area_workPlace;
	private static ImagePanel button_addToMenu;
	private static JLabel add_toMenu_label;
	private static ImagePanel button_manageOrders;
	private static JLabel manageOrders_label;
	//
	
	//add to (add to menu area) :)
	private static ImagePanel addToMenuP;
	private static ImagePanel addToMenu_back;
	private static ImagePanel addToMenuArea;
	private static JTextField titleField; 
	private static JTextField sizeField; 
	private static JTextArea descriptionField; 
	private static JCheckBox availableField; 
	private static ImagePanel button_addToMenu_submit;
	private static JLabel title_label;
	private static JLabel description_label;
	private static JLabel size_label;
	private static JLabel available_label;
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
		initUser();
		setContent(glP);
		frame.repaint();
		
	}
	public static void initMenuArea() {
		menuPlaceP = new ImagePanel();
		menuPlaceP.setBounds(0,0,width,height);
		menuPlaceP.setImage(PhotosDB.getPhoto("main_bg"));
		menuPlaceP.setLayout(null);
		
		menu_back = new ImagePanel();
		menu_back.setBounds(0,0,back_width,back_height);
		menu_back.setImage(PhotosDB.getPhoto("back"));
		
		menu_back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setContent(userPlaceP);
				
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
		

		menu_area = new ImagePanel();
		menu_area.setSize(600,400);
//		menu_area.setLocation(0,0);
		menu_area.setLocation(width/2-menu_area.getWidth()/2,height/2-menu_area.getHeight()/2);
		menu_area.setBackground(new Color(255,0,0,200));
		menu_area.setLayout(null);
		Pizza p = pizzas.get(0);
		ImagePanel pizP = new ImagePanel();
		pizP.setLayout(null);
		pizP.setSize(menu_area.getWidth(),HEIGHT_PIZZA);
		pizP.setLocation(0,0);
		pizP.setBackground(new Color(0,0,0,0));
		pizP.addMouseListener(new MouseListener() {
			
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
				pizP.setBackground(new Color(0,0,0,0));
				frame.repaint();
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				pizP.setBackground(new Color(0,255,255));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JLabel title = new JLabel();
		title.setText(p.getTitle());
		title.setBounds(0,0,50,HEIGHT_PIZZA);
		
		JLabel size = new JLabel();
		size.setText(p.getSize());
		size.setBounds(50,0,50,HEIGHT_PIZZA);
		
		JLabel description = new JLabel();
		description.setText(p.getDecription());
		description.setBounds(100,0,50,HEIGHT_PIZZA);
		
		JLabel available = new JLabel();
		available.setText(Boolean.toString(p.isAvailable()));
		available.setBounds(150,0,50,HEIGHT_PIZZA);
		
		JLabel id = new JLabel();
		id.setText(Integer.toString(p.getId()));
		id.setBounds(200,0,50,HEIGHT_PIZZA);
		
		pizP.add(title);
		pizP.add(size);
		pizP.add(description);
		pizP.add(available);
		pizP.add(id);
		menu_area.add(pizP);
		
		next_button = new ImagePanel();
		next_button.setSize(50,50);
		next_button.setLocation(750,250);
		next_button.setBackground(Color.BLACK);
		next_button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				curPizza++;
				curPizza%=pizzas.size();
				title.setText(pizzas.get(curPizza).getTitle());
				size.setText(pizzas.get(curPizza).getSize());
				description.setText(pizzas.get(curPizza).getDecription());
				available.setText(Boolean.toString(pizzas.get(curPizza).isAvailable()));
				id.setText(Integer.toString(pizzas.get(curPizza).getId()));
				frame.repaint();
				
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
		
		menuPlaceP.add(next_button);
		menuPlaceP.add(menu_area);
		menuPlaceP.add(menu_back);
		frame.repaint();
	}
	public static void addPizza(Pizza p) {
		
//		menu_area.add(pizP);
		pizzas.add(p);
//		frame.repaint();
	}
	public static void deletePizzas() {
		pizzas.clear();
//		menu_area.removeAll();
		frame.repaint();
	}
	public static void initUser() {
		
		userPlaceP = new ImagePanel();
		userPlaceP.setBounds(0,0,width,height);
		userPlaceP.setImage(PhotosDB.getPhoto("main_bg"));
		userPlaceP.setLayout(null);
		
		userPlace_back = new ImagePanel();
		userPlace_back.setBounds(0,0,back_width,back_height);
		userPlace_back.setImage(PhotosDB.getPhoto("back"));
		userPlace_back.addMouseListener(new MouseListener() {
			
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
		menu_area_userPlace = new ImagePanel();
		menu_area_userPlace.setSize(300,400);
		menu_area_userPlace.setLocation(width/2-menu_area_userPlace.getWidth()/2,height/2-menu_area_userPlace.getHeight()/2);
		menu_area_userPlace.setBackground(new Color(255,0,0,200));
		menu_area_userPlace.setLayout(null);
		
		button_seeMenu  = new ImagePanel();
		{
			int margin_left=10;
			int margin_top=10;
			int margin_right=10;
			int widthAutho=menu_area_userPlace.getWidth()-margin_left-margin_right;
			int heightAutho=50;
			seeMenu_label = new JLabel("see_menu");
			seeMenu_label.setBounds(10,5,90,20);
			button_seeMenu.add(seeMenu_label);
			button_seeMenu.setBounds(margin_left,margin_top,widthAutho,heightAutho);
			button_seeMenu.setBackground(new Color(0,255,0));
			button_seeMenu.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					button_seeMenu.setBackground(new Color(0,255,0));
//					setContent(menuPlaceP);
					client.askMenu();
					
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					button_seeMenu.setBackground(new Color(0,255,0));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					button_seeMenu.setBackground(new Color(0,255,255));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		
		button_basket = new ImagePanel();
		{
			int margin_left=10;
			int margin_top=10;
			int margin_right=10;
			int widthAutho=menu_area_userPlace.getWidth()-margin_left-margin_right;
			int heightAutho=50;
			basket_label = new JLabel("basket");
			basket_label.setBounds(10,5,90,20);
			button_basket.add(basket_label);
			button_basket.setBounds(margin_left,2*margin_top+heightAutho,widthAutho,heightAutho);
			button_basket.setBackground(new Color(0,255,0));
			button_basket.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					button_basket.setBackground(new Color(0,255,0));
					//setContent(addToMenuP);
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					button_basket.setBackground(new Color(0,255,0));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					button_basket.setBackground(new Color(0,255,255));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		
		
		menu_area_userPlace.add(button_basket);
		menu_area_userPlace.add(button_seeMenu);
		userPlaceP.add(menu_area_userPlace);
		userPlaceP.add(userPlace_back);
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
		{
			int margin_left=10;
			int margin_top=10;
			int margin_right=10;
			int widthAutho=menu_area_workPlace.getWidth()-margin_left-margin_right;
			int heightAutho=50;
			add_toMenu_label = new JLabel("add_to_menu");
			add_toMenu_label.setBounds(10,5,90,20);
			button_addToMenu.add(add_toMenu_label);
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
		}
		
		
		button_manageOrders = new ImagePanel();
		{
			int margin_left=10;
			int margin_top=10;
			int margin_right=10;
			int widthAutho=menu_area_workPlace.getWidth()-margin_left-margin_right;
			int heightAutho=50;
			manageOrders_label = new JLabel("manage_orders");
			manageOrders_label.setBounds(10,5,90,20);
			button_manageOrders.add(manageOrders_label);
			button_manageOrders.setBounds(margin_left,2*margin_top+heightAutho,widthAutho,heightAutho);
			button_manageOrders.setBackground(new Color(0,255,0));
			button_manageOrders.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					button_manageOrders.setBackground(new Color(0,255,0));
					//setContent(addToMenuP);
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					button_manageOrders.setBackground(new Color(0,255,0));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					button_manageOrders.setBackground(new Color(0,255,255));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		
		
		menu_area_workPlace.add(button_manageOrders);
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
		addToMenuArea = new ImagePanel();
		addToMenuArea.setSize(600,400);
		addToMenuArea.setLocation(width/2-addToMenuArea.getWidth()/2,height/2-addToMenuArea.getHeight()/2);
		addToMenuArea.setBackground(new Color(255,0,0,200));
		addToMenuArea.setLayout(null);
		
		title_label = new JLabel("Title");
		title_label.setBounds(20,40,70,20);
		
		titleField = new JTextField();
		titleField.setBounds(20,60,200,40);
		titleField.setHorizontalAlignment(JTextField.CENTER);
		
		size_label = new JLabel("Size");
		size_label.setBounds(20,180,70,20);
		
		sizeField = new JTextField();
		sizeField.setBounds(20,200,200,40);
		sizeField.setHorizontalAlignment(JTextField.CENTER);

		description_label = new JLabel("Description");
		description_label.setBounds(300,40,70,20);
		
		descriptionField = new JTextArea();
		descriptionField.setBounds(300,60,250,260);
		descriptionField.setLineWrap(true);
		descriptionField.setWrapStyleWord(true);
		
		
		available_label = new JLabel("Available");
		available_label.setBounds(45,300,70,20);
		
		availableField = new JCheckBox();
		availableField.setBounds(20,300,20,20);
		
		
		
		button_addToMenu_submit = new ImagePanel();
		button_addToMenu_submit.setSize(80,40);
		button_addToMenu_submit.setLocation(addToMenuArea.getWidth()-button_addToMenu_submit.getWidth()-20, addToMenuArea.getHeight()-button_addToMenu_submit.getHeight()-20);
		button_addToMenu_submit.setImage(PhotosDB.getPhoto("submit"));
//		button_addToMenu_submit.setBackground(Color.green);
		button_addToMenu_submit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String title = titleField.getText();
				titleField.setText("");
				
				String size = sizeField.getText();
				sizeField.setText("");
				
				String descr = descriptionField.getText();
				descriptionField.setText("");
				
				boolean av = availableField.isSelected();
				availableField.setSelected(false);
				
				addToMenuQuery(title,size,av,descr);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		addToMenuArea.add(titleField);
		addToMenuArea.add(sizeField);
		addToMenuArea.add(descriptionField);
		addToMenuArea.add(availableField);
		addToMenuArea.add(button_addToMenu_submit);
		addToMenuArea.add(title_label);
		addToMenuArea.add(description_label);
		addToMenuArea.add(size_label);
		addToMenuArea.add(available_label);
		
		
		addToMenuP.add(addToMenuArea);
		addToMenuP.add(addToMenu_back);
		
	}
//	public static void updateWorkPlace() {
//		
//	}
	private static void addToMenuQuery(String title,String size, boolean available,String descr) {
		String query = "add_to_menu{";
		query +="title:"+title+",";
		query +="size:"+size+",";
		query +="available:"+available+",";
		query +="description:"+descr;
		query+="}";
		client.send(query);
		
		
	}
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
		gl_user.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				setContent(userPlaceP);
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
		
		
		user_label = new JLabel("User");
		user_label.setFont(new Font("Serif", Font.BOLD, 12));
		user_label.setForeground(Color.black);
		
		user_label.setBounds(width/2 - gl_user.getWidth()-50,height/2 - gl_user.getHeight()/2 ,60,30);
		
		
		
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
		worker_label = new JLabel("Worker");
		worker_label.setFont(new Font("Serif", Font.BOLD, 12));
		worker_label.setForeground(Color.black);
		worker_label.setBounds(width/2 +50,height/2 - gl_worker.getHeight()/2,50,20);
		
		
		glP.add(worker_label);
		glP.add(user_label);
		glP.add(gl_user);
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
		int margin_top=30;
		int margin_right=15;
		int h1=30;
		
		login_label_in = new JLabel("login");
		login_label_in.setBounds(margin_left, margin_top-20,50,20);
		
		login = new MyTF();
		login.setBorder(BorderFactory.createEmptyBorder());
		login.setBackground(new Color(0,0,0,0));
		login.setLocation(margin_left, margin_top);
		login.setSize(w-margin_left-margin_right,h1);
		
		password_label_in = new JLabel("password");
		password_label_in.setBounds(margin_left, 2*margin_top+login.getHeight()+10,70,20);
		pass= new MyPF();
		pass.setEchoChar('*');
		pass.setLocation(margin_left, 2*margin_top+login.getHeight()+30);
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
		sign_inArea.add(password_label_in);
		sign_inArea.add(login_label_in);
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
		int margin_top=25;
		int margin_right=15;
		int h1=30;
		login_label_up = new JLabel("login");
		login_label_up.setBounds(margin_left, h1-20,50,20);
		
		loginUp = new MyTF();
		loginUp.setBorder(BorderFactory.createEmptyBorder());
		loginUp.setBackground(new Color(0,0,0,0));
		loginUp.setLocation(margin_left, margin_top);
		loginUp.setSize(w-margin_left-margin_right,h1);
		
		password_label_up = new JLabel("passwords");
		password_label_up.setBounds(margin_left, 2*margin_top+login.getHeight()+10,70,20);
		
		passUp= new MyPF();
		passUp.setEchoChar('*');
		passUp.setLocation(margin_left, 2*margin_top+login.getHeight()+30);
		passUp.setBorder(BorderFactory.createEmptyBorder());
		passUp.setSize(w-margin_left-margin_right,h1);
		passUp.setBackground(new Color(0,0,0,0));
		
		passRepUp= new MyPF();
		passRepUp.setEchoChar('*');
		passRepUp.setLocation(margin_left, 3*margin_top+login.getHeight()+pass.getHeight()+10);
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
		sign_upArea.add(login_label_up);
		sign_upArea.add(password_label_up);
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
		sign_in_label=new JLabel("Sign_in");
		sign_in_label.setBounds(40,5,50,20);
		button_sign_in_Worker.add(sign_in_label);
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
		sign_up_label=new JLabel("Sign_up");
		sign_up_label.setBounds(40,5,50,20);
		button_sign_up_Worker.add(sign_up_label);
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
