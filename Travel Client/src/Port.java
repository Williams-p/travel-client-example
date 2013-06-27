// Port class; just a placeholder for a port name.
// Name validation tests are handled by SystemManger.
public abstract class Port {
	
	protected String port_name;
	
	// Constructor
	public Port(String port_name){
		if (port_name.length() == 3){
			setPort_name(port_name);
		}
	}
	
	//Getters and Setters
	public void setPort_name(String port_name){
		this.port_name = port_name;
	}
	public String getPort_name(){
		return port_name;
	}
}
