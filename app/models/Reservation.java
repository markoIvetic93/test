package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Reservation")
public class Reservation extends Model{

	@Column
	public String timeFrom;
	@Column
	public String timeTo;
	@Column
	public String user;
	@Column
	public String parking;

	public Reservation(String timeFrom, String timeTo, String user, String parking) {
		super();
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.user = user;
		this.parking = parking;
	}
	
	
	


}