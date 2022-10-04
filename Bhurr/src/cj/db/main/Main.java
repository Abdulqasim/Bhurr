package cj.db.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import cj.db.dao.Bus;
import cj.db.dao.PassengerDao;
import cj.db.model.Passenger;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));		
		PassengerDao passengerDao = new PassengerDao();
		 Passenger psng = new Passenger();
		Bus bus = new Bus();
		String source,destination;
		char ch;
		int age,passenger,busNo;
		long phone;
		String name,email,gender,dateOfJourney;
		int choice;
		while(true) {
			System.out.println();
			System.out.println("1. Search Buses");
			System.out.println("2. Show Ticket");
			System.out.println("3. Cancel Ticket");
			System.out.println("4. Exit");
			System.out.println();
			System.out.print("Enter Your Choice : ");
			System.out.println();
			choice = scan.nextInt();
			if(choice == 6)
				break;
			else
				switch(choice) {
				case 1 : // Search Buses
					System.out.println("Mumbai");
					System.out.println("Nashik");
					System.out.println("Pune");
					System.out.println("Ratnagiri");
					System.out.println("Satara");
					System.out.println();
					System.out.print("Enter Source : ");
					source = scan.next();
					System.out.print("Enter Destination : ");
					destination = scan.next();
					// condition for same source and destination
					System.out.println("Enter Date of Journey [dd-mm-yyyy] : ");
					dateOfJourney = scan.next();
					bus = passengerDao.searchBuses(source,destination);
					if(bus.getSource() != source && bus.getDestination() != destination) {
						System.out.println(bus);
					}
					// bus table show according to source and destination
					System.out.print("Do You Want To Book Ticket [Y / N] : ");
					ch = scan.next().charAt(0);
					if(ch == 'Y' || ch == 'y') {
						System.out.print("Enter busNo : ");
						busNo = scan.nextInt();
						System.out.print("Enter Email : ");
						email = scan.next();
						System.out.print("Enter Mobile No : ");
						phone = scan.nextLong();
						System.out.print("Enter Full Name : ");
						name = inp.readLine();
						System.out.print("Enter Gender : ");
						gender = inp.readLine();
						System.out.print("Enter Age : ");
						age = scan.nextInt();
						System.out.print("Enter No of Passenger : ");
						passenger = scan.nextInt();
						boolean details = passengerDao.insertRecord(name,gender,age,email,phone,passenger,dateOfJourney,busNo);
						if(details)
							System.out.println("Ticket Confirmation Successful");
						else
							System.out.println("Ticket Confirmation Unsuccessful");
					}
					else {
						System.out.println("Thank You");
					}
					break;
				case 2 : // Show Ticket
					System.out.print("Enter Mobile No : ");
					phone = scan.nextLong();
					psng = passengerDao.searchByPhone(phone);
					if(psng.getPhone() != 0)
			        	 System.out.println(psng);
					break;
				case 3 : // Cancel Ticket
					System.out.print("Enter Mobile No : ");
					phone = scan.nextLong();
					boolean details = passengerDao.deleteRecord(phone);
					if(details)
						System.out.println("Ticket Cancellation Successful");
					else
						System.out.println("Ticket Cancellation Unuccessful");
					break;
				default : System.out.println("Invalid Choice");
				}
		}
	}
}
