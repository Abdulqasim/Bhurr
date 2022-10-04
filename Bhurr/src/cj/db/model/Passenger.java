package cj.db.model;

public class Passenger {
	private String name;
	private String gender;
	private int age;
	private String email;
	private long phone;
	private String dateOfJourney;
	private int passenger;
	private int totalFare;
	private String source, destination;
	private int busNo, busFare;
	private String busName, busTime, busHrs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public int getPassenger() {
		return passenger;
	}
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	public int getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
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
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public int getBusFare() {
		return busFare;
	}
	public void setBusFare(int busFare) {
		this.busFare = busFare;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusTime() {
		return busTime;
	}
	public void setBusTime(String busTime) {
		this.busTime = busTime;
	}
	public String getBusHrs() {
		return busHrs;
	}
	public void setBusHrs(String busHrs) {
		this.busHrs = busHrs;
	}
	
	@Override
	public String toString() {
		String result = "\n Bus No = " + this.getBusNo()
		                + "\n Name = " + this.getName()
		                + "\n Mobile No = " + this.getPhone()
		                + "\n Date Of Journey = " + this.getDateOfJourney()
		                + "\n No. of Passenger = " + this.getPassenger()
		                + "\n Source = " + this.getSource()
		                + "\n Destination = " + this.getDestination()
		                + "\n Bus Name = " + this.getBusName() 
		                + "\n Bus Time = " + this.getBusTime() 
		                + "\n Bus Hrs = " + this.getBusHrs()
		                + "\n Total Fare = " + this.getBusFare() * this.getPassenger() + " Rs";
		return result;
	}
}
