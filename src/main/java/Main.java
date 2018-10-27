import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        String[] entree = {"boule", "oule","moule","roule","carticle","chimpanze","soupe"};
        Arrays.sort(entree);
        Arborescence test = new Arborescence();
        test.CreerArbo(entree);
        test.afficherArbo();
        LinkedList<Integer> queue = new LinkedList<>();
        Failure fail = new Failure(test,queue);
        fail.creer_fail();
        fail.creer_delta();
        test.afficherArbo();
        String texte = null;
        try {
            texte = utils.readFile("7germ10.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lecture lect = new Lecture(test,fail);
        lect.Lire(texte);

    }
}
