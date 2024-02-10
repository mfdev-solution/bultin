
public class Devoir {
    public TypeDevoir type;
    public double note;
    public int numDevoir;
    
    public Devoir() {
    }

    public Devoir(TypeDevoir type, double note,int numDevoir) {
        this.type = type;
        this.note = note;
        this.numDevoir = numDevoir;
    }
    public String toString() {
        return String.valueOf(type)+" "+note + " " + numDevoir+ "\n";
    }
}
