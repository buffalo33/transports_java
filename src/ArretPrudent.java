package tec;

public class ArretPrudent implements ComportementNouvelArret{    

    public static final ArretPrudent PRUDENT = new ArretPrudent();
    
    private ArretPrudent(){}
    
    public void choixChangerPlace(Passager p, Vehicule v, int distanceDestination){
	if (distanceDestination > 5)
	    v.arretDemanderAssis(p);
	else if (distanceDestination <= 3 && p.estAssis())
	    v.arretDemanderDebout(p);
    }
}
