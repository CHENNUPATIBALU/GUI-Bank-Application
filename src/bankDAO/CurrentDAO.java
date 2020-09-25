package bankDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import customerUI.CurrentAccount;

public class CurrentDAO {
	PreparedStatement pst;
	Connection con;
	Statement st;
	CurrentAccount c = new CurrentAccount(0, null, 0);
	
	Random rand = new Random();
	
	public CurrentDAO() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "baluvinay123");
	}
	public void insertCurrentTb(long ano,String name,float amount,String uname,String pass) throws Exception
	{
		pst = con.prepareStatement("insert into current values(?,?,?,?,?)");
		pst.setLong(1,ano);
		pst.setString(2, name);
		pst.setFloat(3, amount);
		pst.setString(3, uname);
		pst.setString(4, pass);
		pst.executeUpdate();
	}
	public void displayCurrentTb() throws Exception
	{
		st = con.createStatement();
		ResultSet rst = st.executeQuery("select * from current");
		System.out.println("** CURRENT ACCOUNTS **");
		System.out.println("_____________________________________");
		System.out.println("Account No | Name | Amount | UserName | Password |");
		System.out.println("_____________________________________");
		while(rst.next())
		{
			System.out.println(rst.getInt(1)+"  |  "+rst.getString(2)+"  |  "+rst.getFloat(3)+"  |  "+rst.getString(4)+"  |  "+rst.getString(5));
		}
		System.out.println("_____________________________________");
		System.out.println();
	}
	public void currentBalanceEnquiry(long ano) throws Exception
	{
		ResultSet rst = pst.executeQuery("select balance from current where accno = "+ano);
		while(rst.next())
			c.setCurrentAmount(rst.getFloat(1));
	}
	public void currentWithdraw(long ano,float money) throws Exception
	{
		pst = con.prepareStatement("update current set balance=balance-? where accno = ?");
		pst.setFloat(1, money);
		pst.setLong(2, ano);
		pst.executeUpdate();
		ResultSet rst = pst.executeQuery("select balance from savings where accno = "+ano);
		while(rst.next())
			c.setCurrentAmount(rst.getFloat(1));
	}
	public void currentDeposit(long ano,float money) throws Exception
	{
		pst = con.prepareStatement("update current set balance=balance+? where accno = ?");
		pst.setFloat(1, money);
		pst.setLong(2, ano);
		pst.executeUpdate();
		ResultSet rst = pst.executeQuery("select balance from savings where accno = "+ano);
		while(rst.next())
			c.setCurrentAmount(rst.getFloat(1));
	}
	public void displayCurrentAccount(int ano) throws Exception
	{
		ResultSet rst = pst.executeQuery("select * from current where accno = "+ano);
		while(rst.next())
			c.setCurrentnameDetails(rst.getString(2), rst.getInt(1), rst.getFloat(3));
	}
}
