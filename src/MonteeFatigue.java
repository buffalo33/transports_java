package tec;

class MonteeFatigue extends PassagerAbstrait{

    MonteeFatigue(String nom, int distance, ComportementNouvelArret comportementArret){
	super(nom, distance, comportementArret);
    }

    void choixPlaceMontee(Vehicule v){
	    v.monteeDemanderAssis(this);

    }
}
