package com.company;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] entree = {"bonjour","salut","mec"};
        Arrays.sort(entree);
        Aho_Corasick test = new Aho_Corasick();
        test.CreerArbo(entree);


    }
}
