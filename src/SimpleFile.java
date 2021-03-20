import tec.*;

class SimpleFile {

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
      Transport serenity = new Greffon(new CollectFile("simple.txt"), new Autobus(3,3));


      //lorsque l'on, utilise une fonction interne d'autobus, le programme ne compile pas exemple avec : 
      //serenity.checherEmplacementVide();
    
    
    Usager kaylee = new PassagerIndecis("Kaylee", 4);
    Usager jayne = new PassagerStresse("Jayne", 4);
    Usager inara = new PassagerIndecis("Inara", 5);

    MonteeSportif test = new MonteeSportif("Franck", 5, ArretNerveux.NERVEUX);
    //test.comportement = ArretCalme.CALME; --> provoque une erreur
    
    //0
    System.out.println(serenity);

    serenity.allerArretSuivant();
    //1
    kaylee.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);

    serenity.allerArretSuivant();
    //2
    jayne.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);

    serenity.allerArretSuivant();
    //3
    inara.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //4
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //5
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
    }
   }
