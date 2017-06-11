package models;

import javax.persistence.*;
import play.data.validation.Required;
import play.db.jpa.*;

@Entity
@Table(name="MyUser")
public class MyUser extends Model{
	
	public String name;
	public String surname;
	
	public String username;
	
	public String password;
	
	public String email;
	
	public boolean isAdmin;
	
	public String registrationNumber;

	public MyUser(String name, String surname, String username, String password, String email, boolean isAdmin,
			String registrationNumber) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
		this.registrationNumber = registrationNumber;
	}

}
