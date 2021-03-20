package tec;

import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CollectFile extends Collect{
    private int prev_numeroArret;
    private int prev_nbEntree;
    private int prev_nbSortie;

    private FileWriter f;
    private String nomFichier;
    
    public CollectFile(){
	super();
	try{
	    nomFichier = "log.txt";
	    f = new FileWriter(nomFichier);
	}
	catch(java.io.IOException e){e.printStackTrace();}

	prev_numeroArret = 0;
	prev_nbEntree = 0;
	prev_nbSortie = 0;
    }
   
    public CollectFile(String nomDuFichier){
	super();
	try{
	    this.nomFichier = nomDuFichier;
	    f = new FileWriter(nomDuFichier);
	}
	catch(java.io.IOException e){}
    }

    private void ecrireFichier(int nbArret, int nbEntree, int nbSortie){
	PrintWriter p = new PrintWriter(f);	
	p.println("arret: "+ nbArret + ", nombre d'entrants: " + nbEntree + ", nombre de sortants: " + nbSortie);
	p.flush();
    }

    private String[] lireFichier(){
		/* FROM : https://www.developpez.net/forums/d518276/java/general-java/api-standards-tierces/entree-sortie/lecture-d-fichier-mettre-tableau/ */
	
	// Recupere les lignes du fichier
	String[] tableau = new String[0]; //création d'un fichier vide
	try {
	    java.io.InputStream ips = new java.io.FileInputStream(nomFichier); 
	    java.io.InputStreamReader ipsr = new java.io.InputStreamReader(ips);
	    java.io.BufferedReader br = new java.io.BufferedReader(ipsr);
	    String ligne;
	    //parcour du fichier
	    while ((ligne = br.readLine()) != null){
    	    	String[] oldTableau = tableau;
    	    	int noligne = oldTableau.length;
    	    	tableau = new String[noligne+1]; //afin d'ajouter la ligne on augmente la capacité du tableau
    	    	System.arraycopy(oldTableau, 0, tableau, 0, noligne);//on recopie le contenu de l'ancien tableau dans le nouveau
    	    	tableau[noligne] = ligne; //affectation de la ligne du fichier au dernier élément du tableau
	    }
	    br.close();
	}catch (Exception e){
	    System.out.println(e.toString());
	}
	
	return tableau;
    }

    public void recreerFichier(){
	// Supprime puis recreer le fichier
	try{
	    f.close();
	    java.io.File file = new java.io.File (nomFichier);
	    file.delete();
	    f = new FileWriter(nomFichier);
	}catch(Exception e){
	    e.printStackTrace();
	}
    }
    
    private void reecrireFichier(){
	// On lit le contenu du fichier et on le stocke dans tableau
	String tableau[] = lireFichier();

	// On recreer le fichier pour tout reecrire de zero
	recreerFichier();
	
	// On reecrit tout sauf la derniere ligne
	PrintWriter p = new PrintWriter(f);
	for (int i = 0; i < tableau.length-1; i++){
	    p.println(tableau[i]);
	}

	// On ajoute la nouvelle ligne avec les valeurs modifiees 
	ecrireFichier(prev_numeroArret, prev_nbEntree, prev_nbSortie);
    }
    
    void addMemory(){
	
	if (prev_numeroArret != getNumeroArret()){
	    ecrireFichier(getNumeroArret(), getNbEntree(), getNbSortie());
	    this.prev_numeroArret = getNumeroArret();
	    this.prev_nbEntree = getNbEntree();
	    this.prev_nbSortie = getNbSortie();
	    this.reinitialiser();
	}
	else {
	    this.prev_nbEntree += getNbEntree();
	    this.prev_nbSortie += getNbSortie();
	    reecrireFichier();
	    this.reinitialiser();
	}
    }    
}

