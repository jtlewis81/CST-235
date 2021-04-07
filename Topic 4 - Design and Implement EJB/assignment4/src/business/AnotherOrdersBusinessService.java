package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	
	private List<Order> orders = new ArrayList<Order>();

    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
    	
    	// generate randomized order data
    	for(int i = 1; i <= 16; i++) {
			String orderNum = ((Integer)(int)(Math.random() * 1000)).toString();
			String prodName = "This is product " + i;
			float price = (float) (i * (Math.random() * 10));
			float formattedPrice = (float) (Math.round(price * 100.0) / 100.0);
			int qty = (int) (i * (Math.random() * 10));
			orders.add(new Order(orderNum, prodName, formattedPrice, qty));
		}
    	
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("Hello from the AnotherOrdersBusinessService");
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
