package tec;

public class TestPassagerStresse extends TestPassagerAbstrait{

    public static void main(String[] args) throws TecException {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
	
	int nbTest = 0;
	
	//************ Verifier l'instanciation *************
	System.out.print('.'); nbTest++;
	new TestPassagerStresse().testInstanciation();
	
	//********* Verifier changement d'etat **************
	System.out.print('.'); nbTest++;
	new TestPassagerStresse().testGestionEtat();
	
	//********* Verifier les interactions  *************
	System.out.print('.'); nbTest++;
	new TestPassagerStresse().testInteractionMontee();
	
	System.out.print('.'); nbTest++;
	new TestPassagerStresse().testInteractionArret();
	
	System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStresse"); 
    }
    
  //********************************************************
    
  public void testInstanciation() {
      PassagerStresse p = (PassagerStresse) creerPassager("Jean Castex", 3);

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
    assert "Jean Castex" == p.nom();
  }

    @Override
    public PassagerAbstrait creerPassager(String nom, int distance){
	PassagerStresse p = new PassagerStresse(nom, distance);
	return p;
    }
    
    //    public void testGestionEtat() {



/* Interaction a la montee
   * Trois cas
   *  - des places assises et debout
   *  - pas de place assise
   *  - aucune place. 
   */

    @Override
  public void testInteractionMontee() throws TecException{
      super.testInteractionMontee();
      PassagerStresse p = new PassagerStresse("yyy", 5);

      FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
      p.monterDans(faux);
      assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
      
      faux = new FauxVehicule(FauxVehicule.DEBOUT);
      p.monterDans(faux);
      assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    

      /*      FauxVehicule faux = new FauxVehicule(FauxVehicule.PLEIN);
      p.monterDans(faux);
      assert 0 == faux.logs.size() : "pas de place";        */
  }

    /* Interaction a un arret
   * Deux cas
   *  - numero d'arret < a la destination
   *  - numero d'arret >= a la destination 
   */

    @Override
    public void testInteractionArret() {
      super.testInteractionArret();
      
      PassagerStresse p = new PassagerStresse("yyy", 5);
      
      FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
      
      //      p.nouvelArret(faux, 1);
      //      assert 0 == faux.logs.size() : "pas a destination";

      p.nouvelArret(faux, 3);

      assert "arretDemanderDebout" == getLastLog(faux): "se lève";
    
      p.nouvelArret(faux, 5);
      assert "arretDemanderSortie" == getLastLog(faux) : "destination";
    }
}
