package accaemme.ReflectionTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import accaemme.ReflectionTest.UnaClasse.EccezioneNonVoglioZero;

public class TestUnaClasse {

	UnaClasse uc;
	
	@Before
	public void prima() {
		uc=new UnaClasse();
	}
	
	@Test
	public void testOK() throws EccezioneNonVoglioZero {
		assertEquals(100,uc.unMetodo(100));
	}
	
	@Test(expected=EccezioneNonVoglioZero.class)
	public void testNotOK() throws EccezioneNonVoglioZero {
		assertEquals(100,uc.unMetodo(0));
	}
	
	@Test
	public void TestUnPrivato() {
		try {
			Method m = UnaClasse.class.getDeclaredMethod("unMetodoPrivato", (Class<?>[]) null);
			m.setAccessible(true);
			assertTrue(
					((String)m.invoke(uc, (Object[])null)).equals("pippo")
					);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 

}