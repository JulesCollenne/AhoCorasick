public class Arborescence {

    static int maxChar = 130;
    static int maxState = 100;

    int CommandeTab[][]= new int [maxState][maxChar];
    String output[] = new String[maxState];

    public void initialisation_tab(int tab[][]) {

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = -1;
            }
        }
    }

    public Arborescence(){
        initialisation_tab(CommandeTab);
    }

    public void CreerArbo(String [] Mots){
        int newState = 0;
        for(int i=0;i<Mots.length;i++)
            newState = enter(Mots[i],newState);
        for(int i =0;i<maxChar;i++){
            if(CommandeTab[0][i]==-1)
                CommandeTab[0][i]=0;
        }
    }

    public int enter(String Mot,int newState){
        int state = 0, i;
        for(i = 0;i < Mot.length(); i++){
            if(CommandeTab[state][Mot.charAt(i)] != -1)
                state = CommandeTab[state][Mot.charAt(i)];
            else break;
        }

        for(int p = i;p < Mot.length();p++){
            newState++;
            CommandeTab[state][Mot.charAt(p)] = newState;
            state = newState;
        }
        output[state] = Mot;
        return newState;
    }

    public void afficherArbo(){
        for(int i=0;i<this.CommandeTab.length;i++){
            for(int j=0;j<this.CommandeTab[i].length;j++){
                if(CommandeTab[i][j] > 0)
                    System.out.println(i + " " + CommandeTab[i][j] + " " + (char)j + '\n');
            }
        }
    }
}

