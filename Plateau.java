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
        String res="_______________\n";
        for(int i=0;i<15;i++){
            res+="|";

            for(int j=0;j<15;j++){

                
                if(!g[i][j].estRecouverte()&& g[i][j].getCouleur()!=1){
                    res+= g[i][j].getCouleur();
                }

                

            }

            res+="|\n";
        }
        
        return res;
    }

    public static void main(String[] args){
        Plateau plat;
        plat = new Plateau();
        Ut.afficher(plat.toString());
    }

    
}
