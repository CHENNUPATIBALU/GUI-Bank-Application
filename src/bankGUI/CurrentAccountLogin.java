package bankGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import accountCreation.createAccount;
import customerUI.CurrentAccount;

public class CurrentAccountLogin extends WindowAdapter implements ActionListener {

	JFrame f;
	JTextField t1,t2;
	JLabel l1,l2,l3,l4;
	JButton b1,bcreate;
	createAccount c;
	
	public CurrentAccountLogin()
	{
		f = new JFrame("CurrentAccount Login");
		
		l1 = new JLabel("Enter User Name: ");
		l2 = new JLabel("Enter Password: ");
		l3 = new JLabel("Incorrect username");
		l4 = new JLabel("Incorrect password");
		
		try {
			c = new createAccount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1 = new JTextField();
		t2 = new JTextField();
		
		b1 = new JButton("Login");
		bcreate = new JButton("SignUp");

		
		t1.setBounds(150, 40, 150, 30);
		t2.setBounds(150, 90, 150, 30);
		b1.setBounds(130, 130, 80, 20);
		bcreate.setBounds(220, 130, 80, 20);
		
		l1.setBounds(45, 40, 120, 20);
		l2.setBounds(45, 90, 120, 20);
		l3.setBounds(310, 40, 150, 30);
		l4.setBounds(310, 90, 150, 30);
		
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(t2);
		f.add(b1);
		f.add(l3);
		f.add(l4);
		f.add(bcreate);
		
		l3.setVisible(false);
		l4.setVisible(false);
		
		
		f.setLayout(null);
		f.setSize(450, 300);
		f.setVisible(true);
		f.setBackground(Color.WHITE);
		f.addWindowListener(this);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		b1.addActionListener(this);
		bcreate.addActionListener(this);
		
	}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(t1.getText().equals("") && t2.getText().equals("") && e.getSource()==bcreate)
		{
			f.setVisible(false);
<<<<<<< Updated upstream
=======
			try {
				new createAccount();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
>>>>>>> Stashed changes
		}
		if(t1.getText().equalsIgnoreCase("balu") && t2.getText().equalsIgnoreCase("abcd123") && e.getSource()==b1)
		{
			new CurrentAccount();
			f.setVisible(false);
		}
		else if(!t1.getText().equalsIgnoreCase("balu") && t2.getText().equalsIgnoreCase("abcd123") && e.getSource()==b1)
		{
			l3.setVisible(true);
			l4.setVisible(false);
			
		}
		else if(t1.getText().equalsIgnoreCase("balu") && !t2.getText().equalsIgnoreCase("abcd123") && e.getSource()==b1)
		{
			l4.setVisible(true);
			l3.setVisible(false);
		}
		else
			l3.setText("Enter credentials");l3.setVisible(true);
		
		
	}
}
