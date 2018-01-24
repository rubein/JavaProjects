package pojos;

public class R_Stops {

	private int stopId;
	private String name;
	public int getStopId() {
		return stopId;
	}
	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "R_Stops [stopId=" + stopId + ", name=" + name + "]";
	}
	
}
