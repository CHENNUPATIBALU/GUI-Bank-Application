package customerUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CurrentAccount extends WindowAdapter implements ActionListener {

	JFrame f;
	JTextField t1;
	JLabel lname,laccno,lbalance;
	JButton withdraw_button,deposit_button,balance_enquiry_button;
	
	
	
	public CurrentAccount()
	{
		f = new JFrame("Current Account");
		t1 = new JTextField();
		lname = new JLabel();
		
		lname.setBounds(10, 10, 200, 100);
		
		f.add(t1);
		f.add(lname);
		f.add(withdraw_button);
		f.add(balance_enquiry_button);
		f.add(deposit_button);
		
		f.setLayout(null);
		f.setSize(550, 300);
		f.setVisible(true);
		f.setBackground(Color.WHITE);
		f.addWindowListener(this);
	}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public void setCurrentnameDetails(String name,long accno,float amount)
	{
		lname.setText(name);
		laccno.setText(String.valueOf(accno).toString());
		lbalance.setText(String.valueOf(amount).toString());
	}
	public void setCurrentAmount(float amount)
	{
		lbalance.setText(String.valueOf(amount).toString());
	}
}
