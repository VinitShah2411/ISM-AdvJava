package dao;

import java.security.ProtectionDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ProductBean;
import util.DbConnection;

public class ProductDao {

	public void insertProduct(ProductBean productBean)
	{
		try
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt  = con.prepareStatement("insert into products(productname,qty,price,imgurl) values (?,?,?,?)");
			//pstmt.setInt(1, productBean.getProductid());
			pstmt.setString(1, productBean.getProductname());
			pstmt.setInt(2, productBean.getQty());
			pstmt.setInt(3, productBean.getPrice());
			pstmt.setString(4, productBean.getImgUrl());
			pstmt.executeUpdate();
		//	System.out.println(product + "Data Inserted");
		}catch(Exception e)
		{
			System.out.println("SWR in insertProduct()");
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProductBean> getAllProducts(){
		ArrayList<ProductBean> products = new ArrayList<>();
		try 
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from products");
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductBean product = new ProductBean();
				product.setProductid(rs.getInt("productid"));
				product.setProductname(rs.getString("productname"));
				product.setPrice(rs.getInt("price"));
				product.setQty(rs.getInt("qty"));
				product.setImgUrl(rs.getString("imgurl"));
				
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println("SWR in PorductDao::getAllProducts() ");
			e.printStackTrace();
		}
		
		return products;
	}
}
						
						 
			
