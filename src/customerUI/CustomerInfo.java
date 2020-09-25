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
	}
	
	public boolean checkSavingsInfo(String uName,String pass) throws Exception
	{
		ResultSet rst = st.executeQuery("select * from savings");
		int sav = 0;
		while(rst.next())
		{
			if(rst.getString(3).equals(uName) && rst.getString(4).equals(pass))
			{
				sav = 1;
				break;
			}
			sav = 0;
		}
		if(sav==0)
		{
			return true;
		}
		return false;
	}
	public boolean checkCurrentInfo(String uName, String pass) throws Exception
	{
		ResultSet rst = st.executeQuery("select * from current");
		while(rst.next())
		{
			if(rst.getString(3).equals(uName) && rst.getString(4).equals(pass))
			{
				return true;
			}
		}
		return false;
	}
}
