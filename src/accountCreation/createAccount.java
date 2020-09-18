package accountCreation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.*;
import bankDAO.SavingsDAO;
import customerUI.CurrentAccount;
import customerUI.SavingsAccount;
import bankDAO.CurrentDAO;

public class createAccount extends WindowAdapter implements ActionListener{

	JFrame f;
	JTextField t1,t2;
	JButton b1;
	JCheckBox cb1,cb2;
	JLabel l1,l2,l3;
<<<<<<< Updated upstream
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
	int accno;
	
	static Random rand = new Random();
	
	
	public createAccount()
<<<<<<< Updated upstream
=======
	SavingsDAO sd;
	CurrentDAO cd;
	int accno;
	
	static Random rand = new Random();
	SavingsAccount sa;
	CurrentAccount ca;
	
	public createAccount() throws Exception
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
>>>>>>> Stashed changes
	{
		f = new JFrame("Account Creation");
		t1 = new JTextField();
		t2 = new JTextField();
		
		cb1 = new JCheckBox("Savings");
		cb2 = new JCheckBox("Current");
		
		b1 = new JButton("Create");
		
<<<<<<< Updated upstream
<<<<<<< HEAD
=======
		sd = new SavingsDAO();
		cd = new CurrentDAO();
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
>>>>>>> Stashed changes
		
		l1 = new JLabel("Enter your Name: ");
		l2 = new JLabel("Your Account Number: ");
		l3 = new JLabel("Enter the amount for initial deposit: ");
		
<<<<<<< Updated upstream
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
		l1.setBounds(10, 20, 150, 30);
		l2.setBounds(10, 50, 200, 30);
		l3.setBounds(10, 80, 300, 30);
		
		t1.setBounds(210, 20, 150, 30);
		t2.setBounds(210, 80, 150, 30);
		
		b1.setBounds(250, 200, 80, 30);
		
		cb1.setBounds(210, 120, 100, 30);
		cb2.setBounds(240, 150, 100, 30);
<<<<<<< Updated upstream
=======
		l1.setBounds(10, 20, 80, 30);
		l2.setBounds(10, 50, 80, 30);
		
		t1.setBounds(200, 20, 50, 30);
		t2.setBounds(200, 50, 50, 30);
		
		b1.setBounds(210, 80, 80, 30);
		
		cb1.setBounds(210, 70, 100, 30);
		cb2.setBounds(270, 70, 100, 30);
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
>>>>>>> Stashed changes
		
		
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
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		
<<<<<<< Updated upstream
<<<<<<< HEAD
		f.setSize(700,300);
=======
		f.setSize(400,300);
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
		f.setSize(700,300);
>>>>>>> Stashed changes
		f.setVisible(true);
		f.setLayout(null);
		f.addWindowListener(this);
	}
	
	public void createSavingsAccount(int accno,String name,float amount) throws Exception
	{
<<<<<<< Updated upstream
<<<<<<< HEAD
		SavingsDAO sd;
		SavingsAccount sa;
		sd = new SavingsDAO();
=======
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
		SavingsDAO sd;
		SavingsAccount sa;
		sd = new SavingsDAO();
>>>>>>> Stashed changes
		sa = new SavingsAccount();
		accno=rand.nextInt(999999999);
		sd.insertSavingsTb(accno, name, amount);
		sa.setSavingsnameDetails(name, accno, amount);
		
	}
	public void createCurrentAccount(int accno,String name,float amount) throws Exception
	{
<<<<<<< Updated upstream
<<<<<<< HEAD
		CurrentDAO cd;
		CurrentAccount ca;
		cd = new CurrentDAO();
=======
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
		CurrentDAO cd;
		CurrentAccount ca;
		cd = new CurrentDAO();
>>>>>>> Stashed changes
		ca = new CurrentAccount();
		accno=rand.nextInt(999999999);
		cd.insertCurrentTb(accno, t1.getText(), Float.parseFloat(t2.getText()));
		ca.setCurrentnameDetails(name, accno, amount);
	}
	
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
<<<<<<< HEAD
		if(e.getSource()==cb1 && e.getSource()==b1)
=======
		/*if(e.getActionCommand()==cb1.getName() && e.getSource()==b1)
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
		if(e.getSource()==cb1 && e.getSource()==b1)
>>>>>>> Stashed changes
		{
			try
			{
				new createAccount().createSavingsAccount(accno, t1.getText(), Float.parseFloat(t2.getText()));
			}
			catch(Exception ae) {}
		}
<<<<<<< Updated upstream
<<<<<<< HEAD
		else if(e.getSource()==cb2 && e.getSource()==b1)
=======
		else if(e.getSource()==cb2&& e.getSource()==b1)
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
		else if(e.getSource()==cb2 && e.getSource()==b1)
>>>>>>> Stashed changes
		{
			try
			{
				new createAccount().createCurrentAccount(accno, t1.getText(), Float.parseFloat(t2.getText()));
			}
			catch(Exception ae) {}
<<<<<<< Updated upstream
<<<<<<< HEAD
		}
=======
		}*/
>>>>>>> edfb8e7e0c8b61b60852ec0486be8ad1a84bdb91
=======
		}
>>>>>>> Stashed changes
	}
}
