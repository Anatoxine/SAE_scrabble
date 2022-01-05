public class MEE {

    public static void main(String[] args) {

        int[] tab = { 0, 5, 6, 9, 10, 1 };
        int[] tabBis = { 0, 0, 0, 0, 0, 0 };

        MEE a = new MEE(tab);

        int[] v = { 1, 5, 1, 2, 3, 1, 1, 1, 5, 1 };

        int nb = a.sommeValeurs(v);

        System.out.println(nb);
    }

    private int[] tableauFrequence;

    private int nombreTotalExemplaires; // nombre totale d'element dans notre multi-ensemble

    public MEE(int max) {

        this.tableauFrequence = new int[max];
        this.nombreTotalExemplaires = 0;

    }

    public MEE(int[] tab) {

        this.tableauFrequence = new int[tab.length];

        for (int i = 0; i < tab.length - 1; i++) {

            this.tableauFrequence[i] = tab[i];

        }

        this.nombreTotalExemplaires = 0;

        for (int j = 0; j < tab.length - 1; j++) {

            this.nombreTotalExemplaires += tab[j];

        }
    }

    public MEE(MEE e) {

        this.nombreTotalExemplaires = e.nombreTotalExemplaires;

        this.tableauFrequence = new int[e.tableauFrequence.length];

        for (int i = 0; i < this.tableauFrequence.length; i++) {

            this.tableauFrequence[i] = e.tableauFrequence[i];

        }

    }

    // cette fonction d'affichage me permet de tester
    // aisément les différentes fonctions de la classe
    public String toString() {

        String result = "Nombre total d'exemplaires : " + this.nombreTotalExemplaires + "\n\n";

        for (int i = 0; i < this.tableauFrequence.length; i++) {

            result += "Exemplaires de " + i + " : " + this.tableauFrequence[i] + "\n";

        }

        return result;

    }

    public boolean estVide() {

        return this.nombreTotalExemplaires == 0;

    }

    public void ajoute(int i) {

        this.tableauFrequence[i]++;
        this.nombreTotalExemplaires++;

    }

    public boolean retire(int i) {

        boolean result = this.tableauFrequence[i] > 0;

        if (result) {

            this.tableauFrequence[i]--;
            this.nombreTotalExemplaires--;

        }

        return result;

    }

    public int retireAleat() {

        int nombreExemplairesDifferents = 0;

        for (int i = 0; i < this.tableauFrequence.length; i++) {

            if (tableauFrequence[i] > 0) {

                nombreExemplairesDifferents++;

            }

        }

        int[] tableauExemplairesPresents = new int[nombreExemplairesDifferents];

        int indiceTabFreq = 0;
        int indiceTabExempPres = 0;

        while (indiceTabExempPres < tableauExemplairesPresents.length && indiceTabFreq < this.tableauFrequence.length) {

            if (this.tableauFrequence[indiceTabFreq] > 0) {

                tableauExemplairesPresents[indiceTabExempPres] = indiceTabFreq;
                indiceTabExempPres++;
                indiceTabFreq++;

            } else {

                indiceTabFreq++;

            }

        }

        int indiceAleat = Ut.randomMinMax(0, tableauExemplairesPresents.length - 1);

        int result = tableauExemplairesPresents[indiceAleat];

        this.tableauFrequence[result]--;
        this.nombreTotalExemplaires--;

        return result;

    }

    public boolean transfere(MEE e, int i) {

        boolean result = this.tableauFrequence[i] > 0;

        if (result) {

            this.tableauFrequence[i]--;
            this.nombreTotalExemplaires--;

            e.tableauFrequence[i]++;
            e.nombreTotalExemplaires++;

        }

        return result;

    }

    public int transfereAleat(MEE e, int k) {

        return this.transfereAleatAux(e, k, 0);
    }

    private int transfereAleatAux(MEE e, int k, int result) {

        if (this.nombreTotalExemplaires == 0 || k == 0) {

            return result;

        } else {

            int nombreExemplairesDifferents = 0;

            for (int i = 0; i < this.tableauFrequence.length; i++) {

                if (this.tableauFrequence[i] > 0)
                    nombreExemplairesDifferents++;

            }

            int[] tableauExemplairesPresents = new int[nombreExemplairesDifferents];

            int indiceTabFreq = 0;
            int indiceTabExempPres = 0;

            while (indiceTabExempPres < tableauExemplairesPresents.length
                    && indiceTabFreq < this.tableauFrequence.length) {

                if (this.tableauFrequence[indiceTabFreq] > 0) {

                    tableauExemplairesPresents[indiceTabExempPres] = indiceTabFreq;
                    indiceTabExempPres++;
                    indiceTabFreq++;

                } else {

                    indiceTabFreq++;

                }

            }

            int indiceAleat = Ut.randomMinMax(0, tableauExemplairesPresents.length - 1);

            this.transfere(e, tableauExemplairesPresents[indiceAleat]);

            return this.transfereAleatAux(e, k - 1, result + 1);

        }

    }

    public int sommeValeurs(int[] v) {

        int result = 0;

        for (int i = 0; i < this.tableauFrequence.length; i++)
            result += this.tableauFrequence[i] * v[i];

        return result;

    }

}
