package controllers;
//import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import beans.Order;
import beans.User;
//import business.MyTimerService;
import business.OrdersBusinessInterface;

//FormController Class is a managed Java Bean
//this is the Controller of the MVC design
@ManagedBean
@ViewScoped
public class FormController {
	
	@Inject
	OrdersBusinessInterface service;
//	@EJB
//	MyTimerService timer = new MyTimerService();

	public OrdersBusinessInterface getService() {
		return service;
	}

	// onSubmit method
	// gets called when the Submit button on the TestForm page is clicked
	public String onLogin(User user) {
		FacesContext.getCurrentInstance().getAttributes().get(user);
		// pushes the user object data to the next page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);

//		timer.setTimer(10000);
		
		// returns the next page
		return "Dashboard.xhtml";
	}
	
	// onDelete method
	public String onDelete(Order o) {
		
		service.deleteOrder(o.getOrderNumber());
		
		return "Dashboard.xhtml";
	}
	
//	public String onEdit(Order o) {
//		// pushes the user object data to the next page
//		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("o", o);
//		return "Edit_Order.xhtml";		
//	}
	
	public String onSendOrder(Order order) {		
		order = new Order("888", "TEST ORDER PRODUCT", (float) 8.88, 888); // TEST DATA
		service.sendOrder(order);
		return "OrderResponse.xhtml";
	}
	
	public String onHome() {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", null);
		return "Login.xhtml";
	}
	
	public String onDashboard(User user) {
		FacesContext.getCurrentInstance().getAttributes().get(user);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "Dashboard.xhtml";
	}
	
}
