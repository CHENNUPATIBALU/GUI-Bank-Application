package bankDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class CurrentDAO {
	PreparedStatement pst;
	Connection con;
	Statement st;
	
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
		System.out.println("Account number: "+ano);
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
		ResultSet rst = st.executeQuery("select amount from current where accno = ");
		pst.setInt(1, ano);
		System.out.println("Amount in your account is "+rst.getFloat(1));
	}
	public void currentWithdraw(int ano,float money) throws Exception
	{
		st.executeUpdate("update table current set amount=amount-money where accno = ?");
		pst.setInt(1, ano);
		System.out.println(money+" is debited from your account");
		ResultSet rst = st.executeQuery("select amount from savings where accno = ?");
		pst.setInt(1, ano);
		System.out.println("Remaining Balance is "+rst.getFloat(1));
	}
	public void currentDeposit(int ano,float money) throws Exception
	{
		st.executeUpdate("update table current set amount=amount+money where accno = ?");
		pst.setInt(1, ano);
		System.out.println(money+" is credited from your account");
		ResultSet rst = st.executeQuery("select amount from current where accno = ?");
		pst.setInt(1, ano);
		System.out.println("Total Balance in your account is "+rst.getFloat(1));
	}
	public void displayCurrentAccount(int ano) throws Exception
	{
		ResultSet rst = st.executeQuery("select * from current where accno = ?");
		pst.setInt(1, ano);
		while(rst.next())
		{
			System.out.println("Account Number: "+rst.getInt(1)+"\n"+"Account holder Name: "+rst.getString(2)+"\n"+"Amount: "+rst.getFloat(3));
		}
		
	}
}
