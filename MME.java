public class MME {

    public static void main(String[] args) {

        int[] tab = {4,5,6,9,10,1};
        MME a = new MME(tab);
        System.out.println(a.nombreTotalExemplaires);

    }
    
    private int[] tableauFrequence; /* pour tout indice i, donne le nombre d'exemplaire de la lettre 
    d'indice i dans l'alphabet (a => indice 0, b => indice 1, etc) */
 
    private int nombreTotalExemplaires; //nombre totale d'element dans notre multi-ensemble

    public MME(int max) {

        this.tableauFrequence = new int[max];
        this.nombreTotalExemplaires = 0;

    }

    public MME(int[] tab) {

        this.tableauFrequence = new int[tab.length];

        for (int i = 0; i < tab.length - 1; i++) {

            this.tableauFrequence[i] = tab[i];

        }

        this.nombreTotalExemplaires = 0;

        for (int j = 0; j < tab.length - 1; j++) {

            this.nombreTotalExemplaires += tab[j];

        }
    }

}
