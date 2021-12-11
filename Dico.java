import java.io.*;
import java.util.*;

public class Dico {

    private String[] listeMots;

    public Dico(String source){

        try{

            Scanner scan = new Scanner(new File(source));

            int nombreDeMots = 0;

            while (scan.hasNextLine()) {

                nombreDeMots++;
                scan.nextLine();

            }

            this.listeMots = new String[nombreDeMots];

        } 
        
        catch (EmptyStackException e) {

            System.err.println("Empty source");

        }

        catch (FileNotFoundException e) {

            System.err.println("File not found");

        }

    }

    public static void main(String[] args) {

        Dico a = new Dico("dicoReference.txt");

        System.out.println(a.listeMots.length);
        
    }
}