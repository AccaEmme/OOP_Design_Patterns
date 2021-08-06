import java.util.ArrayList;
import java.util.List;

public class Sensor implements Subject {
	private List<Observer> observers = new ArrayList<>();
	
	public void readData() {
		// routine di lettura dei dati
		notifyObservers(); // questo significa che di tutti gli observer verrà chiamato il metodo update.
	}
	
	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {// usare direttamente i metodi della lista è sbagliato, espongo con un nome consistente ciò che mi serve.
		observers.remove(o); 
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update();
		}
		
	}

}
