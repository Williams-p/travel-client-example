// Maintains information about a given Train, including id, name,
// origin, destination, date, and seat sections.
public class Train extends Connection{

	// Constructor
	public Train(String air_name, String[] route, int year, int month, int day, String flight_id){
		super(air_name, route, year, month, day, flight_id);
	}
	
	public String toString(){
		String result = "Train: " + getFlight_name() + " " + getConnection_id() + " ";
		for(int i = 0; i < route.length; i++){
			result += route[i] + " ";
		}
		result += getYear() + " " + getMonth() + " " + getDay();
		for(int i = 0; i < sectionsLL.size(); i++){
			result += "\n" + sectionsLL.get(i).toString();
		}
		return result;
	}
	
	public void bookSeat(CarClass sc, int row, char col) {
		boolean foundSection = false;
		for(int index = 0; index < sectionsLL.size(); index++){ // Find the correct section
			Section section = sectionsLL.get(index);
			if(((Traincar) section).getSection().equals(sc)){
				foundSection = true;
				section.bookSeat(row, col);
				break;
			}
		}
		if(!foundSection){
			System.out.println("Unable to book seat " + row + col + " on train " + connection_id + "; section '" + sc + " does not exist.");
		}
	}
}
