
public class Singleton {
	private static Singleton instance; // la classe Singleton gestisce un'istanza dello stesso tipo della classe. Questa classe � tutta privata, tranne un metodo pubblico. Poich� un metodo statico accede alla variabile, anche la variabile deve essere statica.
	private static String	 msg;
	
	private Singleton(String msg) { this.msg = msg; }
	
	public static Singleton generateInstance(String msg) { // � l'unico metodo pubblico, che ritorna la classe stessa. Poich� non pu� essere associato all'istanza visto che l'istanza non pu� essere creata con new, devo definirlo come static.
		if( instance == null ) // evitiamo di sovrascrivere la precedente
			instance = new Singleton(msg); // qui posso chiamarlo perch� il costrture essendo privato � accessibile dai metodi della classe
		return instance;
	}
	
	public String getMsg() {
		return msg;
	}
	
	
	public static void destroyInstance() {
		instance = null;
	}
}
