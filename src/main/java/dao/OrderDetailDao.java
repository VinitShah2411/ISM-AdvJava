package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.OrderDetailBean;
import bean.OrderDetailProductBean;
import util.DbConnection;

public class OrderDetailDao {

	public void AddOrderDetail(OrderDetailBean orderDetailBean){
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into orderdetails (orderid,productid,price) values (?,?,?)");
			pstmt.setInt(1,orderDetailBean.getOrderId());
			pstmt.setInt(2, orderDetailBean.getProductId());
			pstmt.setInt(3,orderDetailBean.getPrice());
			pstmt.executeUpdate();
			System.out.println(pstmt);
			
			} catch (Exception e) {
			System.out.println("SWR in OrderDetailDao::OrderDetailDao");
			e.printStackTrace();
		}
	}

	public ArrayList<OrderDetailProductBean> getOrderDetails(int orderId)
	{
		ArrayList<OrderDetailProductBean> details = new ArrayList<>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select p.imgurl,p.productname,od.orderdetailid,od.orderid,od.price,p.productid from orderdetails od , products p where p.productid = od.productid and od.orderid = ? ");
			pstmt.setInt(1, orderId);
			ResultSet rs = pstmt.executeQuery();
			
			OrderDetailProductBean ODPB = new OrderDetailProductBean();
			ODPB.setImgurl(rs.getString("imgurl"));
			ODPB.setOrderDetailId(rs.getInt("orderdetailid"));
			ODPB.setOrderId(rs.getInt("orderId"));
			ODPB.setPrice(rs.getInt("price"));
			ODPB.setProductname(rs.getString("productname"));
			ODPB.setProductId(rs.getInt("productid"));
			System.out.println(ODPB);
			details.add(ODPB);
			
			} catch (Exception e) {
			System.out.println("SWR in OrderDetailDao::OrderDetailDao");
			e.printStackTrace();
		}
		return details;
	}
}


