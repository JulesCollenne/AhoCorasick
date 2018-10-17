public class Arborescence {

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

    public void CreerArbo(String [] Mots){
        int newstate =0;
        for(int i=0;i<Mots.length;i++)
            enter(Mots[i]);
        for(int i =0;i<maxChar;i++){
            if(CommandeTab[0][i]==-1)
                CommandeTab[0][i]=0;
        }
    }

    public void enter(String Mot){


    }

    public void afficherArbo(){
        for(int i=0;i<this.CommandeTab.length;i++){
            for(int j=0;j<this.CommandeTab[i].length;j++){
                if(CommandeTab[i][j]!=-1)
                    System.out.println(i + " " + CommandeTab[i][j] + " " + (char)j + '\n');
            }
        }
    }
}

