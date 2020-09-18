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
	JLabel l1,l2,l3;
	int accno;
	int choice;
	
	static Random rand = new Random();
	
	
	public createAccount()
	{
		f = new JFrame("Account Creation");
		t1 = new JTextField();
		t2 = new JTextField();
		
		cb1 = new JCheckBox("Savings");
		cb2 = new JCheckBox("Current");
		
		b1 = new JButton("Create");
		
		
		l1 = new JLabel("Enter your Name: ");
		l2 = new JLabel("Your Account Number: ");
		l3 = new JLabel("Enter the amount for initial deposit: ");
		
		l1.setBounds(10, 20, 150, 30);
		l2.setBounds(10, 50, 200, 30);
		l3.setBounds(10, 80, 300, 30);
		
		t1.setBounds(210, 20, 150, 30);
		t2.setBounds(210, 80, 150, 30);
		
		b1.setBounds(250, 200, 80, 30);
		
		cb1.setBounds(210, 120, 100, 30);
		cb2.setBounds(240, 150, 100, 30);
		
		
		f.add(l1);
		f.add(b1);
		f.add(l2);
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
	
	public void createSavingsAccount() throws Exception
	{
		SavingsDAO sd;
		SavingsAccount sa;
		sd = new SavingsDAO();
		sa = new SavingsAccount();
		accno=rand.nextInt(999999999);
		accno=rand.nextInt(999999999);
		String name = t1.getText();
		float amount = Float.parseFloat(t2.getText());
		sd.insertSavingsTb(accno, name, amount);
		sa.setSavingsnameDetails(name, accno, amount);
	}
	public void createCurrentAccount() throws Exception
	{
		CurrentDAO cd;
		CurrentAccount ca;
		cd = new CurrentDAO();
		ca = new CurrentAccount();
		accno=rand.nextInt(999999999);
		String name = t1.getText();
		float amount = Float.parseFloat(t2.getText());
		cd.insertCurrentTb(accno, name, amount);
		ca.setCurrentnameDetails(name, accno, amount);
	}
	
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			choice = 1;
		}
		else if(e.getSource()==cb2 && e.getSource()==b1)
		{
			choice = 2;
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==1 && e.getItem()==cb1 && choice==1)
		{
			try {
				new createAccount().createSavingsAccount();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getStateChange()==1 && e.getItem()==cb2)
		{
			try {
				new createAccount().createCurrentAccount();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}
