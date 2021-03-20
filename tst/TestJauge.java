package tec;

class TestJauge {
    public static void main (String[] args) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
	
	new TestJauge().testDansIntervalle();
	new TestJauge().testHorsIntervalle1();
	new TestJauge().testHorsIntervalle2();
	new TestJauge().testHorsIntervalle3();
	new TestJauge().testDansIntervalle2();
	new TestJauge().testIncrementer();
	new TestJauge().testDecrementer();
	new TestJauge().testExceptionCasLimite();
	
	System.out.println("Tests réussis");
    }
    public void testDansIntervalle() {
	Jauge j1 = new Jauge(67899, 100);
	assert j1.estVert(): "testDansIntervalle, j1.estVert est faux";
	assert j1.estRouge()==false: "testDansIntervalle, j1.estRouge est vrai";
    }
    
    public void testHorsIntervalle1() {
	Jauge j1 = new Jauge(700, 800);
	assert j1.estVert()==false: "testHorsIntervalle1, j1.estVert est vrai";
	assert j1.estRouge(): "testHorsIntervalle1, j1.estRouge est faux";
    }

    public void testHorsIntervalle2() {
	Jauge j1 = new Jauge(800, 800);
	assert j1.estVert()==false: "testHorsIntervalle2, j1.estVert est vrai";
	assert j1.estRouge(): "testHorsIntervalle2, j1.estRouge est faux";
    }

    public void testHorsIntervalle3() {
	Jauge j1 = new Jauge(700, -34);
	assert j1.estVert()==false: "testHorsIntervalle3, j1.estVert est vrai";
	assert j1.estRouge()==false: "testHorsIntervalle3, j1.estRouge est faux";
    }
    

    public void testDansIntervalle2() {
	Jauge j1 = new Jauge(700,0);
	assert j1.estVert(): "testDansIntervalle2, j1.estVert est faux";
	assert j1.estRouge()==false: "testDansIntervalle2, j1.estRouge est vrai";
    }
   
    public void testIncrementer(){
	Jauge j1 = new Jauge(1, -1);
	j1.incrementer();
	assert j1.estVert(): "testIncrementer1, j1.estVert est faux";
	assert j1.estRouge()==false: "testIncrementer1, j1.estRouge est vrai";
    }

    public void testDecrementer(){
	Jauge j1 = new Jauge(1, 1);
	j1.decrementer();
	assert j1.estVert(): "testDecrementer1, j1.estVert est faux";
	assert j1.estRouge()==false: "testDecrementer1, j1.estRouge est vrai";
    }

    public void testExceptionCasLimite() {
	Jauge inverse = null;

	try {
	    inverse = new Jauge(-42, 10);
	    assert false : "Exception non levee";
	}
	catch(java.lang.IllegalArgumentException e) {}
    }
}
