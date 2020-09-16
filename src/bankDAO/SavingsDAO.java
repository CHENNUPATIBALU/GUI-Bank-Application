package bankDAO;
import java.sql.*;
import customerUI.*;
import java.util.Random;

public class SavingsDAO {

	PreparedStatement pst;
	Connection con;
	Statement st;
	Random rand = new Random();
	SavingsAccount s = new SavingsAccount();
	
	public SavingsDAO() throws Exception
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "baluvinay123");
	}
	
	public void insertSavingsTb(int ano,String name,float amount) throws Exception
	{
		pst = con.prepareStatement("insert into savings values(?,?,?)");
		pst.setInt(1,ano);
		pst.setString(2, name);
		pst.setFloat(3, amount);
		pst.executeUpdate();
	}
	public void displaySavingsTb() throws Exception
	{
		st = con.createStatement();
		ResultSet rst = st.executeQuery("select * from savings");
		System.out.println("** SAVINGS ACCOUNTS **");
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
	public void savingsBalanceEnquiry(int ano) throws Exception
	{
		ResultSet rst = pst.executeQuery("select balance from savings where accno = "+ano);
		while(rst.next())
			s.setSavingsAmount(rst.getFloat(1));
	}
	public void savingsWithdraw(int ano,float money) throws Exception
	{
		pst = con.prepareStatement("update savings set balance=balance-? where accno = ?");
		pst.setFloat(1, money);
		pst.setInt(2, ano);
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
	public void displaySavingsAccount(int ano) throws Exception
	{
		ResultSet rst = pst.executeQuery("select * from savings where accno = "+ano);
		while(rst.next())
			s.setSavingsnameDetails(rst.getString(2), rst.getInt(1), rst.getFloat(3));
	}
	
}
