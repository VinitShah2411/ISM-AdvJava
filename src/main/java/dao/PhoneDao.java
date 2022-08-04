package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.TelephoneBean;
import util.DbConnection;


public class PhoneDao {

	public void insertnumber(TelephoneBean telephoneBean) 
	{
		try 
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into telephone(firstname,lastname,number) values (?,?,?)");
			pstmt.setString(1, TelephoneBean.getFirstname());
			pstmt.setString(2, TelephoneBean.getLastname());
			pstmt.setString(3, TelephoneBean.getNumber());
			
			int records = pstmt.executeUpdate();
			System.out.println(records + "Data Inserted");
		} catch(Exception e) 
		  {
			System.out.println("SWR in insertUser()");
			e.printStackTrace();
		  }
}
}
