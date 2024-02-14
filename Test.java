import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Services services = new Services();
        // Eleve eleve = services.renseignerEleve(new Eleve());
        Eleve eleve = services.renseigenrRandomEleve(new Eleve());
        // eleve.moyenne = services.calculateAverage(eleve.matieres);
        // System.out.println(eleve.toString());
        System.out.println(eleve.toString());
        // Devoir devoir = services.renseignerDevoir();
        // System.out.println(String.valueOf(devoir.type)+" "+devoir.note + " " +
        // devoir.numDevoir);
    }
}
