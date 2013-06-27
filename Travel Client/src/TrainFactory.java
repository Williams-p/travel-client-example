
public class TrainFactory  implements ManagerFactory {
	
	public Trainport createPort(String port_name){
		Trainport tp = new Trainport(port_name);
		return tp;
	}
	
	public Trainline createLine(String line_name){
		Trainline tl = new Trainline(line_name);
		return tl;
	}

	public Train createConnection(String line_name, String[] route, int year, int month, int day, String flight_id) {
		Train tr = new Train(line_name, route, year, month, day, flight_id);
		return tr;
		
	}

	public Traincar createSection(String line_name, String connection_ID, int rows, int cols, int num, int section_type) {
		CarClass cc;
		if(section_type == 0){
			cc = CarClass.first;
		}
		else if(section_type == 1){
			cc = CarClass.business;
		}
		else{
			cc = CarClass.economy;
		}
		Traincar tc = new Traincar(line_name, connection_ID, rows, cols, 1, cc);
		return tc;
	}
}