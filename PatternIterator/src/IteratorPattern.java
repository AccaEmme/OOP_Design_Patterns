import java.util.ArrayList;
import java.util.Iterator;

/*
Scorrere una collezione attraverso un iterator.
 */

class LibrettoUniversitario{
  private ArrayList<String> esami = new ArrayList<String>();
  
  public LibrettoUniversitario() {
	  this.fill();
  }
  
  private void fill() {
	  esami.add("Analisi");
	  esami.add("Programmazione 1");
	  esami.add("Programmazione 2");
	  esami.add("Ingegneria del Software");
  }
  
  public Iterator<String> pull(){
	  return esami.iterator();
  }
}

public class IteratorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibrettoUniversitario lb = new LibrettoUniversitario();
		
		
       for(
    		   Iterator<?> iter = lb.pull(); 
    		   iter.hasNext();
    	   ){
          String name = (String) iter.next();
          System.out.println("Insegnamento: " + name);
       } 
	}

}
