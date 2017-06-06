package models;

import javax.persistence.*;
import play.data.validation.Required;
import play.db.jpa.*;

@Entity
@Table(name="user")
public class MyUser extends Model{
	
	@Column
	public String name;
	@Column
	public String surname;
	
	@Required
	@Column(nullable=false, unique=true)
	public String username;
	
	@Required
	@Column(nullable=false)
	public String password;
	
	@Column
	public String email;
	
	@Column
	public boolean isAdmin;
	
	@Column(unique=true)
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
