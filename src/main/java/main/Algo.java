package main;

import java.util.*;

public class Algo {
    private String[] mots_cle;
    private int[][] commande;
    int[] echec;

    public void tri_alphabet()
    {
        Arrays.sort(mots_cle);
    }

    /**
     * Fonction "Goto" qui créé l'automate à partir des mots clés
     */
    public void creer_etats() {
        int from = 0;
        int to = 1;
        int i = 0,j = 0;

        commande[mots_cle[0].charAt(0)][0] = to;
        to++;

        for(i=0;i<mots_cle[j].length();i++) {
            for (j = 1; j < mots_cle.length; j++) {
                if (mots_cle[j].charAt(i) != mots_cle[j - 1].charAt(i)) {
                    commande[mots_cle[j].charAt(i)][from] = to;
                    to++;
                }
            }
            from++;
        }
    }

    /**
     * La fonction "failure" qui renvoie l'etat dans lequel aller si jamais l'etat
     * "etat" a fail
     * @param etat, l'etat qui a fail
     * @return le prochain etat
     */
    public int Fail(int etat){
        return 0;
    }

    /**
     * Renvoie la sortie de l'etat actuel
     * @param etat actuel
     * @return le mot clé trouvé ou null
     */
    public String Sortie(int etat){
        return mots_cle[0];
    }

    /**
     * Probablement a refaire avec une classe etat,
     * pour l'instant, retourner -1 est equivalent a fail
     * @param etat
     * @param car
     * @return
     */
    public int Goto(int etat, char car){
        return -1;
    }

    public void AfficheSortie(int etat, int i){
        System.out.println(i + " " + Sortie(etat));
    }

    public void Lecture(String texte){
        int etat = 0;
        int i;
        for(i=0;i<texte.length();i++){
            while(Goto(etat,texte.charAt(i)) == -1)
                etat = echec[etat];
            etat = Goto(etat,texte.charAt(i));
            if(Sortie(etat) != null){
                AfficheSortie(etat,i);
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
