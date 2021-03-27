package beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class User {

	private String firstName, lastName;
	
	public User() {
		this.firstName = "Jamie";
		this.lastName = "Lewis";
	}
	
	public User(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
