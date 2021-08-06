
public class DataReader implements Observer {
	private final String name;

	public DataReader(String readerName) {
		// TODO Auto-generated constructor stub7
		name = readerName;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Received data from sensor. - " + name);
	}

}
