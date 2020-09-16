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
	CurrentAccount c = new CurrentAccount();
	
	Random rand = new Random();
	
	public CurrentDAO() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "baluvinay123");
	}
	public void insertCurrentTb(int ano,String name,float amount) throws Exception
	{
		pst = con.prepareStatement("insert into current values(?,?,?)");
		pst.setInt(1,ano);
		pst.setString(2, name);
		pst.setFloat(3, amount);
		pst.executeUpdate();
	}
	public void displayCurrentTb() throws Exception
	{
		st = con.createStatement();
		ResultSet rst = st.executeQuery("select * from current");
		System.out.println("** CURRENT ACCOUNTS **");
		System.out.println("_____________________________");
		System.out.println("Account No | Name | Amount |");
		System.out.println("_____________________________");
		while(rst.next())
		{
			System.out.println(rst.getInt(1)+"  |  "+rst.getString(2)+"  |  "+rst.getFloat(3));
		}
		System.out.println("_____________________________");
		System.out.println();
	}
	public void currentBalanceEnquiry(int ano) throws Exception
	{
		ResultSet rst = pst.executeQuery("select balance from current where accno = "+ano);
		while(rst.next())
			c.setCurrentAmount(rst.getFloat(1));
	}
	public void currentWithdraw(int ano,float money) throws Exception
	{
		pst = con.prepareStatement("update current set balance=balance-? where accno = ?");
		pst.setFloat(1, money);
		pst.setInt(2, ano);
		pst.executeUpdate();
		ResultSet rst = pst.executeQuery("select balance from savings where accno = "+ano);
		while(rst.next())
			c.setCurrentAmount(rst.getFloat(1));
	}
	public void currentDeposit(int ano,float money) throws Exception
	{
		pst = con.prepareStatement("update current set balance=balance+? where accno = ?");
		pst.setFloat(1, money);
		pst.setInt(2, ano);
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
