package controllers;
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
		
		timer.setTimer(10000);
		
		service.test();
		
		// pushes the user object data to the next page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		// returns the next page
		return "Response.xhtml";
	}
	
	public OrdersBusinessInterface getService() {		
		return service;
	}
	
}
