import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Services {
    private static Scanner scanner = new Scanner(System.in);

    public static Eleve renseignerEleve(Eleve eleve) {
        eleve.firstName = validerEntrees("Veillez entrez le prennom");
        eleve.lastName = validerEntrees("Veillez entrez le nom");
        eleve.niveau.classe = getClasse();
        eleve.niveau.serie = getSerie();
        eleve.matieres = attribuerMatieres(eleve.niveau);
        return eleve;
    }

    private static String validerEntrees(String message) {
        String champs = null;
        do {
            System.out.println(message);
            champs = scanner.nextLine();
        } while (champs != null && champs.length() < 0);

        return champs;
    }

    private static Classe getClasse() {
        System.out.println("Veillez choisir la classe");
        String[] niveaux = new String[Classe.values().length];
        int i = 0;
        for (Classe iterable_element : Classe.values()) {
            niveaux[i] = String.valueOf(iterable_element);
            System.out.println(i + " : " + iterable_element);
            i++;
        }
        int choix = scanner.nextInt();

        return Classe.valueOf(niveaux[choix]);
    }

    private static Serie getSerie() {
        System.out.println("Veillez choisir la serie");
        String[] series = new String[Serie.values().length];
        int i = 0;
        for (Serie iterable_element : Serie.values()) {
            series[i] = String.valueOf(iterable_element);
            System.out.println(i + " : " + iterable_element);
            i++;
        }
        int choix = scanner.nextInt();
        return Serie.valueOf(series[choix]);
    }

    private static Map<NMatiere, Double> attribuerMatieres(Niveau niveau) {
        Map<NMatiere,Double> attribuer = new HashMap<NMatiere, Double>();
        switch (niveau.classe.toString()) {
            case "sisieme", "cinqueme":
                attribuer.put(new NMatiere(Matiere.Anglais),2.0);
                attribuer.put(new NMatiere(Matiere.Mathematique), 3.0);
                attribuer.put(new NMatiere(Matiere.SVT), 2.0);
                attribuer.put(new NMatiere(Matiere.HG), 2.0);
                attribuer.put(new NMatiere(Matiere.EC), 1.0);
                attribuer.put(new NMatiere(Matiere.EPS), 2.0);
                attribuer.put(new NMatiere(Matiere.Dictee), 1.0);
                attribuer.put(new NMatiere(Matiere.TSQ), 1.0);
                attribuer.put(new NMatiere(Matiere.Redaction), 2.0);
                return attribuer;
            case "quatrieme", "troisieme":
                attribuer.put(new NMatiere(Matiere.Anglais ), 2.0);
                attribuer.put(new NMatiere(Matiere.Mathematique ), 3.0);
                attribuer.put(new NMatiere(Matiere.SVT ), 2.0);
                attribuer.put(new NMatiere(Matiere.HG ), 2.0);
                attribuer.put(new NMatiere(Matiere.EC ), 1.0);
                attribuer.put(new NMatiere(Matiere.EPS ), 2.0);
                attribuer.put(new NMatiere(Matiere.Dictee ), 1.0);
                attribuer.put(new NMatiere(Matiere.TSQ ), 1.0);
                attribuer.put(new NMatiere(Matiere.Redaction ), 2.0);
                attribuer.put(new NMatiere(Matiere.Science_Physique ), 2.0);
                if (niveau.serie.equals(Serie.A)) {
                    attribuer.put(new NMatiere(Matiere.Arabe ), 2.0);
                    System.out.println("test");

                }
                if (niveau.serie.equals(Serie.ES)) {
                    attribuer.put(new NMatiere(Matiere.Espagnol ), 2.0);
                }
                return attribuer;
            case "seconde":
                attribuer.put(new NMatiere(Matiere.EPS ), 2.0);
                if (niveau.serie.equals(Serie.S)) {
                    attribuer.put(new NMatiere(Matiere.Mathematique ), 5.0);
                    attribuer.put(new NMatiere(Matiere.SVT ), 5.0);
                    attribuer.put(new NMatiere(Matiere.Anglais ), 2.0);
                    attribuer.put(new NMatiere(Matiere.HG ), 2.0);
                    attribuer.put(new NMatiere(Matiere.Science_Physique ), 5.0);
                    attribuer.put(new NMatiere(Matiere.Francais ), 3.0);
                    attribuer.put(new NMatiere(Matiere.Arabe ), 2.0);
                } else if (niveau.serie.equals(Serie.L)) {
                    attribuer.put(new NMatiere(Matiere.SVT ), 2.0);
                    attribuer.put(new NMatiere(Matiere.Anglais ), 2.0);
                    attribuer.put(new NMatiere(Matiere.HG ), 4.0);
                    attribuer.put(new NMatiere(Matiere.Science_Physique ), 2.0);
                    attribuer.put(new NMatiere(Matiere.Francais ), 4.0);
                    attribuer.put(new NMatiere(Matiere.Arabe ), 2.0);
                }
                return attribuer;
            case "premiere", "terminal":
                attribuer.put(new NMatiere(Matiere.EPS ), 2.0);
                return attribuer;
            default:
                break;
        }
        return null;
    }

    public Devoir renseignerDevoir() {
        int[] numDevoirs = new int[3];
        TypeDevoir[] typeDevoirs = new TypeDevoir[2];
        System.out.println("Choisir le type de devoir");
        int i = 1;
        for (TypeDevoir iterable_element : TypeDevoir.values()) {
            typeDevoirs[i] = iterable_element;
            System.out.println(i+" : pour "+String.valueOf(iterable_element));
            i++;
        }
        int typeChoice = scanner.nextInt();
        System.out.println("Choisir le numero du devoir");
        for (int index = 0; index < numDevoirs.length; index++) {
            numDevoirs[index] = index;
            System.out.println(index + " : Devoir N°"+index+1 );
        }
        int choix = scanner.nextInt();
        System.out.println("Entrer la note");
        double note = scanner.nextDouble();
        return new Devoir(typeDevoirs[typeChoice], note, numDevoirs[choix]);
    }
}
