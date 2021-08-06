package way.bad;

/*
principio LSP:
� uno dei 5 principi che ci spiega l�astrazione tra le varie classi.
Spesso capita di unire le stesse classi sotto una classe interfaccia o una classe astratta 
che condividono gli stessi attributi ma li gestiscono in maniera differente.
se q(x) � una propriet� che si pu� dimostrare essere valida per un oggetto x di tipo T, 
allora q(y) deve essere valida per gli oggetti y di tipo S dove S � un sottotipo di T.

Qui sotto cosa NON rispetta il principio LSP
il classico esempio � del quadrato e del rettangolo
il quadrato pu� essere visto anche come un rettangolo fatto di lati uguali

Ci� � vero ma non nel nostro caso, in quanto hanno attributi differenti:
 - uno ha un'altezza e una base
 
 l'altro ha un solo lato.
 
 Ma quando l'utente va a creare un nuovo rettangolo,
 si aspetta di avere a che fare con un rettangolo
 e non con un quadrato nascosto(che ha un'unica propriet�).
 
 Un altro esempio che spesso troviamo � la paperella finta che assomiglia a un'anatra: entrambe fanno quack ma la prima ha bisogno di batterie quindi l'astrazione � errata.
 
 Per l'esempio del rettangolo qualcuno potrebbe dire: la gestiamo che se riceviamo solo un lato � un quadrato se ne riceviamo due � un rettangolo.
 Questo � vero per� � sbagliato il concetto che l'utente debba fare questo tipo di controllo,
 L'utente non deve sapere cosa c'� sotto, deve solo richiamare una classe e poi la classe gestisce la cosa.
 
 */

class User {
	
}

class Rectangle{
	void setH() {};
	void setW() {};
}

class Square{
	void setSide() {};
}

public class LSP_Principle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
