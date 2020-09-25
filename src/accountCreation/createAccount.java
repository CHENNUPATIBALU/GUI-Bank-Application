package accountCreation;

import java.awt.GridLayout;
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
import bankGUI.AccountSelection;

public class createAccount extends WindowAdapter implements ActionListener{

	JFrame f;
	JTextField t1,t2,t3,t4;
	JButton b1;
	JRadioButton rb1,rb2;
	JLabel l1,l2,l3,l4,l5,l6;
	int accno;
	int choice;
	CurrentDAO cd;
	AccountSelection a;
	
	static Random rand = new Random();
	
	
	public createAccount()
	{
		f = new JFrame("Account Creation");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		
		rb1 = new JRadioButton("Savings");
		rb2 = new JRadioButton("Current");
		
		accno=rand.nextInt(999999999);
		
		b1 = new JButton("Create");
		
		
		l1 = new JLabel("Enter your Name: ");
		l2 = new JLabel("Your Account Number: ");
		l3 = new JLabel("Enter the amount for initial deposit: ");
		l4 = new JLabel();
		l5 = new JLabel("User Name: ");
		l6 = new JLabel("Password: ");
		
		l1.setBounds(100, 20, 300, 30);
		l2.setBounds(80, 50, 300, 30);
		l4.setBounds(220, 50, 200, 30);
		l3.setBounds(10, 80, 300, 30);
		l5.setBounds(140, 110, 500, 30);
		l6.setBounds(140, 140, 500, 30);
		
		
		t1.setBounds(210, 20, 150, 30);
		t2.setBounds(210, 80, 150, 30);
		t3.setBounds(210, 110, 150, 30);
		t4.setBounds(210, 140, 150, 30);
		
		b1.setBounds(250, 300, 80, 30);
		
		rb1.setBounds(210, 180, 100, 30);
		rb2.setBounds(220, 130, 100, 30);
		
		
		f.add(l1);
		f.add(t1);
		
		f.add(l2);
		f.add(l4);
		
		f.add(l3);
		f.add(t2);

		f.add(l5);
		f.add(t3);		
		
		f.add(l6);
		f.add(t4);
		
		f.add(rb1);
		f.add(rb2);
		
		f.add(b1);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		b1.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		
		f.setSize(500,400);
		f.setVisible(true);
		f.setLayout(new GridLayout(12,2));
		f.revalidate();
		f.addWindowListener(this);
	}
	
	public void createSavingsAccount(long acno,String name,float amount,String uName,String pass) throws Exception
	{
		SavingsDAO sd;
		SavingsAccount sa;
		sd = new SavingsDAO();
		sa = new SavingsAccount();
		acno = this.accno;
		sd.insertSavingsTb(accno, name, amount,uName,pass);
		sa.setSavingsnameDetails(name, accno, amount);
		System.out.println("Savings Account Created Successfully");
	}
	public void createCurrentAccount(long acno,String name,float amount,String uName,String pass) throws Exception
	{
		CurrentDAO cd;
		CurrentAccount ca;
		cd = new CurrentDAO();
		ca = new CurrentAccount();
		acno = this.accno;
		cd.insertCurrentTb(accno, name, amount,uName,pass);
		ca.setCurrentnameDetails(name, accno, amount);
		System.out.println("Current Account Created Successfully");
	}
	
	public void windowClosing(WindowEvent e)
	{
		a = new AccountSelection();
		f.setVisible(false);
		a.FrameVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(rb1.isSelected() && e.getSource()==b1)
		{
			rb2.setSelected(false);
			try
			{
				try {
					new createAccount().createSavingsAccount(accno, t1.getText(), Float.parseFloat(t2.getText()),t3.getText(),t4.getText());
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
		else if(rb2.isSelected() && e.getSource()==b1)
		{
			rb1.setSelected(false);
			try
			{
				try {
					new createAccount().createCurrentAccount(accno, t1.getText(), Float.parseFloat(t2.getText()),t3.getText(),t4.getText());
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
