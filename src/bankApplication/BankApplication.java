package bankApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import bankGUI.*;

public class BankApplication extends WindowAdapter implements ActionListener{
	
	JFrame f;
	JPanel p;
	JButton adminButton,customerButton;
	
	public BankApplication()
	{
		f = new JFrame("Bank");
		p = new JPanel(null);
		adminButton = new JButton("Bank Login");
		customerButton = new JButton("Customer Login");
		
		adminButton.setBounds(70, 30, 150, 30);
		customerButton.setBounds(70, 80, 150, 30);
		f.add(p);
		p.add(adminButton);
		p.add(customerButton);
		
		adminButton.addActionListener(this);
		customerButton.addActionListener(this);

		f.setSize(300, 200);
		f.setLocation(600, 300);
		f.setVisible(true);
		f.addWindowListener(this);
	}
	

	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	public static void main(String[] args) {
		new BankApplication();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		BankAdminLogin b = new BankAdminLogin();
		AccountSelection a = new AccountSelection();
		if(e.getSource()==adminButton)
		{
			b.show(true);
			a.FrameVisible(false);
		}
		if(e.getSource()==customerButton)
		{
			b.show(false);
			a.FrameVisible(true);
		}
		
	}

}
