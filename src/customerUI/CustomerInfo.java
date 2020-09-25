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
	
	public boolean checkSavingsInfo(long acc,String name) throws Exception
	{
		ResultSet rst = st.executeQuery("select * from savings");
		while(rst.next())
		{
			if(rst.getLong(1)==acc && rst.getString(2).equals(name))
			{
				return true;
			}
		}
		return false;
	}
	public boolean checkCurrentInfo(long acc,String name) throws Exception
	{
		ResultSet rst = st.executeQuery("select * from current");
		while(rst.next())
		{
			if((rst.getLong(1)==acc) && rst.getString(2).equals(name))
			{
				return true;
			}
		}
		return false;
	}
}
