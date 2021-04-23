package business;

import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import beans.Order;
import database.DataAccessInterface;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService1 implements OrdersBusinessInterface {

	@Inject
	DataAccessInterface db;
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

	
	@Override
	public int insertOrder(Order o) {
		return db.insertOrder(o);
	}

	@Override
	public ArrayList<Order> getAllOrders() {
		return db.getAllOrders();
	}

	@Override
	public int updateOrder(int id, Order o) {
		return db.updateOrder(id, o);
	}

	@Override
	public int deleteOrder(String orderNumber) {
		return db.deleteOrder(orderNumber);
	}

	@Override
	public void sendOrder(Order order) {

		// Send a Message for an Order
		try 
		{
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject(order);
			messageProducer.send(message2);
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}

		
	}
	
	

}
