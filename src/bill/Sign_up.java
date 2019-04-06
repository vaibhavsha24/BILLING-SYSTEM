package bill;
import java.sql.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dashboard.Dashboard;

public class Sign_up extends JFrame{
	JFrame f= new JFrame("Signup");
	
	 Connection con;
	 Statement st;
	JLabel title ;
	JLabel Fname;
	JLabel Sname;
	JLabel username;
	JLabel pass;
	JLabel cpass;
	JTextField fn;
	JTextField sn;
	JTextField use;
	JPasswordField pas;
	JPasswordField cpas;
	JButton reg=  new JButton("Register");
	JButton lo= new JButton("Login");
//	JLabel reg_no;
	
	public Sign_up() {
		f.setLayout(null);
		f.setSize(600,400);
		f.setLocation(400, 250);
		f.setVisible(true);
		f.setContentPane(new JLabel(new ImageIcon("E:\\projectphoto\\va.jpg")));

		title =new JLabel("Sign up");
		title.setFont(new Font("Kristen ITC", 1, 30));
		title.setBounds(250,30,500,80);
		title.setForeground(Color.ORANGE);
		
		f.add(title);
		Fname= new JLabel("Fname");
		Fname.setFont(new Font("Kristen ITC", 1, 20));
		Fname.setBounds(200,80,500,80);
		Fname.setForeground(Color.yellow);
		f.add(Fname);
		Sname= new JLabel("Sname");
		Sname.setFont(new Font("Kristen ITC", 1, 20));
		Sname.setBounds(200,120,500,80);
		Sname.setForeground(Color.yellow);
		f.add(Sname);

		username= new JLabel("username");
		username.setFont(new Font("Kristen ITC", 1, 20));
		username.setBounds(200,160,500,80);
		username.setForeground(Color.yellow);
		f.add(username);
	

		pass= new JLabel("Password");
		pass.setFont(new Font("Kristen ITC", 1, 20));
		pass.setBounds(200,200,500,80);
		pass.setForeground(Color.yellow);
		f.add(pass);

		cpass= new JLabel("Confirm pass");
		cpass.setFont(new Font("Kristen ITC", 1, 20));
		cpass.setBounds(150,240,500,80);
		cpass.setForeground(Color.yellow);
		f.add(cpass);
		
		fn= new JTextField();
		fn.setBounds(300,100,200,30);
		f.add(fn);
		sn= new JTextField();
		sn.setBounds(300,140,200,30);
		f.add(sn);
			
		use= new JTextField();
		use.setBounds(300,180,200,30);
		f.add(use);
			
		pas= new JPasswordField();
		pas.setBounds(300,220,200,30);
		f.add(pas);
			
		cpas= new JPasswordField();
		cpas.setBounds(300,260,200,30);
		f.add(cpas);
		lo.setBounds(50, 200, 100, 30);
		f.add(lo);
		reg.setBounds(300,300,200,30);
		f.add(reg);
		lo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
				new Login();
				
				
			}
		});
		reg.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(fn.getText().equals("")||use.getText().equals("")||use.getText().equals("")||pas.getText().equals("")||cpas.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "all fields are required");
				}
				else if(!pas.getText().equals(cpas.getText()))
				{
					JOptionPane.showMessageDialog(null, "password and confirm password field should be same");
				}
				
				else
				{
					
					
					String fna= fn.getText();
					String sna=sn.getText();
					String user=use.getText();
						String pass=cpas.getText();
					try {
					Class.forName(Constant.DRIVER);
					con= DriverManager.getConnection(Constant.CONNECTION_STRING, Constant.USRENAME, Constant.PASSWORD);
					String querry="insert into login values('"+fn.getText()+"','"+sn.getText()+"','"+use.getText()+"','"+pass+"')";
					
					st=con.createStatement();
					st.executeUpdate(querry);
				
					System.out.println("upated");
					f.dispose();
					new Dashboard();
					
				}
					catch(Exception ea) {
						ea.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error please Check your information and try again");
					}
			}
				}
		});
		
		

	}
}
