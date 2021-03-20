package tec;

class TestGreffon {
  
    public static void main (String[] args) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;

	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}

	int nbTest = 0;

	//************ Verifier l'instanciation *************
	System.out.print('.'); nbTest++;
	new TestGreffon().testInstanciation();

	System.out.print('.'); nbTest++;
	new TestGreffon().testMonteeDemanderDebout();

	System.out.print('.'); nbTest++;
	new TestGreffon().testMonteeDemanderAssis();

	System.out.print('.'); nbTest++;
	new TestGreffon().testAllerArretSuivant();

    }

    public void testInstanciation()
    {
	Greffon gref = new Greffon(new FauxCollect(), new Autobus(4,5));
	FauxCollect fauxColl = (FauxCollect) gref.getCollecte();
	
	assert fauxColl.logs.size() == 0
	    : "mauvaise initialisation";
	    
    }
    

    public void testMonteeDemanderDebout()
    {
	Greffon gref = new Greffon(new FauxCollect(), new Autobus(3,3));
	FauxCollect fauxColl = (FauxCollect) gref.getCollecte();
	
	MonteeRepos p1 = new MonteeRepos("p1",3,ArretNerveux.NERVEUX);
	MonteeRepos p2 = new MonteeRepos("p2",4,ArretNerveux.NERVEUX);
	MonteeRepos p3 = new MonteeRepos("p3",3,ArretNerveux.NERVEUX);
        gref.monteeDemanderDebout(p1);
	gref.monteeDemanderDebout(p2);
        gref.monteeDemanderDebout(p3);
	for (int j = 1; j < 3; j++)
	    {
		assert fauxColl.logs.get(fauxColl.logs.size() - j)  == "Une Entree"
		    : "nbEntree faux testMonteeDemander debout 1";
	    }

	int formerSize  = fauxColl.logs.size();
	MonteeRepos p4 = new MonteeRepos("p4",3,ArretNerveux.NERVEUX);
	gref.monteeDemanderDebout(p4);
	assert formerSize  == fauxColl.logs.size()
	    : "nbEntree faux testMonteeDemander debout 2";
    }

    public void testMonteeDemanderAssis()
    {
	Greffon gref = new Greffon(new FauxCollect(), new Autobus(3,5));
	FauxCollect fauxColl = (FauxCollect) gref.getCollecte();
	
	MonteeRepos p1 = new MonteeRepos("p1",3,ArretNerveux.NERVEUX);
	MonteeRepos p2 = new MonteeRepos("p2",4,ArretNerveux.NERVEUX);
	MonteeRepos p3 = new MonteeRepos("p3",3,ArretNerveux.NERVEUX);
        gref.monteeDemanderAssis(p1);
	gref.monteeDemanderAssis(p2);
        gref.monteeDemanderAssis(p3);

	for (int j = 1; j < 3; j++)
	    {
		assert fauxColl.logs.get(fauxColl.logs.size() - j)  == "Une Entree"
		    : "nbEntree faux testMonteeDemander assis 1";
	    }

	int formerSize  = fauxColl.logs.size();
	MonteeRepos p4 = new MonteeRepos("p4",3,ArretNerveux.NERVEUX);
	gref.monteeDemanderAssis(p4);

	assert formerSize  == fauxColl.logs.size()
	    : "nbEntree faux testMonteeDemander assis 2";

    }

    public void testAllerArretSuivant()
    {
	Greffon gref = new Greffon(new FauxCollect(), new Autobus(4,5));
	FauxCollect fauxColl = (FauxCollect) gref.getCollecte();
	
	MonteeRepos p1 = new MonteeRepos("p1",3,ArretNerveux.NERVEUX);
	MonteeRepos p2 = new MonteeRepos("p2",4,ArretNerveux.NERVEUX);
	MonteeRepos p3 = new MonteeRepos("p3",3,ArretNerveux.NERVEUX);
        gref.monteeDemanderAssis(p1);
	gref.monteeDemanderAssis(p2);
        gref.monteeDemanderAssis(p3);
	
	for (int i = 0; i<5; i++)
	    {
		int formerSize  = fauxColl.logs.size();
		
		gref.allerArretSuivant();
		//fauxColl.printLogs();
		//System.out.println("\n");

				
		if (i+1 == 3)
		    {
			for (int j = 1; j < 3; j++)
			    {
				assert fauxColl.logs.get(fauxColl.logs.size() - j)  == "Une Sortie"
			    : "mauvaises sorties 1";
			    }
		    }
		else if (i+1 == 4)
		    {
			assert fauxColl.logs.get(fauxColl.logs.size() - 1)  == "Une Sortie"
			    : "mauvaises sorties 2";
		    }
		else if (i+1 != 3 && i+1 != 4)
		    {
			
			assert formerSize + 1 == fauxColl.logs.size()
			    : "mauvaise sortie 3";
		    }
	    }
	
	}
}
