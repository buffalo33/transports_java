package tec;

abstract class Collect extends InterfaceCollect{

    private int nbEntree;
    private int nbSortie;
    private int nbArret;

    Collect()
    {
	this.nbEntree=0;
	this.nbSortie=0;
	this.nbArret=0;
    }
    
    void uneEntree(Passager p)
    {
	nbEntree++;
	addMemory();
    }

    void uneSortie(Passager p)
    {
	nbSortie++;
	addMemory();
    }

    void changerArret()
    {
	nbArret++;
	addMemory();
    }

    void reinitialiser()
    {
	nbEntree=0;
	nbSortie=0;
    }

    int getNbEntree()
    {
	return this.nbEntree;
    }
    
    int getNbSortie()
    {
	return this.nbSortie;
    }
    
    int getNumeroArret()
    {
	return this.nbArret;
    }

    void setNbEntree(int nbEntree)
    {
	this.nbEntree = nbEntree;
    }
    
    void setNbSortie(int nbSortie)
    {
	this.nbSortie = nbSortie;
    }
    
    void setNumeroArret(int numArret)
    {
	this.nbArret = numArret;
    }
}
