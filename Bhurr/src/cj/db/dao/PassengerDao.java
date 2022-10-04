package cj.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cj.db.model.Passenger;
import cj.db.util.DatabaseConnect;

public class PassengerDao {
	// Connect the database
	Connection con = DatabaseConnect.connect();
	
	// Cancel Ticket
	public boolean deleteRecord(long phone) {
		String sql = "delete from passenger where phone = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, phone);
			int i = ps.executeUpdate();
			if(i > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Search Buses
	public boolean insertRecord(String name, String gender, int age, String email, long phone, int passenger,
			String dateOfJourney, int busNo) {
		String sql = "insert into passenger values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setInt(3, age);
			ps.setString(4, email);
			ps.setLong(5, phone);
			ps.setInt(6, passenger);
			ps.setString(7, dateOfJourney);
			ps.setInt(8, busNo);
			int i = ps.executeUpdate();
			if(i > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Show Ticket
	public Passenger searchByPhone(long phone) {
		Passenger p = null;
		try {
			PreparedStatement ps = con.prepareStatement
					("select passenger.busNo,passenger.name,passenger.phone,passenger.dateOfJourney,passenger.passenger,"
							+ "bus.source,bus.destination,bus.busName,bus.busTime,bus.busHrs,bus.busFare"
							+ " from bus right join passenger on bus.busNo = passenger.busNo"
							+ " where phone = ?");
			ps.setLong(1, phone);
			ResultSet rs = ps.executeQuery();
			p = new Passenger();
			rs.next();
			p.setBusNo(rs.getInt("busNo"));
			p.setName(rs.getString("name"));
			p.setPhone(rs.getLong("phone"));
			p.setDateOfJourney(rs.getString("dateOfJourney"));
			p.setPassenger(rs.getInt("passenger"));
			p.setSource(rs.getString("source"));
			p.setDestination(rs.getString("destination"));
			p.setBusName(rs.getString("busName"));
			p.setBusTime(rs.getString("busTime"));
			p.setBusHrs(rs.getString("busHrs"));
			p.setBusFare(rs.getInt("busfare"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	// search buses
	public Bus searchBuses(String source, String destination) {
		Bus b = null;
		try {
			PreparedStatement ps = con.prepareStatement
					("select * from bus where source = ? and destination = ?");
			ps.setString(1, source);
			ps.setString(2, destination);
			ResultSet rs = ps.executeQuery();
			b = new Bus();
			rs.next();
			b.setBusNo(rs.getInt("busNo"));
			b.setSource(rs.getString("source"));
			b.setDestination(rs.getString("destination"));
			b.setBusName(rs.getString("busName"));
			b.setBusTime(rs.getString("busTime"));
			b.setBusHrs(rs.getString("busHrs"));
			b.setBusFare(rs.getInt("busFare"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

}
