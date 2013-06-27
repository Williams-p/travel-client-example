// Specialty class extending Section; dependent call upon super class, and sets up the AccommodationsLL object accordingly.
public class FlightSection extends Section{

	private SeatClass sc;
	
	public FlightSection(String air_name, String flID, int rows, int cols, int num, SeatClass sc){
		super(air_name, flID, rows, cols, 1);
		createSeats(rows, cols);
		this.sc = sc;
	}
	
	public void createSeats(int rows, int cols){
		char char_col = 0;
		for(int i=0; i<rows; i++){
			for(int y=0; y<cols; y++){
				
				switch(y){
				case 0:	char_col = 'A';
						break;
				case 1:	char_col = 'B';
						break;
				case 2:	char_col = 'C';
						break;
				case 3:	char_col = 'D';
						break;
				case 4:	char_col = 'E';
						break;
				case 5:	char_col = 'F';
						break;
				case 6:	char_col = 'G';
						break;
				case 7:	char_col = 'H';
						break;
				case 8:	char_col = 'I';
						break;
				case 9:	char_col = 'J';
						break;
				default :	char_col = 'O';
				}
				Seat s = new Seat(i+1, char_col);
				AccommodationsLL.add(s);
			}
		}
	}
	
	public String toString(){
		String result = "Flight Section: " + getCompany_name() + " flight " + getFlID() + " " + getRows() + " rows, " + getCols() + " columns, '" + sc + "' class.";
		for(int i = 0; i < AccommodationsLL.size(); i++){
			result += "\n" + AccommodationsLL.get(i).toString();
		}
		return result;
	}
	
	public SeatClass getSection(){
		return sc;
	}
}