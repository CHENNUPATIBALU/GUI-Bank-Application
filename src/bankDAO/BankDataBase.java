package bankDAO;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BankDataBase {
	
	Connection con;
	PreparedStatement pst;
	Statement st;
	
	public BankDataBase() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "baluvinay123");
	}
	
	public void createDB() throws Exception
	{
		st = con.createStatement();
		DatabaseMetaData dmd = con.getMetaData();
		ResultSet r = dmd.getCatalogs();
		while(r.next())
		{
			if(r.getString(1).equalsIgnoreCase("bank"))
			{
				st.executeUpdate("drop database bank");
			}
		}
		st.executeUpdate("create database bank");
		System.out.println("Bank Database created");
		st.executeQuery("use bank");
		System.out.println("Using Bank Database");
	}
	
	public void createBankTB() throws Exception
	{
		st.executeUpdate("create table savings(accno int(15),name varchar(20),balance float(10),username varchar(20),password varchar(20))");
		st.executeUpdate("create table current(accno int(15),name varchar(20),balance float(10),username varchar(20),password varchar(20))");
		System.out.println("Savings and Current accounts tables created");
	}
	
	
	
	
	

}
