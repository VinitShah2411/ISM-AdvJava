package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CartBean;
import bean.CartProductBean;
import util.DbConnection;

public class CartDao {
	
	public void AddToCart(CartBean cart)
	{
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into carts (userid,productid) values (?,?)");
			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getProductId());
			pstmt.executeUpdate(); // insert update delete
			
		} catch (Exception e) {
			System.out.println("SWR in CartDao::AddToCart()");
			e.printStackTrace();
		}
	}
	
	public ArrayList<CartProductBean> getCartItems(int userId) {
		ArrayList<CartProductBean> carts = new ArrayList<CartProductBean>();

		try {
			Connection con = DbConnection.getConnection(); // db connection
			PreparedStatement pstmt = con.prepareStatement(
					"select p.productname , p.price , c.cartid , p.productid , c.userid  from products p,carts c where c.userid = ? and c.productid = p.productid ");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();// select
			while (rs.next()) {
				CartProductBean cart = new CartProductBean();
				cart.setCartId(rs.getInt("cartid"));
				cart.setProductId(rs.getInt("productid"));
				cart.setUserId(rs.getInt("userid"));
				cart.setProductname(rs.getString("productname"));
				cart.setPrice(rs.getInt("price"));
				carts.add(cart);
			}

		} catch (Exception e) {
			System.out.println("SMW CartDao::getCartItems()");
			e.printStackTrace();
		}

		return carts;
	}

	public boolean deletecartitem(int cartId) {
		Boolean flag=false;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from carts where cartid=?");	
					){
				pstmt.setInt(1, cartId);
				int deleteRow = pstmt.executeUpdate();
				if(deleteRow==1)
				{
					flag=true;
				}
			}catch(Exception e) {
				System.out.println("SWR in cartDao::deletecart()");
				e.printStackTrace();
			}
		
		return flag;
	}
	
	public void emptyCart(int userId) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from carts where userid = ? ");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW CartDao::emptyCart()");
			e.printStackTrace();
		}
	}
}	
