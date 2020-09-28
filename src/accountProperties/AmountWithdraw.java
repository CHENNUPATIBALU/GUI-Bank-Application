package accountProperties;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import bankDAO.*;

public class AmountWithdraw extends WindowAdapter implements ActionListener{

	JFrame f;
	static JTextField t1;
	JLabel withdraw_label,l;
	JButton withdraw_button;
	float amount;
	long accno;
	static CurrentDAO cd;
	SavingsDAO sd;
	
	
	public AmountWithdraw()
	{
		f = new JFrame("Withdraw");
		t1 = new JTextField();
		
		withdraw_label = new JLabel();
		l = new JLabel("Enter amount to Withdraw: ");
		withdraw_button = new JButton("Withdraw");
		
		f.add(l);
		f.add(t1);
		f.add(withdraw_label);
		f.add(withdraw_button);
		
		
		f.setLayout(new GridLayout());
		f.setSize(300,200);
		f.setVisible(true);
		f.addWindowListener(this);
	}
	
	public void windowClosing(WindowEvent e)
	{
		f.setVisible(false);
	}

	public void currentWithDrawAmount(long accno) throws Exception
	{
		cd = new CurrentDAO();
		this.accno = accno;
		float a = Float.parseFloat(t1.getText());
		cd.currentWithdraw(accno, a);
	}
	
	public void savingsWithDraw(long accno) throws Exception
	{
		sd = new SavingsDAO();
		this.accno = accno;
		float a = Float.parseFloat(t1.getText());
		sd.savingsWithdraw(accno, a);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==withdraw_button)
		{
			try {
				currentWithDrawAmount(accno);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
