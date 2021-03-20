package tec;

class FauxCollect extends Collect {

    final java.util.List<String> logs = new java.util.LinkedList<String>();

    public void uneEntree(Passager p)
    {
	logs.add("Une Entree");
    }

    public void uneSortie(Passager p)
    {
	logs.add("Une Sortie");
    }


       public void changerArret()
    {
	logs.add("changer arret");
    }
    
    
    public void addMemory(){
	logs.add("Mise en memoire de" + getNbEntree() + "entrees et " + getNbSortie() + "sorties a l'arret" + getNumeroArret());

    }

    public void printLogs()
    {
	for (int i = 0; i < logs.size(); i++)
	    {
		System.out.println(logs.get(i));
	    }
    }

    
}



