package purchase;
import javax.swing.*;

import product.*;
public class New_Purchase extends JFrame
{
	Product p= new Product();
	JFrame f= new JFrame("Notice");
	public New_Purchase()
	{
		JOptionPane.showMessageDialog(f,"You are directed to add product page to add the product for new Purchase  ");
		p.add_product();
//		setLayout(null);
//		setVisible(true);
//		setLocation(400,250);
//		setSize(600,400);
		
	}
	
	
	
}
