package purchase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bill.Constant;

import java.sql.*;
public class Purchase extends JFrame {
	Connection con;
	Statement st;
	ResultSet rs;
JLabel Product_id = new	JLabel("Product id");
JLabel Product_name= new JLabel("Product name");
JTextField Product_idl= new JTextField();
JTextField Product_Name= new JTextField();
JLabel Vendor= new JLabel("Vendor");
JTextField Vendorl= new JTextField();
JLabel Quantity= new JLabel("Quantity");
JTextField Quantityl= new JTextField();
JLabel Purchase_Price= new JLabel("Purchase_Price");
JTextField Purchase_Pricel= new JTextField();
JLabel Bill_no= new JLabel("Bill_no");
JTextField Bill_nol= new JTextField();
JButton confirm = new JButton("Confirm");

	public Purchase()
	{
	setLayout(null);
	setLocation(200,100);
	setSize(500,400);
	setVisible(true);
 	getContentPane().setBackground(Color.RED);

	Product_id.setBounds(50,50,100,20);
	add(Product_id);
	Product_idl.setBounds(150,50,100,20);
	add(Product_idl);
	
	Product_name.setBounds(50,100,100,20);
	add(Product_name);
	Product_Name.setBounds(150,100,100,20);
	add(Product_Name);
	
	Vendor.setBounds(50,150,100,20);
	add(Vendor);
	Vendorl.setBounds(150,150,100,20);
	add(Vendorl);

	Quantity.setBounds(50,200,100,20);
	add(Quantity);
	Quantityl.setBounds(150,200,100,20);
	add(Quantityl);
	
	Purchase_Price.setBounds(50,250,100,20);
	add(Purchase_Price);
	Purchase_Pricel.setBounds(150,250,100,20);
	add(Purchase_Pricel);
	
	Bill_no.setBounds(50,300,100,20);
	add(Bill_no);
	Bill_nol.setBounds(150,300,100,20);
	add(Bill_nol);
	
	confirm.setBounds(300, 150, 100, 30);	
		add(confirm);
		confirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				

				// TODO Auto-generated method stub
				try
				{
					Class.forName(Constant.DRIVER);
					con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
					st=con.createStatement();
					String querry = "select * from PRODUCT where id='"+Product_idl.getText()+"'";
					
					rs= st.executeQuery(querry);
					if(rs.next())
					{
						int sto=rs.getInt(8)+Integer.parseInt(Quantityl.getText());
						
						querry="INSERT INTO purchase values('"+Product_idl.getText()+"','"+Vendorl.getText()+"','"+Quantityl.getText()+"','"+Purchase_Pricel.getText()+"','"+Bill_nol.getText()+"')";
						st.executeUpdate(querry);
					//	System.out.println(sto);
						
						
						
						querry="UPDATE product SET stock='"+sto+"' WHERE id='"+Product_idl.getText()+"'";
						st.executeUpdate(querry);
						JOptionPane.showMessageDialog(null, "Purchase made succesfully ");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"id does not exist choose anyother for Purchase");
					}
				}
				catch(Exception ea)
				{
					System.out.println(ea);
				}
			
			}
		});
	
		
		
	}

}