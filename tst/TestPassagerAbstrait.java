package tec;

abstract class TestPassagerAbstrait {
    public TestPassagerAbstrait(){
	
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
    }
    
  //********************************************************
  /* Classe PAssagerAbstrait abstraite donc non instanciable. Donc test d'intanciation abstrait.
   */  
    abstract protected void testInstanciation();
    
    abstract protected PassagerAbstrait creerPassager(String nom, int destination);
    
    /* Gestion des changement d'état.
     * 
     * Changer Debout puis Dehors puis assis. 
     */
    protected void testGestionEtat() {
	Passager p = creerPassager("yyy", 3);

	p.changerEnDebout();
	assert false == p.estAssis();
	assert true == p.estDebout();
	assert false == p.estDehors();

	p.changerEnDehors();
	assert false == p.estAssis();
	assert false == p.estDebout();
	assert true == p.estDehors();

	p.changerEnAssis();
	assert true == p.estAssis();
	assert false == p.estDebout();
	assert false == p.estDehors();
    }  

      /* Interaction a la montee
       *  - aucune place. 
       */
    protected void testInteractionMontee() throws TecException {
	PassagerAbstrait p = (PassagerAbstrait) creerPassager("yyy", 5);
	
	FauxVehicule faux = new FauxVehicule(FauxVehicule.PLEIN);
	p.monterDans(faux);

	assert p.estDehors() : "pas de place";
    }

    protected void testInteractionArret(){
      Passager p = (Passager) creerPassager("yyy", 5);
    
      FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
         
      p.nouvelArret(faux, 5);
      assert "arretDemanderSortie" == getLastLog(faux) : "destination";
    }
    
    protected String getLastLog(FauxVehicule f) {
	return f.logs.get(f.logs.size() -1);
    }

    protected void testDistanceNegative(){
	try{
	    new fauxPassagerAbstrait("idiot",-1);
	}
	catch(IllegalArgumentException i){
	    ;
	}
	assert false : "Exception distance negative pas catch";
    }
		
}
