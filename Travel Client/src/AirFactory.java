
public class AirFactory  implements ManagerFactory {
	
	public Airport createPort(String port_name){
		Airport ap = new Airport(port_name);
		return ap;
	}
	
	public Airline createLine(String line_name){
		Airline al = new Airline(line_name);
		return al;
	}

	public Flight createConnection(String air_name, String[] route, int year, int month, int day, String flight_id) {
		Flight fl = new Flight(air_name, route, year, month, day, flight_id);
		return fl;
		
	}

	public FlightSection createSection(String line_name, String connection_ID, int rows, int cols, int num, int section_type) {
		SeatClass sc;
		if(section_type == 0){
			sc = SeatClass.first;
		}
		else if(section_type == 1){
			sc = SeatClass.business;
		}
		else{
			sc = SeatClass.economy;
		}
		FlightSection fs = new FlightSection(line_name, connection_ID, rows, cols, 1, sc);
		return fs;
	}
}
