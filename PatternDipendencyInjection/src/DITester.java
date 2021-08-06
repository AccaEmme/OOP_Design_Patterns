/*
 * https://www.youtube.com/watch?v=HR4iEIRpeUU
 * 
 * usato molto anche da framework come spring per il backend e angular per il front-end
 * 
 *  problema da risolvere: vogliamo ridurre la quantità di dipendenze dannose tra classi. Normalmente nella programmazione procedurale è il codice di una classe a chiamare il codice di un'altra classe, attraverso la creazione di un oggetto. Questo vogliamo limitarlo (es. quando facciamo new e passiamo i parametri) quell'atto di creazione spesso crea dipendenze dannose che posson essere evitate (es. come se una macelleria oltre a tagliare la carne la creasse anche, è sbagliato. la macelleria riceve la carne iniettata e la lavora)
 *  soluzione: la dipendency injection è un design pattern creazionale che permette il trasferimento del controllo del flusso di un programma a un framework o a un container(una classe che gestisca questa cosa).
 *  
 *  Avrete sentito parlare di "inversion of control" o "class of control": la Dipendency injection no nè altro che uno dei modi per applicare l'inversione di controllo.
 *  
 *  Due classi comunicano attraverso un "controller di dipendenza" che
 *  La classe A utilizza una interfaccia per il disaccoppiamento, questa interfaccia non è altro che la classe B.
 *  Comunicheranno attraverso un oggetto esterno che chiameremo "dependency controller" (injector) che crea un'associazione tra la classe chiamante e la classe chiamata.
 *  
 *  Vantaggi:
 *   - aumento del disaccoppiamento tra le classi
 *   - la classe chiamante fa solo una cosa
 *   - possiamo iniettare a runtime le dipendenze
 *   
 *   3 modi di utilizzo della Dipendency Injection:
 *    - Constructor Injection: la più utilizzata, spesso in angular.
 *    - Property Injection: spesso utilizzata in spring con l'auto-wired di un qualcosa che vogliamo inniettare
 *    - Method Injection: non viene utilizzato perché crea dipendenze circolari tra le classi.
 *    
 *    Inversion of control vs Dependency Injection
IoC is a generic term meaning that rather than having the application call the implementations provided by a library (also know as toolkit),
a framework calls the implementations provided by the application.

DI is a form of IoC, where implementations are passed into an object through constructors/setters/service lookups, which the object will 'depend' on in order to behave correctly.

IoC without using DI, for example would be the Template pattern because the implementation can only be changed through sub-classing.

DI frameworks are designed to make use of DI and can define interfaces (or Annotations in Java) to make it easy to pass in the implementations.

IoC containers are DI frameworks that can work outside of the programming language. In some you can configure which implementations to use in metadata files (e.g. XML) which are less invasive. With some you can do IoC that would normally be impossible like inject an implementation at pointcuts.

---
La dependency inversion è un principio SOLID,
mentre la dependency injection è un pattern che si avvale dell'inversion of control.
 */

class Engine{
	private String cilindrata;
	
	public Engine(String cilindrata) {
		this.cilindrata=cilindrata;
	}
	
	public void setCilindrata(String c) {
		this.cilindrata=c;
	}
	
	public String getCilindrata() {
		return this.cilindrata;
	}	
}

class Car{
	/*
	Engine engine;
	public Car() {
		this.engine = new Engine("2000cc"); //QUI creiamo il problema, creiamo una dipendenza fortissima. La car deve semplicemente gestire i suoi oggetti, non deve crearli, creandoli crea una dipendenza molto forte. Come il macellaio che deve tagliare la carne non crearla.
		// se noi volessimo cambiare questa cilindrata? Dovremmo cambiarla dalla classe Car, ma questo è sbagliato perché in un contesto più ampio in cui queste classi non sono accessibili possiamo solo creare la classe più esterna e metterci le mani e non potendo cambiare all'interno della classe car praticamente avremmo problemi.
	}
	*/
	
	/* 
	// SCENARIO2:
	Engine engine;
	public Car(Engine engine) {// già così è diverso, stiamo applicando dipendency injection, inseriamo un motore nella classe Car. Quindi la Car non si preoccuperà più di creare un motore, ma solo di usarlo.
		this.engine = engine;
	}
	*/
	
	// SCENARIO3:
	IEngine iengine;
	public Car(IEngine engine) {// già così è diverso, stiamo applicando dipendency injection, inseriamo un motore nella classe Car. Quindi la Car non si preoccuperà più di creare un motore, ma solo di usarlo.
		this.iengine = engine;
	}
}

// volendo astrarre ancora di più questo concetto, dobbiamo usare un'interfaccia perché un motore può essere diesel, benzina, ...
interface IEngine{
	String getEngineType();
	String getCilindrata();
	void setCilindrata(String cilindrata);
}

class EngineOil implements IEngine{
	private String cilindrata;
	
	public EngineOil(String cilindrata) {
		// TODO Auto-generated constructor stub
		this.cilindrata=cilindrata;
	}

	@Override
	public String getEngineType() {
		// TODO Auto-generated method stub
		return "Motore a benzina";
	}

	@Override
	public String getCilindrata() {
		// TODO Auto-generated method stub
		return this.cilindrata;
	}

	@Override
	public void setCilindrata(String cilindrata) {
		// TODO Auto-generated method stub
		this.cilindrata=cilindrata;
	}
}

class EnginePower implements IEngine{
	String cilindrata;
	
	public EnginePower(String cilindrata) {
		// TODO Auto-generated constructor stub
		this.cilindrata=cilindrata;
	}
	
	@Override
	public String getEngineType() {
		// TODO Auto-generated method stub
		return "Motore elettrico";
	}

	@Override
	public String getCilindrata() {
		// TODO Auto-generated method stub
		return this.cilindrata;
	}

	@Override
	public void setCilindrata(String cilindrata) {
		// TODO Auto-generated method stub
		this.cilindrata=cilindrata;
	}
}


public class DITester {

	public static void main(String[] args) {
		// -------------Problema:
		/*
		 Car car = new Car();	
		 System.out.println( car.engine.getCilindrata() );
		*/
		
		// -------------Usiamo la dipendency injection:
		/*
		// quindi il main si preoccuperà di:
		Engine engine = new Engine("1500cc");
		Car car = new Car(engine);
		// in questo caso siamo liberi anche a runtime di cambiare questa cilindrata, che è il nostro scopo.
		System.out.println( car.engine.getCilindrata() );
		*/
		
		// -------------Usiamo l'interfaccia:
		IEngine engine = new EngineOil("1500cc"); // li definisco a runtime
		Car car = new Car(engine);
		// in questo caso siamo liberi anche a runtime di cambiare questa cilindrata, che è il nostro scopo.
		System.out.println( car.iengine.getEngineType() );
		
	}

}
