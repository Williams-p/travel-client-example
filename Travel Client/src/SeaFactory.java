public class SeaFactory  implements ManagerFactory {
	
	public Seaport createPort(String port_name){
		Seaport sp = new Seaport(port_name);
		return sp;
	}
	
	public Cruiseline createLine(String line_name){
		Cruiseline cl = new Cruiseline(line_name);
		return cl;
	}

	public Cruise createConnection(String line_name, String[] route, int year, int month, int day, String flight_id) {
		Cruise cr = new Cruise(line_name, route, year, month, day, flight_id);
		return cr;
		
	}

	public CabinSection createSection(String line_name, String connection_ID, int rows, int cols, int num, int section_type) {
		CabinClass cc;
		if(section_type == 0){
			cc = CabinClass.family;
		}
		else if(section_type == 1){
			cc = CabinClass.deluxe_family;
		}
		else if(section_type ==2){
			cc = CabinClass.couples;
		}
		else{
			cc = CabinClass.deluxe_couples;
		}
		CabinSection cs = new CabinSection(line_name, connection_ID, rows, cols, num, cc);
		return cs;
	}
}
