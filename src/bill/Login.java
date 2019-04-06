package bill;
import java.awt.

BorderLayout;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dashboard.Dashboard;

import java.awt.Cursor;
//import javafx.scene.paint.Color;
import java.awt.*;
import java.awt.*;
public class Login extends JFrame {
	//JFrame f = new JFrame("Login");
	JLabel title;
	JLabel username,log;
	JLabel password;
	JTextField user;
	JPasswordField pass;
	JButton login;
	JButton exit;
	JButton signup;
	Cursor c = new Cursor(HAND_CURSOR);
	Connection con;
	ResultSet rs;
	Statement st;
	String querry;
	//ImageIcon imglogin;
	//JPanel panel;
//	Image im=ImageIO.read(new File("E:\\\\projectphoto\\\\taj.jpg"));
	public Login()
	{
		
		setLayout(null);
		setLocation(300,250);		setVisible(true);
	setSize(600,400);
		
		setContentPane(new JLabel(new ImageIcon("E:\\projectphoto\\f.jpg")));
//		imglogin	=	new ImageIcon(getClass().getResource(Constant.PATH+"login2.jpg"));
//		log =new JLabel(imglogin);
//		log.setBounds(20, 10, 600,400);
//		add(log);
//		
	//setBackground(Color.GREEN);
		setTitle("Login page");
		//panel= new JPanel(new GridLayout(3,1));
		
		title=new JLabel("Login");
		title.setFont(new Font("Bradley Hand ITC ",2,30));
		title.setBounds(250,30,500,80);
		title.setForeground(Color.YELLOW);
		
		//title.setForeground(Color.RED);
		
		username = new JLabel("Username");
		username.setFont(new Font("Bradley Hand ITC ",2,20));
		username.setBounds(200,80,500,80);
		username.setForeground(Color.GREEN);
		password = new JLabel("Password");
		password.setFont(new Font("Bradley Hand ITC ",2,20));
		password.setBounds(200,130,500,80);
		password.setForeground(Color.GREEN);
		
		user = new JTextField(null);
		user.setBounds(300,100,200,30);
		pass = new JPasswordField(null);
		pass.setBounds(300,150,200,30);
		login = new JButton("Login");
		exit = new JButton("Exit");
		//login.setText("Login");
		//exit.setText("Exit");
		//title.setForeground(Color.RED);
		login.setBounds(300,200,80,20);
		exit.setBounds(400,200,80,20);
		//title.setForeground(Color.RED);
		signup= new JButton("Signup");
		signup.setBounds(350,250,80,20);
		signup.setCursor(c);
		add(signup);
		add(title);
		add(username);
		add(password);
		add(user);
		add(pass);
		add(login);
		add(exit);  
		exit.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "sure you want to exit", "Title on Box", dialogButton);
				if(dialogResult == 0) {
				 dispose();
					//System.out.println("Yes option");
				} else {
				  //System.out.println("No Option");
				} 
			}
		});
				signup.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Sign_up();
			
			}
		});
			
				login.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(user.getText().equals("admin")&&pass.getText().equals("admin"))
						new Dashboard();
						else	
						try
						{
						Class.forName(Constant.DRIVER);
							con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
							st = con.createStatement();
							querry = "select * from login where username='"+user.getText()+"' and password='"+pass.getText()+"'";
							rs = st.executeQuery(querry);
						
							if(rs.next())
							{
								String fname = rs.getString(1);
								String sname = rs.getString(2);
							    dispose();
								new Dashboard();
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Enter  valid Username and Password");						}
						}
						
						catch(Exception eb)
						{
							eb.printStackTrace();
						}
						
						
						
					}
				});
		
		//add(panel,BorderLayout.CENTER);
		
		//login.setVisible(true);
		//exit.setVisible(true);
		
	}

}
