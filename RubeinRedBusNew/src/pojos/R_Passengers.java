package pojos;

import java.sql.Time;
import java.util.Date;

public class R_Passengers {

	private int passengerId;
	private R_BusDetails busDetails;
	private R_Seat seat;
	private Time departure;
	private Date doj;
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public R_BusDetails getBusDetails() {
		return busDetails;
	}
	public void setBusDetails(R_BusDetails busDetails) {
		this.busDetails = busDetails;
	}
	public Time getDeparture() {
		return departure;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public R_Seat getSeat() {
		return seat;
	}
	public void setSeat(R_Seat seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "R_Passengers [passengerId=" + passengerId + ", busDetails="
				+ busDetails + ", seat=" + seat + ", departure=" + departure
				+ ", doj=" + doj + "]";
	}
	
}
