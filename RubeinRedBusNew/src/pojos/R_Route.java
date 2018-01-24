package pojos;

public class R_Route {

	private int routeId;
	private String stops;
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getStops() {
		return stops;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	@Override
	public String toString() {
		return "R_Route [routeId=" + routeId + ", stops=" + stops + "]";
	}
	
	
}
