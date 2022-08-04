package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.UserBean;
import util.DbConnection;

//steps to follow
//1) connect database as Connection con = DbConnection.getConnection();
//2) use preparedStatement pstmt = con.preparedStatement("query") for fetching query
//3) set datatypes using 


public class UserDao 
{
	public void insertUser(UserBean userBean) 
	{
		try 
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into users(firstname,lastname,email,password,gender) values (?,?,?,?,?)");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			
			int records = pstmt.executeUpdate();
			System.out.println(records + "Data Inserted");
		} catch(Exception e) 
		  {
			System.out.println("SWR in insertUser()");
			e.printStackTrace();
		  }
		}
	
	public ArrayList<UserBean> getAllUsers()
	{
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			
			ResultSet rs = pstmt.executeQuery();  //select randomly ==>query data store 
			
			while (rs.next() == true)  // 1st row 2nd row
			{
				int userId = rs.getInt("userid");   // db column name
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String userType = rs.getString("usertype");
				
				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);
				user.setUserType(userType);
				users.add(user);
			}
		// go to line num -> 63

					// user1
					// user2
		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
		}
			return users; 
		}

	public UserBean login(String email, String password) {
		
		UserBean user = null;
		try 
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email= ? and password=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			//read select
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setUserType(rs.getString("usertype"));
			}
		} catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}
		return user;
	}

	public boolean deleteUser(int userId)
	{
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from users where userid=?");	
				){
			pstmt.setInt(1, userId);
			
			int deleteRow = pstmt.executeUpdate();
			if(deleteRow==1)
			{
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public UserBean getUserByUserID(int userId)
	{
		UserBean user = null;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users where userid=?");	
					){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					user = new UserBean();
					user.setFirstName(rs.getString("firstName"));	
					user.setLastName(rs.getString("lastName"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));	
					user.setGender(rs.getString("gender"));
					user.setUserId(userId);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean updateUser(UserBean user) {
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update users set firstname=? , lastname=? ,password=? , gender=? where userid=?");)
		{
			pstmt.setString(1,user.getFirstName());
			pstmt.setString(2,user.getLastName());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getGender());
			pstmt.setInt(5,user.getUserId());
			
			int updateCount = pstmt.executeUpdate();
			if(updateCount==1)
			{
				flag=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return flag;
	}

}
			
