/*

principio LSP:
è uno dei 5 principi che ci spiega l’astrazione tra le varie classi.
Spesso capita di unire le stesse classi sotto una classe interfaccia o una classe astratta 
che condividono gli stessi attributi ma li gestiscono in maniera differente.
se q(x) è una proprietà che si può dimostrare essere valida per un oggetto x di tipo T, 
allora q(y) deve essere valida per gli oggetti y di tipo S dove S è un sottotipo di T.

in questo esempio c'è un'applicazione che calcola i costi di licenza,
abbiamo la classe billing che va a richiamare l'interfaccia License che verrà implementata da PersonLicense o BusinessLicense
Billing non conoscerà le differenze tra le due perché non avrà bisogno di conoscerle
A billing basterà chiamare CalcFee

 */


class Billing{
	
}

interface License{
 void calcFee();	
}


class PersonLicense implements License{

	@Override
	public void calcFee() {
		// TODO Auto-generated method stub
		
	}
	
}

class BusinessLicense implements License{

	@Override
	public void calcFee() {
		// TODO Auto-generated method stub
		
	}
	
}

public class GoodLSP_Principle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
