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
            //System.out.println("l'etat suivant est "+r);
            for(int i=0;i<arborescence.maxChar;i++) {
                if (arborescence.CommandeTab[r][i] != -1){
                    s = arborescence.CommandeTab[r][i];
                    queue.add(s);
                    //System.out.println("ajout de "+arborescence.CommandeTab[r][i]);
                    state=fail[r];
                    while(arborescence.CommandeTab[state][i]==-1) {
                        state=fail[state];
                    }
                    fail[s]=arborescence.CommandeTab[state][i];
                    //output[s] = output[s] + output[fail[s]]; //TODO
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
}
