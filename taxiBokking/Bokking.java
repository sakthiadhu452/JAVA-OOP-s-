package taxiBokking;
import java.util.*;

public class Bokking {
     
    private int bookingId;
    private String name;
    private char pickUpPoint;
    private char dropPoint;
    private int pickUpTime;
    private int dropTime;
    private int allottedTaxi;
    private int costForTravel = 0; 

    Scanner scanner = new Scanner(System.in);

    public Bokking(int no) {
        bookingId = no;
        System.out.println("Enter your Name:");
        name = scanner.next();

        System.out.println("Enter your PickUp Location (A, B, C, etc.):");
        pickUpPoint = scanner.next().charAt(0);

        System.out.println("Enter your Drop Location (A, B, C, etc.):");
        dropPoint = scanner.next().charAt(0);

        System.out.println("Enter your PickUp Time (in hours):");
        pickUpTime = scanner.nextInt();

        dropTime = pickUpTime + Math.abs(pickUpPoint - dropPoint);
        
        costForTravel=Math.abs(pickUpPoint - dropPoint)*100;
    }

    public int getDropTime() {
        return dropTime;
    }

    public int getTotalCostForTravel() {
        return costForTravel;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getName() {
        return name;
    }

    public char getPickUpPoint() {
        return pickUpPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setAllottedTaxi(int taxiNo) {
        this.allottedTaxi = taxiNo;
    }

    public int getAllottedTaxi() {
        return allottedTaxi;
    }

    public void execute(ArrayList<Taxi> taxis, Bokking selectedBooking) {
        for (Taxi individualTaxi : taxis) {
            if (individualTaxi.getTaxiNo() == allottedTaxi) {
                individualTaxi.setBookStatus(false);
            }
//            System.out.println(selectedBooking.getDropTime()+" "+pickUpTime);
            if (selectedBooking.getDropTime() <= pickUpTime) {
                individualTaxi.setBookStatus(true);
                individualTaxi.addEarnings(selectedBooking.getTotalCostForTravel());
                individualTaxi.setCurrentLocation(selectedBooking.getDropPoint());
            }
        }
    }

    
  public int selectTaxi(ArrayList<Taxi> taxis, ArrayList<Bokking> bookings) {
        ArrayList<Integer> eligibleTaxis = new ArrayList<>();

        for (Taxi itaxi : taxis) {
            if (itaxi.getBookStatus()) {
                eligibleTaxis.add(itaxi.getTaxiNo());
            }
        }

       
        for (Bokking ibooking : bookings) {
            if (this.pickUpTime > ibooking.getPickUpTime() && this.dropTime < ibooking.getDropTime()) {
                eligibleTaxis.remove((Integer) ibooking.getAllottedTaxi());
            }
        }

////        System.out.println("Eligible taxis:");
//        for (int i:eligibleTaxis) {
//        	System.out.print(i+" ");
//        }
        int min = Integer.MAX_VALUE;

        
        for(int i :eligibleTaxis) {
        	for (Taxi itaxi:taxis) {
        		if(i==itaxi.getTaxiNo()) {
        			if(Math.abs(itaxi.getCurrentLocation()-pickUpPoint)<min) {
                		min=itaxi.getTaxiNo();
                	}
        		}
        	}
        }
        
        

        return min == Integer.MAX_VALUE ? -1 : min;
    }



    
    public int doBook(ArrayList<Taxi> taxis, ArrayList<Bokking> bookings) {
        for (Bokking individualBooking : bookings) {
            if (pickUpTime > individualBooking.getPickUpTime()) {
                individualBooking.execute(taxis, individualBooking);
            }
        }
        
        
        
        
        int finalTaxi;
        
        finalTaxi=selectTaxi(taxis,bookings);
       
        
        
        return finalTaxi;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
