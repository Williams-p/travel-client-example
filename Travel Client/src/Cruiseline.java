// The Airline class is responsible for the name of the airline it represents,
// and the flights associated with that airline.
public class Cruiseline extends TravelCompany{	
	
	// Constructor
	public Cruiseline(String trainline_name){
		super(trainline_name);
	}
	
	public String toString(){
		String result = "\nCruiseline: " + getName();
		for(int i = 0; i < connectionsLL.size(); i++){
			result += "\n" + connectionsLL.get(i).toString();
		}
		return result;
	}
	
	public Cruise getCruise(String flID){
        Cruise result = null;
        for(int index = 0; index < connectionsLL.size(); index++){
                if(connectionsLL.get(index).getConnection_id().equals(flID)){
                        result = (Cruise) connectionsLL.get(index);
                        break;
                }
        }
        return result;
	}
}