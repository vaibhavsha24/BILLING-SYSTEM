package stock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import bill.Constant;
public class Stock extends JFrame
 {
	Connection con;
	Statement sta;

	JButton search = new JButton("Search");
	JTextField s = new JTextField();
	JTextField st= new JTextField();
	JLabel stoc= new JLabel("Stock is");
	
	
	public Stock()
	{
		setLayout(null);
		setLocation(200,100);
		setSize(600,200);
		setVisible(true);
		
		
	search.setBounds(100,30,80,20);
	add(search);
	
	s.setBounds(200,30,300,20);
	add(s);	

	
	
	st.setBounds(200,60,100,20);
	add(st);
	
	stoc.setBounds(100,60,100,20);
	add(stoc);
	search.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try
			{
				Class.forName(Constant.DRIVER);
				con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
				sta=con.createStatement();
				String querry = "select * from PRODUCT where id='"+s.getText()+"'";
				ResultSet rs;
				rs= sta.executeQuery(querry);
				if(rs.next())
				{
					st.setText(rs.getString(8));
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
		}
	});
	
	
	
	
	
	
	}
	
	
	
	
}
