package customerUI;

import javax.swing.*;

public class createAccount {

	JFrame f;
	JTextField t1,t2;
	JButton b1;
	JLabel l1,l2,l3;
	
	public createAccount()
	{
		f = new JFrame("Account Creation");
		t1 = new JTextField();
		t2 = new JTextField();
		
		l1 = new JLabel("Enter your Name: ");
		l2 = new JLabel("Your Account Number: ");
		l3 = new JLabel("Enter the amount for initial deposit: ");
		
		
		
	}
}
