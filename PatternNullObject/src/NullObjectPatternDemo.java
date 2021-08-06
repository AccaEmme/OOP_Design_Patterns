/*
Il Null Object pattern rientra tra i design comportamentali dei design pattern
è molto utilizzato perché consente di evitare che si verifichino tutte le fastidiosissime "Null Pointer Exception" 
che derivano da controlli non effettuati da parte dei programmatori.

In ogni punto del programma in cui c'è pericolo di generare una Null Pointer Exception,
lo si sostituisce con un oggeto vuoto che non fa nulla.

Creiamo una classe astratta e una concreta,
avranno entrambe un metodo booleano isNil

 */

abstract class AbstractCustomer{
	protected String name;
	public abstract boolean isNil();
	public abstract String getName();
}

class RealCustomer extends AbstractCustomer{// la classe concreta
	public RealCustomer(String name) {
		this.name = name; // this.name non da errore perché lo ereditiamo dalla classe astratta
	}
	
	@Override
	public boolean isNil() { // sei un oggetto creato per gestire i riferimenti a null? False, sono il RealCustomer.
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	} 
	
}

class NullCustomer extends AbstractCustomer{
	@Override
	public boolean isNil() { // poiché è un metodo per verificare se è un oggetto di tipo Null, dovrà restituire true. Sono un oggetto creato per evitare un riferimento a null.
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Not Available in customer database";
	}
}

class CustomerFactory{
	public static final String[] names = {"Rob", "Joe", "Julie"};
	
	public static AbstractCustomer getCustomer(String name) {
		// ritorna un riferimento a un oggetto di tipo AbstractCustomer
		for(int i=0; i<names.length; i++) {
			if(names[i].equalsIgnoreCase(name)) {
				return new RealCustomer(name);
			}
		}
		return new NullCustomer();
	}
}



public class NullObjectPatternDemo {
	public static void main(String[] args) {
		// richiamo la factory 4 volte e vediamo se si trova nel nostro piccolo "DB virtuale" (l'array)
		AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
		AbstractCustomer customer2 = CustomerFactory.getCustomer("Joe");
		AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
		AbstractCustomer customer4 = CustomerFactory.getCustomer("Bob"); // dovrebbe restituire un "null" se non avessimo la NullObjectPattern

		System.out.println("Customers:");
		System.out.println("\t 1) " + customer1.getName() + " - è nullo? " + customer1.isNil() );
		System.out.println("\t 2) " + customer2.getName());
		System.out.println("\t 3) " + customer3.getName());
		System.out.println("\t 4) " + customer4.getName());
		
	}
}
