package beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.*;

@ManagedBean
@ViewScoped
//User Class is a managed Java Bean
//this is the data Model of the MVC design
public class User {
	
	// a user has a first and last name
	@NotNull()
	@Size(min=5, max=15) 
	private String firstName;
	@NotNull()
	@Size(min=5, max=15)
	private String lastName;
	
	// default constructor
	public User() {
		this.firstName = null;
		this.lastName = null;
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
