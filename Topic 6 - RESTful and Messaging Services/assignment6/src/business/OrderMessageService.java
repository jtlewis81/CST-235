package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import database.DataAccessInterface;

	

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {
	
	@Inject
	DataAccessInterface service;

    /**
     * Default constructor. 
     */
    public OrderMessageService() {
    	
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
		try {
			if(message instanceof TextMessage) {
				String text = ((TextMessage) message).getText();
				System.out.println(text);
			} else if (message instanceof ObjectMessage){
				Order o = (Order) ((ObjectMessage) message).getObject();
				System.out.println("TEST ORDER : OrderNumber = " + o.getOrderNumber() + ", ProductName = " + o.getProductName() + ", Price = " + o.getPrice() + ", Qty = " + o.getQty());
        		service.insertOrder(o);
			} else {				
	    		System.out.println("ERROR in OrderMessageService.onMessage : Your Message was not a TextMessage OR an OrderMessage!");
	    	}
		} catch (JMSException e) {
			e.printStackTrace();
		}        
    }

}
