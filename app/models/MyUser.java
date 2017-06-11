package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name="MyUser")
public class MyUser extends Model{
	
	@Column
	public String name;
	@Column
	public String surname;
	@Column
	public String username;
	
	@Column
	public String password;
	
	@Column
	public String email;
	
	@Column
	public boolean isAdmin;
	
	@Column
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
