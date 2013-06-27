
public class Airline {
	/*
	 * An	airline	has	a	name	that	must	have	a	length	less	than	6.	No	two	airlines	can	have	the	same	name.
	 * 
	 * createAirline(String	n)
	 * 
	 * todo
	 * 	airline_name only letters
	 * 
	 */
	
	private String airline_name;
	
	public String createAirline(String	n){
		if(n.length() < 6 && n.length() > 0){
			airline_name = n;
			return airline_name;
		}
		else
			return "eeeeeeeeeerrrrrrrrrrrrrroooooooooooooooooorrrrrrrrrrrrrrrrr invalid airline name length";
	}
	
}
