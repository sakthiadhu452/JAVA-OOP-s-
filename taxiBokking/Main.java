package taxiBokking;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Taxi> taxis = new ArrayList<Taxi>();
        ArrayList<Bokking> bookings = new ArrayList<Bokking>();

        int taxiLimit = 2;
        int userChoice = 1;

        for (int i = 0; i < taxiLimit; i++) {
            taxis.add(new Taxi(i));
            
        }
        
        int confirmedBookingCount = 0;
        
        
        while (userChoice == 1) {
            System.out.println("Enter the choice \n1. Book taxi\n2. Exit");
            userChoice = scanner.nextInt();
            if (userChoice == 1) {
                 Bokking temp = new Bokking(confirmedBookingCount+1);
                 int res = temp.doBook(taxis,bookings);
                 if(res==-1) {
                	 System.out.print("ALL Taxix are busy !😥 pls try again sometime");
                 }
                 else {
                	 
                	 temp.setAllottedTaxi(res);
                	 bookings.add(temp);
                	 
                	 System.out.println("Taxi "+ ""+res+" is booked! Thank You");
                 }
             }
            }
        }
        
        
   
}
