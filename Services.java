import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Services {

    private static Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    public Eleve renseignerEleve(Eleve eleve) {
        eleve.firstName = validerEntrees("Veillez entrez le prennom");
        eleve.lastName = validerEntrees("Veillez entrez le nom");
        eleve.niveau.classe = getClasse();
        eleve.niveau.serie = getSerie();
        eleve.matieres = this.attribuerMatieres(eleve.niveau);
        eleve.moyenne =  this.calculateAverage(eleve.matieres);
        return eleve;
    }

    public Eleve renseigenrRandomEleve(Eleve eleve) {
        eleve.firstName = this.randomWord(Consts.PRENOMS);
        eleve.lastName = this.randomWord(Consts.NOMS);
        eleve.niveau.classe = this.getRandClasse();
        eleve.niveau.serie = this.getRandomSerie(eleve.niveau.classe);
        eleve.matieres = this.attribuerMatieres(eleve.niveau);
        eleve.moyenne =  this.calculateAverage(eleve.matieres);
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

    public Classe getRandClasse() {
        Classe[] randClasse = Classe.values();
        int randomNumber = rand.nextInt(randClasse.length);
        return randClasse[randomNumber];
    }

    public Serie getRandomSerie(Classe classe) {
        Serie[] randSerie;
        switch (String.valueOf(classe)) {
            case "sisieme", "cinqueme":
                return Serie.valueOf(String.valueOf(CollegeSeries.NONE));
            case "quatrieme", "troisieme":
                randSerie = new Serie[Consts.NOMBRE_SERIE_4_3];
                int i = 0;
                for (CollegeSeries series : CollegeSeries.values()) {
                    if (series.equals(CollegeSeries.NONE))
                        continue;
                    randSerie[i] = Serie.valueOf(String.valueOf(series));
                    i++;
                }
                return randSerie[rand.nextInt(randSerie.length)];

            case "seconde":
                randSerie = new Serie[Consts.NOMBRE_SERIE_SECOND];
                randSerie[0] = Serie.valueOf(String.valueOf(SecondaireSeries.L));
                randSerie[1] = Serie.valueOf(String.valueOf(SecondaireSeries.S));
                return randSerie[rand.nextInt(randSerie.length)];
            case "premiere", "terminal":
                randSerie = new Serie[Consts.NOMBRE_SERIES_PREMIERE_TERMINAL];
                i = 0;
                for (SecondaireSeries serie : SecondaireSeries.values()) {
                    if (serie.equals(SecondaireSeries.L) || serie.equals(SecondaireSeries.S))
                        continue;
                    randSerie[i] = Serie.valueOf(String.valueOf(serie));
                    i++;
                }
                return randSerie[rand.nextInt(randSerie.length)];
            default:
                break;
        }
        return null;
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

    private Map<NMatiere, Double> attribuerMatieres(Niveau niveau) {
        Map<NMatiere, Double> attribuer = new HashMap<NMatiere, Double>();
        switch (niveau.classe.toString()) {
            case "sisieme", "cinqueme":
                attribuer.put(new NMatiere(Matiere.Anglais), 2.0);
                attribuer.put(new NMatiere(Matiere.Mathematique), 3.0);
                attribuer.put(new NMatiere(Matiere.SVT), 2.0);
                attribuer.put(new NMatiere(Matiere.HG), 2.0);
                attribuer.put(new NMatiere(Matiere.EC), 1.0);
                attribuer.put(new NMatiere(Matiere.EPS), 2.0);
                attribuer.put(new NMatiere(Matiere.Dictee), 1.0);
                attribuer.put(new NMatiere(Matiere.TSQ), 1.0);
                attribuer.put(new NMatiere(Matiere.Redaction), 2.0);
                break;
            case "quatrieme", "troisieme":
                attribuer.put(new NMatiere(Matiere.Anglais), 2.0);
                attribuer.put(new NMatiere(Matiere.Mathematique), 3.0);
                attribuer.put(new NMatiere(Matiere.SVT), 2.0);
                attribuer.put(new NMatiere(Matiere.HG), 2.0);
                attribuer.put(new NMatiere(Matiere.EC), 1.0);
                attribuer.put(new NMatiere(Matiere.EPS), 2.0);
                attribuer.put(new NMatiere(Matiere.Dictee), 1.0);
                attribuer.put(new NMatiere(Matiere.TSQ), 1.0);
                attribuer.put(new NMatiere(Matiere.Redaction), 2.0);
                attribuer.put(new NMatiere(Matiere.Science_Physique), 2.0);
                attribuer.put(new NMatiere(Matiere.Music), 1.0);
                if (niveau.serie.equals(Serie.A)) {
                    attribuer.put(new NMatiere(Matiere.Arabe), 2.0);
                }
                if (niveau.serie.equals(Serie.ES)) {
                    attribuer.put(new NMatiere(Matiere.Espagnol), 2.0);
                }
                break;
            case "seconde":
                attribuer.put(new NMatiere(Matiere.EPS), 1.0);
                if (niveau.serie.equals(Serie.S)) {
                    attribuer.put(new NMatiere(Matiere.Mathematique), 5.0);
                    attribuer.put(new NMatiere(Matiere.SVT), 5.0);
                    attribuer.put(new NMatiere(Matiere.Anglais), 2.0);
                    attribuer.put(new NMatiere(Matiere.HG), 2.0);
                    attribuer.put(new NMatiere(Matiere.Science_Physique), 5.0);
                    attribuer.put(new NMatiere(Matiere.Francais), 3.0);
                    attribuer.put(new NMatiere(Matiere.Arabe), 2.0);
                } else if (niveau.serie.equals(Serie.L)) {
                    attribuer.put(new NMatiere(Matiere.SVT), 2.0);
                    attribuer.put(new NMatiere(Matiere.Anglais), 2.0);
                    attribuer.put(new NMatiere(Matiere.HG), 4.0);
                    attribuer.put(new NMatiere(Matiere.Science_Physique), 2.0);
                    attribuer.put(new NMatiere(Matiere.Francais), 4.0);
                    attribuer.put(new NMatiere(Matiere.Arabe), 2.0);
                }
                break;
            case "premiere", "terminal":
                attribuer.put(new NMatiere(Matiere.EPS), 2.0);
                break;
            default:
                break;
        }
        // return reseignerTousDevoirs(attribuer);
        return renseignerTousDevoirRandom(attribuer);
    }

    private Map<NMatiere, Double> renseignerTousDevoirRandom(Map<NMatiere, Double> attribuer) {

        attribuer.forEach((nMatiere, coef) ->{
            List<Devoir> devoirs = new ArrayList<Devoir>();
            devoirs.add(new Devoir(TypeDevoir.devoir, rand.nextInt(20), 1));
            devoirs.add(new Devoir(TypeDevoir.devoir, rand.nextInt(20), 2));
            devoirs.add(new Devoir(TypeDevoir.composition, rand.nextInt(20), 1));
            nMatiere.devoirs = devoirs;
        });
        return attribuer;
    }

    private Devoir renseignerDevoir() {
        int[] numDevoirs = new int[Consts.NOMBRE_DEVOIRS];
        TypeDevoir[] typeDevoirs = new TypeDevoir[Consts.NOMBRE_TYPES_DEVOIRS];
        System.out.println("Choisir le type de devoir");
        int i = 1;
        for (TypeDevoir iterable_element : TypeDevoir.values()) {
            typeDevoirs[i - 1] = iterable_element;
            System.out.println(i + " : pour " + String.valueOf(iterable_element));
            i++;
        }
        int typeChoice = scanner.nextInt();
        if (typeDevoirs[typeChoice - 1].equals(TypeDevoir.devoir)) {
            System.out.println("Choisir le numero du devoir");
            for (int index = 1; index < numDevoirs.length + 1; index++) {
                numDevoirs[index - 1] = index;
                System.out.println(index + " : Devoir N°" + (index));
            }
        }
        if (typeDevoirs[typeChoice - 1].equals(TypeDevoir.composition)) {
            System.out.println("Choisir le numero du semestre");
            for (int index = 1; index < Consts.NOMBRE_COMPOSITIONS + 1; index++) {
                numDevoirs[index - 1] = index;
                System.out.println(index + " : Composition N°" + (index));
            }
        }
        int choix = scanner.nextInt();
        System.out.println("Entrer la note");
        double note = scanner.nextDouble();
        return new Devoir(typeDevoirs[typeChoice - 1], note, numDevoirs[choix - 1]);
    }

    private NMatiere renseignerNMatier(NMatiere nMatiere) {

        System.out.println("Matiere : " + String.valueOf(nMatiere.nomMatiere));
        int i = 1;
        boolean rep;
        while (i < Consts.NOMBRE_DEVOIRS + 1) {
            rep = yesOrNo("Voulez-vous ajouter un devoir");
            if (!rep)
                break;
            nMatiere.devoirs.add(renseignerDevoir());
            i++;
        }
        return nMatiere;
    }

    public Map<NMatiere, Double> reseignerTousDevoirs(Map<NMatiere, Double> matiersMap) {

        matiersMap.forEach((nMat, v) -> nMat = renseignerNMatier(nMat));
        return matiersMap;
    }

    public double calculateAverage(Map<NMatiere, Double> matieres) {
        double totalCoef = 0.0;
        double totalPoints = 0.0;
        for (NMatiere nMatiere : matieres.keySet()) {
            totalCoef += matieres.get(nMatiere);
            totalPoints += (caculateAverageByDev(nMatiere.devoirs) * matieres.get(nMatiere));
        }
        return totalPoints / totalCoef;
    }

    private double caculateAverageByDev(List<Devoir> devoirs) {
        double ccAverage = 0.0;
        double dsAverage = 0.0;
        for (Devoir dev : devoirs) {
            if (dev.type.equals(TypeDevoir.devoir))
                ccAverage += dev.note;
            if (dev.type.equals(TypeDevoir.composition))
                dsAverage += dev.note;
        }
        ccAverage /= 2;
        return (ccAverage + dsAverage) / 2;
    }

    private boolean yesOrNo(String question) {
        int answer = 0;
        do {
            System.out.println(question);
            System.out.println("1 : OUI\n2 : NON");
            answer = scanner.nextInt();
        } while (answer != 1 && answer != 2);
        return answer == 1;
    }

    public String randomWord(String[] words) {

        int randomNumber = rand.nextInt(words.length);
        return words[randomNumber];
    }

}