package accountProperties;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import bankDAO.CurrentDAO;
import bankDAO.SavingsDAO;
import bankDAO.*;

class Deposit extends BankDataBase
{
	String uname,pass;
	Deposit()
	{
		
	}
	
}
public class AmountDeposit extends WindowAdapter implements ActionListener {
	
	static JFrame f;
	JLabel accBal;
	JTextField t;
	JButton depositButton;
	String uname,pass;
	
	public AmountDeposit()
	{
		f = new JFrame("Deposit");
		accBal = new JLabel();
		t = new JTextField();
		depositButton = new JButton("Deposit");
		
		depositButton.addActionListener(this);
		t.addActionListener(this);
		
		f.setSize(300,200);
		f.setLayout(new GridLayout(5,3));
		f.addWindowListener(this);
	}

	public static void show(boolean set)
	{
		f.setVisible(set);
	}
	
	public void currentAccountDeposit(String uname,String pass)
	{
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		CurrentDAO cd;
		float amount = Float.parseFloat(t.getText());
		if(e.getSource()==depositButton)
		{
			try {
				cd = new CurrentDAO();
				//cd.currentDeposit(uname, pass);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
