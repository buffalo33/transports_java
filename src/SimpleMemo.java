import tec.*;

class SimpleMemo {

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
      CollectMemo memo = new CollectMemo();
      Transport serenity = new Greffon(memo, new Autobus(3,3));
      
      //lorsque l'on, utilise une fonction interne d'autobus, le programme ne compile pas exemple avec : 
      //serenity.checherEmplacementVide();
    
    
    Usager kaylee = new PassagerIndecis("Kaylee", 4);
    Usager jayne = new PassagerStresse("Jayne", 4);
    Usager inara = new PassagerIndecis("Inara", 5);

    System.out.println("***EXECUTION SimpleMemo***");
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
    System.out.println(memo.toString());
    System.out.println();
  }
}
