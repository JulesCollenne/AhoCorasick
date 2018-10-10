package main;

import java.util.*;

public class Algo {
    String[] mots_cle;
    int[][] commande;
    int[] echec;

    public void tri_alphabet()
    {
        Arrays.sort(mots_cle);
    }

    public void creer_etats() {
        int etat = 1;

        //i = longueur mot, j = mot dans le tab mots_cle
        int i = 0, j = 0;

        commande[mots_cle[0].charAt(0)][0] = 0;

        for (i = 0; i < mots_cle[j].length(); i++)
            for (j = 1; j < mots_cle.length; j++) {
                if (mots_cle[j].charAt(i) != mots_cle[j - 1].charAt()) {
                    commande[mots_cle[j].charAt(0)][0] = etat;
                    etat++;
                }
            }
    }

    }

    public  static void main(String[] args){
        Algo algo = new Algo();
        algo.mots_cle = args;
        Arrays.sort(algo.mots_cle);
        for(int i=0;i<algo.mots_cle.length;i++) {
            System.out.println(algo.mots_cle[i] + '\n');
        }
    }
}
