package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import beans.Order;


/**
 * 
 * DataAccess class 
 *
 * provides access to the database
 *
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
@Alternative
public class DataAccessService1 implements DataAccessInterface {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	String dbURL = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String pword = "admin";
	
	/**
	 * insertOrder Method
	 * 
	 * overrides Interface insertOrder Method
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public int insertOrder(Order o) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(dbURL, username, pword);
			stmt = conn.prepareStatement("INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)");
			stmt.setString(1, o.getOrderNumber());
			stmt.setString(2, o.getProductName());
			stmt.setFloat(3, o.getPrice());
			stmt.setInt(4, o.getQty());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FAILURE on insertOrder()!!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * getAllOrders Method
	 * 
	 * overrides Interface getAllOrders Method
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Order> getAllOrders() {
		
		ArrayList<Order> orders = new ArrayList<Order>();
		
		try {
			conn = DriverManager.getConnection(dbURL, username, pword);
			stmt = conn.prepareStatement("SELECT * FROM testapp.Orders");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				orders.add(new Order(rs.getString("order_no"), rs.getString("product_name"), rs.getFloat("price"), rs.getInt("quantity")));
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FAILURE on getAllOrders()!!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	/**
	 * updateOrder Method
	 * 
	 * overrides Interface updateOrder Method
	 * 
	 * @param id, o
	 * @return
	 */
	@Override
	public int updateOrder(int id, Order o) {
		int result = 0;
		
		System.out.println("\r\r>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Called DataAccess.updateOrder() IMPLEMENTATION NEEDED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\r");
		
		
		
		return result;
	}

	/**
	 * deleteOrder Method
	 * 
	 * overrides Interface deleteOrder Method
	 * 
	 * @param orderNumber
	 * @return
	 */
	@Override
	public int deleteOrder(String orderNumber) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(dbURL, username, pword);
			stmt = conn.prepareStatement("DELETE FROM testapp.Orders WHERE order_no = ?");
			stmt.setString(1, orderNumber);
			stmt.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FAILURE on deleteOrder()!!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
		
}
