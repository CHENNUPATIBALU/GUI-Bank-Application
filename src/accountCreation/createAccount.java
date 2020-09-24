package accountCreation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.*;
import bankDAO.SavingsDAO;
import customerUI.CurrentAccount;
import customerUI.SavingsAccount;
import bankDAO.CurrentDAO;

public class createAccount extends WindowAdapter implements ActionListener,ItemListener{

	JFrame f;
	JTextField t1,t2;
	JButton b1;
	JCheckBox cb1,cb2;
	JLabel l1,l2,l3,l4;
	int accno;
	int choice;
	
	static Random rand = new Random();
	
	
	public createAccount()
	{
		f = new JFrame("Account Creation");
		t1 = new JTextField();
		t2 = new JTextField();
		
		accno=rand.nextInt(999999999);
		
		cb1 = new JCheckBox("Savings");
		cb2 = new JCheckBox("Current");
		
		b1 = new JButton("Create");
		
		
		l1 = new JLabel("Enter your Name: ");
		l2 = new JLabel("Your Account Number: ");
		l3 = new JLabel("Enter the amount for initial deposit: ");
		l4 = new JLabel();
		
		l1.setBounds(10, 20, 150, 30);
		l2.setBounds(10, 50, 200, 30);
		l4.setBounds(250, 50, 200, 30);
		l3.setBounds(10, 80, 300, 30);
		
		t1.setBounds(210, 20, 150, 30);
		t2.setBounds(210, 80, 150, 30);
		
		b1.setBounds(250, 200, 80, 30);
		
		cb1.setBounds(210, 120, 100, 30);
		cb2.setBounds(220, 150, 100, 30);
		
		
		f.add(l1);
		f.add(b1);
		f.add(l2);
		f.add(l4);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(cb1);
		f.add(cb2);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		b1.addActionListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		
		f.setSize(700,300);
		f.setVisible(true);
		f.setLayout(null);
		f.addWindowListener(this);
	}
	
	public void createSavingsAccount(int accno,String name,float amount) throws Exception
	{
		SavingsDAO sd;
		SavingsAccount sa;
		sd = new SavingsDAO();
		sa = new SavingsAccount();
		sd.insertSavingsTb(accno, name, amount);
		sa.setSavingsnameDetails(name, accno, amount);
		System.out.println("Savings Account Created Successfully");
	}
	public void createCurrentAccount(int accno,String name,float amount) throws Exception
	{
		CurrentDAO cd;
		CurrentAccount ca;
		cd = new CurrentDAO();
		ca = new CurrentAccount();
		cd.insertCurrentTb(accno, t1.getText(), Float.parseFloat(t2.getText()));
		ca.setCurrentnameDetails(name, accno, amount);
		System.out.println("Current Account Created Successfully");
	}
	
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==1 && e.getSource()==cb1)
		{
			l4.setText(""+accno);
			choice = 1;
		}
		if(e.getStateChange()==1 && e.getSource()==cb2)
		{
			l4.setText(""+accno);
			choice = 2;
		}
		if(e.getStateChange()==1 && e.getSource()==cb1 && e.getSource()==cb2)
		{
			f.setTitle("* Select any one CheckBox");
		}
		else
		{
			f.setTitle("Account Creation");
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(choice==1 && e.getSource()==b1)
		{
			try
			{
				try {
					new createAccount().createSavingsAccount(accno, t1.getText(), Float.parseFloat(t2.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			catch(Exception ae) {}
		}
		else if(choice==2 && e.getSource()==b1)
		{
			try
			{
				try {
					new createAccount().createCurrentAccount(accno, t1.getText(), Float.parseFloat(t2.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			catch(Exception ae) {}
		}
	}
	
}
