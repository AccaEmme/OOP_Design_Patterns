/*
 * Esempio di un sensore azionato da due "macchine" di generazione dati.
 * Da tutorial: https://www.youtube.com/watch?v=IvKZJQdtcag
 * @author Hermann
 */


public class TestDriven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sensor s = new Sensor();
		DataReader dr = new DataReader("reader 1");
		DataReader dr2 = new DataReader("reader 2");
		
		s.register(dr); // ho creato il collegamento. Se il mio sensore legge i dati, verrà notificato nel reader 1.
		s.register(dr2); 
		
		s.readData();
		
		s.unregister(dr2);
		s.readData();
	
	}

}
