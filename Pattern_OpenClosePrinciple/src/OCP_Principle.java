/*
https://www.youtube.com/watch?v=xq6uSFsd6Dk

OCP Principle rientra tra i principi SOLID.
Open-Closed Principle definisce che un'opera software dovrebbe essere aperta alle estensioni, ma chiusa alle modifiche

Problema: supponiamo di avere un'applicazione utile per gestire le spese personali "MovimentData" e che allo stato attuale 
l'applicazione generi un report che viene stampato a schermo "MovementReport" con una propria 
formattazione (colori differenti in base al tipo di movimento, etc...). 
Immaginiamo di dover ampliare questa reportistica, in quel caso dovremmo mettere mano al codice già consolidato con diversi 
rischi legati al caso, per non parlare al lavoro in più che si farebbe. Questa soluzione non rispetta "OCP Principle" 
perché non estendiamo nulla modifichiamo solo la classe e ciò è sbagliato.

La soluzione risiede nell'astrazione, permessa tramite una interfaccia, e consente di rendere di rendere una classe sì immutabile
ma facilmente sentibile da classi concrete che realizzano comportamenti diversi.

Seppur non perfetta, questa soluzione rispetta "OCP Principle".

Le dipendenze devono essere spostate verso l'esterno della gerarchia così da proteggere dalle modifiche quei moduli che 
contengono logiche operative(service e controller)

 */

class MovementData{ // Questa classe simula una classe che gestisce la persistenza dati sul DB
	
	public String readData() { // recupera i dati con una SELECT dal DB ritornando una stringa.
		return "Dati DB";
	}
	/*
	 * Qui altri metodi C.R.U.D.
	 */
}

// introduciamo OCP:
class MovementReportService {
	public String getDataForReport() {
		MovementData md = new MovementData();
		return md.readData();
	}
}

interface MovementReportOutput{
	public void printReport();
}

class MovementReportScreen implements MovementReportOutput{
	@Override
	public void printReport() {
		// TODO Auto-generated method stub
		MovementReportService service = new MovementReportService();
		System.out.println( service.getDataForReport() + " formattati per schermo");
	}
}

class MovementReportPaper implements MovementReportOutput{
	@Override
	public void printReport() {
		// TODO Auto-generated method stub
		MovementReportService service = new MovementReportService();
		System.out.println( service.getDataForReport() + " formattati per carta");
	}
}

// Si va a creare una sorta di gerarchia, in cui il livello più interno viene protetto dalle modifiche che avvengono in quello più esterno. Rispettando il principio OCP.


class MovementReportWeb{
	/* CASO BASE:
	public void printOnWebReport() {
		MovementData md = new MovementData();
		System.out.println(md.readData() + " per la stampa su Report web con formattazione di tipo A ");
	}
	*/
	
	// ------------
	/* SCELTA SBAGLIATA:
	public void printOnWebReport(String tipologiaStampa) {
		MovementData md = new MovementData();
		if(tipologiaStampa.equals("A"))
			System.out.println(md.readData() + " per la stampa su Report web con formattazione di tipo A ");
		else
			System.out.println(md.readData() + " per la stampa su Report web con formattazione di tipo B ");
	}
	*/
	
	// ------------UTILIZZANDO OCP Principle: introduciamo un'interfaccia tra service e layer di visualizzazione questo permetterà di implementare tante classi concrete che si attengono a un contratto stabilito dall'interfaccia, implementando le risoluzioni in base alle esigenze soprattutto quella del service che va protetta.
	
	
}

public class OCP_Principle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
