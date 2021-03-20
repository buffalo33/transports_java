package tec;

import java.util.ArrayList;

public class Greffon extends Vehicule implements Transport{
    private Vehicule v;
    private InterfaceCollect collecte;

    
    public Greffon(InterfaceCollect init_collecte, Vehicule vehicule){
	this.v = vehicule;
	this.collecte = init_collecte;
    }
    
    public void allerArretSuivant(){
	collecte.changerArret();
	v.allerArretSuivant(this);	    
    }
    
    void allerArretSuivant(Vehicule ve){
	v.allerArretSuivant(ve);
	this.allerArretSuivant();
    }

    boolean aPlaceAssise()
    {
	return v.aPlaceAssise();
    }

    boolean aPlaceDebout()
    {
	return v.aPlaceDebout();
    }

    void arretDemanderDebout(Passager p)
    {
	 v.arretDemanderDebout(p);
    }

    void arretDemanderAssis(Passager p)
    {
	 v.arretDemanderAssis(p);
    }
    
    void arretDemanderSortie(Passager p)
    {
	v.arretDemanderSortie(p);
	if(p.estDehors()){
	     collecte.uneSortie(p);
	}
    }
    
     void monteeDemanderAssis(Passager p){
	v.monteeDemanderAssis(p);
	if (!p.estDehors())
	    {
		collecte.uneEntree(p);
	    }
    }
    
    void monteeDemanderDebout(Passager p){
	v.monteeDemanderDebout(p);
	if (!p.estDehors())
	    {
		collecte.uneEntree(p);
	    }
    }


    InterfaceCollect getCollecte()
    {
	return this.collecte;
    }

    @Override
    public String toString()
    {
	String str = v.toString();
	str += "nbEntree" + collecte.getNbEntree();
	str += "nbSortie" + collecte.getNbSortie();
	return str;
    }
}
