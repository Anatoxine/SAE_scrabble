public class Joueur {

    private String nom;
    private MEE chevalet;
    private int score;

    public Joueur(String unNom) {

        this.nom = unNom;
        this.chevalet = new MEE(26);
        this.score = 0;

    }

    public String toString() {

        return "\nNom : " + this.nom + "\nScore : " + this.score;

    }

    public int getScore() {

        return this.score;

    }

    public void ajouteScore(int nombre) {

        this.score += nombre;

    }

    public int nbPointsChevalet(int[] nbPointsJet) {
        
        return this.chevalet.sommeValeurs(nbPointsJet);

    }

    public void prendJetons(MEE s, int nbJetons) {

        s.transfereAleat(this.chevalet, nbJetons);

    }

    
}
