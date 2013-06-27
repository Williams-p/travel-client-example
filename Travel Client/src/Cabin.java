// Simple; just need to instantiate the superclass with the appropriate number of bookable objects
public class Cabin extends Accommodations {
	public Cabin(int row, char col, int size){
		super(row, col, size);
	}
	
	public String toString(){
		String result = "Cabin " + row + col +" (Capacity " + capacity + "): ";
		for(int i = 0; i < capacity; i++){
			result += (i + 1) + " - ";
			if(getStatus(i) == 'b'){
				result += "booked";
			}
			else{
				result += "empty";
			}
			if(i < capacity - 1){
				result += ", ";
			}
		}
		return result;
	}
}
