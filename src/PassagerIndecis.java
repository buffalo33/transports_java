package tec;

public class PassagerIndecis extends PassagerAbstrait {
    
    public PassagerIndecis(String nom, int distance){
	super(nom, distance, ArretNerveux.NERVEUX);
      }

    void choixPlaceMontee(Vehicule v){
	if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
    }

    void choixPlaceArret(Vehicule v, int numeroArret){
	if (distanceAvantSortie(numeroArret) > 0){
	    if (this.estAssis()) {
		v.arretDemanderDebout(this);
	    }
	    else if (this.estDebout()){
		v.arretDemanderAssis(this);
	    }
	}
    }
}

