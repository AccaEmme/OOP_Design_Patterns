import java.awt.Color;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;



/*
https://www.baeldung.com/java-flyweight

Questo pattern viene usato per ridurre le impronte di memoria
e può anche implementare performance nelle applicazioni dove l'instantiation is expensive.

semplicemente il flyweight è basato sulla factory la quale ricicla gli oggetti creati salvandoli dopo la creazione.

Ogni volta che un oggetto viene richiesto, la factory cerca gli oggetti in ordine per controllare se sono già stati creati
Se presente, l'oggetto esistente viene ritornato altrimenti ne viene creato uno nuovo

Lo stato dell'oggetto flyweight è composto da componenti non variabili condivisi, con altri simili oggetti (intrinsic)
e componenti variabili che possono essere manipolati dal client code(extrinsic)


PROBLEMA: eccessiva creazione di oggetti simili
SOLUZIONE: Cerca se già presente sennò lo crea

GOAL:
 - data compression: ridurre la memoria utilizzata condividendo più dati possibili
 - data caching: il flyweight pattern è simile a concetti di caching, sebbene ci sono qualche differenze chiave di complessità e implementazione tra questo pattern rispetto a un general-purpose cache.

Implementazione:
gli elementi principali di questo pattern sono
 - un'interfaccia che definisce le operazioni che il client code può perform sul flyweight object
 - una o più concrete implementazioni della prporia interfaccia
 - una factory per gestire l'istanziazione degli oggetti e il caching.
 */

interface Vehicle{
	public void start();
	public void stop();
	public Color getColor();
}

class Engine{
	//private final static Logger LOG = LoggerFactory.getLogger(Engine.class);
	PrintStream LOG = System.out;
	
	public void start() {
		//LOG.info("Engine is starting!");
		LOG.print("Engine is starting!");
	}
	
	public void stop() {
		//LOG.info("Engine is stopping!");
		LOG.print("Engine is stopping!");
	}
}

class Car implements Vehicle { // a concrete vehicle
	//private final static Logger LOG = LoggerFactory.getLogger(Car.class); // logger
	PrintStream LOG = System.out;
	private Engine engine; // the car engine
	private Color color;  // the car's color
	
	/**
	 * Instantiates a new Car.
	 *
	 * @param engine
	 *            the {@link #engine}
	 * @param color
	 *            the {@link #color}
	 */
	public Car(Engine engine, Color color) {
		this.engine = engine;
		this.color = color;

		// Building a new car is a very expensive operation!
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			//LOG.error("Error while creating a new car", e);
			LOG.print("Error while creating a new car " + e);
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		//LOG.info("Car is starting!");
		LOG.print("Car is starting!");
		engine.start();
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		//LOG.info("Car is stopping!");
		LOG.print("Car is stopping!");
		engine.stop();
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}
}

class VehicleFactory{
	// salva i veicoli già creati
	private static Map<Color, Vehicle> vehiclesCache = new HashMap<Color, Vehicle>();

	// costruttore privato per prevenire l'istanziazione della classe
	private VehicleFactory() {};
	
	public static Vehicle createVehicle(Color color) {
		Vehicle newVehicle = vehiclesCache.computeIfAbsent(color, newColor->{
			Engine newEngine = new Engine();
			return new Car(newEngine, newColor);
		});
		return newVehicle;
	}
}

public class FlyweightPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
