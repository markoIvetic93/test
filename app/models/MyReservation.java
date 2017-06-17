package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="MyReservation")
public class MyReservation extends Model{

	@Column
	public Date timeFrom;
	@Column
	public Date timeTo;
	@Column
	public String resUser;
	@Column
	public String parking;

	public MyReservation(Date timeFrom, Date timeTo, String resUser, String parking) {
		super();
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.resUser = resUser;
		this.parking = parking;
	}
	
	
	


}