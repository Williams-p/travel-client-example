import java.util.LinkedList;

// Maintains information about a given flight, including id, name,
// origin, destination, date, and seat sections.
public abstract class Connection{
	
	protected String connection_id;
	protected String flight_name;
	protected String[] route;
	protected int year;
	protected int month;
	protected int day;
	protected LinkedList<Section> sectionsLL = new LinkedList<Section>();
	
	
	// Constructor
	public Connection(String air_name, String[] route, int year, int month, int day, String connectionid){
		setConnection_id(connectionid);
		setFlight_name(air_name);
		setRoute(route);
		setYear(year);
		setMonth(month);
		setDay(day);
	}	
	
	public void addSection(Section s){
		sectionsLL.add(s);
	}
	
	public void printConnection(){
        System.out.print(getConnection_id() + " " + getFlight_name() + " ");
        for(int i = 0; i < route.length; i++){
        	System.out.print(route[i] + " ");
        }
        System.out.print(getYear() + " " + getMonth() + " " + getDay());
	}

	
	// Does the flight have available seats? Calls sister method in FlightSection
	public boolean hasEmptySeat() {
		boolean result = false;
		for(int section_index = 0; section_index < sectionsLL.size(); section_index++){
			if(sectionsLL.get(section_index).hasEmptySeat()){
				result = true;
				break;
			}
		}
		return result;
	}
	
	// Getters and Setters
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getConnection_id() {
		return connection_id;
	}

	public void setConnection_id(String flight_id) {
		this.connection_id = flight_id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String[] getRoute() {
		return route;
	}

	public void setRoute(String[] route) {
		this.route = route;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public LinkedList<Section> getFlightsSectionsLL(){
		return sectionsLL;
	}
}
