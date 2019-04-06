package bill;
import sell.*;



import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import dashboard.Dashboard;

import javax.swing.JLabel;

public class Welcome extends JFrame implements Runnable
{
	JLabel title;
	JProgressBar bar;
	Thread t;
	public Welcome() {
	setLayout(null);
	setUndecorated(true);
	setBackground(Color.GREEN);
	t = new Thread(this);
	title = new JLabel("My Billing System");
	title.setFont(new Font("Bradley Hand ITC",2,44));
	title.setBounds(100,80,500,80);
	title.setForeground(Color.RED);
	add(title);
	 
	bar= new JProgressBar();
	bar.setBounds(1,246,598,4);	
	bar.setForeground(Color.BLUE);
	add(bar);
	t.start();
	setLocation(400,250);
	setVisible(true);
	setSize(600,250);
 	getContentPane().setBackground(Color.pink);
	
	
	
		
		
	}
	
	public static void main(String[] args) {
		new Welcome();
	}

	public void run() {
	try
	{
		for(int i=0;i<=100;i++)
		{
			bar.setValue(i);
			Thread.sleep(40);
		}
		dispose();
		new Login();
	}
	catch(Exception e)
	{
		System.out.println(e);
		}
	}
	}


