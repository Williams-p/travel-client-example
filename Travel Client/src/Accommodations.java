// Seat maintains information about seats. Specifically, the Seat object stores 
// its row, column, and whether the seat is booked or not.
public abstract class Accommodations {
	
	protected int capacity;  //Capacity of accommodations offered (1 for airline seat, x for cruiseship cabins)
	protected int num_unbooked; //How many open spots here? Calculated against 'capacity'
	protected int row;
	protected char col;
	protected char[] accommodations; //Stores the availability of all bookable objects in this class (1 seats, x beds / cabin)
	
	
	//Constructor
	public Accommodations(int row, char col, int bookable){
		setRow(row);
		setCol(col);
		capacity = bookable;
		num_unbooked = bookable;
		accommodations = new char[bookable];
		for(int i = 0; i < capacity; i++){ //All bookables are unbooked initially
			accommodations[i] = 'e';
		}
	}
	
	public boolean is_full(){ //Is there an unbooked object in this class?
		return num_unbooked > 0;
	}
	
	//Standard array of setters and getters
	public int getCapacity(){
		return capacity;
	}
	
	public void setCapacity(int num){
		this.capacity = num;
	}
	
	public int getNumAvailable(){
		return num_unbooked;
	}
	
	public int getRow(){
		return row;
	}
	
	public void setRow(int row){
		this.row = row;
	}
	
	public char getCol(){
		return col;
	}
	
	public void setCol(char col){
		this.col = col;
	}
	
	public char getStatus(int which){
		return accommodations[which];
	}
	
	public void setStatus(int which, char status){
		if(status == 'b' && which < capacity && which >= 0){
			if(this.accommodations[which] == 'e'){
				this.accommodations[which] = status;
				num_unbooked--;
			}
			else{
				System.out.println("Accommodation is already marked as being booked.");
			}
		}
		else if(status == 'e' && which < capacity && which >= 0){
			if(this.accommodations[which] == 'b'){
				this.accommodations[which] = status;
				num_unbooked++;
			}
			else{
				System.out.println("Accommodation is already marked as being empty.");
			}
		}
		else{
			if(status != 'e' && status != 'b'){
				System.out.println("Seat_status must be 'b' for booked, or 'e' for empty.");
			}
			else if(which > capacity || which < 0){
				System.out.println("Accommodation number out of range (0 to " + capacity + ").");
			}
			else{
				System.out.println("Unknown error setting accommodation availability!");
			}
		}
	}
}
