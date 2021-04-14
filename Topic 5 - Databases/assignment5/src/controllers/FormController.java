package controllers;
import java.sql.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

//FormController Class is a managed Java Bean
//this is the Controller of the MVC design
@ManagedBean
@ViewScoped
public class FormController {
	
	@Inject
	OrdersBusinessInterface service;
	@EJB
	MyTimerService timer = new MyTimerService();

	// onSubmit method
	// gets called when the Submit button on the TestForm page is clicked
	public String onSubmit(User user) {

		// pushes the user object data to the next page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		service.test();
		
		timer.setTimer(10000);
		
		getAllOrders();
		
		insertOrder();
		
		getAllOrders();
		
		
		
		// returns the next page
		return "Response.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return service;
	}
	
	private void getAllOrders() {
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		String dbq = "SELECT * FROM testapp.Orders";
		
		// Database Connection
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
			System.out.println("CONNECTION SUCCESS on getAllOrders!!");
			statement = conn.createStatement();
			rs = statement.executeQuery(dbq);
			
			while(rs.next()) {
				System.out.println("Order ID = " + rs.getInt("order_no") + ", Product = " + rs.getString("product_name") + ", Price = " + rs.getFloat("price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CONNECTION FAILURE!!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void insertOrder() {
		
		Connection conn = null;
		Statement statement = null;
		String dbi = "INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('001122334455', 'This was inserted new', 25.00, 100)";
		
		// Database Connection
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
			System.out.println("CONNECTION SUCCESS on insertOrder!!");
			statement = conn.createStatement();
			statement.executeUpdate(dbi);			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CONNECTION FAILURE!!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
