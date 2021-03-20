package tec;

abstract class PassagerAbstrait extends Passager implements Usager{
    private String nom;
    private int distance;
    private Position position;
    ComportementNouvelArret comportement;
    
    PassagerAbstrait(String nom, int distance, ComportementNouvelArret comportement){
	if (distance < 0){
	    throw new IllegalArgumentException("distance < 0");
	}
	this.nom = nom;
	this.distance = distance;
	this.position = Position.DEHORS;
	this.comportement = comportement;
    }

    abstract void choixPlaceMontee(Vehicule v);

    void choixChangerPlace(Passager p, Vehicule v, int distanceDestination){
	comportement.choixChangerPlace(p, v, distanceDestination);
    }

    final protected int distanceAvantSortie(int numeroArret){
	return distance - numeroArret;
    }
    
    final public void monterDans(Transport t) throws TecException{
	Vehicule v = (Vehicule) t;
	if(!(v instanceof Transport)){
	    throw new TecException("échec conversion de type entre transport et vehicule");
	}
	try{
	    choixPlaceMontee(v);
	}
	catch(IllegalStateException i){
	    throw new TecException(i);
	}
    }

    final void nouvelArret(Vehicule v, int numeroArret){
	if (distance <= numeroArret){
	    v.arretDemanderSortie(this);
	}
	else
	    {
		choixChangerPlace(this, v, distanceAvantSortie(numeroArret));
	    }
    }

    String nom(){
	return nom;
    }
    
    boolean estDehors(){
	return position.estDehors();
    }

    boolean estAssis(){
	return position.estAssis();
    }

    boolean estDebout(){
	return position.estDebout();
    }

    void changerEnDehors(){
	position = Position.DEHORS;
    }

    void changerEnAssis(){
	position = Position.ASSIS;
    }

    void changerEnDebout(){
	position = Position.DEBOUT;
    }

    
    @Override
    public String toString(){
	String str = this.nom + " <";
	
	if (estAssis() )
	    {
		str += "assis";
	    }
	if (estDebout() )
	    {
		str += "debout";
	    }
	if (estDehors() )
	    {
		str += "endehors";
	    }
	str += ">";
	return str;
    }
}
