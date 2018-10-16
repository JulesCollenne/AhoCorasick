package com.company;

import java.util.LinkedList;

public class Failure  {

    Arborescence arborescence;
    LinkedList<Integer> queue;

    int []fail= new int[100];

    Failure(Arborescence arborescence){
        this.arborescence=arborescence;
        queue=null;
    }

    public void creer_fail(){

        int etat_test;
        for(int i=0;i<arborescence.maxChar;i++) {
            if (arborescence.CommandeTab[0][i] != -1) {
                queue.add(arborescence.CommandeTab[0][i]);
                fail[arborescence.CommandeTab[0][i]] = 0;
            }
        }
        while(queue.size()!=0){
            int etatcourant= queue.removeFirst();
            for(int i=0;i<arborescence.maxChar;i++) {
                if (arborescence.CommandeTab[etatcourant][i] != -1){
                    queue.add(arborescence.CommandeTab[etatcourant][i]);
                    etat_test=fail[etatcourant];
                    while(arborescence.CommandeTab[etat_test][i]==-1)
                    { etat_test=fail[etat_test];}

                    fail[arborescence.CommandeTab[etatcourant][i]]=arborescence.CommandeTab[etat_test][i];

                }

            }
        }


    }


}
