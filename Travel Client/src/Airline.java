// The Airline class is responsible for the name of the airline it represents,
// and the flights associated with that airline.
public class Airline extends TravelCompany{	
	
	// Constructor
	public Airline(String airline_name){
		super(airline_name);
	}
	
	public String toString(){
		String result = "\nAirline: " + getName();
		for(int i = 0; i < connectionsLL.size(); i++){
			result += "\n" + connectionsLL.get(i).toString();
		}
		return result;
	}
	
	public Flight getFlight(String flID){
        Flight result = null;
        for(int index = 0; index < connectionsLL.size(); index++){
                if(connectionsLL.get(index).getConnection_id().equals(flID)){
                        result = (Flight) connectionsLL.get(index);
                        break;
                }
        }
        return result;
	}
}
