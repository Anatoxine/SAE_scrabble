
public class ArbreListe {

    /* 
    */

    public static void main(String[] args) {

        
    }
    
    private Arbre tete;
    private ArbreListe queue;
    public int length;

    public ArbreListe() {

        this.queue = null;
        this.tete = new Arbre();
        this.length = 0;

    }

    public ArbreListe(Arbre tete) {

        this.tete = tete;
        this.queue = null;
        this.length = 1;

    }

    public ArbreListe(Arbre tete, ArbreListe queue) {

        this.tete = tete;
        this.queue = queue;
        this.length = 1 + queue.length;

    }

    public ArbreListe(ArbreListe aCopie) {

        this.tete = aCopie.tete;
        this.queue = aCopie.queue;
        this.length = aCopie.length;
    }



    public void ajoutTete(Arbre element) {

        this.queue = new ArbreListe(this.tete, this.queue);
        this.tete = element;
        this.length++;

    }

    public Arbre retireTete() {

        Arbre resultat = this.tete;

        this.tete = this.queue.tete;
        this.queue = this.queue.queue;
        this.length--;

        return resultat;

    }

    public Arbre index(int i) {

        switch (i) {

            case 0:
            return this.tete;

            default:
            return this.queue.index(i - 1);

        }
    }
}
