package tec;

class TestPosition{
    public static void main (String[] args){
	boolean estMisAssertion = false;
	assert estMisAssertion = true;

	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}

	new TestPosition().testDehors();
	new TestPosition().testDebout();
	new TestPosition().testAssis();
	
	return;
    }

    public void testDehors(){
	Position test = Position.DEHORS;    
	
	assert test.estDehors() : "test dehors: Faux Le passager n est pas dehors";

	assert !test.estInterieur() : "test dehors: Pourquoi est il dedans?";
	assert !test.estAssis() : "test dehors: Pourquoi est il assis?";
	assert !test.estDebout() : "test dehors: Pourquoi est il debout?";

	System.out.println("test dehors reussi");
    }
    public void testDebout(){
	Position test = Position.DEBOUT;
	
	assert !test.estDehors() : "test debout: Faux Le passager est dehors";
	assert test.estInterieur() : "test debout: Pourquoi n'est pas il dedans?";
	assert !test.estAssis() : "test debout: Pourquoi est il assis?";      
	assert test.estDebout() : "test debout: Pourquoi n'est il pas debout?";
	System.out.println("test debout reussi");
    }
    
    public void testAssis(){
	Position test = Position.ASSIS;
	
	assert !test.estDehors() : "test assis: Faux Le passager est dehors";
	assert test.estInterieur() : "test assis: Pourquoi n est pas il dedans?";
	assert test.estAssis() : "test assis: Pourquoi n est il pas assis?";
	assert !test.estDebout() : "test assis: Pourquoi est il debout?";
	System.out.println("test assis reussi");
    }
}
