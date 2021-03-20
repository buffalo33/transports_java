package tec;

public class MonteeRepos extends PassagerAbstrait {

    MonteeRepos(String nom, int distance, ComportementNouvelArret comportement){
	super(nom,distance,comportement);
    }

    void choixPlaceMontee(Vehicule v){
	v.monteeDemanderAssis(this);
	if (this.estDehors()){
	    v.monteeDemanderDebout(this);
	}
    }
}

