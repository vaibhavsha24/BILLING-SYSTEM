package dashboard;

import product.*;
import purchase.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import sell.*;
import javax.swing.*;

import java.sql.*;
import bill.Constant;
import stock.*;
public class Dashboard extends JFrame

{
	public JFrame f = new JFrame("Dashboard");
	JLabel dash;
	JMenuBar menubar;
	JMenu product;
	JMenu purchase;
	//JButton Sell;
	JMenu Stock;
	JMenu Sell;
	JMenu Report;
	
	Product p= new Product();
	
	JMenuItem menuitem1;
		
		// JMenu menu, submenu;  
         JMenuItem i1, i2, i3, i4, i5,new_Purchase,Existing_purchase,one_stock,sell,bill,purch,sell_report,stock,profit_loss;  
         public Dashboard()
         {  
        	 dispose();
         
        	 
        	 
        	 JFrame f= new JFrame("Billing System");  
        	 ImageIcon img= new ImageIcon("E:\\projectphoto\\da.jpg");
        	 Image im= img.getImage();
        	 Image temp=im.getScaledInstance(1000, 500, Image.SCALE_SMOOTH);
        	 img=new ImageIcon(temp);
        	 JLabel bac=new JLabel("",img,JLabel.CENTER);
        	 bac.setBounds(0,0,1000,500);
        	 f.add(bac);
        	 
        	 JMenuBar mb=new JMenuBar();  
         product=new JMenu("Product");  
         //submenu=new JMenu("Sub Menu");  
         i1=new JMenuItem("Add New Product");  
         i2=new JMenuItem("Update existing ");  
         i3=new JMenuItem("Delete");  
         i4=new JMenuItem("View Product");  
       //  i5=new JMenuItem("Item 5");  
         product.add(i1); product.add(i2); product.add(i3);  
        product.add(i4); //submenu.add(i5);  
       //  menu.add(submenu);  
         mb.add(product);  
     
         purchase=new JMenu("Purchase");  
         //submenu=new JMenu("Sub Menu");  
         new_Purchase=new JMenuItem("New Product Purchase");  
         Existing_purchase=new JMenuItem("Existing Product Purchase");  
        purchase.add(new_Purchase); //submenu.add(i5);  
        purchase.add(Existing_purchase); 
        //  menu.add(submenu);  
         mb.add(purchase); 
        //  menu.add(submenu);  
         //mb.add(Sell);
        Stock=new JMenu("Stock");  
         //submenu=new JMenu("Sub Menu"
        one_stock=new JMenuItem("View Stock");
         
        Stock.add(one_stock); 
        //  menu.add(submenu);  
         mb.add(Stock); 
         Sell= new JMenu("Sell");
         sell= new JMenuItem("Sell");
         Sell.add(sell);
         bill  = new JMenuItem("Bill");
 Sell.add(bill);
         mb.add(Sell);
         
//         
         Report= new JMenu("Report");
        purch = new JMenuItem("Purchase Report");
        sell_report = new JMenuItem("Sell Report");
        stock= new JMenuItem("Stock Report");
        profit_loss = new JMenuItem("Profit loss Report");
        
        
        Report.add(purch);
        Report.add(sell_report);
        Report.add(stock);Report.add(profit_loss); 
       //  mb.add(Report);
         
         i1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p.add_product();
				repaint();
			}
		});

         i2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new Edit();
				repaint();
			}
		});
         i4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new View();
				repaint();
			}
		});
        
         i3.addActionListener(new ActionListener() {
 			
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				new Delete();
 				repaint();
 				
 			}
 		});
     	//f.setContentPane(new JLabel(new ImageIcon("E:\\projectphoto\\da.jpg")));
     	
         f.setLocation(200,100);
         f.setJMenuBar(mb);  
         f.setSize(800,500);  
         f.setLayout(null);  
         f.setVisible(true);  
	new_Purchase.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new New_Purchase();
			repaint();
		}
	});
	Existing_purchase.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Purchase();
			
		}
	});
	
	
	one_stock.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Stock();
			
		}
	});
         
         
sell.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Sell();
			
		}
	});
bill.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		final JFrame f= new JFrame();
		JLabel l =new JLabel("Enter bill no");
		final JTextField la= new JTextField();
		JButton ok= new JButton("ok");
		f.setVisible(true);
		f.setLayout(null);
		f.setLocation(500, 300);
		f.setSize(500,200);
		l.setBounds(30,30,200,30);
		f.add(l);
		l.setFont(new Font("Kristen ITC", 1, 20));
		la.setBounds(100,70,100,30);
		f.add(la);
		
		ok.setBounds(150,100,100,30);
		f.add(ok);
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				
				// TODO Auto-generated method stub
				if(la.getText().equals(""))
				{
					JOptionPane.showMessageDialog(f,"id cannot be empty");
				}
				
			
			else
			{	int a= Integer.parseInt(la.getText());
			try
			{
				Class.forName(Constant.DRIVER);
			Connection	con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
			Statement	st=con.createStatement();
				String querry = "select * from bill where billno='"+la.getText()+"'";
				ResultSet rs;
				rs= st.executeQuery(querry);
				if(rs.next())
				{

					f.dispose();
					new Bill(a);
				}
				else
				{
					JOptionPane.showMessageDialog(f,"id is wrong");

				}
			}
			catch(Exception ea)
			{
				System.out.println(ea);
			}
			
			}
			}
		});
		
		
		//new Bill(a);
	}
});
    

         }
	
	
	
}
