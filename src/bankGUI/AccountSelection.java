package bankGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class AccountSelection extends WindowAdapter implements ActionListener{

	JFrame f;
	JButton bs,bc;
	
	public AccountSelection()
	{
		f = new JFrame("Choose");
		
		bs = new JButton("Savings Account");
		bc = new JButton("Current Account");
		
		bs.setBounds(130, 30, 200, 30);
		bc.setBounds(130, 70, 200, 30);
		
		bs.addActionListener(this);
		bc.addActionListener(this);
		
		f.add(bs);
		f.add(bc);
		
		f.setLayout(null);
		f.setSize(450, 300);
		f.setVisible(false);
		f.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bs)
		{
			f.setVisible(false);
			new SavingsAccountLogin();
		}		
		else if(e.getSource()==bc)
		{
			f.setVisible(false);
			new CurrentAccountLogin();
		}
		
	}
	public void FrameVisible(boolean frame)
	{
		f.setVisible(frame);
	}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
