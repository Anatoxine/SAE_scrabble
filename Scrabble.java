public class Scrabble {

    public static void main(String[] args) {

      //  Joueur[] joueurs = {new Joueur("beuteu")};
      //  new Scrabble(joueurs);
        int []tab={3,2,5};
        MEE chevalet= new MEE (tab);
        Plateau plateau=new Plateau();
       

    }
    
    private Joueur[] joueurs;
    private int numJoueur;
    private Plateau plateau;
    private MEE sac;
    
    public static  int[] nbPointsJeton = {1,3,3,2,1,4,2,4,1,8,10,1,2,1,1,3,8,1,1,1,1,4,10,10,10,10};

    public Scrabble(String[] joueurs) {

        this.joueurs = new Joueur[joueurs.length];

        for(int i = 0; i < joueurs.length; i++) this.joueurs[i] = new Joueur(joueurs[i]);
        
        this.numJoueur = Ut.randomMinMax(1, joueurs.length);
        this.plateau = new Plateau();
        int[] distributionLettres = {9,2,2,3,15,2,2,2,8,1,1,5,3,6,6,2,1,6,6,6,6,2,1,1,1,1};
        this.sac = new MEE(distributionLettres);
        
    }
}
