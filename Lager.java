import java.util.ArrayList;
/**
 * Die Klasse Lager verwaltet die Bestände an Materialien, die für die Produktion von Produkten benötigt werden. 
 * Sie ermöglicht die Überprüfung der Materialverfügbarkeit, berechnet die Beschaffungszeit und kann bei Bedarf das Lager auffüllen.
 * Zusätzlich gibt sie die aktuellen Lagerbestände auf der Konsole aus.
 * 
 * Die Klasse interagiert mit den Klassen Bestellung, Standardtuer und Premiumtuer, um den Materialbedarf zu berechnen.
 * Falls die Materialien nicht ausreichen, wird die Beschaffungszeit erhöht und das Lager kann mit Hilfe eines Lieferanten aufgefüllt werden.
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class Lager {
    // Aktuelle Bestände der einzelnen Materialeinheiten
    private int holzeinheiten;
    private int schrauben;
    private int farbeinheiten;
    private int kartoneinheiten;
    private int glaseinheiten;

    // Maximale Lagerkapazitäten für jede Materialart
    private static final int MAX_HOLZEINHEITEN = 10_000;
    private static final int MAX_SCHRAUBEN = 10_000;
    private static final int MAX_FARBEINHEITEN = 5_000;
    private static final int MAX_KARTONEINHEITEN = 5_000;
    private static final int MAX_GLASEINHEITEN = 5_000;

    // Lieferant, der Material nachbestellen kann
    private Lieferant lieferant;

    /**
     * Konstruktor für die Klasse Lager. 
     * Initialisiert das Lager mit den maximalen Kapazitäten für jedes Material 
     * und erstellt eine neue Instanz des Lieferanten.
     */
    public Lager() {
        this.holzeinheiten = MAX_HOLZEINHEITEN;
        this.schrauben = MAX_SCHRAUBEN;
        this.farbeinheiten = MAX_FARBEINHEITEN;
        this.kartoneinheiten = MAX_KARTONEINHEITEN;
        this.glaseinheiten = MAX_GLASEINHEITEN;
        this.lieferant = new Lieferant();
    }

    /**
     * Überprüft, ob ausreichend Materialien für eine gegebene Bestellung vorhanden sind. 
     * Falls nicht genügend Materialien vorhanden sind, wird eine Beschaffungszeit von 2 Tagen zurückgegeben. 
     * Andernfalls beträgt die Beschaffungszeit 0 Tage.
     * 
     * @param bestellung Die zu prüfende Bestellung.
     * @return 0, wenn ausreichend Materialien vorhanden sind; 2, wenn Material nachbestellt werden muss.
     */
    public int gibBeschaffungszeit(Bestellung bestellung) {
        int benoetigteHolzeinheiten = 0;
        int benoetigteSchrauben = 0;
        int benoetigteFarbeinheiten = 0;
        int benoetigteKartoneinheiten = 0;
        int benoetigteGlaseinheiten = 0;

        // Liste aller Produkte in der Bestellung
        ArrayList<Produkt> produkte = bestellung.gibBestellteProdukte();

        // Materialbedarf für jedes Produkt berechnen
        for (Produkt produkt : produkte) {
            if (produkt instanceof Standardtuer) {
                benoetigteHolzeinheiten += Standardtuer.gibHolzeinheiten();
                benoetigteSchrauben += Standardtuer.gibSchrauben();
                benoetigteFarbeinheiten += Standardtuer.gibFarbeinheiten();
                benoetigteKartoneinheiten += Standardtuer.gibKartoneinheiten();
            } else if (produkt instanceof Premiumtuer) {
                benoetigteHolzeinheiten += Premiumtuer.gibHolzeinheiten();
                benoetigteSchrauben += Premiumtuer.gibSchrauben();
                benoetigteFarbeinheiten += Premiumtuer.gibFarbeinheiten();
                benoetigteKartoneinheiten += Premiumtuer.gibKartoneinheiten();
                benoetigteGlaseinheiten += Premiumtuer.gibGlaseinheiten();
            }
        }

        // Überprüfen, ob die vorhandenen Bestände ausreichen
        if (benoetigteHolzeinheiten > holzeinheiten ||
            benoetigteSchrauben > schrauben ||
            benoetigteFarbeinheiten > farbeinheiten ||
            benoetigteKartoneinheiten > kartoneinheiten ||
            benoetigteGlaseinheiten > glaseinheiten) {
            return 2; // Materialien müssen nachbestellt werden
        }

        return 0; // Materialien sind ausreichend vorhanden
    }

    /**
     * Füllt das Lager mit den maximalen Kapazitäten für jedes Material auf. 
     * Gibt eine entsprechende Nachricht aus, wenn das Auffüllen abgeschlossen ist.
     */
    public void lagerAuffuellen() {
        System.out.println("Lager wird aufgefüllt...");
        this.holzeinheiten = MAX_HOLZEINHEITEN;
        this.schrauben = MAX_SCHRAUBEN;
        this.farbeinheiten = MAX_FARBEINHEITEN;
        this.kartoneinheiten = MAX_KARTONEINHEITEN;
        this.glaseinheiten = MAX_GLASEINHEITEN;
        System.out.println("Lager erfolgreich aufgefüllt.");
    }

    /**
     * Gibt die aktuellen Lagerbestände für alle Materialien auf der Konsole aus.
     */
    public void lagerBestandAusgeben() {
        System.out.println("Aktuelle Lagerbestände:");
        System.out.println("Holzeinheiten: " + holzeinheiten);
        System.out.println("Schrauben: " + schrauben);
        System.out.println("Farbeinheiten: " + farbeinheiten);
        System.out.println("Kartoneinheiten: " + kartoneinheiten);
        System.out.println("Glaseinheiten: " + glaseinheiten);
    }

    /**
     * Gibt die aktuelle Anzahl an Holzeinheiten zurück.
     * @return Anzahl der Holzeinheiten im Lager.
     */
    public int gibHolzeinheiten() {
        return holzeinheiten;
    }

    /**
     * Gibt die aktuelle Anzahl an Schrauben zurück.
     * @return Anzahl der Schrauben im Lager.
     */
    public int gibSchrauben() {
        return schrauben;
    }

    /**
     * Gibt die aktuelle Anzahl an Farbeinheiten zurück.
     * @return Anzahl der Farbeinheiten im Lager.
     */
    public int gibFarbeinheiten() {
        return farbeinheiten;
    }

    /**
     * Gibt die aktuelle Anzahl an Kartoneinheiten zurück.
     * @return Anzahl der Kartoneinheiten im Lager.
     */
    public int gibKartoneinheiten() {
        return kartoneinheiten;
    }

    /**
     * Gibt die aktuelle Anzahl an Glaseinheiten zurück.
     * @return Anzahl der Glaseinheiten im Lager.
     */
    public int gibGlaseinheiten() {
        return glaseinheiten;
    }
}
