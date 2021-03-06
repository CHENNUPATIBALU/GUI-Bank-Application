package bankGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import accountCreation.createAccount;
import customerUI.CurrentAccount;
import customerUI.CustomerInfo;

public class CurrentAccountLogin extends WindowAdapter implements ActionListener {

	JFrame f;
	JTextField t1;
	JPasswordField t2;
	JLabel l1,l2,l3;
	JButton b1,bcreate;
	createAccount c;
	
	public CurrentAccountLogin()
	{
		f = new JFrame("CurrentAccount Login");
		
		l1 = new JLabel("Enter User Name: ");
		l2 = new JLabel("Enter Password: ");
		l3 = new JLabel();
		
		t1 = new JTextField();
		t2 = new JPasswordField();
		
		
		b1 = new JButton("Login");
		bcreate = new JButton("SignUp");

		
		t1.setBounds(150, 40, 150, 30);
		t2.setBounds(150, 90, 150, 30);
		b1.setBounds(130, 130, 80, 20);
		bcreate.setBounds(220, 130, 80, 20);
		
		l1.setBounds(45, 40, 120, 20);
		l2.setBounds(45, 90, 120, 20);
		l3.setBounds(310, 40, 150, 30);
		
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(t2);
		f.add(b1);
		f.add(l3);
		f.add(bcreate);
		
		l3.setVisible(false);
		
		
		f.setLayout(null);
		f.setSize(450, 300);
		f.setVisible(true);
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
	public void show(boolean set)
	{
		f.setVisible(set);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
				if(t1.getText().equals("") && t2.getText().equals("") && e.getSource()==bcreate)
				{
					f.setVisible(false);
					try {
						new createAccount().show(true);
						new createAccount().show(false);
						show(true);
					} catch (Exception e1) {
						show(true);
					}
				}
					
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}l3.setVisible(true);
		}
		
	public void check() throws Exception
	{
	try
		{
			CustomerInfo ci = new CustomerInfo();
				if(ci.checkCurrentInfo(t2.getText(), t1.getText()))
				{
					new CurrentAccount(null, 0, 0).show();
					System.out.println("Current Account Login Success");
					f.setVisible(false);
				}
				else if(ci.checkCurrentInfo(t2.getText(), ""))
				{
					l3.setText("Incorrect username");
				}
				else if(ci.checkCurrentInfo("", t1.getText()))
				{
					l3.setText("Incorrect password");
				}
				else if(ci.checkCurrentInfo("", ""))
				{
					l3.setText("Enter Credentials");
				}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		
	}
}

