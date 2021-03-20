/**
 * Cette interface publique permet l'acces par le client a la methode monterDans(Transport t)
 */

package tec;



public interface Usager{
    /*
     *Cette methode permet au passager d'adopter une position à l'interieur du véhicule si cela est
     *possible
     */    
    public void monterDans(Transport t) throws TecException;
}
