/**
 * Die Klasse Premiumtuer ist eine Spezialisierung der Klasse Produkt und repräsentiert eine Tür, die zusätzliche Anforderungen 
 * an Materialeinheiten im Vergleich zu einer Standardtür hat. Die für die Produktion benötigten Materialeinheiten 
 * und die Produktionszeit sind statisch definiert, da sie für alle Premiumtüren gleich sind.
 * 
 * Diese Klasse ergänzt die Funktionalität der Superklasse durch spezifische Eigenschaften, die nur für Premiumtüren relevant sind,
 * wie die Anzahl benötigter Glaseinheiten.
 * 
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class Premiumtuer extends Produkt {

    // Materialeinheiten, die für die Produktion einer Premiumtür benötigt werden
    private static final int HOLZEINHEITEN = 4;
    private static final int SCHRAUBEN = 5;
    private static final int GLASEINHEITEN = 5;
    private static final int FARBEINHEITEN = 1;
    private static final int KARTONEINHEITEN = 5;
    
    // Produktionszeit in Minuten für eine Premiumtür
    private static final int PRODUKTIONSZEIT = 30;

    /**
     * Standardkonstruktor der Klasse Premiumtuer.
     * Da keine zusätzlichen Initialisierungen erforderlich sind, wird der Konstruktor der Superklasse optional aufgerufen.
     */
    public Premiumtuer() {
        super(); // Optionaler Aufruf des Konstruktors der Superklasse
    }

    /**
     * Gibt die benötigte Anzahl Holzeinheiten für die Produktion einer Premiumtür zurück.
     * 
     * @return Anzahl der Holzeinheiten (int)
     */ 
    public static int gibHolzeinheiten() {
        return HOLZEINHEITEN;
    }

    /**
     * Gibt die benötigte Anzahl Schrauben für die Produktion einer Premiumtür zurück.
     * 
     * @return Anzahl der Schrauben (int)
     */ 
    public static int gibSchrauben() {
        return SCHRAUBEN;
    }

    /**
     * Gibt die benötigte Anzahl Glaseinheiten für die Produktion einer Premiumtür zurück.
     * 
     * @return Anzahl der Glaseinheiten (int)
     */
    public static int gibGlaseinheiten() {
        return GLASEINHEITEN;
    }

    /**
     * Gibt die benötigte Anzahl Farbeinheiten für die Produktion einer Premiumtür zurück.
     * 
     * @return Anzahl der Farbeinheiten (int)
     */  
    public static int gibFarbeinheiten() {
        return FARBEINHEITEN;
    }

    /**
     * Gibt die benötigte Anzahl Kartoneinheiten für die Produktion einer Premiumtür zurück.
     * 
     * @return Anzahl der Kartoneinheiten (int)
     */
    public static int gibKartoneinheiten() {
        return KARTONEINHEITEN;
    }

    /**
     * Gibt die Produktionszeit für die Herstellung einer Premiumtür zurück.
     * 
     * @return Produktionszeit in Minuten (int)
     */ 
    public static int gibProduktionszeit() {
        return PRODUKTIONSZEIT;
    }
}
