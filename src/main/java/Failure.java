import java.util.LinkedList;

/**
 * Failure contient une arborescence, une liste chainé qui sera utilisée
 * lors de la construction du tableau "fail"
 * Et un tableau fail qui, pour chaque état,
 */
public class Failure  {

    Arborescence arborescence;
    LinkedList<Integer> queue;

    int[] fail= new int[200];

    Failure(Arborescence arborescence,LinkedList queue){
        this.arborescence=arborescence;
        this.queue=queue;
    }

    /**
     * On dira qu'une transition "fail" si cette derniere n'est pas utilisée
     * (pour le moment, voir méthode "creer_delta") à la création d'un mot
     * @param state Etat actuel
     * @param i Caractère lu
     * @return Vrai si la combinaison (state,i) fail, faux sinon
     */
    public boolean isFail(int state, int i){
        return arborescence.CommandeTab[state][i] == -1;
    }

    /**
     * Remplis le tableau fail d'arborescence
     * C
     */
    public void creer_fail(){
        int state,s;
        for(int i=0;i<arborescence.maxChar;i++) {
            if (arborescence.CommandeTab[0][i] > 0) {
                s = arborescence.CommandeTab[0][i];
                queue.add(s);
                fail[s] = 0;
            }
        }
        while(!queue.isEmpty()){
            int r= queue.removeFirst();
            for(int i=0;i<arborescence.maxChar;i++) {
                if (!isFail(r,i)){
                    s = arborescence.CommandeTab[r][i];
                    queue.add(s);
                    state=fail[r];
                    while(isFail(state,i)) {
                        state=fail[state];
                    }
                    fail[s]=arborescence.CommandeTab[state][i];
                    if(arborescence.output[fail[s]] != null)
                        arborescence.output[s] += " " + arborescence.output[fail[s]];
                }

            }
        }
    }

    /**
     * Affiche le tableau fail[]
     */
    void afficher_fail(){
        for(int i=0;i<fail.length;i++){
            if(fail[i] != 0)
              System.out.println(" si " + i + " fail , on va dans l'etat  " + fail[i]);
        }
    }

    /**
     * Remplis une seconde fois CommandeTab en utilisant le tableau fail
     * De ce fait, l'automate deviens finis et deterministe
     * Il n'y a donc plus de "fail" (=-1) dans CommandeTab,
     * Ces derniers sont remplacés par des transitions normale dans CommandeTab
     */
    public void creer_delta(){
        int s;
        for(int i=0;i<arborescence.maxChar;i++) {
            if (arborescence.CommandeTab[0][i] > 0)
                queue.add(arborescence.CommandeTab[0][i]);
        }
        while(!queue.isEmpty()){
            int r = queue.removeFirst();
            for(int i=0;i<arborescence.maxChar;i++) {
                if (arborescence.CommandeTab[r][i] != -1)
                    queue.add(arborescence.CommandeTab[r][i]);
                else
                    arborescence.CommandeTab[r][i] = arborescence.CommandeTab[fail[r]][i];
            }
        }
    }
}
