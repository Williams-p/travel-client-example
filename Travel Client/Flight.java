
public class Flight {
	/*
	 * Create a flight	given an airline name, the name	of an originating airport, the name	of a destination airport, a	flight number, and a departure date:	
	 * A flight	has	an identifier that is a	string of alphanumeric characters.
	 * 
	 * createFlight(String flight_name, String orig, String dest, int year, int month, int day, String flight_id): 
	 * Creates a flight for an airline named flight_name, from an originating airport (orig) to a destination airport (dest) on a particular date. The flight has an identifier(flight_id).
	 * 
	 * todo
	 * 	
	 * 
	 */
	
	private String flight_id;
	private String flight_name;
	private String orig;
	private String dest;
	private int year;
	private int month;
	private int day;
	
	public void createFlight(String flight_id_in, String flight_name_in, String orig_in, String dest_in, int year_in, int month_in, int day_in){
		setFlight_id(flight_id_in);
		setFlight_name(flight_name_in);
		setOrig(orig_in);
		setDest(dest_in);
		setYear(year_in);
		setMonth(month_in);
		setDay(day_in);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String getOrig() {
		return orig;
	}

	public void setOrig(String orig) {
		this.orig = orig;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
}
