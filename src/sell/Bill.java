package sell;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import bill.Constant;

public class Bill extends JFrame {
	 JButton SEARCH,PRINT;
	    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,p;
	    JTextField text1,text2,text3,text4,text5,text0,text6,text7,text8,text9,text10,text11,text12,text13;
	    JComboBox cb;
	    String rate;
	    String ids,c1,c2,c3;
	    JTable product_list; 
	    JScrollPane js;
	    DefaultTableModel model;
	    public Bill(int bill_no){
	    	
	    	String column_name[] = {"Item Code","Particulars","Qty","Price","Amount"};
	        String list="",price="",amount="",quty="",total_unit="",b_t=""; 
	        setTitle("SELL");
	        setLayout(null);
	      
	        label1=new JLabel("Bill genration");
	        label1.setFont(new Font("Comic Sans MS",4,40));
	        label1.setBounds(300,30,200,40);
	        add(label1);
	        
	        label2 = new JLabel();
	        label2.setText("Customer_Name");
	        label2.setFont(new Font("Comic Sans MS", 4, 16));
	        label2.setBounds(50,90,200,60);
	        add(label2);
	        text2 = new JTextField(null);
	        text2.setBounds(250, 105, 300, 20);
	        add(text2);  
	        text2.setEditable(false);
	        
	        
	        
	        
	         label3 = new JLabel();
	        label3.setText("Phone No:");
	        label3.setFont(new Font("Comic Sans MS", 4, 16));
	        label3.setBounds(50,110,200,60);
	        add(label3);
	        text3 = new JTextField(null);
	        text3.setBounds(250,130, 300, 20);
	        add(text3); 
	        text3.setEditable(false);
 
	        label4 = new JLabel();
	        label4.setText("Product id");
	        label4.setFont(new Font("Comic Sans MS", 4, 16));
	        label4.setBounds(50,135,200,60);
	        add(label4);
	        text4 = new JTextField(null);
	        text4.setBounds(250,150, 300, 20);
	        add(text4); 
	        text4.setEditable(false);

	        label5 = new JLabel();
	        label5.setText("product");
	        label5.setFont(new Font("Comic Sans MS", 4, 16));
	        label5.setBounds(50,160,200,60);
	        add(label5);
	        text5 = new JTextField(null);
	        text5.setBounds(250,175, 100, 20);
	        add(text5); 
	        text5.setEditable(false);
	      // text5.getText().toString();
	       
	      
	        
//	        label5 = new JLabel();
//	        label5.setText("Manifactured By");
//	        label5.setFont(new Font("Comic Sans MS", 4, 16));
//	        label5.setBounds(50,220,200,60);
//	        add(label5);
//	        text6 = new JTextField(null);
//	        text6.setBounds(250,235, 100, 20);
//	        add(text6); 
	       
	       // text6.setText(text5.getText().toString() );
	        
	        label6 = new JLabel();
	        label6.setText("Price");
	        label6.setFont(new Font("Comic Sans MS", 4, 16));
	        label6.setBounds(50,190,50,60);
	        add(label6);
	        text7 = new JTextField(null);
	        text7.setBounds(100,205, 100, 20);
	        add(text7); 
	        text7.setEditable(false);

	        
	          
	        label7 = new JLabel();
	        label7.setText("QNT");
	        label7.setFont(new Font("Comic Sans MS", 4, 16));
	        label7.setBounds(210,190,50,60);
	        add(label7);
	        
	        String quantity[] = {"1","2","3","4","5","6","7","8","9","10"};  
	        cb = new JComboBox(quantity);
	        cb.setBounds(260,205,50,20);
	        add(cb);
	        cb.getSelectedItem().toString();
	        cb.setEditable(false);
	        
	        label8 = new JLabel();
	        label8.setText("CGST");
	        label8.setFont(new Font("Comic Sans MS", 4, 16));
	        label8.setBounds(320,190,50,60);
	        add(label8);
	        text8 = new JTextField(null);
	        text8.setBounds(380,205, 100, 20);
	        add(text8); 
	        text8.setEditable(false);

	        label9 = new JLabel();
	        label9.setText("SGST");
	        label9.setFont(new Font("Comic Sans MS", 4, 16));
	        label9.setBounds(490,190,50,60);
	        add(label9);
	        text9 = new JTextField(null);
	        text9.setBounds(550,205, 100, 20);
	        add(text9); 
	        text9.setEditable(false);

	        label10 = new JLabel();
	        label10.setText("Total");
	        label10.setFont(new Font("Comic Sans MS", 4, 16));
	        label10.setBounds(660,190,50,60);
	        add(label10);
	        text10 = new JTextField(null);
	        text10.setBounds(720,205, 100, 20);
	        add(text10); 
	        text10.setEditable(false);

	   
	   
	        
	        
	        
	          PRINT = new JButton("Print Bill");
	          PRINT.setFont(new Font("Comic Sans MS", 4, 16));
	          PRINT.setBounds(100,390,100,20);
	          add(PRINT);
	        
	          model = new DefaultTableModel();
	          model.setColumnIdentifiers(column_name);
	          product_list = new JTable();
	          product_list.setModel(model);
	          product_list.enable(false);
	          
	          JTableHeader header = product_list.getTableHeader();
	          header.setBackground(Color.GRAY);
	          header.setForeground(new java.awt.Color(255, 255, 255));
	          header.setFont(new java.awt.Font("Elephant", 0, 12));
	          
	          product_list.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	          
	          product_list.getColumnModel().getColumn(0).setPreferredWidth(80);
	          product_list.getColumnModel().getColumn(1).setPreferredWidth(365);
	          product_list.getColumnModel().getColumn(2).setPreferredWidth(50);
	          product_list.getColumnModel().getColumn(3).setPreferredWidth(50);
	   //       product_list.getColumnModel().getColumn(4).setPreferredWidth(50);
	          product_list.getColumnModel().getColumn(4).setPreferredWidth(100);
	          
	          JScrollPane scroll = new JScrollPane(product_list);
	          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	          scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	          scroll.setBounds(200, 250, 700, 300);
	          getContentPane().add(scroll);
	          	

				try
				{
					Class.forName(Constant.DRIVER);
				Connection	con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
				Statement	st=con.createStatement();
					String querry = "select * from bill where billno='"+bill_no+"'";
				
					ResultSet rs;
					rs= st.executeQuery(querry);
					if(rs.next())
					{
						
						text2.setText(rs.getString(2));
						text3.setText(rs.getString(2));
						
					
					}
					
					
					
					else
					{
						JOptionPane.showMessageDialog(null, "Error!!");
					}
					
					
					
				}
				catch(Exception ea)
				{
					System.out.println(ea);
				}
	          try
	          {
	        	  Class.forName(Constant.DRIVER);
					Connection	con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
					Statement	st=con.createStatement();
						String querry = "select * from billdetail where billno='"+bill_no+"'";
						ResultSet rs;
						rs= st.executeQuery(querry);
						while(rs.next())
						{
							
							text4.setText(rs.getString(2));
							text5.setText(rs.getString(3));
							text10.setText(rs.getString(4));

						
						}
						querry ="SELECT * from billdetail where billno='"+bill_no+"'";
						rs=st.executeQuery(querry);
						String itemcode,parti,quan,pric,total,gst;
						
						if(rs.next())
						{
							itemcode=rs.getString(2);
							parti=rs.getString(3);
							quan=rs.getString(4);
							pric=rs.getString(5);
							total=rs.getString(6);
							gst=rs.getString(7);
							
							cb.setSelectedItem(quan);
							text8.setText(gst);
							text9.setText(gst);
					text7.setText(pric);
							model.addRow(new Object[]{itemcode,parti,quan,pric,total});
						}
						

	          }
	          catch(Exception ea)
				{						
	        	  JOptionPane.showMessageDialog(null, "Error!!");

					System.out.println(ea);
				}
	       	getContentPane().setBackground(Color.blue);

	          setVisible(true);
	              setExtendedState(JFrame.MAXIMIZED_BOTH);           
	    } 
	        
}
