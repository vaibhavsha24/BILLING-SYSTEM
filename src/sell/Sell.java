package sell;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import bill.Constant;

import java.sql.*;
/**
 *
 * @author ACER
 */
public class Sell extends JFrame {
    
     JButton SEARCH,PRINT,add,delete;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,p;
    JTextField text1,text2,text3,text4,text5,text0,text6,text7,text8,text9,text10,text11,text12,text13;
    JComboBox cb;
    String rate;
    int row_no=0;
    static int  bill_no=1;
    String sta;
    JTable product_list; 
    JScrollPane js;
    DefaultTableModel model;
    float total=0,to;
    float tgst;
    String toa;
    
    public Sell(){
    	String column_name[] = {"Item Code","Particulars","Qty","Price","Amount"};
        String list="",price="",amount="",quty="",total_unit="",b_t=""; 
        setTitle("SELL");
        setLayout(null);
      sta=String.valueOf(bill_no);
        p = new JLabel();
        p.setText("Enter product id or name");
        p.setFont(new Font("Comic Sans MS", 4, 16));
        p.setBounds(30,20,200,60);
        add(p);
        
        
        text0 = new JTextField(null);
        text0.setBounds(300,40, 200, 20);
        add(text0);       
        
        SEARCH = new JButton("VIEW PRODUCT");
        SEARCH.setFont(new Font("Comic Sans MS", 4, 16));
        SEARCH.setBounds(650,40,100,20);
        add(SEARCH);
        
        label1 = new JLabel();
        label1.setText("BILL NO:");
        label1.setFont(new Font("Comic Sans MS", 4, 16));
        label1.setBounds(50,60,200,60);
        add(label1);
        text1 = new JTextField(null);
        text1.setBounds(250, 75, 300, 20);
       // text1.setEditable(false);
        text1.setText(String.valueOf(bill_no));
        add(text1);
        
        
        
        label2 = new JLabel();
        label2.setText("Customer_Name");
        label2.setFont(new Font("Comic Sans MS", 4, 16));
        label2.setBounds(50,90,200,60);
        add(label2);
        text2 = new JTextField(null);
        text2.setBounds(250, 105, 300, 20);
        add(text2);       
        
        
        
        
         label3 = new JLabel();
        label3.setText("Phone No:");
        label3.setFont(new Font("Comic Sans MS", 4, 16));
        label3.setBounds(50,110,200,60);
        add(label3);
        text3 = new JTextField(null);
        text3.setBounds(250,130, 300, 20);
        add(text3); 
        
        label4 = new JLabel();
        label4.setText("Product id");
        label4.setFont(new Font("Comic Sans MS", 4, 16));
        label4.setBounds(50,135,200,60);
        add(label4);
        text4 = new JTextField(null);
        text4.setBounds(250,150, 300, 20);
        add(text4); 
        
        label5 = new JLabel();
        label5.setText("product");
        label5.setFont(new Font("Comic Sans MS", 4, 16));
        label5.setBounds(50,160,200,60);
        add(label5);
        text5 = new JTextField(null);
        text5.setBounds(250,175, 100, 20);
        add(text5); 
       
      // text5.getText().toString();
       
      
        
//        label5 = new JLabel();
//        label5.setText("Manifactured By");
//        label5.setFont(new Font("Comic Sans MS", 4, 16));
//        label5.setBounds(50,220,200,60);
//        add(label5);
//        text6 = new JTextField(null);
//        text6.setBounds(250,235, 100, 20);
//        add(text6); 
       
       // text6.setText(text5.getText().toString() );
        
        label6 = new JLabel();
        label6.setText("Price");
        label6.setFont(new Font("Comic Sans MS", 4, 16));
        label6.setBounds(50,190,50,60);
        add(label6);
        text7 = new JTextField(null);
        text7.setBounds(100,205, 100, 20);
        add(text7); 
   
        
          
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
        
        label8 = new JLabel();
        label8.setText("CGST");
        label8.setFont(new Font("Comic Sans MS", 4, 16));
        label8.setBounds(320,190,50,60);
        add(label8);
        text8 = new JTextField(null);
        text8.setBounds(380,205, 100, 20);
        add(text8); 
        
        label9 = new JLabel();
        label9.setText("SGST");
        label9.setFont(new Font("Comic Sans MS", 4, 16));
        label9.setBounds(490,190,50,60);
        add(label9);
        text9 = new JTextField(null);
        text9.setBounds(550,205, 100, 20);
        add(text9); 
        
        label10 = new JLabel();
        label10.setText("Total");
        label10.setFont(new Font("Comic Sans MS", 4, 16));
        label10.setBounds(660,190,50,60);
        add(label10);
        text10 = new JTextField(null);
        text10.setBounds(720,205, 100, 20);
        add(text10); 
   
        delete = new JButton("Delete previous Product");
        delete.setFont(new Font("Comic Sans MS", 4, 16));
        delete.setBounds(1000,300,200,20);
        add(delete);
        
   
        add = new JButton("Add Product");
        add.setFont(new Font("Comic Sans MS", 4, 16));
        add.setBounds(850,200,200,20);
        add(add);
        
        
          PRINT = new JButton("Save Bill");
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
      //    product_list.getColumnModel().getColumn(4).setPreferredWidth(50);
          product_list.getColumnModel().getColumn(4).setPreferredWidth(100);
          
          JScrollPane scroll = new JScrollPane(product_list);
          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          scroll.setBounds(200, 250, 700, 300);
          getContentPane().add(scroll);
          	
          SEARCH.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				try
				{
					Class.forName(Constant.DRIVER);
				Connection	con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
				Statement	st=con.createStatement();
					String querry = "select * from PRODUCT where id='"+text0.getText()+"'";
					ResultSet rs;
					rs= st.executeQuery(querry);
					if(rs.next())
					{
						text4.setText(rs.getString(1));
						text5.setText(rs.getString(2));
					//	querry = " INSERT INTO ";
						text7.setText(rs.getString(6));
						
					}
					
					
					
					else
					{
						JOptionPane.showMessageDialog(null, "Item code is not valid");
					}
				}
				catch(Exception ea)
				{
					System.out.println(ea);
				}
				// TODO Auto-generated method stub
				
			}
			
		});
          add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			to =Integer.parseInt(text7.getText())*(Integer.parseInt((String) cb.getSelectedItem()));
			tgst=Integer.parseInt(text8.getText())+Integer.parseInt(text9.getText());
			to=to+((total*tgst)/100);
			toa=String.valueOf(to);
			total=total+to;
			text10.setText(String.valueOf(total));
			try
				{
					row_no++;
					System.out.println(row_no);
					Class.forName(Constant.DRIVER);
				Connection	con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
				Statement	st=con.createStatement();
					String querry = "Insert into billdetail values('"+text1.getText()+"','"+text4.getText()+"','"+text5.getText()+"','"+cb.getSelectedItem()+"','"+text7.getText()+"','"+text10.getText()+"','"+text9.getText()+"')";
					ResultSet rs;
				 st.executeUpdate(querry);
				 
				 model.addRow(new Object[]{text4.getText(),text5.getText(),cb.getSelectedItem(),text7.getText(),toa});
					
				
				}
				catch(Exception ea)
				{
					System.out.println(ea);
				}
				
			}
		});
          delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			try
			{Class.forName(Constant.DRIVER);
				Connection	con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
				Statement	st=con.createStatement();
				 model.removeRow(model.getRowCount()-1);
				 row_no--;
				String querry = "delete from billdetail where itemcode='"+text4.getText()+"'";
					ResultSet rs;
				 st.executeUpdate(querry);
				 JOptionPane.showMessageDialog(null, "Item deleted sucesfully");
				 
			}catch(Exception ed)
			{
				ed.printStackTrace();
			}
			}
		});
          
          PRINT.addActionListener(new ActionListener() {
		
        	  
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					
					
					
					Class.forName(Constant.DRIVER);
					Connection	con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
					Statement	st=con.createStatement();
						String querry = "Insert into bill values('"+text1.getText()+"','"+text2.getText()+"','"+text3.getText()+"','"+total+"')";
						
					 st.executeUpdate(querry);
					 JOptionPane.showMessageDialog(null, "Bill Sucessfuly saved");
					 bill_no++;
				}catch(Exception ed)
				{
					JOptionPane.showMessageDialog(null, "Bill not Saved try again");
				}
			}
		});
          
       	getContentPane().setBackground(Color.green);

          
          setVisible(true);
              setExtendedState(JFrame.MAXIMIZED_BOTH);           
    } 
        
        
        
}
