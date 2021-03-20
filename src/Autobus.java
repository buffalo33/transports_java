package tec;

import java.util.ArrayList;

public class Autobus extends Vehicule implements Transport {

    private int numeroArret = 0;
    
    private final Jauge jaugeAssis;
    private final Jauge jaugeDebout;
    
    private ArrayList<Passager> passagers;

    public Autobus(int nbPlaceAssise, int nbPlaceDebout){
	if (nbPlaceAssise < 0 || nbPlaceDebout < 0){
	    throw new IllegalArgumentException("nombre place assis ou nombre place debout < 0");
	}
        jaugeAssis = new Jauge(nbPlaceAssise, 0);
	jaugeDebout = new Jauge(nbPlaceDebout, 0);

	passagers = new ArrayList<Passager>();
    }

    int chercherEmplacementVide(){
        for (int i = 0; i < passagers.size(); i++)
	    if (passagers.get(i) == null)
		return i;
	return -1;
    }

    int chercherPassager(Passager p){
        for (int i = 0; i < passagers.size(); i++)
	    if (p == passagers.get(i))
		return i;
	return -1;
    }

    public void allerArretSuivant(){
	numeroArret++;
	for (int i = passagers.size() -1; i>=0; i--){
	    passagers.get(i).nouvelArret(this, numeroArret);
	}
    }


    void allerArretSuivant(Vehicule v){
	  numeroArret++;
	  for (int i = passagers.size() -1; i>=0; i--){
	       passagers.get(i).nouvelArret(v, numeroArret);
	  }
     } 
    
    boolean aPlaceAssise(){
	return jaugeAssis.estVert();
    }

    boolean aPlaceDebout(){
	return jaugeDebout.estVert();
    }
    
    void monteeDemanderAssis(Passager p){
	for(Passager pi : passagers){
	    if (pi == p){
		throw new IllegalStateException("passager fait monté plusieurs fois");
	    }
	}
	if (aPlaceAssise()){
	    //i = chercherEmplacementVide(passagers);
	    p.changerEnAssis();
	    jaugeAssis.incrementer();
	    passagers.add(p);
	}
    }
    
    void monteeDemanderDebout(Passager p){
	for(Passager pi : passagers){
	    if (pi == p){
		throw new IllegalStateException("passager fait monté plusieurs fois");
	    }
	}
	if (aPlaceDebout()){
	    //i = chercherEmplacementVide(passagers);
	    p.changerEnDebout();
	    jaugeDebout.incrementer();
	    passagers.add(p);
	   
	}
    }
    
    void arretDemanderDebout(Passager p){
	if (aPlaceDebout()){
	    p.changerEnDebout();
	    jaugeDebout.incrementer();
	    jaugeAssis.decrementer();
	}
    }
    
    void arretDemanderAssis(Passager p){
	if (aPlaceAssise()){
	    p.changerEnAssis();
	    jaugeAssis.incrementer();
	    jaugeDebout.decrementer();
	}
    }
    
    void arretDemanderSortie(Passager p){
        if (p.estAssis()){
	    p.changerEnDehors();
	    jaugeAssis.decrementer();
	}
	if (p.estDebout()){
	    p.changerEnDehors();
	    jaugeDebout.decrementer();
	}

	passagers.remove(p);
    }

    ArrayList<Passager> getPassagers()
    {
	ArrayList<Passager> copy;
	copy = (ArrayList<Passager>) passagers.clone();
	return copy;
    }

    @Override
    public String toString(){
	String str = "[arret " + this.numeroArret+"]";
	str += " assis" + jaugeAssis.toString();
	str += " debout" + jaugeDebout.toString();
	return str;
    }
}
