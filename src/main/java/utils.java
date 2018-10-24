import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class utils {
    public static String LisFichier(String file){
        File f = new File (file);
        String texte = new String();
        try {
            FileReader fr = new FileReader(f);
            try {
                int c = fr.read();
                while (c != -1) {
                    texte += (char)c;
                    c = fr.read();
                }
            }
            catch (IOException exception) {
                System.out.println("Erreur lors de la lecture : " + exception.getMessage());
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("Le fichier n'a pas été trouvé");
        }
        return texte;
    }
}
