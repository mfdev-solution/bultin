import java.util.HashMap;
import java.util.Map;

public class Eleve {
    public String firstName;
    public String lastName;
    public Niveau niveau = new Niveau();
    public Map<NMatiere, Double> matieres = new HashMap<>();

    public Eleve(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Eleve() {
        // TODO Auto-generated constructor stub
    }

    public String toString() {
        String newMatieres = "Matieres (";
        for (NMatiere matiere : this.matieres.keySet()) {
            newMatieres = newMatieres + " (" + String.valueOf(matiere.nomMatiere) + " , "
                    + String.valueOf(this.matieres.get(matiere)) + " , " + matiere.devoirs.size() + ")";
        }
        newMatieres += " )";
        return firstName + " " + lastName + " " + String.valueOf(niveau.classe) + " " + newMatieres;
    }

}
