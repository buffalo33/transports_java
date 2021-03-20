package tec;

public class PassagerStresse extends PassagerAbstrait{

    public PassagerStresse(String nom, int distance){
	super(nom, distance, ArretNerveux.NERVEUX);
    }
    
    void choixPlaceMontee(Vehicule v){
	if (v.aPlaceAssise()){
	    v.monteeDemanderAssis(this);
	}
	else {
	    if (v.aPlaceDebout()){
		    v.monteeDemanderDebout(this);
		}
	}
	
    }

    void choixPlaceArret(Vehicule v, int numeroArret){
	if (distanceAvantSortie(numeroArret) <= 3){
	    if (distanceAvantSortie(numeroArret) > 0){
		v.arretDemanderDebout(this);
	    }
	}
    }
}			      
