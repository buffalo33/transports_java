package tec;

class MonteeTetu extends PassagerAbstrait{
    
    MonteeTetu(String nom, int distance, ComportementNouvelArret comportementArret){
	super(nom, distance, comportementArret);
    }

    void choixPlaceMontee(Vehicule v){
	    v.monteeDemanderAssis(this);
	    if (this.estDehors()){
		v.monteeDemanderDebout(this);
	    }
    }
}
