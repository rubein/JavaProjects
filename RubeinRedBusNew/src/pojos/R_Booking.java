package pojos;

import java.util.Date;

public class R_Booking {

	private int bookingId;
	private R_Customer customer;
	//private R_Passenger passenger;
	private R_BusDetails busDetails;
	private Date doj;
	private Date dob;
	private String customer_source;
	private String customer_destination;
	private int NOS;
	private String seatId;// csv
	private String status;
	private float totalFare;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public R_Customer getCustomer() {
		return customer;
	}
	public void setCustomer(R_Customer customer) {
		this.customer = customer;
	}
	public R_BusDetails getBusDetails() {
		return busDetails;
	}
	public void setBusDetails(R_BusDetails busDetails) {
		this.busDetails = busDetails;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCustomer_source() {
		return customer_source;
	}
	public void setCustomer_source(String customer_source) {
		this.customer_source = customer_source;
	}
	public String getCustomer_destination() {
		return customer_destination;
	}
	public void setCustomer_destination(String customer_destination) {
		this.customer_destination = customer_destination;
	}
	public int getNOS() {
		return NOS;
	}
	public void setNOS(int nOS) {
		NOS = nOS;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(float totalFare) {
		this.totalFare = totalFare;
	}
	@Override
	public String toString() {
		return "R_Booking [bookingId=" + bookingId + ", busDetails="
				+ busDetails + ", doj=" + doj + ", dob=" + dob
				+ ", customer_source=" + customer_source
				+ ", customer_destination=" + customer_destination + ", NOS="
				+ NOS + ", seatId=" + seatId + ", status=" + status
				+ ", totalFare=" + totalFare + "]";
	}
}
