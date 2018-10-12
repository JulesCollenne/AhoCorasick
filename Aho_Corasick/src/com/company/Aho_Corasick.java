package com.company;

public class Aho_Corasick {

    static int maxChar = 130;
    static int maxState = 100;

    int CommandeTab[][]= new int [maxState][maxChar];

    public void initialisation_tab(int tab[][]) {

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = -1;
            }
        }
    }

    public int TaillePlusGrandMot(String[] Mots) {

        int Taillecourante = Mots[0].length();
        for (int i = 1; i < Mots.length; i++) {
            if (Mots[i].length() > Taillecourante) {

                Taillecourante = Mots[i].length();
            }
        }
        return Taillecourante;
    }

    public void CreerArbo( String [] Mots)
    {
        int num_etat = 0 ;
        int etatcourant = 0;
        int profondeur = 0;

        this.initialisation_tab(CommandeTab);


        while (profondeur<this.TaillePlusGrandMot(Mots)){

            for(int i =0;i<Mots.length;i++) {
            String mot = Mots[i];
                if (profondeur < mot.length()) {
                    int caractere = mot.charAt(profondeur);
                    System.out.println(" recuperation de " + (char)caractere);
                    if (CommandeTab[etatcourant][caractere] == -1) {
                        CommandeTab[etatcourant][caractere] = num_etat;
                        System.out.println("l etat " + num_etat + " a ete rajoute " );
                        num_etat++;
                        etatcourant=CommandeTab[etatcourant][caractere];
                        }
                    }
                }
                profondeur++;
            }
    }

    public void afficherArbo(){
        for(int i=0;i<this.CommandeTab.length;i++){
            for(int j=0;j<this.CommandeTab[i].length;j++){
                System.out.println(" "+CommandeTab[i][j]);
            }
            System.out.println();
        }
    }
}

