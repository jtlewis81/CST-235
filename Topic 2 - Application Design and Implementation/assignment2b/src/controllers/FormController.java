package controllers;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import beans.User;

//FormController Class is a managed Java Bean
//this is the Controller of the MVC design
@ManagedBean
@ViewScoped
public class FormController {

	// onSubmit method
	// gets called when the Submit button on the TestForm page is clicked
	public String onSubmit(User user) {
		
		// pushes the user object data to the next page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		// returns the next page
		return "TestResponse.xhtml";
	}

	// onFlash method
	// gets called when the Flash button on the TestForm page is clicked
	public String onFlash(User user) {
		
		// pushes the user object data to the next page
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		
		// returns the next page
		return "TestResponse2.xhtml";
	}
}
