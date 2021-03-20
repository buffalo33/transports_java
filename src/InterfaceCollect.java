package tec;

abstract class InterfaceCollect{
    abstract void addMemory();
    abstract void uneEntree(Passager p);
    abstract void uneSortie(Passager p);
    abstract void changerArret();
    abstract void reinitialiser();
    abstract int getNbEntree();
    abstract int getNbSortie();
    abstract int getNumeroArret();
}
