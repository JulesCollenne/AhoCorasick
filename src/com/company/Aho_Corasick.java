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



    public void CreerArbo( String [] Mots)
    {
        int num_etat = 1 ;

        this.initialisation_tab(CommandeTab);

            for(int i =0;i<Mots.length;i++) {
            String mot = Mots[i];
            int etatcourant=0;

                for(int j=0;j<mot.length();j++){
                    int caractere = mot.charAt(j);

                    System.out.println(" recuperation de " + (char)caractere);
                    if (CommandeTab[etatcourant][caractere] == -1) {
                        CommandeTab[etatcourant][caractere] = num_etat++;
                        System.out.println("l etat " + num_etat + " a ete rajoute " );
                        }
                    etatcourant=CommandeTab[etatcourant][caractere];
                    }


            }
    }

    public void afficherArbo(){
        for(int i=0;i<this.CommandeTab.length;i++){
            for(int j=0;j<this.CommandeTab[i].length;j++){
                if(CommandeTab[i][j]!=-1)
                    System.out.println(" transition depuis l'etat " + i + " avec le charactere " + (char)j + " vers l'etat " + CommandeTab[i][j] );
            }
            System.out.println();
        }
    }
}

