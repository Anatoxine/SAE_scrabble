public class Plateau {

   
    private Case[][] g = new Case[15][15];

    public Plateau() {

        int[][] plateau = {
                { 5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5 },
                { 1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1 },
                { 1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1 },
                { 2, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 2 },
                { 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1 },
                { 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1 },
                { 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1 },
                { 5, 1, 1, 2, 1, 1, 1, 4, 1, 1, 1, 2, 1, 1, 5 },
                { 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1 },
                { 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1 },
                { 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1 },
                { 2, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 2 },
                { 1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1 },
                { 1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1 },
                { 5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5 }
        };

        for (int i = 0; i < 15; i++) {

            for (int j = 0; j < 15; j++) {
                g[i][j] = new Case(plateau[i][j]);
            }

        }
    }

    public Plateau(Case[][] plateau) {
        this.g = plateau;
    }

    public String toString() {
        String res = "   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15\n";
        res += "   ____________________________________________________________\n";
        char let = 'A';
        for (int i = 0; i < 15; i++, let++) {
            res += let + " |";

            for (int j = 0; j < 15; j++) {

                if (!g[i][j].estRecouverte() && g[i][j].getCouleur() != 1) {
                    res += g[i][j].getCouleur() + "   ";
                } else if (!g[i][j].estRecouverte() && g[i][j].getCouleur() == 1) {
                    res += "    ";
                } else {
                    res += g[i][j].getLettre() + "   ";
                }
            }

            if (i < 14) {
                res += "|\n";
                res += "\n";
            } else {
                res += "|\n";
            }

        }

        res += "   ____________________________________________________________\n";

        return res;
    }

    public boolean placementValide(String mot, int numLig, int numCol, char sens, MEE e) {

        boolean res = false;

        if (this.g[7][7].getLettre() == '0') {

            switch (sens) {

                case 'h':
                    res = numLig == 7 && 7 >= numCol && 7 <= numCol + mot.length() && mot.length() >= 2
                            && e.contientMot(mot);
                    break;

                case 'v':
                    res = numCol == 7 && 7 >= numLig && 7 <= numLig + mot.length() && mot.length() >= 2
                            && e.contientMot(mot);
                    break;
            }

        } else {

            boolean depassement = sens == 'v'
                    ? numLig + mot.length() <= 14
                    : numCol + mot.length() <= 14;

            

            depassement = depassement && numCol >= 0 && numLig >= 0;

            boolean niPrecedeeNiSuivie = sens == 'v'
                    ? (numLig == 0 || !this.g[numLig - 1][numCol].estRecouverte())
                            && (numLig + mot.length() - 1 == 14
                                    || !this.g[numLig + mot.length()][numCol].estRecouverte())
                    : (numCol == 0 || !this.g[numLig][numCol - 1].estRecouverte())
                            && (numCol + mot.length() - 1 == 14
                                    || !this.g[numLig][numCol + mot.length()].estRecouverte());

            /*
             * System.out.println("droite " + (numLig + mot.length() - 1 == 14 ||
             * !this.g[numLig + mot.length()][numCol].estRecouverte()));
             * System.out.println("gauche " + (numLig == 0 || !this.g[numLig -
             * 1][numCol].estRecouverte()));
             * System.out.println("gg " + (numLig + mot.length() - 1 == 14));
             */

            boolean auMoinsUneNonRecouverte = false;
            boolean auMoinsUneRecouverte = false;
            boolean lettreCorrespond = true;

            String motNonPresent = "";

            if (sens == 'v') {

                for (int i = numLig; i < numLig + mot.length(); i++) {

                    if (this.g[i][numCol].estRecouverte()) {

                        auMoinsUneRecouverte = true;
                        lettreCorrespond = this.g[i][numCol].getLettre() == mot.charAt(i - numLig);

                    } else {

                        auMoinsUneNonRecouverte = true;
                        motNonPresent += mot.charAt(i - numLig);

                    }

                }

            } else {

                for (int i = numCol; i < numCol + mot.length(); i++) {

                    if (this.g[numLig][i].estRecouverte()) {

                        auMoinsUneRecouverte = true;
                        lettreCorrespond = this.g[numLig][i].getLettre() == mot.charAt(i - numCol);

                    } else {

                        auMoinsUneNonRecouverte = true;
                        motNonPresent += mot.charAt(i - numCol);

                    }

                }

                

            }

            res = depassement && niPrecedeeNiSuivie && e.contientMot(motNonPresent) && auMoinsUneNonRecouverte
                        && auMoinsUneRecouverte && lettreCorrespond;

           

        }

        return res;

    }

    public static boolean verifCapeloDico(String mot) {
        Ut.afficher("le mot " + mot
                + " existe-t-il bien dans le dictionnaire et est-il en majuscule?   Si oui tappez true, sinon tappez false  ");
        return Ut.saisirBooleen();
    }

    public int nbPointsPlacement(String mot, int numLig, int numCol, char sens, int[] nbPointsJet) {

        int nbPoint = 0;
        int motCompteDouble = 0;
        boolean motCompteTriple = false;

        if (sens == 'h') {

            for (int i = 0; i < mot.length(); i++) {

                if (g[numLig][numCol + i].getCouleur() < 4) {

                    nbPoint += nbPointsJet[MEE.valeurLettre(mot.charAt(i))] * g[numLig][numCol + i].getCouleur();

                } else {

                    nbPoint += nbPointsJet[MEE.valeurLettre(mot.charAt(i))];

                    switch (g[numLig][numCol + i].getCouleur()) {

                        case 4:
                            motCompteDouble++;
                            break;
                        case 5:
                            motCompteTriple = true;
                            break;
                    }
                }

            }

        } else {

            for (int i = 0; i < mot.length(); i++) {

                if (g[numLig + i][numCol].getCouleur() < 4) {

                    nbPoint += nbPointsJet[MEE.valeurLettre(mot.charAt(i))] * g[numLig + i][numCol].getCouleur();

                }

                else {

                    nbPoint += nbPointsJet[MEE.valeurLettre(mot.charAt(i))];

                    switch (g[numLig + i][numCol].getCouleur()) {

                        case 4:
                            motCompteDouble++;
                            break;
                        case 5:
                            motCompteTriple = true;
                            break;

                    }
                }

            }
        }

        nbPoint = nbPoint * Ut.puissance(2, motCompteDouble);

        if (motCompteTriple) {

            nbPoint = nbPoint * 3;
        }

        return nbPoint;
    }

    public int place(String mot, int numLig, int numCol, char sens, MEE e) {

        if (sens == 'h') {

            for (int i = 0; i < mot.length(); i++) {
                g[numLig][numCol + i].setLettre(mot.charAt(i));
                e.retire(MEE.valeurLettre(g[numLig][numCol + i].getLettre()));
            }
        }

        else {

            for (int i = 0; i < mot.length(); i++) {
                g[numLig + i][numCol].setLettre(mot.charAt(i));
                e.retire(MEE.valeurLettre(g[numLig + i][numCol].getLettre()));
            }

        }
        return mot.length();
    }

} // end class
