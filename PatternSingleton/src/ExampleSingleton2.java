class DBConnection{
	private static DBConnection instance = null;
	private DBConnection() {};
	
	public static DBConnection getInstance() {
		if(instance == null)
			instance = new DBConnection();
		return instance;
	}
	
}


public class ExampleSingleton2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getInstance();
		DBConnection db2 = DBConnection.getInstance();
		
		if(db == db2)
			System.out.println("Sono uguale");
		else
			System.out.println("Sono diverso");
	}

}
