package tec;

public class ArretPoli implements ComportementNouvelArret{

    public static final ArretPoli POLI = new ArretPoli();

    private ArretPoli(){}

    public void choixChangerPlace(Passager p, Vehicule v, int numeroArret){
	if (!v.aPlaceAssise()){
	    if (v.aPlaceDebout()){
		v.arretDemanderDebout(p);
	    }
	}
    }
}

