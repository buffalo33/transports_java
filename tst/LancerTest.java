package tec;
import java.lang.reflect.Method;
import java.lang.Class;
import java.lang.reflect.InvocationTargetException;

class LancerTests {
    static private void lancer(Class c) throws Exception{
	Method[] allMethods = c.getMethods();
	int nbTests = 0;
	
	for (Method m: allMethods){
	    String name = m.getName();
	    if (name.startsWith("test")){
		m.setAccessible(true);
		
		try{
		    m.invoke(c.newInstance());
		}
		catch(IllegalAccessException e){
		    System.out.println("exception 1");
		}
		catch(InvocationTargetException e){
		    System.out.println("exception 2");
		    e.printStackTrace();
		}
		catch(IllegalArgumentException e){
		    System.out.println("exception 3");
		}
		    
		System.out.print('.');
		nbTests++;
	    }
	}
	System.out.println(c + " OK - tests réussis: " + nbTests);
    }

    static public void main(String[] args) throws Exception {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    System.exit(0);
	}

	for (String str : args){
	    Class c = Class.forName(str);
	    lancer(c);
	}
    }
}
