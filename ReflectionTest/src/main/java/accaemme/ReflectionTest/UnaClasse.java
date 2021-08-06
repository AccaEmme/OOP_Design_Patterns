package accaemme.ReflectionTest;

public class UnaClasse {

	public class EccezioneNonVoglioZero extends Exception{

		private static final long serialVersionUID = 1L;
		
		public EccezioneNonVoglioZero(String msg) {
			super();
			System.err.println(msg);
		}
		
	}
	
	public int unMetodo(int i) throws EccezioneNonVoglioZero {
		if (i==0)
			throw new EccezioneNonVoglioZero("avevo detto no zeri");
			
		return i;
	}
	
	private String unMetodoPrivato() {
		return "pippo";
	}
	
	
}
