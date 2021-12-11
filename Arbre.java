public class Arbre {

    public char lettre;
    private ArbreListe branches;

    public static void main(String[] args) {
        
        Arbre arbre = new Arbre('0', new ArbreListe(new Arbre('a', new ArbreListe(new Arbre('a'))), new ArbreListe(new Arbre('b', new ArbreListe(new Arbre('a'), new ArbreListe(new Arbre('b')))), new ArbreListe(new Arbre('c')))));

        System.out.println(arbre.branches.length);

        System.out.println(arbre.contient("ac"));
    }
    
    public Arbre() {

        this.branches = new ArbreListe();
        this.lettre = '0';

    }

    public Arbre(char a) {
        
        this.lettre = a;
        this.branches = null;

    }

    public Arbre(ArbreListe al) {

        this.lettre = '0';
        this.branches = al;

    }

    public Arbre(char a, ArbreListe al) {
 
        this.lettre = a;
        this.branches = al;

    }

    public boolean contient(String mot){

        return true;

    }


    
}
