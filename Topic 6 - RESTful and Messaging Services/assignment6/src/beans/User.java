package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.*;

@ManagedBean
@SessionScoped
//User Class is a managed Java Bean
//this is the data Model of the MVC design
public class User implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	// a user has a first and last name
	@NotNull()
	@Size(min=5, max=15) 
	private String firstName;
	@NotNull()
	@Size(min=5, max=15)
	private String lastName;
	
	// default constructor
	public User() {

	}
	
	public User(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	
	// firstName getter
	public String getFirstName() {
		return firstName;
	}

	// firstName setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// lastName getter
	public String getLastName() {
		return lastName;
	}

	// lastName setter
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
