package tec;

public class MonteeSportif extends PassagerAbstrait {

    public MonteeSportif(String nom, int distance, ComportementNouvelArret comportement){
	super(nom,distance,comportement);
	if (comportement == ArretPrudent.PRUDENT)
	    {
		this.comportement = ArretNerveux.NERVEUX;
	    }
    }

    void choixPlaceMontee(Vehicule v){
	v.monteeDemanderDebout(this);
	}
}
 
