
public class Airport {
	/*
	 * An	airport	must	have	a	name	consisting	of	exactly	three	alphabetic	characters.	No	two	airports	can	have	the	same	name.
	 * 
	 * createAirport(String n)
	 * 
	 * todo
	 * 	airport_name only letters
	 * 
	 */
	private String airport_name;
	
	public String createAirport(String n){
		if (n.length() == 3){
			airport_name = n;
			return airport_name;
		}
		else 
			return "eeeeeeeeeerrrrrrrrrrrrrroooooooooooooooooorrrrrrrrrrrrrrrrr";
	}
	
	
	
}
