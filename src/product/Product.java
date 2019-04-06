package product;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bill.Constant;
import dashboard.*;
import java.sql.*;
public class Product extends JFrame {
	//JPanel panel = new JPanel();
	Connection con;
	Statement st;
	
	JLabel id= new JLabel("ID");
	JLabel name= new JLabel("Name");
	JLabel M_by= new JLabel("Manufactured By");
	JLabel M_Date= new JLabel("Manufatured Date");
	JLabel e_date= new JLabel("Expiry Date");
	JLabel S_Price= new JLabel("Sailing Price");
	JLabel P_Price= new JLabel("Purchase Price");
	JLabel quantity =new JLabel ("Stock");
	JLabel discount = new JLabel("Discount");
	JLabel status = new JLabel ("Status");
	JLabel min= new JLabel("minimum stock");
	JLabel About= new JLabel("About Product");
	JTextField idl= new JTextField();
	JTextField namel= new JTextField();
	JTextField M_byl= new JTextField();
	JTextField M_Datel= new JTextField();
	JTextField e_datel= new JTextField();
	JTextField S_Pricel= new JTextField();
	JTextField P_Pricel= new JTextField();
	JTextField quantityl =new JTextField ();
	JTextField discountl = new JTextField();
	JTextField statusl =new  JTextField ();
	JTextField minl= new JTextField();
	JTextField Aboutl= new JTextField();
	


	public  void add_product()
	{
		setLayout(null);
//setContentPane(new JLabel(new ImageIcon("E:\\projectphoto\\vai.jpg")));
     	getContentPane().setBackground(Color.YELLOW);

		
		setVisible(true);
		// setLocation(0,0);
         setExtendedState(JFrame.MAXIMIZED_BOTH); 
      //  setUndecorated(true);
	id.setBounds(50, 15, 60, 30);	
	id.setForeground(Color.MAGENTA);
	id.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(id);
	idl.setBounds(250, 20, 200, 20);	
	//idl.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(idl);
	name.setBounds(50, 60, 150, 30);	
	name.setForeground(Color.MAGENTA);
	name.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(name);
	namel.setBounds(250, 65, 200, 20);	
	//namel.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(namel);
	M_by.setBounds(50, 110, 200, 30);	
	M_by.setForeground(Color.MAGENTA);
	M_by.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(M_by);
	M_byl.setBounds(250, 115, 200, 20);	
	//M_byl.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(M_byl);
	
	M_Date.setBounds(50, 170, 200, 20);	
	M_Date.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(M_Date);
	M_Datel.setBounds(250, 175, 200, 20);	
	M_Datel.setForeground(Color.MAGENTA);
	//M_Datel.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(M_Datel);
	
	
	e_date.setBounds(50, 210, 150, 20);	
	e_date.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(e_date);
	e_datel.setBounds(250, 215, 200, 20);	
	e_datel.setForeground(Color.MAGENTA);
	//e_datel.setFont(new Font("Bradley Hand ITC ", 1, 10));
	add(e_datel);
	
	S_Price.setBounds(600, 15, 200, 20);	
	S_Price.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(S_Price);
	S_Pricel.setBounds(900, 15, 200, 20);	
	S_Price.setForeground(Color.MAGENTA);
	//S_Pricel.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(S_Pricel);
	
	P_Price.setBounds(600, 60, 200, 20);	
	P_Price.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(P_Price);
	P_Pricel.setBounds(900, 60, 200, 20);	
	P_Price.setForeground(Color.MAGENTA);
//	P_Pricel.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(P_Pricel);
	
	quantity.setBounds(600, 110, 200, 20);	
	quantity.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(quantity);
	quantityl.setBounds(900, 115, 200, 20);	
	quantity.setForeground(Color.MAGENTA);
	//quantityl.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(quantityl);
	
//	discount.setBounds(50, 460, 100, 20);	
//	discount.setFont(new Font("Bradley Hand ITC ", 1, 20));
//	add(discount);
//	discountl.setBounds(150, 465, 60, 30);	
//	discount.setForeground(Color.MAGENTA);
//	discountl.setFont(new Font("Bradley Hand ITC ", 1, 20));
//	add(discountl);

	status.setBounds(600, 160, 200, 20);	
	status.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(status);
	statusl.setBounds(900, 160 ,200, 20);	
	status.setForeground(Color.MAGENTA);
	//statusl.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(statusl);

	min.setBounds(600, 215, 200, 20);	
	min.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(min);
	minl.setBounds(900, 215, 200, 20);	
	min.setForeground(Color.MAGENTA);
	
	//minl.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(minl);
	
	About.setBounds(100, 350, 200, 20);	
	About.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(About);
	Aboutl.setBounds(300, 300, 500, 100);	
//	Aboutl.setForeground(Color.MAGENTA);
	idl.setText("");
	namel.setText("");
	M_byl.setText("");
	M_Datel.setText("");
	e_datel.setText("");
	S_Pricel.setText("");
	P_Pricel.setText("");
	quantityl.setText("");
	statusl.setText("");
	minl.setText("");
	Aboutl.setText("");
	
	
	//minl.setFont(new Font("Bradley Hand ITC ", 1, 20));
	add(Aboutl);
	 JButton submit= new JButton("Submit");
	submit.setBounds(550, 500, 100, 20);
			add(submit);
		
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try
				{
					Class.forName(Constant.DRIVER);
					con = DriverManager.getConnection(Constant.CONNECTION_STRING,Constant.USRENAME,Constant.PASSWORD);
					st=con.createStatement();
					String querry = "select * from PRODUCT where id='"+idl.getText()+"'";
					ResultSet rs;
					rs= st.executeQuery(querry);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null,"id already exist choose anyother");
					}
					else
					{
						querry=" INSERT INTO product values('"+idl.getText()+"','"+	namel.getText()+"','"+M_byl.getText()+"','"+M_Datel.getText()+"','"+e_datel.getText()+"','"+S_Pricel.getText()+"','"+P_Pricel.getText()+"','"+quantityl.getText()+"','"+statusl.getText()+"','"+minl.getText()+"','"+Aboutl.getText()+"')";                         
						JOptionPane.showMessageDialog(null, "Successfully added");
						st.executeUpdate(querry);
						idl.setText("");
						namel.setText("");
						M_byl.setText("");
						M_Datel.setText("");
						e_datel.setText("");
						S_Pricel.setText("");
						P_Pricel.setText("");
						quantityl.setText("");
						statusl.setText("");
						minl.setText("");
						Aboutl.setText("");
						repaint();
					
					
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

