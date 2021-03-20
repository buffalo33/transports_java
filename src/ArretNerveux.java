package tec;

public class ArretNerveux implements ComportementNouvelArret{
    
    public static final ArretNerveux NERVEUX = new ArretNerveux();
    
    private ArretNerveux(){}
    
    public void choixChangerPlace(Passager p, Vehicule v, int distanceDestination){
	if (p.estAssis()) {
	    v.arretDemanderDebout(p);
	}
	else if (p.estDebout()){
	    v.arretDemanderAssis(p);
	}
    }
}
