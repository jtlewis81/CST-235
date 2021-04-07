package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import beans.Order;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
	
	private List<Order> orders = new ArrayList<Order>();

    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
    	
    	// generic order data
    	orders.add(new Order("Order# 1", "Product 1", (float)1.00, 10));
    	orders.add(new Order("Order# 2", "Product 2", (float)2.00, 20));
    	orders.add(new Order("Order# 3", "Product 3", (float)3.00, 30));
    	orders.add(new Order("Order# 4", "Product 4", (float)4.00, 40));
    	orders.add(new Order("Order# 5", "Product 5", (float)5.00, 50));
    	orders.add(new Order("Order# 6", "Product 6", (float)6.00, 60));
    	orders.add(new Order("Order# 7", "Product 7", (float)7.00, 70));
    	orders.add(new Order("Order# 8", "Product 8", (float)8.00, 80));
    	orders.add(new Order("Order# 9", "Product 9", (float)9.00, 90));
    	orders.add(new Order("Order# 10", "Product 10", (float)10.00, 100));
    }
    
	/**
  * @see OrdersBusinessInterface#test()
  */
 public void test() {
 	System.out.println("Hello from the OrdersBusinessService");
 }


	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
