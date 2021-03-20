
/**
 * Classe faussaire pour le test unitaire fonctionnel
 * d'Autobus. 
 *
 * Ce faussaire ne declenche pas d'appel aux methodes
 * d'Autobus.
 *
 * Il ne change pas son etat (la variable d'instance status). 
 * C'est le test qui change directement la valeur de cette variable. 
 *
 * Il enregistre l'appel aux méthodes qui doivent modifier son etat.
 */
package tec;

class FauxComportement implements ComportementNouvelArret{
    public static final FauxComportement f = new FauxComportement();
    private FauxComportement(){};
    public void choixChangerPlace(Passager p, Vehicule v, int distanceDestination){;
    }
}


class FauxPassager extends Passager implements Usager {
    Position status;
      
    final java.util.List<String> logs = new java.util.LinkedList<String>();
    
    FauxPassager() {
	this.status = Position.DEHORS;
    }
    
    FauxPassager(Position init) {
	status = init;
    }

    public String nom() {
	return null;
    }

    public boolean estDehors() {
	return status == Position.DEHORS;
    }
  
    public boolean estAssis() {
	return status == Position.ASSIS;
    }
  
    public boolean estDebout() {
	return status == Position.DEBOUT;
    }

    // Enregistrements des appels effectues par Autobus.
    public void changerEnDehors() {
	logs.add("changerEnDehors");
    }

    public void changerEnAssis() {
	logs.add("changerEnAssis");
    }

    public void changerEnDebout() {
	logs.add("changerEnDebout");
    }

    public void nouvelArret(Vehicule bus, int numeroArret) {
	logs.add("nouvelArret");
    }

    // Autobus n'utilise pas cette méthode.
    public void monterDans(Transport t) { 
    }

    public String toString(){
	String str = " <";
	if (estAssis())
	    {
		str += "assis";
	    }
	if (estDebout())
	    {
		str += "debout";
	    }
	if (estDehors())
	    {
		str += "dehors";
	    }
	str += ">";
	System.out.println(str);
	return str;
    }

}

class fauxPassagerAbstrait extends PassagerAbstrait {
    public fauxPassagerAbstrait(String nom, int distance){
	super(nom, distance, FauxComportement.f);
    }
    void choixPlaceMontee(Vehicule v){;}
    void choixPlaceArret(Vehicule v, int numeroArret){;}
}

    
