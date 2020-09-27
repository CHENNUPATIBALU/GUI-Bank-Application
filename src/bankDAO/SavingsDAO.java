package bankDAO;
import java.sql.*;
import customerUI.*;
import java.util.Random;

public class SavingsDAO {

	PreparedStatement pst;
	Connection con;
	Statement st;
	Random rand = new Random();
	SavingsAccount s = new SavingsAccount(null, 0, 0);
	
	public SavingsDAO() throws Exception
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "baluvinay123");
	}
	
	public void insertSavingsTb(long ano,String name,float amount,String uname,String pass) throws Exception
	{
		pst = con.prepareStatement("insert into savings values(?,?,?,?,?)");
		pst.setLong(1,ano);
		pst.setString(2, name);
		pst.setFloat(3, amount);
		pst.setString(4, uname);
		pst.setString(5, pass);
		pst.executeUpdate();
	}
	public void displaySavingsTb() throws Exception
	{
		st = con.createStatement();
		ResultSet rst = st.executeQuery("select * from savings");
		System.out.println("** SAVINGS ACCOUNTS **");
		System.out.println("_____________________________________");
		System.out.println("Account No | Name | Amount | UserName | Password |");
		System.out.println("_____________________________________");
		while(rst.next())
		{
			System.out.println(rst.getInt(1)+"  |  "+rst.getString(2)+"  |  "+rst.getFloat(3)+"  |  "+rst.getString(3)+"  |  "+rst.getString(4));
		}
		System.out.println("_____________________________________");
		System.out.println();
	}
	public void savingsBalanceEnquiry(long ano) throws Exception
	{
		ResultSet rst = pst.executeQuery("select balance from savings where accno = "+ano);
		while(rst.next())
			s.setSavingsAmount(rst.getFloat(1));
	}
	public void savingsWithdraw(long ano,float money) throws Exception
	{
		pst = con.prepareStatement("update savings set balance=balance-? where accno = ?");
		pst.setFloat(1, money);
		pst.setLong(2, ano);
		pst.executeUpdate();
		ResultSet rst = pst.executeQuery("select balance from savings where accno = "+ano);
		while(rst.next())
			s.setSavingsAmount(rst.getFloat(1));
	}
	public void savingsDeposit(int ano,float money) throws Exception
	{
		pst = con.prepareStatement("update savings set balance=balance+? where accno = ?");
		pst.setFloat(1, money);
		pst.setInt(2, ano);
		pst.executeUpdate();
		ResultSet rst = pst.executeQuery("select balance from savings where accno = "+ano);
		while(rst.next())
			s.setSavingsAmount(rst.getFloat(1));
	}
	public void displaySavingsAccount(long ano) throws Exception
	{
		ResultSet rst = pst.executeQuery("select * from savings where accno = "+ano);
		while(rst.next())
			s.setSavingsnameDetails(rst.getString(2), rst.getInt(1), rst.getFloat(3));
	}
	
}
