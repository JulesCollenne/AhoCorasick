package main;

import java.util.*;

public class Algo {
    private static int maxState = 500;
    private static int maxChar = 100;

    private String[] mots_cles;
    private static int[][] commande = new int[maxState][maxChar];
    private String output[] = new String[maxState];
    private int echec[] = new int[maxState];

    /**
     * @param args mots_clés
     */
    Algo(String[] args){
        mots_cles = args;
    }

    /**
     *
     * @param imot numéro du mot clé
     * @param ilettre numéroe de la lettre du mot i
     * @return vrai si etat existe faux sinon
     *//*
    public boolean EtatExiste(int imot, int ilettre){
        int etat = 0;
        for(int i=0;i<26;i++){
            if(i == NumLettre(mots_cles[imot][i]))
                commande[etat][i];
        }
        return true;
    }*/

    /**
     * Fonction "Goto" qui créé l'automate à partir des mots clés
     * Version professeur
     */
/*
    public void Creer_Etats() {
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
*/

    /**
     * Version originale
     */

    /**
     *
     * @param etat
     * @return
     */
    public String output(int etat){

        return null;
    }

    /**
     * Remplis la matrice commande de sorte à créé les aretes
     * de l'automate utilisé lors de la découverte du mot "mot"
     * @param mot que l'on ajoute à l'automate
     * @param nouvelEtat : Dernier etat créé
     * @return
     */
    public int enter(String mot, int nouvelEtat){
        int etat = 0, j = 1;

        while(commande[etat][mot.charAt(j)] != -1){
            etat = commande[etat][mot.charAt(j)];
            j++;
        }

        for(int p = j; p < mot.length(); p++){
            nouvelEtat++;
            commande[etat][mot.charAt(p)] = nouvelEtat;
            etat = nouvelEtat;
        }
        output[etat] = mot;
        return nouvelEtat;
    }

    /**
     * Créé les etats de l'automate à partir des mots clés.
     */
    public void Creer_Etats(){
        int nouvelEtat = 0;
        for(int i = 0; i < mots_cles.length; i++){
            nouvelEtat = enter(mots_cles[i],nouvelEtat);
        }
        for(int i = 0; i < maxChar; i++){
            if(commande[0][i] == -1)
                commande[0][i] = 0;
        }
    }

    public void initialise(int tab[]){
        for(int i = 0; i < tab.length; i++){
            tab[i] = -1;
        }
    }

    public boolean isEmpty(int tab[]){
        for(int i=0;i<tab.length;i++){
            if(tab[i] != -1)
                return false;
        }
        return true;
    }

    /**
     * La fonction "failure" qui renvoie l'etat dans lequel aller si jamais l'etat
     * "etat" a fail
     * @param etat, l'etat qui a fail
     * @return le prochain etat
     */
    public int Fail(int etat){
        int queue[] = new int[maxState]; //vide
        initialise(queue);
        int etatQueue = 0;

        for(int i = 0; i < maxChar; i++){
            if(commande[0][i] != 0){
                queue[etatQueue] = i;
                etatQueue++;
                echec[commande[0][i]] = 0;
            }
        }
        while(!isEmpty(queue)){

        }
        return 0;
    }

    /**
     * Renvoie la sortie de l'etat actuel
     * @param etat actuel
     * @return le mot clé trouvé ou null
     */
    public String Sortie(int etat){
        return mots_cles[0];
    }

    /**
     * Probablement a refaire avec une classe etat,
     * pour l'instant, retourner -1 est equivalent a fail
     * @param etat
     * @param car
     * @return
     */
    private int Goto(int etat, char car){
        return -1;
    }

    private void AfficheSortie(int etat, int i){
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

    public void FaireAlgo(){
        Creer_Etats();

        for(int i=0;i<mots_cles.length;i++) {
            System.out.println(mots_cles[i] + '\n');
        }
    }
}
