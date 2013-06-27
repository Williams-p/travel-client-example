import java.util.LinkedList;

public class SystemManager{
	
	ManagerFactory AF = new AirFactory();
	ManagerFactory SF = new SeaFactory();
	ManagerFactory TF = new TrainFactory();
	LinkedList<Airport> airportLL = new LinkedList<Airport>();
	LinkedList<Airline> airlineLL = new LinkedList<Airline>();
	LinkedList<Seaport> seaportLL = new LinkedList<Seaport>();
	LinkedList<Cruiseline> cruiselineLL = new LinkedList<Cruiseline>();
	LinkedList<Trainport> trainportLL = new LinkedList<Trainport>();
	LinkedList<Trainline> trainlineLL = new LinkedList<Trainline>();
	
	public void createAirport(String airport_name){
		if(isValidPortName(airport_name)){ // If the airport name is valid...
			if(!isAirportInList(airport_name)){ // ... and the name isn't already taken...
				airportLL.add((Airport) AF.createPort(airport_name)); // ... then add the airport.
			}
			else{ // Airport name was taken; inform user.
				System.out.println("Unable to add airport \"" + airport_name + "\": an airport with that name already exists.");
			}
		}
	}

	public void createSeaport(String seaport_name){
		if(isValidPortName(seaport_name)){ // If the airport name is valid...
			if(!isSeaportInList(seaport_name)){ // ... and the name isn't already taken...
				seaportLL.add((Seaport) SF.createPort(seaport_name)); // ... then add the airport.
			}
			else{ // port name was taken; inform user.
				System.out.println("Unable to add seaport \"" + seaport_name + "\": a seaport with that name already exists.");
			}
		}
	}

	public void createTrainport(String trainport_name){
		if(isValidPortName(trainport_name)){ // If the airport name is valid...
			if(!isTrainportInList(trainport_name)){ // ... and the name isn't already taken...
				trainportLL.add((Trainport) TF.createPort(trainport_name)); // ... then add the airport.
			}
			else{ // port name was taken; inform user.
				System.out.println("Unable to add trainport \"" + trainport_name + "\": a trainport with that name already exists.");
			}
		}
	}

	public void createAirline(String airline_name){
		if(isValidLineName(airline_name)){ // If the airline name is valid...
			if(!isAirlineInList(airline_name)){ // ... and the name isn't already taken...
				airlineLL.add((Airline) AF.createLine(airline_name)); // ... then add the airline.
			}
			else{
				System.out.println("Unable to add airline \"" + airline_name + "\": and airline with that name already exists.");
			}
		}
	}

	public void createCruiseline(String cruiseline_name){
		if(isValidLineName(cruiseline_name)){ // If the airline name is valid...
			if(!isCruiselineInList(cruiseline_name)){ // ... and the name isn't already taken...
				cruiselineLL.add((Cruiseline) SF.createLine(cruiseline_name)); // ... then add the airline.
			}
			else{
				System.out.println("Unable to add cruiseline \"" + cruiseline_name + "\": a cruiseline with that name already exists.");
			}
		}
	}
	
	public void createTrainline(String trainline_name){
		if(isValidLineName(trainline_name)){ // If the airline name is valid...
			if(!isTrainlineInList(trainline_name)){ // ... and the name isn't already taken...
				trainlineLL.add((Trainline) TF.createLine(trainline_name)); // ... then add the airline.
			}
			else{
				System.out.println("Unable to add trainline \"" + trainline_name + "\": a trainline with that name already exists.");
			}
		}
	}

	public void createFlight(String airline_name, String[] route, int year, int month, int day, String flight_id){
		boolean good_to_go = true;
		for(int i = 0; i < route.length; i++){
			if(!isAirportInList(route[i])){
				System.out.println("Cannot create flight " + airline_name + " " + flight_id + ": airport \"" + route[i] + "\" does not exist.");
				good_to_go = false;
				break;
			}
		}

		if(route.length < 2){
			System.out.println("Cannot create flight " + airline_name + " " + flight_id + ": specified route is too short.");
			good_to_go = false;
		}

		// Test airline exists
		if(!isAirlineInList(airline_name)){
			System.out.println("Cannot create flight " + airline_name + " " + flight_id + ": airline \"" + airline_name + "\" does not exist.");
			good_to_go = false;
		}

		// Test flight id validity
		if(!isValidID(flight_id)){
			System.out.println("Cannot create flight " + airline_name + " " + flight_id + ": flight_id \"" + flight_id + "\" is not valid.");
			good_to_go = false;
		}

		//Test flight id is not taken
		if(isFlightInList(flight_id, airline_name)){
			System.out.println("Cannot create flight " + airline_name + " " + flight_id + ": flight " + airline_name + " " + flight_id + " already exists");
			good_to_go = false;
		}

		// Test flight date
		if(year <= 2012){
			System.out.println("Cannot create flight " + airline_name + " " + flight_id + ": year (" + year + ") is before 2013");
			good_to_go = false;
		}

		// All tests passed; create the flight.
		if(good_to_go){
			getAirline(airline_name).AddConnection(AF.createConnection(airline_name, route, year, month, day, flight_id));
		}
	}

	public void createCruise(String cruiseline_name, String[] route, int year, int month, int day, String flight_id){
		boolean good_to_go = true;
		for(int i = 0; i < route.length; i++){
			if(!isSeaportInList(route[i])){
				System.out.println("Cannot create cruise " + cruiseline_name + " " + flight_id + ": seaport \"" + route[i] + "\" does not exist.");
				good_to_go = false;
				break;
			}
		}

		if(route.length < 2){
			System.out.println("Cannot create cruise " + cruiseline_name + " " + flight_id + ": specified route is too short.");
			good_to_go = false;
		}

		// Test airline exists
		if(!isCruiselineInList(cruiseline_name)){
			System.out.println("Cannot create cruise " + cruiseline_name + " " + flight_id + ": cruiseline \"" + cruiseline_name + "\" does not exist.");
			good_to_go = false;
		}

		// Test flight id validity
		if(!isValidID(flight_id)){
			System.out.println("Cannot create cruise " + cruiseline_name + " " + flight_id + ": cruise_id \"" + flight_id + "\" is not valid.");
			good_to_go = false;
		}

		//Test flight id is not taken
		if(isCruiseInList(flight_id, cruiseline_name)){
			System.out.println("Cannot create flight " + cruiseline_name + " " + flight_id + ": cruise " + cruiseline_name + " " + flight_id + " already exists");
			good_to_go = false;
		}

		// Test flight date
		if(year <= 2012){
			System.out.println("Cannot create flight " + cruiseline_name + " " + flight_id + ": year (" + year + ") is before 2013");
			good_to_go = false;
		}

		// All tests passed; create the flight.
		if(good_to_go){
			getCruiseline(cruiseline_name).AddConnection(SF.createConnection(cruiseline_name, route, year, month, day, flight_id));
		}
	}
	
	public void createTrain(String trainline_name, String[] route, int year, int month, int day, String flight_id){
		boolean good_to_go = true;
		for(int i = 0; i < route.length; i++){
			if(!isTrainportInList(route[i])){
				System.out.println("Cannot create train " + trainline_name + " " + flight_id + ": trainport \"" + route[i] + "\" does not exist.");
				good_to_go = false;
				break;
			}
		}

		if(route.length < 2){
			System.out.println("Cannot create train " + trainline_name + " " + flight_id + ": specified route is too short.");
			good_to_go = false;
		}

		// Test airline exists
		if(!isTrainlineInList(trainline_name)){
			System.out.println("Cannot create train " + trainline_name + " " + flight_id + ": trainline \"" + trainline_name + "\" does not exist.");
			good_to_go = false;
		}

		// Test flight id validity
		if(!isValidID(flight_id)){
			System.out.println("Cannot create train " + trainline_name + " " + flight_id + ": train_id \"" + flight_id + "\" is not valid.");
			good_to_go = false;
		}

		//Test flight id is not taken
		if(isTrainInList(flight_id, trainline_name)){
			System.out.println("Cannot create train " + trainline_name + " " + flight_id + ": train " + trainline_name + " " + flight_id + " already exists");
			good_to_go = false;
		}

		// Test flight date
		if(year <= 2012){
			System.out.println("Cannot create train " + trainline_name + " " + flight_id + ": year (" + year + ") is before 2013");
			good_to_go = false;
		}

		// All tests passed; create the flight.
		if(good_to_go){
			getTrainline(trainline_name).AddConnection(TF.createConnection(trainline_name, route, year, month, day, flight_id));
		}
	}

	//Creates a section on a given airline flight, provided all tests pass.
	public void createFlightSection(String air_name, String flID, int rows, int cols, int num, int sc){
		boolean valid_flight_info = true;
		boolean flight_section_test = true;
		//Is the given information valid?
		if(rows > 100 || rows < 1){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on flight " + air_name + " " + flID + ": 'rows' (" + rows + ") out of range (1-100).");
		}
		else if(cols > 10 || cols < 1){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on flight " + air_name + " " + flID + ": 'cols' (" + cols + ") out of range (1-10).");
		}
		else if(!isValidLineName(air_name)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on flight " + air_name + " " + flID + ": \"" + air_name + "\" is not a valid name.");
		}
		else if(!isAirlineInList(air_name)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on flight " + air_name + " " + flID + ": airline " + air_name + " does not exist.");
		}
		else if(!isValidID(flID)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on flight " + air_name + " " + flID + ": \"" + flID + "\" is not a valid flight_id.");
		}
		else if(!isFlightInList(flID, air_name)){
			System.out.println("Unable to create section '" + sc + "' on flight " + air_name + " " + flID + ": flight " + flID + " does not exist.");
			valid_flight_info = false;
		}

		if(valid_flight_info){
			Flight flight = getFlight(flID, air_name);
			//for all flight sections
			for(int section=0; section < flight.getFlightsSectionsLL().size(); section++){
				// if the section for that flight already exists test = false
				if(((FlightSection) flight.getFlightsSectionsLL().get(section)).getSection().equals(sc)){
					System.out.println("Unable to create section '" + sc + "' on flight " + air_name + " " + flID + ": section " + sc + " already exists.");
					flight_section_test = false;
				}
			}
			if(flight_section_test){
				flight.addSection(AF.createSection(air_name, flID, rows, cols, num, sc));
			}
		}
	}

	public void createCruiseSection(String air_name, String flID, int rows, int cols, int num, int cc){
		boolean valid_flight_info = true;
		boolean flight_section_test = true;
		//Is the given information valid?
		if(rows > 100 || rows < 1){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + cc + "' on cruise " + air_name + " " + flID + ": 'rows' (" + rows + ") out of range (1-100).");
		}
		else if(cols > 10 || cols < 1){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + cc + "' on cruise " + air_name + " " + flID + ": 'cols' (" + cols + ") out of range (1-10).");
		}
		else if(!isValidLineName(air_name)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + cc + "' on cruise " + air_name + " " + flID + ": \"" + air_name + "\" is not a valid name.");
		}
		else if(!isCruiselineInList(air_name)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + cc + "' on cruise " + air_name + " " + flID + ": sealine " + air_name + " does not exist.");
		}
		else if(!isValidID(flID)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + cc + "' on cruise " + air_name + " " + flID + ": \"" + flID + "\" is not a valid cruise_id.");
		}
		else if(!isCruiseInList(flID, air_name)){
			System.out.println("Unable to create section '" + cc + "' on cruise " + air_name + " " + flID + ": cruise ID " + flID + " does not exist.");
			valid_flight_info = false;
		}

		if(valid_flight_info){
			Cruise flight = getCruise(flID, air_name);
			//for all flight sections
			for(int section=0; section < flight.getFlightsSectionsLL().size(); section++){
				// if the section for that flight already exists test = false
				if(((CabinSection) flight.getFlightsSectionsLL().get(section)).getSection().equals(cc)){
					System.out.println("Unable to create section '" + cc + "' on flight " + air_name + " " + flID + ": section " + cc + " already exists.");
					flight_section_test = false;
				}
			}
			if(flight_section_test){
				flight.addSection(SF.createSection(air_name, flID, rows, cols, num, cc));
			}
		}
	}

	public void createTrainSection(String air_name, String flID, int rows, int cols, int num, int sc){
		boolean valid_flight_info = true;
		boolean flight_section_test = true;
		//Is the given information valid?
		if(rows > 100 || rows < 1){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on train " + air_name + " " + flID + ": 'rows' (" + rows + ") out of range (1-100).");
		}
		else if(cols > 10 || cols < 1){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on train " + air_name + " " + flID + ": 'cols' (" + cols + ") out of range (1-10).");
		}
		else if(!isValidLineName(air_name)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on train " + air_name + " " + flID + ": \"" + air_name + "\" is not a valid name.");
		}
		else if(!isTrainlineInList(air_name)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on train " + air_name + " " + flID + ": trainline " + air_name + " does not exist.");
		}
		else if(!isValidID(flID)){
			valid_flight_info = false;
			System.out.println("Unable to create section '" + sc + "' on train " + air_name + " " + flID + ": \"" + flID + "\" is not a valid train_id.");
		}
		else if(!isTrainInList(flID, air_name)){
			System.out.println("Unable to create section '" + sc + "' on train " + air_name + " " + flID + ": train " + flID + " does not exist.");
			valid_flight_info = false;
		}

		if(valid_flight_info){
			Train train = getTrain(flID, air_name);
			//for all flight sections
			for(int section=0; section < train.getFlightsSectionsLL().size(); section++){
				// if the section for that flight already exists test = false
				if(((Traincar) train.getFlightsSectionsLL().get(section)).getSection().equals(sc)){
					System.out.println("Unable to create section '" + sc + "' on train " + air_name + " " + flID + ": section " + sc + " already exists.");
					flight_section_test = false;
				}
			}
			if(flight_section_test){
				train.addSection(TF.createSection(air_name, flID, rows, cols, num, sc));
			}
		}
	}
	
	public void findAvailableFlights(String orig, String dest){
		// Test the origin and destination strings
		boolean airports_valid = false;
		if(isValidPortName(orig) && isValidPortName(dest)){
			if(!isAirportInList(orig)){
				System.out.println("Cannot find flight between " + orig + " and " + dest + ": airport " + orig + " does not exist.");
			}
			else if(!isAirportInList(dest)){
				System.out.println("Cannot find flight between " + orig + " and " + dest + ": airport " + dest + " does not exist.");
			}
			else{
				airports_valid = true;
			}
		}

		if(airports_valid){
			LinkedList<Flight> available_fl = new LinkedList<Flight>();

			// For all airlines
			for(int airline=0; airline<airlineLL.size(); airline++){
				// For all flights
				for(int flight=0; flight<airlineLL.get(airline).getConnectionsLL().size(); flight++){
					// If the origin and destination match
					if(airlineLL.get(airline).getConnectionsLL().get(flight).getRoute()[0].equals(orig) && airlineLL.get(airline).getConnectionsLL().get(flight).getRoute()[airlineLL.get(airline).getConnectionsLL().get(flight).getRoute().length - 1].equals(dest)){
						available_fl.add((Flight) airlineLL.get(airline).getConnectionsLL().get(flight));
					}
				}
			}

			// prints information on available flights
			System.out.println("These are the available flights:\n");
			for(int flight=0; flight<available_fl.size(); flight++){
				System.out.println(available_fl.get(flight));
				System.out.println();
			}
		}
	}

	public void findAvailableCruises(String orig, String dest){
		// Test the origin and destination strings
		boolean airports_valid = false;
		if(isValidPortName(orig) && isValidPortName(dest)){
			if(!isSeaportInList(orig)){
				System.out.println("Cannot find cruise between " + orig + " and " + dest + ": seaport " + orig + " does not exist.");
			}
			else if(!isSeaportInList(dest)){
				System.out.println("Cannot find cruise between " + orig + " and " + dest + ": seaport " + dest + " does not exist.");
			}
			else{
				airports_valid = true;
			}
		}

		if(airports_valid){
			LinkedList<Cruise> availableLL = new LinkedList<Cruise>();

			// For all airlines
			for(int cruiseline=0; cruiseline<cruiselineLL.size(); cruiseline++){
				// For all flights
				for(int cruise=0; cruise<cruiselineLL.get(cruiseline).getConnectionsLL().size(); cruise++){
					// If the origin and destination match
					if(cruiselineLL.get(cruiseline).getConnectionsLL().get(cruise).getRoute()[0].equals(orig) && cruiselineLL.get(cruiseline).getConnectionsLL().get(cruise).getRoute()[cruiselineLL.get(cruiseline).getConnectionsLL().get(cruise).getRoute().length-1].equals(dest)){
						availableLL.add((Cruise) cruiselineLL.get(cruiseline).getConnectionsLL().get(cruise));
					}
				}
			}

			// prints information on available flights
			System.out.println("These are the available cruises:\n");
			for(int flight=0; flight<availableLL.size(); flight++){
				System.out.println(availableLL.get(flight));
			}
		}
	}
	
	public void findAvailableTrains(String orig, String dest){
		// Test the origin and destination strings
		boolean airports_valid = false;
		if(isValidPortName(orig) && isValidPortName(dest)){
			if(!isTrainportInList(orig)){
				System.out.println("Cannot find flight between " + orig + " and " + dest + ": airport " + orig + " does not exist.");
			}
			else if(!isTrainportInList(dest)){
				System.out.println("Cannot find flight between " + orig + " and " + dest + ": airport " + dest + " does not exist.");
			}
			else{
				airports_valid = true;
			}
		}

		if(airports_valid){
			LinkedList<Train> available_fl = new LinkedList<Train>();

			// For all airlines
			for(int airline=0; airline<trainlineLL.size(); airline++){
				// For all flights
				for(int flight=0; flight<trainlineLL.get(airline).getConnectionsLL().size(); flight++){
					// If the origin and destination match
					if(trainlineLL.get(airline).getConnectionsLL().get(flight).getRoute()[0].equals(orig) && trainlineLL.get(airline).getConnectionsLL().get(flight).getRoute()[trainlineLL.get(airline).getConnectionsLL().get(flight).getRoute().length - 1].equals(dest)){
						available_fl.add((Train) trainlineLL.get(airline).getConnectionsLL().get(flight));
					}
				}
			}

			// prints information on available flights
			System.out.println("These are the available flights:\n");
			for(int flight=0; flight<available_fl.size(); flight++){
				System.out.println(available_fl.get(flight));
				System.out.println();
			}
		}
	}

	//Isolate the flight we need to book the seat on and call that flight's bookSeat() method
	public void bookSeat(String air_name, String flID, SeatClass sc, int row, char col){
		boolean found_airline = false;
		boolean found_flight = false;
		for(int airline=0; airline<airlineLL.size(); airline++){
			if(airlineLL.get(airline).getName().equals(air_name)){
				found_airline = true;
				for(int flight=0; flight<airlineLL.get(airline).getConnectionsLL().size(); flight++){
					if(airlineLL.get(airline).getConnectionsLL().get(flight).getConnection_id().equals(flID)){
						found_flight = true;
						((Flight) airlineLL.get(airline).getConnectionsLL().get(flight)).bookSeat(sc, row, col);
					}
				}
			}
		}
		if(!found_airline){
			System.out.println("Unable to book seat " + row + col + " on " + air_name + " flight " + flID + ", airline was not found.");
		}
		else if(!found_flight){
			System.out.println("Unable to book seat " + row + col + " on " + air_name + " flight " + flID + ", flight was not found.");
		}
	}

	public void bookCabin(String air_name, String flID, CabinClass cc, int row, char col){
		boolean found_airline = false;
		boolean found_flight = false;
		for(int cruiseline=0; cruiseline<cruiselineLL.size(); cruiseline++){
			if(cruiselineLL.get(cruiseline).getName().equals(air_name)){
				found_airline = true;
				for(int cruise=0; cruise<cruiselineLL.get(cruiseline).getConnectionsLL().size(); cruise++){
					if(cruiselineLL.get(cruiseline).getConnectionsLL().get(cruise).getConnection_id().equals(flID)){
						found_flight = true;
						((Cruise) cruiselineLL.get(cruiseline).getConnectionsLL().get(cruise)).bookSeat(cc, row, col);
					}
				}
			}
		}
		if(!found_airline){
			System.out.println("Unable to book cabin " + row + col + " on " + air_name + " cruise " + flID + ", cruiseline was not found.");
		}
		else if(!found_flight){
			System.out.println("Unable to book cabin " + row + col + " on " + air_name + " cruise " + flID + ", cruise was not found.");
		}
	}
	
	public void bookTrainSeat(String air_name, String flID, CarClass sc, int row, char col){
		boolean found_airline = false;
		boolean found_flight = false;
		for(int airline=0; airline<trainlineLL.size(); airline++){
			if(trainlineLL.get(airline).getName().equals(air_name)){
				found_airline = true;
				for(int flight=0; flight<trainlineLL.get(airline).getConnectionsLL().size(); flight++){
					if(trainlineLL.get(airline).getConnectionsLL().get(flight).getConnection_id().equals(flID)){
						found_flight = true;
						((Train) trainlineLL.get(airline).getConnectionsLL().get(flight)).bookSeat(sc, row, col);
					}
				}
			}
		}
		if(!found_airline){
			System.out.println("Unable to book seat " + row + col + " on " + air_name + " flight " + flID + ", airline was not found.");
		}
		else if(!found_flight){
			System.out.println("Unable to book seat " + row + col + " on " + air_name + " flight " + flID + ", flight was not found.");
		}
	}

	public void displayAirlineSystemDetails(){
		System.out.println("\nAirports:");
		for(int airport=0; airport<airportLL.size(); airport++){
			System.out.print(airportLL.get(airport).getPort_name());
			System.out.print(" ");
		}
		System.out.println("\n");

		System.out.println("Airlines and flight information:");
		// for all airlines
		for(int airline=0; airline<airlineLL.size(); airline++){
			System.out.println(airlineLL.get(airline));
		}
	}

	public void displayCruiselineSystemDetails(){
		System.out.println("\nSeaports:");
		for(int seaport=0; seaport<seaportLL.size(); seaport++){
			System.out.print(seaportLL.get(seaport).getPort_name());
			System.out.print(" ");
		}
		System.out.println("\n");

		System.out.println("Cruiselines and cruise information:");
		// for all airlines
		for(int cruiseline=0; cruiseline<cruiselineLL.size(); cruiseline++){
			System.out.println(cruiselineLL.get(cruiseline));
		}
	}
	
	public void displayTrainlineSystemDetails(){
		System.out.println("\nSeaports:");
		for(int trainport=0; trainport<trainportLL.size(); trainport++){
			System.out.print(trainportLL.get(trainport).getPort_name());
			System.out.print(" ");
		}
		System.out.println("\n");

		System.out.println("Trainlines and train information:");
		// for all airlines
		for(int trainline=0; trainline<trainlineLL.size(); trainline++){
			System.out.println(trainlineLL.get(trainline));
		}
	}
	
	
// ========================== Helper Methods =======================================================\
	public boolean isValidPortName(String port_name){
		boolean result = true;
		//Is it the appropriate length?
		if(port_name.length() != 3){
			System.out.println("Port identifier \"" + port_name + "\" invalid: identifier must be three letters long");
			result = false;
		}
		//Is each character a letter?
		for(int character = 0; character < port_name.length(); character++){
			if(!Character.isLetter(port_name.charAt(character))){
				System.out.println("Airport identifier \"" + port_name + "\" invalid: identifier must consist of letters.");
				result = false;
				break;
			}
		}
		return result;
	}
	
	public boolean isValidLineName(String line_name){
		boolean result = true;
		//Is the name the appropriate length?
		if(line_name.length() > 5 || line_name.length() < 1){ // Is the name too long?
			System.out.println("Line name \"" + line_name + "\" invalid: name must be between 1 and 5 characters.");
			result = false;
		}
		//Is each character a letter?
		for(int character = 0; character < line_name.length(); character++){
			if(!Character.isLetter(line_name.charAt(character))){
				System.out.println("Line name \"" + line_name + "\" invalid: name must consist of letters.");
				result = false;
			}
		}
		return result;
	}
	
	public boolean isValidID(String ID){
		boolean result = true;
		// Test length of ID
		if(ID.length() > 6 || ID.length() < 3){
			result = false;
			System.out.println("ID " + ID + " is invalid: ID must be between 3 and 6 characters");
		}
		if(result){
			// Test each character is alphanumeric
			for(int index = 0; index < ID.length(); index++){
				if(!Character.isLetterOrDigit(ID.charAt(index))){
					result = false;
					System.out.println("ID " + ID + " is invalid: characters must be alphanumeric");
					break;
				}
			}
		}
		return result;
	}
	
	//==================== AIR SUBSYSTEM HELPERS =================================================================\
	
	public boolean isAirportInList(String airport_name){
		boolean result = false;
		for(int airport=0; airport<airportLL.size(); airport++){
			if(airportLL.get(airport).getPort_name().equals(airport_name)){
				result = true;
				break;
			}
		}
		return result;
	}
	
	// Get an airport object from the 3-letter identifier. Return null if not found.
	public Airport getAirport(String airport_name){
		Airport result = null;
		for(int index = 0; index < airportLL.size(); index++){
			if(airportLL.get(index).getPort_name().equals(airport_name)){
				result = airportLL.get(index);
				break;
			}
		}
		return result;
	}
	
	public boolean isAirlineInList(String airline_name){
		boolean result = false;
		for(int airline=0; airline<airlineLL.size(); airline++){
			if(airlineLL.get(airline).getName().equals(airline_name)){
				result = true;
			}
		}
		return result;
	}
	
	public Airline getAirline(String airline_name){
		Airline result = null;
		for(int index = 0; index < airlineLL.size(); index++){
			if(airlineLL.get(index).getName().equals(airline_name)){
				result = airlineLL.get(index);
				break;
			}
		}
		return result;
	}
	
	public boolean isFlightInList(String flID, String airline_name){
		boolean result = false;
		Airline airline = getAirline(airline_name);
		if(airline != null){
			for(int index = 0; index < airline.getConnectionsLL().size(); index++){
				if(airline.getConnectionsLL().get(index).getConnection_id().equals(flID)){
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	public Flight getFlight(String flID, String airline_name){
		Flight result = null;
		Airline airline = getAirline(airline_name);
		if (airline != null){
			result = airline.getFlight(flID);
		}
		return result;
	}
	
	
	//==================== SEA SUBSYSTEM HELPERS =================================================================\
	
	public boolean isSeaportInList(String seaport_name){
		boolean result = false;
		for(int seaport=0; seaport<seaportLL.size(); seaport++){
			if(seaportLL.get(seaport).getPort_name().equals(seaport_name)){
				result = true;
				break;
			}
		}
		return result;
	}
	
	// Get an airport object from the 3-letter identifier. Return null if not found.
		public Seaport getSeaport(String seaport_name){
			Seaport result = null;
			for(int index = 0; index < seaportLL.size(); index++){
				if(seaportLL.get(index).getPort_name().equals(seaport_name)){
					result = seaportLL.get(index);
					break;
				}
			}
			return result;
		}
		
		public boolean isCruiselineInList(String cruiseline_name){
			boolean result = false;
			for(int cruiseline=0; cruiseline<cruiselineLL.size(); cruiseline++){
				if(cruiselineLL.get(cruiseline).getName().equals(cruiseline_name)){
					result = true;
				}
			}
			return result;
		}
		
		public Cruiseline getCruiseline(String cruiseline_name){
			Cruiseline result = null;
			for(int index = 0; index < cruiselineLL.size(); index++){
				if(cruiselineLL.get(index).getName().equals(cruiseline_name)){
					result = cruiselineLL.get(index);
					break;
				}
			}
			return result;
		}
		
		public boolean isCruiseInList(String ID, String cruiseline_name){
			boolean result = false;
			Cruiseline cruiseline = getCruiseline(cruiseline_name);
			if(cruiseline != null){
				for(int index = 0; index < cruiseline.getConnectionsLL().size(); index++){
					if(cruiseline.getConnectionsLL().get(index).getConnection_id().equals(ID)){
						result = true;
						break;
					}
				}
			}
			return result;
		}
		
		public Cruise getCruise(String flID, String cruiseline_name){
			Cruise result = null;
			Cruiseline cruiseline = getCruiseline(cruiseline_name);
			if (cruiseline != null){
				result = cruiseline.getCruise(flID);
			}
			return result;
		}
	
	//==================== TRAIN SUBSYSTEM HELPERS ===============================================================\
	
	public boolean isTrainportInList(String trainport_name){
		boolean result = false;
		for(int trainport=0; trainport<trainportLL.size(); trainport++){
			if(trainportLL.get(trainport).getPort_name().equals(trainport_name)){
				result = true;
				break;
			}
		}
		return result;
	}
	
	// Get an airport object from the 3-letter identifier. Return null if not found.
		public Trainport getTrainport(String trainport_name){
			Trainport result = null;
			for(int index = 0; index < trainportLL.size(); index++){
				if(trainportLL.get(index).getPort_name().equals(trainport_name)){
					result = trainportLL.get(index);
					break;
				}
			}
			return result;
		}
		
		public boolean isTrainlineInList(String trainline_name){
			boolean result = false;
			for(int trainline=0; trainline<trainlineLL.size(); trainline++){
				if(trainlineLL.get(trainline).getName().equals(trainline_name)){
					result = true;
				}
			}
			return result;
		}
		
		public Trainline getTrainline(String trainline_name){
			Trainline result = null;
			for(int index = 0; index < trainlineLL.size(); index++){
				if(trainlineLL.get(index).getName().equals(trainline_name)){
					result = trainlineLL.get(index);
					break;
				}
			}
			return result;
		}
		
		public boolean isTrainInList(String ID, String trainline_name){
			boolean result = false;
			Trainline trainline = getTrainline(trainline_name);
			if(trainline != null){
				for(int index = 0; index < trainline.getConnectionsLL().size(); index++){
					if(trainline.getConnectionsLL().get(index).getConnection_id().equals(ID)){
						result = true;
						break;
					}
				}
			}
			return result;
		}
		
		public Train getTrain(String flID, String trainline_name){
			Train result = null;
			Trainline trainline = getTrainline(trainline_name);
			if (trainline != null){
				result = trainline.getTrain(flID);
			}
			return result;
		}
}