package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="MyReservation")
public class MyReservation extends Model{

	@Column
	public String timeFrom;
	@Column
	public String timeTo;
	@Column
	public String user;
	@Column
	public String parking;

	public MyReservation(String timeFrom, String timeTo, String user, String parking) {
		super();
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.user = user;
		this.parking = parking;
	}
	
	
	


}