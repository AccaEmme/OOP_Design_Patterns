import java.util.ArrayList;

/*
 * la legge di Demetra: un modulo non dovrebbe conoscere l’interno degli “oggetti” che manipola.
 * Poiché le strutture di dati non contengono alcun comportamento, espongono naturalmente la loro struttura interna.
 * Quindi in tal caso, Demeter non si applica.

The Law Of Demeter strives to reduce coupling between objects following the principle of information hiding

 */


class Foo{
	public ArrayList<String> poo = null;
	public Foo() {	
		this.poo = new ArrayList<String>();
	}
	
	// right way
	public void addFoo(String s){
		poo.add(s);
	}
}

public class DemeterLaw {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Foo f = new Foo();
		
		f.addFoo("right way");
		
		f.poo.add("bad way");
	}

}
