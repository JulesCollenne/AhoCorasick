public class Lecture {
    private Arborescence  arbo;
    private Failure fail;

    public Lecture(Arborescence arbo, Failure fail) {
        this.arbo = arbo;
        this.fail = fail;
    }

    /**
     * Parcours le texte "texte" et nous indique à chaque fois quel mot a été trouvé.
     * Le texte est parcouru une seule fois
     * @param texte : Texte dans lequel on va chercher les mots clés
     */
    public void Lire(String texte){
        int etat = 0;
        for(int i=0;i<texte.length();i++){
            while(arbo.CommandeTab[etat][texte.charAt(i)] == -1)
                //etat = fail.fail[etat];
                System.out.println("AAAAAAAAAA\n\n\n\n");
            etat = arbo.CommandeTab[etat][texte.charAt(i)];
            if(arbo.output[etat] != null) {
                System.out.println("A la position " + i + ", il y a \"" + arbo.output[etat] + "\"\n");
                //for(int j=i-10;j<i+10;j++)
                  //  System.out.println(texte.charAt(j));
            }
        }
    }

}
