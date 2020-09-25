package customerUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import bankGUI.AccountSelection;

public class CurrentAccount extends WindowAdapter implements ActionListener {

	JFrame f;
	JTextField t1;
	JLabel lname,laccno,lbalance;
	JButton withdraw_button,deposit_button,balance_enquiry_button;
	AccountSelection a;
	

	public CurrentAccount()
	{
		f = new JFrame("Current Account");
		t1 = new JTextField();
		lname = new JLabel();
		laccno = new JLabel();
		lbalance = new JLabel();
		
		lname.setBounds(10, 10, 200, 100);
		laccno.setBounds(10, 30, 200, 100);
		lbalance.setBounds(10, 50, 200, 100);
		
		t1.addActionListener(this);
		
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
		f.addWindowListener(this);
	}
	public void windowClosing(WindowEvent e)
	{
		a = new AccountSelection();
		f.setVisible(false);
		a.FrameVisible(true);
	}
	
	public void show()
	{
		
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public void setCurrentnameDetails(String name,long accno,float amount)
	{
		lname.setText("Account Holder Name: "+name);
		laccno.setText("Account Number: "+accno);
		lbalance.setText("Balance: "+amount);
	}
	public void setCurrentAmount(float amount)
	{
		lbalance.setText("Balance: "+amount);
	}
}
