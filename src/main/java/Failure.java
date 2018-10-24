import java.util.LinkedList;

public class Failure  {

    Arborescence arborescence;
    LinkedList<Integer> queue;

    int []fail= new int[200];

    Failure(Arborescence arborescence,LinkedList queue){
        this.arborescence=arborescence;
        this.queue=queue;
    }

    public void initialiseFail(){
        for(int i=0;i<fail.length;i++){
            fail[i] = 0;
        }
    }

    public boolean isFail(int state, int i){
        return arborescence.CommandeTab[state][i] == -1;
    }

    public void creer_fail(){
        int state,s;
        for(int i=0;i<arborescence.maxChar;i++) {
            if (arborescence.CommandeTab[0][i] > 0) {
                s = arborescence.CommandeTab[0][i];
                queue.add(s);
                System.out.println("ajout de "+s);
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

    void afficher_fail(){
        for(int i=0;i<fail.length;i++){
            if(fail[i] != 0)
              System.out.println(" si " + i + " fail , on va dans l'etat  " + fail[i]);
        }
    }

    public void creer_delta(){
        int state,s;
        for(int i=0;i<arborescence.maxChar;i++) {
            if (arborescence.CommandeTab[0][i] > 0) {
                s = arborescence.CommandeTab[0][i];
                queue.add(s);
                System.out.println("ajout de "+s);
            }
        }
        while(!queue.isEmpty()){
            int r = queue.removeFirst();
            for(int i=0;i<arborescence.maxChar;i++) {
                if (arborescence.CommandeTab[r][i] != -1){
                    s = arborescence.CommandeTab[r][i];
                    queue.add(s);
                    if(arborescence.output[fail[s]] != null)
                        arborescence.output[s] += " " + arborescence.output[fail[s]];
                }
            }
        }
    }
}
