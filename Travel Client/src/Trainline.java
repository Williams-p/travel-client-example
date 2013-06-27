// The Trainline class is responsible for the name of the Trainline it represents,
// and the flights associated with that airline.
public class Trainline extends TravelCompany{	
	
	// Constructor
	public Trainline(String trainline_name){
		super(trainline_name);
	}
	
	public String toString(){
		String result = "\nTrainline: " + getName();
		for(int i = 0; i < connectionsLL.size(); i++){
			result += "\n" + connectionsLL.get(i).toString();
		}
		return result;
	}
	
	public Train getTrain(String flID){
        Train result = null;
        for(int index = 0; index < connectionsLL.size(); index++){
                if(connectionsLL.get(index).getConnection_id().equals(flID)){
                        result = (Train) connectionsLL.get(index);
                        break;
                }
        }
        return result;
	}
}
