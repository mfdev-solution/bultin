import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Eleve {
    public String firstName;
    public String lastName;
    public Niveau niveau = new Niveau();
    public Map<NMatiere, Double> matieres = new HashMap<>();
    public double moyenne;

    public Eleve(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Eleve() {
        // TODO Auto-generated constructor stub
    }

    public String toString() {
        String newMatieres = "Matieres (\n";
        for (NMatiere matiere : this.matieres.keySet()) {
            newMatieres = newMatieres + " (" + String.valueOf(matiere.nomMatiere) + " , "
                    + String.valueOf(this.matieres.get(matiere)) + " , " + afficherDevoir(matiere.devoirs)
                    + ") \n";
        }
        newMatieres += " ) ";
        return firstName + " " + lastName + " " + String.valueOf(niveau.classe) + " " + niveau.serie  + " " + newMatieres + "\nMoyenne générale : " + moyenne +"\n";
    }

    private String afficherDevoir(List<Devoir> devoirs) {
        String listDevoir = "Devoirs ( ";
        for (Devoir dev : devoirs) {
            listDevoir += dev.type.toString() + " N° " + dev.numDevoir + ", " + dev.note + " ";
        }
        return listDevoir;

    }

}
