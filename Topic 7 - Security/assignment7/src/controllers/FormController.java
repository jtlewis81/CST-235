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
	
	// onDelete method
	public String onDelete(Order o) {
		
		service.deleteOrder(o.getOrderNumber());
		
		return "TestResponse.xhtml";
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
		return "LoginForm.xhtml";
	}
	
	public String onDashboard(User user) {
		FacesContext.getCurrentInstance().getAttributes().get(user);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	public String onLogOff() {
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "TestResponse.xhtml?faces-redirect=true";
	}
	
}
