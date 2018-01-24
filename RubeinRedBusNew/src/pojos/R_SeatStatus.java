package pojos;

import java.sql.Time;
import java.util.Date;

public class R_SeatStatus {

	private int seatId;
	private R_Seat seat;
	private R_Booking bookingId;
	private Date doj;
	private Time timeSlot;
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public R_Seat getSeat() {
		return seat;
	}
	public void setSeat(R_Seat seat) {
		this.seat = seat;
	}
	public R_Booking getBookingId() {
		return bookingId;
	}
	public void setBookingId(R_Booking bookingId) {
		this.bookingId = bookingId;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Time getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(Time timeSlot) {
		this.timeSlot = timeSlot;
	}
	@Override
	public String toString() {
		return "R_SeatStatus [seatId=" + seatId + ", doj=" + doj
				+ ", timeSlot=" + timeSlot + "]";
	}
	
	
}
