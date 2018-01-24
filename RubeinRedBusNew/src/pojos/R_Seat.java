package pojos;

public class R_Seat {

	private int seatId;
	private R_BusDetails busDetails;
	private float fare;
	private String SeatSleepType;
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public R_BusDetails getBusDetails() {
		return busDetails;
	}
	public void setBusDetails(R_BusDetails busDetails) {
		this.busDetails = busDetails;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	
	public String getSeatSleepType() {
		return SeatSleepType;
	}
	public void setSeatSleepType(String seatSleepType) {
		SeatSleepType = seatSleepType;
	}
	@Override
	public String toString() {
		return "R_Seat [seatId=" + seatId + ", busDetails=" + busDetails
				+ ", fare=" + fare + ", SeatSleepType=" + SeatSleepType + "]";
	}
	
	
}
