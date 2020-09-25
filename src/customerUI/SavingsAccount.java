package customerUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class SavingsAccount extends WindowAdapter implements ActionListener {

	JFrame f;
	JTextField t1;
	JLabel lname,laccno,lbalance;
	JButton withdraw_button,deposit_button,balance_enquiry_button;
	long saccno;
	String sname;
	float sbalance;
	
	
	
	public SavingsAccount(long saccno,String sname,float sbalance)
	{
		this.sname = sname;
		this.saccno = saccno;
		this.sbalance = sbalance;
		
		f = new JFrame("Savings Account");
		t1 = new JTextField();
		lname = new JLabel();
		laccno = new JLabel();
		lbalance = new JLabel();
		
		lname.setBounds(10, 10, 200, 100);
		laccno.setBounds(10, 30, 200, 100);
		lbalance.setBounds(10, 50, 200, 100);
		
		withdraw_button = new JButton("WithDraw");
		deposit_button = new JButton("Deposit");
		balance_enquiry_button = new JButton("Balance Enquiry");
		
		withdraw_button.setBounds(330, 10, 190,30);
		deposit_button.setBounds(330, 50, 190,30);
		balance_enquiry_button.setBounds(330, 90, 190,30);
		
		
		f.add(t1);
		f.add(lname);
		f.add(laccno);
		f.add(lbalance);
		f.add(withdraw_button);
		f.add(balance_enquiry_button);
		f.add(deposit_button);
		
		
		f.setLayout(null);
		f.setSize(550, 300);
		f.setVisible(true);
		f.addWindowListener(this);
	}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public void setSavingsnameDetails(String name,long accno,float amount)
	{
		name = this.sname;
		accno = this.saccno;
		amount = this.sbalance;
		
		lname.setText("Account Holder Name: "+name);
		laccno.setText("Account Number: "+accno);
		lbalance.setText("Balance: "+amount);
	}
	public void setSavingsAmount(float amount)
	{
		lbalance.setText("Balance: "+amount);
	}
	
}
