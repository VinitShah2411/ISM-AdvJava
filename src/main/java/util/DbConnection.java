package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConnection 
{
	static String driver = "org.postgresql.Driver";
	static String url = "jdbc:postgresql://localhost:5432/ism2022";
	static String userName = "postgres";
	static String password = "admin";
	
	public static Connection getConnection()
	{
		
		
			try 
			{
				//driver load
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url,userName,password);
				if(con!=null)
				{
					System.out.println("Db Connected");
				}
				return con;
			}
				
			 catch (ClassNotFoundException e) {
				 e.printStackTrace();
			 }
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;	
	}
}	 
