package com.company;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] entree = {"coup","art","cle","table","cart"};
        Arrays.sort(entree);
        Arborescence test = new Arborescence();
        test.CreerArbo(entree);
        test.afficherArbo();


    }
}
