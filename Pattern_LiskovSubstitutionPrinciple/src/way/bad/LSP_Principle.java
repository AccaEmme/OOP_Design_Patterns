package way.bad;

/*
principio LSP:
è uno dei 5 principi che ci spiega l’astrazione tra le varie classi.
Spesso capita di unire le stesse classi sotto una classe interfaccia o una classe astratta 
che condividono gli stessi attributi ma li gestiscono in maniera differente.
se q(x) è una proprietà che si può dimostrare essere valida per un oggetto x di tipo T, 
allora q(y) deve essere valida per gli oggetti y di tipo S dove S è un sottotipo di T.

Qui sotto cosa NON rispetta il principio LSP
il classico esempio è del quadrato e del rettangolo
il quadrato può essere visto anche come un rettangolo fatto di lati uguali

Ciò è vero ma non nel nostro caso, in quanto hanno attributi differenti:
 - uno ha un'altezza e una base
 
 l'altro ha un solo lato.
 
 Ma quando l'utente va a creare un nuovo rettangolo,
 si aspetta di avere a che fare con un rettangolo
 e non con un quadrato nascosto(che ha un'unica proprietà).
 
 Un altro esempio che spesso troviamo è la paperella finta che assomiglia a un'anatra: entrambe fanno quack ma la prima ha bisogno di batterie quindi l'astrazione è errata.
 
 Per l'esempio del rettangolo qualcuno potrebbe dire: la gestiamo che se riceviamo solo un lato è un quadrato se ne riceviamo due è un rettangolo.
 Questo è vero però è sbagliato il concetto che l'utente debba fare questo tipo di controllo,
 L'utente non deve sapere cosa c'è sotto, deve solo richiamare una classe e poi la classe gestisce la cosa.
 
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
