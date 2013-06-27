
public class SeatClass {
	/*
	 * creates seat classes and stores values for seat class
	 * 
	 * 
	 */
	private String seat_class = "empty value for seat";

	public void createSeat_class(String s){
		if(s.equals("first") || s.equals("business") ||s.equals("economy")){
			seat_class = s;
		}
	}
	
	public String getSeat_class() {
		return seat_class;
	}

	public void setSeat_class(String seat_class) {
		this.seat_class = seat_class;
	}
}
