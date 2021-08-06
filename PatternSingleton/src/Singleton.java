
public class Singleton {
	private static Singleton instance; // la classe Singleton gestisce un'istanza dello stesso tipo della classe. Questa classe è tutta privata, tranne un metodo pubblico. Poiché un metodo statico accede alla variabile, anche la variabile deve essere statica.
	private static String	 msg;
	
	private Singleton(String msg) { this.msg = msg; }
	
	public static Singleton generateInstance(String msg) { // è l'unico metodo pubblico, che ritorna la classe stessa. Poiché non può essere associato all'istanza visto che l'istanza non può essere creata con new, devo definirlo come static.
		if( instance == null ) // evitiamo di sovrascrivere la precedente
			instance = new Singleton(msg); // qui posso chiamarlo perché il costrture essendo privato è accessibile dai metodi della classe
		return instance;
	}
	
	public String getMsg() {
		return msg;
	}
	
	
	public static void destroyInstance() {
		instance = null;
	}
}
