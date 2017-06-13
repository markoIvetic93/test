package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name="Comment")
public class Comment extends Model{

	@Column
	public String parkingName;
	
	@Column
	public String username;
	
	@Column
	public String comment;

	public Comment(){
		super();
	}
	
	public Comment(String parkingName, String username, String comment) {
		super();
		this.parkingName = parkingName;
		this.username = username;
		this.comment = comment;
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
