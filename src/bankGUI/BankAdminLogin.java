package bankGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import bankDAO.*;

import javax.swing.*;



public class BankAdminLogin extends WindowAdapter implements ActionListener{
	
	JFrame f;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JButton b1;
	
	
	public BankAdminLogin()
	{
		f = new JFrame("Bank Admin");
		
		l1 = new JLabel("Enter User Name: ");
		l2 = new JLabel("Enter Password: ");
		l3 = new JLabel("Incorrect username");
		l4 = new JLabel("Incorrect password");
		
		t1 = new JTextField();
		t2 = new JTextField();
		
		b1 = new JButton("Login");
		
		t1.setBounds(150, 40, 150, 30);
		t2.setBounds(150, 90, 150, 30);
		b1.setBounds(190, 130, 80, 20);
		
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
		
		
		
		l3.setVisible(false);
		l4.setVisible(false);
		
		
		f.setLayout(null);
		f.setSize(450, 300);
		f.setVisible(true);
		f.addWindowListener(this);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		b1.addActionListener(this);
	}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	

	public static void main(String[] args) throws Exception{
		new BankAdminLogin();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		AccountSelection a = new AccountSelection();
		f.setVisible(false);
		try {
				a.FrameVisible(true);
				BankDataBase b = new BankDataBase();
				b.createDB(t1.getText(),t2.getText());
				b.createBankTB();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
}
