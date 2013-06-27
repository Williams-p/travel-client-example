import java.util.LinkedList;

public class TravelCompany {	
	
	protected String company_name;
	protected LinkedList<Connection> connectionsLL = new LinkedList<Connection>(); //TODO fix
	
	public TravelCompany(String company_name){
		setCompany_name(company_name);
	}	
	
	public void AddConnection(Connection s){
		connectionsLL.add(s);
	}
	
	public void setCompany_name(String airline_name){
		this.company_name = airline_name;
	}
	
	public String getName(){
		return company_name;
	}
	
	public LinkedList<Connection> getConnectionsLL(){
		return connectionsLL;
	}
}
