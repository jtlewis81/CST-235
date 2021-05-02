package business;

import java.util.ArrayList;
import javax.ejb.Local;
import beans.Order;

@Local
public interface OrdersBusinessInterface {

	public int insertOrder(Order o);
	public ArrayList<Order> getAllOrders();
	public int updateOrder(int id, Order o);
	public int deleteOrder(String orderNumber);
	public void sendOrder(Order order);
	
} 
