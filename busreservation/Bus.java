package busreservation;

public class Bus {
	private int Busno;
	private boolean ac;
	private int capacity;
	
	Bus(int no,boolean ac, int cap){
		this.Busno=no;
		this.ac=ac;
		this.capacity=cap;
	}
	
	
	
	public int getCapacity(){ //accessor method
		return capacity;
	}
	
	public void setCapacity(int cap) { //mutator
		capacity = cap;
	}
	
	public int getBusno(){ //accessor method
		return Busno;
	}
	
	public void setBusno(int no) { //mutator
		Busno=no;
	}
	
	public void displayBusInfo(){
		System.out.println("\nBus No:"+Busno+"\nAC:"+ac+"\nTotal Capacity"+capacity+"\n");
	}
	
	
}
