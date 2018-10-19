import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        String[] entree = {"coup","arte","cle","table","cart"};
        Arrays.sort(entree);
        Arborescence test = new Arborescence();
        test.CreerArbo(entree);
        test.afficherArbo();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        Failure fail = new Failure(test,queue);
        fail.creer_fail();
        fail.afficher_fail();

        Lecture lect = new Lecture(test,fail);
        lect.Lire("Le coup de la cle met le carte sur la table, mais je pense que tart");
    }
}
