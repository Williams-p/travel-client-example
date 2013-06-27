
public class Cruise extends Connection{
	public Cruise(String cruise_name, String[] route, int year, int month, int day, String cruise_id){
		super(cruise_name, route, year, month, day, cruise_id);
	}
	
	public String toString(){
		String result = "Cruise: " + getFlight_name() + " " + getConnection_id() + " ";
		for(int i = 0; i < route.length; i++){
			result += route[i] + " ";
		}
		result += getYear() + " " + getMonth() + " " + getDay();
		for(int i = 0; i < sectionsLL.size(); i++){
			result += "\n" + sectionsLL.get(i).toString();
		}
		return result;
	}
	
	public void bookSeat(CabinClass cc, int row, char col) {
		boolean foundSection = false;
		for(int index = 0; index < sectionsLL.size(); index++){ // Find the correct section
			Section section = sectionsLL.get(index);
			if(((CabinSection) section).getSection().equals(cc)){
				foundSection = true;
				section.bookSeat(row, col);
				break;
			}
		}
		if(!foundSection){
			System.out.println("Unable to book seat " + row + col + " on flight " + connection_id + "; section '" + cc + " does not exist.");
		}
	}
}
