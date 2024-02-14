import java.util.List;

public class NClasse {
    public Classe nomClasse;
    public int effectif;
    public Serie serieClasse;
    public List<Eleve> eleves;

    public NClasse() {
    }
    public NClasse(Classe nomClasse, int effectif, Serie serieClasse, List<Eleve> eleves) {
        this.nomClasse = nomClasse;
        this.effectif = effectif;
        this.serieClasse = serieClasse;
        this.eleves = eleves;
    }
    public NClasse(Classe nomClasse, int effectif, Serie serieClasse) {
        this.nomClasse = nomClasse;
        this.effectif = effectif;
        this.serieClasse = serieClasse;
    }

    public String toString() {
        String out = "Classe:"+nomClasse + " " +serieClasse.toString() + " Effectif : "+effectif + "{\n";
        for (Eleve eleve : eleves) {
            out += ""+eleve.toString();
        }
        out+= "}";
        return out;
        
    }
    
    
}
