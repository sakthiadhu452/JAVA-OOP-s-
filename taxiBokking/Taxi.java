package taxiBokking;

import java.util.ArrayList;

public class Taxi {
    private int taxiNo;
    private char currentLocation = 'A';
    private int totalEarnings = 0;
    private boolean bookStatus=true;
    private ArrayList<Bookings> bookingHistory = new ArrayList<Bookings>();

    // Constructor
    public Taxi(int taxiNo) {
        this.taxiNo = taxiNo;
    }

    // Getter and setter for taxiNo
    public int getTaxiNo() {
        return taxiNo;
    }

    public void setTaxiNo(int taxiNo) {
        this.taxiNo = taxiNo;
    }

    // Getter and setter for currentLocation
    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    // Getter and setter for totalEarnings
    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void addEarnings(int earnings) {
        this.totalEarnings += earnings;
    }

    // Getter and setter for bookingHistory
    public ArrayList<Bookings> getBookingHistory() {
        return bookingHistory;
    }

    public void addBooking(Bookings booking) {
        this.bookingHistory.add(booking);
    }
    
    public boolean getBookStatus() {
    	return bookStatus;
    }
    
    public void setBookStatus(boolean value) {
    	bookStatus= value;
    }
    
    // Display details
    public void displayDetails() {
        System.out.println("Taxi Number: " + taxiNo);
        System.out.println("Current Location: " + currentLocation);
        System.out.println("Total Earnings: " + totalEarnings);
        System.out.println("Booking History: " + bookingHistory);
    }
}

class Bookings {
    // Assuming the Bookings class has some properties
    private String customerName;
    private char pickupLocation;
    private char dropLocation;
    private int fare;

    // Constructor
    public Bookings(String customerName, char pickupLocation, char dropLocation, int fare) {
        this.customerName = customerName;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Bookings [customerName=" + customerName + ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", fare=" + fare + "]";
    }

    // Getter and setter methods for the Bookings class can also be added here
}
