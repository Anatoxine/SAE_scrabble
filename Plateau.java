public class Plateau {
    
    private Case [][] g = new Case [15] [15];


    public Plateau(){


        int [][] plateau ={
            {5,1,1,2,1,1,1,5,1,1,1,2,1,1,5},
            {1,4,1,1,1,3,1,1,1,3,1,1,1,4,1},
            {1,1,4,1,1,1,2,1,2,1,1,1,4,1,1},
            {2,1,1,4,1,1,1,2,1,1,1,4,1,1,2},
            {1,1,1,1,4,1,1,1,1,1,4,1,1,1,1},
            {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
            {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
            {5,1,1,2,1,1,1,4,1,1,1,2,1,1,5}, 
            {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
            {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
            {1,1,1,1,4,1,1,1,1,1,4,1,1,1,1},
            {2,1,1,4,1,1,1,2,1,1,1,4,1,1,2},
            {1,1,4,1,1,1,2,1,2,1,1,1,4,1,1},
            {1,4,1,1,1,3,1,1,1,3,1,1,1,4,1},
            {5,1,1,2,1,1,1,5,1,1,1,2,1,1,5}
        };
        
        for(int i=0;i<15;i++){

            for(int j=0;j<15;j++){
                g[i][j]= new Case(plateau[i][j]);
            }
        
        }
    }
    

    public Plateau (Case[][] plateau) {
        this.g = plateau;
    }

    public String toString(){
        String res="   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15\n";
        res+="   ____________________________________________________________\n";
        char let = 'A';
        for(int i=0;i<15;i++, let++){
            res+= let +" |";

            for(int j=0;j<15;j++){

                
                if(!g[i][j].estRecouverte()&& g[i][j].getCouleur()!=1){
                    res+= g[i][j].getCouleur()+"   ";
                }
                else if(!g[i][j].estRecouverte()&& g[i][j].getCouleur()==1){
                    res+="    ";
                }
                else{
                    res+= g[i][j].getLettre();
                }
            }

           if(i<14){
               res+="|\n";
                res+="\n";
            }
            else{
                res+="|\n";
            }
            
        }

        res+="    ____________________________________________________________\n";
        
        return res;
    }

     public boolean placementValide(String mot,int numLig, int numCol,char sens,MEE e){
        boolean res=false;
        MEE chevalet= new MEE(26);
        if(mot.length()>=2){

        }


     } 

    public static boolean verifCapeloDico(String mot){
        Ut.afficher("le mot "+mot+" existe-t-il bien dans le dictionnaire et est-il en majuscule?   Si oui tappez true, sinon tappez false  ");
        return Ut.saisirBooleen();
    }


    public static void main(String[] args){

        Plateau grille= new Plateau();
        Ut.afficher(grille.toString());
        Ut.afficher(verifCapeloDico("kawai"));
    }

    
}
