package beans;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.ArrayList;

@ManagedBean
@ViewScoped
public class Orders {

	List<Order> orders = new ArrayList<Order>();

	/**
	 * Default Constructor w/ "dummy" data
	 */
	public Orders() {
		
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
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
