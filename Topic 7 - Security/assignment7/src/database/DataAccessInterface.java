package database;

import java.util.ArrayList;
import javax.ejb.Local;
import beans.Order;

@Local
public interface DataAccessInterface {

	public int insertOrder(Order o);
	public ArrayList<Order> getAllOrders();
	public int updateOrder(int id, Order o);
	public int deleteOrder(String orderNumber);
	
}
