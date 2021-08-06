/*
Lo Strategy Pattern rientra tra i pattern comportamentali
e sostanzialmente descrive un modo attraverso il quale
possiamo cambiare il comportamento a runtime degli oggetti
avendo degli oggetti che vadano a decidere una strategia
per eseguire un certo algoritmo o operazione, direttamente a runtime

Vogliamo scegliere il nostro mostro a runtime che attacco deve fare
Dobbiamo quindi scorporare la strategia con cui viene fatto l'attacco, dall'attacco mostro.

Abbiamo dimostrato come estrarre il comportamento di una classe estrapolandone la strategia attraverso l'interfaccia,
poi attraverso l'interfaccia generalizziamo e adattiamo a varie esigenze questa interfaccia con classi che la implementano.

 Consente di avere gerarchie di oggetti molto meno profonde.
 */

/* without strategy pattern
class Monster{
	public Monster() {}

	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("ATTACK!");
	}
}


public class StrategyPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monster m = new Monster();
		m.attack();
		
	}

}
*/


interface AttackStrategy{
	public void attack();
}

class SimpleAttackStrategy implements AttackStrategy{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("ATTACK!");
	}
	
}

class PowerAttackStrategy implements AttackStrategy{
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("POWER ATTACK!");
	}
}

class Monster{
	AttackStrategy attackStrategy;
	
	public Monster() {
		attackStrategy = new SimpleAttackStrategy();
	}
	
	public void attack() {
		// TODO Auto-generated method stub
		attackStrategy.attack(); // demando la scelta al valore corrente di attackstrategy
	}

	public void setAttackStrategy(AttackStrategy newAttackStrategy) {
		// TODO Auto-generated method stub
		attackStrategy = newAttackStrategy; // con questo metodo posso cambiare la strategia di attacco del nostro mostro.
	}
}

public class StrategyPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monster m = new Monster();
		m.attack();
		m.setAttackStrategy( new PowerAttackStrategy() );
		m.attack();
	}

}