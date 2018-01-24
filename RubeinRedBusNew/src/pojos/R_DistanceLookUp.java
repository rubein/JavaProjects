package pojos;

public class R_DistanceLookUp {

	private int lookupId;
	private String source;
	private String destination;
	private R_Route routeId;
	private int distance;
	
	public int getLookupId() {
		return lookupId;
	}
	public void setLookupId(int lookupId) {
		this.lookupId = lookupId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public R_Route getRouteId() {
		return routeId;
	}
	public void setRouteId(R_Route routeId) {
		this.routeId = routeId;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "R_DistanceLookUp [lookupId=" + lookupId + ", source=" + source
				+ ", destination=" + destination + ", routeId=" + routeId
				+ ", distance=" + distance + "]";
	}
}