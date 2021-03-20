import tec.Usager;
import tec.Transport;
import tec.Autobus;
import tec.PassagerIndecis;
import tec.PassagerStresse;
import tec.MonteeSportif;
import tec.ArretNerveux;
import tec.ArretCalme;
import tec.TecException;

class Simple {

  /*
   * Affiche l'etat des deux instances passees en parametre.
   * La methode println(Object x) de la classe PrintWriter 
   * declenche la methode toString() sur l'objet passe 
   * en parametre (x.toString()) et affiche la chaine 
   * de caracteres obtenue..
   */
    static private void deboguerEtat (Autobus t, PassagerIndecis p) {
    System.out.println(p);
    System.out.println(t);
  }

    static private void deboguerEtat (Autobus t, PassagerStresse p) {
    System.out.println(p);
    System.out.println(t);
    }

  static public void main (String[] args) throws TecException{
      Transport serenity = new Autobus(3, 3);
    
    
    Usager kaylee = new PassagerIndecis("Kaylee", 4);
    Usager jayne = new PassagerStresse("Jayne", 4);
    Usager inara = new PassagerIndecis("Inara", 5);

    System.out.println("***EXECUTION Simple***");
    //0
    System.out.println(serenity);
    System.out.println();
    
    serenity.allerArretSuivant();

    //1
    kaylee.monterDans(serenity);
    
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println();
    
    serenity.allerArretSuivant();

    //2
    jayne.monterDans(serenity);
    
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println();
    
    serenity.allerArretSuivant();

    //3
    inara.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
    System.out.println();
    
    serenity.allerArretSuivant();
    //4
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
    System.out.println();
    
    serenity.allerArretSuivant();
    //5
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
    System.out.println();
    }
   }

