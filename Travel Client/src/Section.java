import java.util.LinkedList;


public abstract class Section {
	/*
	 * This class maintains information about flight sections. A flight section has a seat class (first, business or economy) and must have at least 1 seat.
	 * A flight section can contain at most 100 rows of seats and at most 10 columns of seats.
	 * 
	 * createSection(String	air, String flID, int rows, int cols, SeatClass s): Creates a section, of class s, for a flight with identifier flID, associated with an airline, air.
	 * The	section	will contain the input number of rows and columns.
	 * 
	 * todo
	 * 	
	 * 	flight sections can not be changed if a seat has already been booked
	 * 
	 */
	
	protected String air_name;
	protected String flID;
	protected int rows;
	protected int cols;
	LinkedList<Accommodations> AccommodationsLL = new LinkedList<Accommodations>();
	
	
	// Constructor
	public Section(String air_name, String flID, int rows, int cols, int num_per){
		setAir_name(air_name);
		setFlID(flID);
		setRows(rows);
		setCols(cols);
	}
	
	// Book a seat in this section
	public void bookSeat(int row, char col){
		if(row > rows || row < 0){ // Is the row number within the valid range?
			System.out.println("Unable to book seat " + row + col + " on flight " + flID + ": 'row' out of range (1-" + rows + ").");
		}
		else if(getColumnInt(col) > cols || getColumnInt(col) < 0){
			System.out.println("Unable to book seat " + row + col + " on flight " + flID + ": 'col' out of range (A-" + col + ").");
		}
		for(int index = 0; index < AccommodationsLL.size(); index++){
			Accommodations acc = AccommodationsLL.get(index);
			if(acc.getCol() == col && acc.getRow() == row){
				boolean booked = false;
				for(int i = 0; i < acc.getCapacity(); i++){
					if(acc.getStatus(i) == 'e'){
						acc.setStatus(i, 'b');
						booked = true;
						break;
					}
				}
				if(!booked){
					System.out.println("Unable to book accommodation " + row + col + " on flight " + flID + ": accommodation is already booked to capacity.");
				}
			}
		}
	}
	
	
	//Does this section have at least one empty seat?
	public boolean hasEmptySeat(){
		boolean result = false;
		for(int index = 0; index < AccommodationsLL.size(); index++){
			if(!AccommodationsLL.get(index).is_full()){
				result = true;
				break;
			}
		}
		return result;
	}
	
	// Return the integer value of a character-represented column
	public int getColumnInt(char col){
		int result = -1;
		switch(col){
			case 'A':	result = 0;
				break;
			case 'B':	result = 1;
				break;
			case 'C':	result = 2;
				break;
			case 'D':	result = 3;
				break;
			case 'E':	result = 4;
				break;
			case 'F':	result = 5;
				break;
			case 'G':	result = 6;
				break;
			case 'H':	result = 7;
				break;
			case 'I':	result = 8;
				break;
			case 'J':	result = 9;
				break;
			default :	result = -1;
		}
		return result;
	}
	
	
	//Return the character value of an integer-represented column
	public char getColumnChar(int col){
		char result = 'z';
		switch(col){
			case 0:	result = 'A';
				break;
			case 1:	result = 'B';
				break;
			case 2:	result = 'C';
				break;
			case 3:	result = 'D';
				break;
			case 4:	result = 'E';
				break;
			case 5:	result = 'F';
				break;
			case 6:	result = 'G';
				break;
			case 7:	result = 'H';
				break;
			case 8:	result = 'I';
				break;
			case 9:	result = 'J';
				break;
			default :	result = 'O';
		}
		return result;
	}
	
	//Getters and Setters
	public String getCompany_name() {
		return air_name;
	}

	public void setAir_name(String air) {
		this.air_name = air;
	}
	
	public String getFlID() {
		return flID;
	}

	public void setFlID(String flID) {
		this.flID = flID;
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public LinkedList<Accommodations> getAccommodationsLL(){
		return AccommodationsLL;
	}
}
