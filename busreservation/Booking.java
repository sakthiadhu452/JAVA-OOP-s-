package busreservation;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Passenger Name:");
		passengerName=scanner.next();
		System.out.println("Enter Bus no:");
		busNo = scanner.nextInt();
		System.out.println("Enter date in dd-mm-yyyy format");
		String dateInput=scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public boolean isAvailable(ArrayList <Booking> bookings, ArrayList <Bus> buses) {
		int capacity=0;
		for ( Bus individualbus:buses) {
			
			if(individualbus.getBusno()==busNo) {
				capacity=individualbus.getCapacity();
				
			}
		}
		int count = 0;
		for (Booking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				count++;
			}
		}
		if	(count<capacity){
			return true;
		}
		
		return false;
	}
	
}
