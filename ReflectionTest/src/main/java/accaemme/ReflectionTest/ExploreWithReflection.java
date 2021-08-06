/*
 * @author: Magliacane Hermann
 * Uncompleted
 */

package accaemme.ReflectionTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ExploreWithReflection {

	public static void main(String[] args) {
		Class<Reflected> reflectedClass = Reflected.class;
		
		System.out.println("Classe: " + reflectedClass.getName());
		
		for (Constructor<?> cons : reflectedClass.getConstructors()) {
			System.out.println("Ha il costruttore: " + cons.getName() + " che accetta " + cons.getParameterCount() + " parametri, ovvero:" );
			for (Parameter per : cons.getParameters()){
				System.out.println("\tParametro nome: " + per.getName() + "parametro tipo: " + per.getType().getName() );
			}
			
		}
		
		for (Method met : reflectedClass.getMethods()) {
			System.out.println("Metodi: " + met.getName());
			System.out.println("Num. Parametri:" + met.getParameterCount());
			for (Parameter per : met.getParameters()){
				System.out.println("Parametro: " + per.getName());
				System.out.println("Parametro: " + per.getType().getName());
			}
			
		}
	
		
		System.out.println("\n-----------\nProvo a ricreare il codice sorgente della tua classe:");
		System.out.println("import " + reflectedClass.getPackage() + ";");

		String nomeClasse;
		String nomeCostrutture;
		String tipoParametro;

		nomeClasse=reflectedClass.getName().substring(reflectedClass.getName().lastIndexOf('.') + 1);
		System.out.println("zzz class " + nomeClasse+"{");
		for(Constructor<?> c : reflectedClass.getConstructors()) {		
			nomeCostrutture=c.getName().substring(c.getName().lastIndexOf('.') + 1);
			System.out.print("\tyyy"+" "+nomeCostrutture+"(");
				int i=0;
				for(Parameter p:c.getParameters()) {
					if(i>0) System.out.print(", ");
					tipoParametro=p.getType().getName();
					tipoParametro=tipoParametro.substring(tipoParametro.lastIndexOf('.') + 1);
					System.out.print(tipoParametro + " "+ p.getName() );
					i++;
				}
			System.out.println("){");
				for(Method m : reflectedClass.getMethods()) {
					System.out.print("\t\txxx "+m.getReturnType()+" "+m.getName()+" (");
						i=0;
						for(Parameter p:m.getParameters()) {
							if(i>0) System.out.print(", ");
							System.out.print(p.getType().getName() + " " + p.getName());
							i++;
						}
					System.out.println("){");
					System.out.println("\t\t}");
				}
			System.out.println("\t}");
		}
		System.out.println("}");
	}

}