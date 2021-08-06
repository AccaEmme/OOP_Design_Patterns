//il singleton mi assicura che della classe (che è un singleton) nel sistema ne esista una sola istanza.
// non potrò mai chiamarla con Singleton s = new Singleton(); quindi non deve avere un costruttore pubblico

/*
 * I pattern sono soluzioni stabili a problemi ricorrenti, tutti i design pattern hanno un nome, un problema e una soluzione.

	Il singleton è ottimo quando dobbiamo accedere a risorse condivise (es. implementiamo una sorte di spooler di stampa, gestire cache, risorse, ...) tuti i casi in cui serve una sola istanza.

L'abuso di questo pattern può creare problemi di dipendenza.
Dobbiamo ridurre il più possibile le dipendenze tra i vari moduli.
Una dipendenza si crea quando si utilizza una classe singleton per memorizzare variabili globali del sistema.
Nell'esempio del Singleton come si creano le dipendenze? Si vengono a creare quando usiamo la classe Singleton per memorizzare variabili globali del sistema, 
tutti i moduli del sistema accederanno a questa classe, questo comporterà sia un problema di dipendenze, sia che la classe singleton non farà più una sola cosa ma ne farà diverse.
e questo va a violare il principio SRP - Single Responsive Principle.

fare esempio: Singleton DBConnection

 * 
 */

public class DriverTest {
	public static void main(String[] args) { 
		Singleton s  = Singleton.generateInstance("Hermann");
		
		Singleton s2 = Singleton.generateInstance("Roxana");	

		String msg1 = s.getMsg();
		String msg2 = s2.getMsg();
		
		if( msg1.equals(msg2) )
			System.out.println("ok " + s + " - " + s2);
		else
			System.out.println("not equals" + s);
		
		Singleton.destroyInstance();
		System.out.println("destroyed: " + s + " - " + s2);
		
		if( s2 == null ) System.out.println("s is null");
	}
}
