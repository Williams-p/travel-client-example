
public class TestRunner {
	public static void main(String[] args){
		SystemManager res = new SystemManager();
		res.createAirport("DEN");
		res.createAirport("DFW");
		res.createAirport("LON");
		res.createAirport("DEN");//invalid
		res.createAirport("DENW");//invalid

		res.createAirline("DELTA");
		res.createAirline("AMER");
		res.createAirline("FRONT");
		res.createAirline("FRONTIER"); //invalid
		res.createAirline("FRONT"); //invalid
		String[] arry1 = {"DEN", "DFW", "LON"};
		String[] arry2 = {"DEN", "DEN"};
		String[] arry3 = {"DEN", "LON"};
		String[] arry4 = {"LON33", "DEN33"};
		String[] arry5 = {"DEN", "LON"};
		String[] arry6 = {"DEN", "DFW"};
		String[] arry7 = {"DEN", "DFW"};
		String[] arry8 = {"DEN"};
		res.createFlight("DELTA", arry1, 2013, 10, 10, "123");
		res.createFlight("DELTA", arry2, 2013, 8, 8, "567abc");		
		res.createFlight("DEL", arry3, 2013, 9, 8, "567"); //invalid airline
		res.createFlight("DELTA", arry4, 2013, 5, 7, "123");//invalid airports
		res.createFlight("AMER", arry5, 2010, 40, 100, "123abc");//invalid date
		res.createFlight("DELTA", arry6, 2013, 40, 100, "123");//invalid repeat flight_ID
		res.createFlight("AMER", arry7, 2013, 40, 100, "123");
		res.createFlight("DELTA", arry8, 2013, 11, 19, "hi420");


		res.createFlightSection("DELTA","123", 2, 2, 1, 2);		
		res.createFlightSection("DELTA","123", 2, 3, 1, 1);
		res.createFlightSection("DELTA","123", 2, 3, 1, 0);//Invalid 
		res.createFlightSection("SWSERTT","123", 5, 5, 1, 2);//Invalid airline
		res.createFlightSection("DELTA","122", 2, 3, 1, 1);//Invalid flID


		res.bookSeat("DELTA", "123", SeatClass.first, 1, 'A');
		res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A');
		res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'B');
		res.bookSeat("DELTA888", "123", SeatClass.business, 1, 'A'); //Invalid airline
		res.bookSeat("DELTA", "123haha7", SeatClass.business, 1, 'A'); //Invalid flightId
		res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A'); //already booked

		res.displayAirlineSystemDetails();

		res.findAvailableFlights("DEN", "LON");
		
		System.out.println("\n\n");
		
		res.createSeaport("DEN");
		res.createSeaport("DFW");
		res.createSeaport("LON");
		res.createSeaport("DEN");//invalid
		res.createSeaport("DENW");//invalid

		res.createCruiseline("DELTA");
		res.createCruiseline("AMER");
		res.createCruiseline("FRONT");
		res.createCruiseline("FRONTIER"); //invalid
		res.createCruiseline("FRONT"); //invalid

		res.createCruise("DELTA", arry1, 2013, 10, 10, "123");
		res.createCruise("DELTA", arry2, 2013, 8, 8, "567abc");		
		res.createCruise("DEL", arry3, 2013, 9, 8, "567"); //invalid airline
		res.createCruise("DELTA", arry4, 2013, 5, 7, "123");//invalid airports
		res.createCruise("AMER", arry5, 2010, 40, 100, "123abc");//invalid date
		res.createCruise("DELTA", arry6, 2013, 40, 100, "123");//invalid repeat flight_ID
		res.createCruise("AMER", arry7, 2013, 40, 100, "123");
		res.createCruise("DELTA", arry8, 2013, 11, 19, "hi420");


		res.createCruiseSection("DELTA","123", 2, 2, 4, 0);		
		res.createCruiseSection("DELTA","123", 2, 3, 4, 2);
		res.createCruiseSection("DELTA","123", 2, 3, 4, 0);//Invalid 
		res.createCruiseSection("SWSERTT","123", 5, 5, 4, 1);//Invalid airline
		res.createCruiseSection("DELTA","122", 2, 3, 4, 3);//Invalid flID


		res.bookCabin("DELTA", "123", CabinClass.family, 1, 'A');
		res.bookCabin("DELTA", "123", CabinClass.couples, 1, 'A');
		res.bookCabin("DELTA", "123", CabinClass.deluxe_family, 1, 'B');
		res.bookCabin("DELTA888", "123", CabinClass.family, 1, 'A'); //Invalid airline
		res.bookCabin("DELTA", "123haha7", CabinClass.deluxe_couples, 1, 'A'); //Invalid flightId
		res.bookCabin("DELTA", "123", CabinClass.couples, 1, 'A'); //already booked

		res.displayCruiselineSystemDetails();

		res.findAvailableCruises("DEN", "LON");
		
System.out.println("\n\n");
		
		res.createTrainport("DEN");
		res.createTrainport("DFW");
		res.createTrainport("LON");
		res.createTrainport("DEN");//invalid
		res.createTrainport("DENW");//invalid

		res.createTrainline("DELTA");
		res.createTrainline("AMER");
		res.createTrainline("FRONT");
		res.createTrainline("FRONTIER"); //invalid
		res.createTrainline("FRONT"); //invalid

		res.createTrain("DELTA", arry1, 2013, 10, 10, "123");
		res.createTrain("DELTA", arry2, 2013, 8, 8, "567abc");		
		res.createTrain("DEL", arry3, 2013, 9, 8, "567"); //invalid airline
		res.createTrain("DELTA", arry4, 2013, 5, 7, "123");//invalid airports
		res.createTrain("AMER", arry5, 2010, 40, 100, "123abc");//invalid date
		res.createTrain("DELTA", arry6, 2013, 40, 100, "123");//invalid repeat flight_ID
		res.createTrain("AMER", arry7, 2013, 40, 100, "123");
		res.createTrain("DELTA", arry8, 2013, 11, 19, "hi420");


		res.createTrainSection("DELTA","123", 2, 2, 1, 1);		
		res.createTrainSection("DELTA","123", 2, 3, 1, 0);
		res.createTrainSection("DELTA","123", 2, 3, 1, 2);//Invalid 
		res.createTrainSection("SWSERTT","123", 5, 5, 1, 0);//Invalid airline
		res.createTrainSection("DELTA","122", 2, 3, 1, 2);//Invalid flID


		res.bookTrainSeat("DELTA", "123", CarClass.economy, 1, 'A');
		res.bookTrainSeat("DELTA", "123", CarClass.business, 1, 'A');
		res.bookTrainSeat("DELTA", "123", CarClass.first, 1, 'B');
		res.bookTrainSeat("DELTA888", "123", CarClass.first, 1, 'A'); //Invalid airline
		res.bookTrainSeat("DELTA", "123haha7", CarClass.economy, 1, 'A'); //Invalid flightId
		res.bookTrainSeat("DELTA", "123", CarClass.business, 1, 'A'); //already booked

		res.displayTrainlineSystemDetails();

		res.findAvailableTrains("DEN", "LON");
	}
}
