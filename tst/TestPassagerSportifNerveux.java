package tec;

class TestPassagerSportifNerveux extends TestPassagerAbstrait{

    public static void main (String[] args) throws TecException{
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
	
	int nbTest = 0;
	
	//************ Verifier l'instanciation *************
	System.out.print('.'); nbTest++;
	new TestPassagerSportifNerveux().testInstanciation();
	
	//********* Verifier changement d'etat **************
	System.out.print('.'); nbTest++;
	new TestPassagerSportifNerveux().testGestionEtat();
	
	//********* Verifier les interactions  *************
	System.out.print('.'); nbTest++;
	new TestPassagerSportifNerveux().testInteractionMontee();
	
	System.out.print('.'); nbTest++;
	new TestPassagerSportifNerveux().testInteractionArret();
	
	System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStandard"); 
    }

    public void testInstanciation() {
	MonteeSportif p = new MonteeSportif("xxx",3,ArretNerveux.NERVEUX);
	assert false == p.estAssis();
	assert false == p.estDebout();
	assert true == p.estDehors();

	MonteeSportif p1 = new MonteeSportif("xxx",3,ArretPrudent.PRUDENT);
	assert p1.comportement == ArretNerveux.NERVEUX;
    }
    
    public PassagerAbstrait creerPassager(String nom, int distance){
	MonteeSportif p = new MonteeSportif(nom,distance,ArretNerveux.NERVEUX);
	return p;
    }


     /* Interaction a la montee
   * Trois cas
   *  - des places assises et debout
   *  - pas de place assise
   *  - aucune place. 
   */
    @Override
    public void testInteractionMontee() throws TecException{
	super.testInteractionMontee();
	/*MonteeSportif p = new MonteeSportif("yyy",5,ArretNerveux.NERVEUX);
	
	FauxVehicule faux1 = new FauxVehicule(FauxVehicule.VIDE);
	p.choixPlaceMontee(faux1);

	assert "monteeDemanderDebout" == getLastLog(faux1) : "debout";

	FauxVehicule faux2 = new FauxVehicule(FauxVehicule.DEBOUT);
	p.choixPlaceMontee(faux2);

	assert "monteeDemanderDebout" == getLastLog(faux2) : "debout";*/
    }

     /* Interaction a un arret
   * Deux cas
   *  - numero d'arret < a la destination
   *  - numero d'arret >= a la destination 
   */
    @Override
    public void testInteractionArret() {
	super.testInteractionArret();
      
	MonteeSportif p = new MonteeSportif("yyy", 5,ArretNerveux.NERVEUX);
	
	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

	p.changerEnDebout();

	p.nouvelArret(faux, 1);
	assert "arretDemanderAssis" == getLastLog(faux): "assis";
	p.changerEnAssis();
	
	
	p.nouvelArret(faux,2);
	assert "arretDemanderDebout" == getLastLog(faux): "debout";
	p.changerEnDebout();
	
	p.nouvelArret(faux, 5);
	assert "arretDemanderSortie" == getLastLog(faux) : "destination";

	FauxVehicule faux2 = new FauxVehicule(FauxVehicule.DEBOUT);

	p.changerEnDebout();

	p.nouvelArret(faux2,1);
	p.changerEnDebout();
	

	p.nouvelArret(faux2,2);
	assert "arretDemanderAssis" == getLastLog(faux2): "assis";

	MonteeSportif p1 = new MonteeSportif("yyy", 100,ArretNerveux.NERVEUX);
	
	FauxVehicule faux3 = new FauxVehicule(FauxVehicule.VIDE);

	p1.changerEnDebout();
	for(int i = 1; i < 99; i++)
	    {
		p1.nouvelArret(faux3,i);
		if (i%2 == 1)
		    {
			assert "arretDemanderAssis" == getLastLog(faux3): "assis";
			p1.changerEnAssis();
		    }
		else
		    {
			assert "arretDemanderDebout" == getLastLog(faux3): "debout";
			p1.changerEnDebout();
		    }
	    }

    }
}

    

    
