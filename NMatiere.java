import java.util.ArrayList;
import java.util.List;

public class NMatiere {

    public Matiere nomMatiere;
    public List<Devoir> devoirs = new ArrayList<>();

    public NMatiere() {
    }

    public NMatiere(Matiere nomMatiere, List<Devoir> devoirs) {
        this.nomMatiere = nomMatiere;
        this.devoirs = devoirs;
    }

    public NMatiere(Matiere nomMatiere) {
        this.nomMatiere = nomMatiere;
    }
    public String toString() {
        String nmatieres = String.valueOf(nomMatiere);

        for (Devoir devoir : devoirs) {
            nmatieres += " " + devoir.toString();
        }

        return nmatieres;
    }
}
