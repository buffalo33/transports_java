package tec;

import java.util.ArrayList; 

public class CollectMemo extends Collect {

    private ArrayList<Integer> memoEntree;
    private ArrayList<Integer> memoSortie;
    private ArrayList<Integer> memoArret;

    public CollectMemo()
    {
	super();
	memoEntree = new ArrayList<Integer>();
	memoSortie = new ArrayList<Integer>();
	memoArret = new ArrayList<Integer>();
    }
    
    void addMemory(){
	int lastIndex = 0;
	if (memoArret.size() > 0)
	    lastIndex = memoArret.size()-1;

	if (memoArret.size() > 0 && memoArret.get(lastIndex) == getNumeroArret()){
	    memoSortie.set(lastIndex, memoSortie.get(lastIndex) + getNbSortie());
	    memoEntree.set(lastIndex, memoEntree.get(lastIndex) + getNbEntree());
	    this.reinitialiser();
	}
	else {
	    memoArret.add(getNumeroArret());
	    memoSortie.add(getNbSortie());
	    memoEntree.add(getNbEntree());
	    this.reinitialiser();
	}
    }    

    int getNbEntreeMem(int i){
	return this.memoEntree.get(i);
    }

    int getNbSortieMem(int i){
	return this.memoSortie.get(i);
    }

    int getNumeroArretMem(int i){
	return this.memoArret.get(i);
    }
    
    @Override
    public String toString(){
	String str = "Entree   Sortie   Arret\n";
	for (int i = 0; i < memoEntree.size(); i++){
	    str += memoEntree.get(i) + "        ";
	    str += memoSortie.get(i) + "        ";
	    str += memoArret.get(i)  + "        ";
	    
	    str += "\n";
	}
	return str;
    }
}



