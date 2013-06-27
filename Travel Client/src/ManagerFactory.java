
public interface ManagerFactory {
	public Port createPort(String s);
	public TravelCompany createLine(String s);
	public Connection createConnection(String port_name, String[] route, int year, int month, int day, String connection_id);
	public Section createSection(String line_name, String connection_ID, int rows, int cols, int num, int class_type);
}
