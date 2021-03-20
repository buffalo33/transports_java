package tec;

public class ArretAgoraphobe implements ComportementNouvelArret{

    static final ArretAgoraphobe AGORAPHOBE = new ArretAgoraphobe();

    private ArretAgoraphobe(){}
    
    public void choixChangerPlace(Passager p, Vehicule v, int distanceDestination){
	if (!v.aPlaceAssise()){
	    if (!v.aPlaceDebout()){
		v.arretDemanderSortie(p);
	    }
	}
    }
}
