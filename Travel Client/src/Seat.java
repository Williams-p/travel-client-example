// Super simple; just have to instantiate the super-class with a capacity of 1; the rest handles itself.
public class Seat extends Accommodations{
	public Seat(int row, char col){
		super(row, col, 1);
	}
	
	public String toString(){
		String result = "Seat " + row + col + ": ";
		if(getStatus(0) == 'b'){
			result += "booked";
		}
		else{
			result += "empty";
		}
		return result;
	}
}
