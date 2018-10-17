import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        String[] entree = {"coup","art","cle","table","cart"};
        Arrays.sort(entree);
        Arborescence test = new Arborescence();
        test.CreerArbo(entree);
        test.afficherArbo();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        Failure fail = new Failure(test,queue);
        fail.creer_fail();
        fail.afficher_fail();


    }
}
