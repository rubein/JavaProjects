package pojos;

public class R_BusDetails {

	private int busId;
	private String busNo;
	private R_Route route;
	private String AcNAc;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAcNAc() {
		return AcNAc;
	}
	public void setAcNAc(String acNAc) {
		AcNAc = acNAc;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public R_Route getRoute() {
		return route;
	}
	public void setRoute(R_Route route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "R_BusDetails [busId=" + busId + ", busNo=" + busNo + ", route="
				+ route + ", AcNAc=" + AcNAc + ", status=" + status + "]";
	}
	
}
