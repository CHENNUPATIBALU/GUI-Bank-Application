package customerUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerInfo {

	PreparedStatement pst;
	Connection con;
	Statement st;
	
	public CustomerInfo() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "baluvinay123");
		st = con.createStatement();
	}
	
	public boolean checkSavingsInfo(String uName,String pass) throws Exception
	{
		ResultSet rst = st.executeQuery("select username,password from savings");
		while(rst.next())
		{
			if(rst.getString(1).equals(uName) && rst.getString(2).equals(pass))
			{
				return true;
			}
		}
		return false;
	}
	public boolean checkCurrentInfo(String uName, String pass) throws Exception
	{
		ResultSet rst = st.executeQuery("select username,password from current");
		while(rst.next())
		{
			if(rst.getString(1).equals(uName) && rst.getString(2).equals(pass))
			{
				return true;
			}
		}
		return false;
	}
}
