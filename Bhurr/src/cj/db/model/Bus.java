package cj.db.model;

public class Bus {
	private int busNo;
	private String source;
	private String destination;
	private String busName;
	private int busTime;
	private String busHrs;
	private int busFare;
	
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
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
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getBusTime() {
		return busTime;
	}
	public void setBusTime(int busTime) {
		this.busTime = busTime;
	}
	public String getBusHrs() {
		return busHrs;
	}
	public void setBusHrs(String busHrs) {
		this.busHrs = busHrs;
	}
	public int getBusFare() {
		return busFare;
	}
	public void setBusFare(int busFare) {
		this.busFare = busFare;
	}
	
	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", source=" + source + ", destination=" + destination + ", busName=" + busName
				+ ", busTime=" + busTime + ", busHrs=" + busHrs + ", busFare=" + busFare + "]";
	}
}
