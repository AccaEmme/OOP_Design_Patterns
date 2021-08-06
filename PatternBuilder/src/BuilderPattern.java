/*
Il pattern builder è molto importante, ci consente di configurare degli oggetti con costruttore complesso,
con elevato numero di variabili di istanza, in un modo che sia il più possibile leggibile
e chiaro nell'utilizzo di questo oggetto.

Immaginiamo di avere un negozio con 5 variabili d'istanza
il Patter Builder oltre a istanziare le variabili dell'oggetto non necessariamente tutte insieme (può portare a problemi di null object?)
potrebbe aiutare a rendere il codice più leggibile. 

In primis devo impedire la creazione dell'oggetto costruttore definito.
Definiamo il costruttore come privato, così non lo rendiamo accessibile da altre classi.

Il Bulder abbiamo detto che crea un oggetto di tipo builder.
Voglio che la classe builder mi metta a disposizione un insieme di setters diversi dai setter normali.

Per ritornare questa fluent interface ovvero un metodo di setter che ritorna se stesso,
devo far sì che tutti i settersi ritornino un oggetto di tipo Bulder e nello specifico return this;

Creo man mano il mio oggetto tenendo conto che i default sono già stati creati all'interno del builder, quindi non posso sbagliarmi.
Potrei anche non impostare nessun valore di default.
 */


class Negozio{
	private int 	codice;
	private String 	proprietario;
	private String 	indirizzo;
	private boolean inCentroCommerciale;
	
	private Negozio() {}
	

	
	@Override
	public String toString() {
		return "Negozio [codice=" + codice + ", proprietario=" + proprietario + ", indirizzo=" + indirizzo
				+ ", inCentroCommerciale=" + inCentroCommerciale + "]";
	}



	public static class Builder { // innerclass
		// avrà un costruttore che avrà nessuna o tutte le variabili d'istanza.
	
		
		private int 	codice;
		private String 	proprietario;
		private String 	indirizzo;
		private boolean inCentroCommerciale;
		
		public Builder(int codice) {
			this.codice = codice;
			this.proprietario="";
			this.indirizzo="";
			this.inCentroCommerciale=false;
		}
		
		public Negozio build() {
			// all'interno crea un negozio a partire dalla classe interna.
			// essendo una inner class ha accesso alle variabili private della classe che la contiene.
			// questo metodo prende i valori 
			Negozio negozio 			= new Negozio();
			negozio.codice 				= this.codice;
			negozio.proprietario 		= this.proprietario;
			negozio.indirizzo 			= this.indirizzo;
			negozio.inCentroCommerciale = this.inCentroCommerciale;
			return negozio;
		}

		/**
		 * @param proprietario the proprietario to set
		 */
		public Builder setProprietario(String proprietario) {
			this.proprietario = proprietario;
			return this;
		}

		/**
		 * @param indirizzo the indirizzo to set
		 */
		public Builder setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
			return this;
		}

		/**
		 * @param inCentroCommerciale the inCentroCommerciale to set
		 */
		public Builder setInCentroCommerciale(boolean inCentroCommerciale) {
			this.inCentroCommerciale = inCentroCommerciale;
			return this;
		}
	}
}


public class BuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Negozio negozio = new Negozio(2345, "Mario Rossi", "via Roma 1, Avellino", false);
		Negozio negozio = new Negozio.Builder(2345)
				.setProprietario("Mario Rossi")
				.setIndirizzo("via Roma, 1 - Avellino")
				.setInCentroCommerciale(true).build();
		System.out.println( negozio.toString() );
	}

}
