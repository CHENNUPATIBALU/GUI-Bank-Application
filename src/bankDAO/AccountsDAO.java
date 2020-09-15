package bankDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AccountsDAO {
	
	PreparedStatement pst;
	Connection con;
	Statement st;
	
	SavingsDAO s = new SavingsDAO();
	CurrentDAO c = new CurrentDAO();
	
	public AccountsDAO() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "baluvinay123");
	}
	
	public void displayAllAccounts() throws Exception
	{
		s.displaySavingsTb();
		c.displayCurrentTb();
	}
}
