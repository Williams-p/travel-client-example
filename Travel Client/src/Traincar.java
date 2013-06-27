// Specialty class extending Section; dependent call upon super class, and sets up the AccommodationsLL object accordingly.
public class Traincar extends Section{

	private CarClass sc;
	
	public Traincar(String air_name, String flID, int rows, int cols, int num, CarClass sc){
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
				TrainSeat s = new TrainSeat(i+1, char_col);
				AccommodationsLL.add(s);
			}
		}
	}
	
	public String toString(){
		String result = "Train Section: " + getCompany_name() + " train " + getFlID() + " " + getRows() + " rows, " + getCols() + " columns, '" + sc + "' class.";
		for(int i = 0; i < AccommodationsLL.size(); i++){
			result += "\n" + AccommodationsLL.get(i).toString();
		}
		return result;
	}
	
	public CarClass getSection(){
		return sc;
	}
}