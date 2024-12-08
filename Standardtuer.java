/**
 * Die Klasse Standardtuer ist eine Spezialisierung der Klasse Produkt und repräsentiert eine Tür, 
 * die für die Produktion spezifische Materialeinheiten benötigt. 
 * Die benötigten Materialeinheiten und die Produktionszeit sind statisch definiert, da sie für alle Standardtüren gleich sind.
 * 
 * Diese Klasse ergänzt die Funktionalität der Superklasse durch Eigenschaften, 
 * die spezifisch für die Produktion von Standardtüren relevant sind.
 * 
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class Standardtuer extends Produkt {

    // Materialeinheiten, die für die Produktion einer Standardtür benötigt werden
    private static final int HOLZEINHEITEN = 2;
    private static final int SCHRAUBEN = 10;
    private static final int FARBEINHEITEN = 2;
    private static final int KARTONEINHEITEN = 1;
    
    // Produktionszeit in Minuten für eine Standardtür
    private static final int PRODUKTIONSZEIT = 10;

    /**
     * Standardkonstruktor der Klasse Standardtuer.
     * Da keine zusätzlichen Initialisierungen erforderlich sind, wird der Konstruktor der Superklasse optional aufgerufen.
     */
    public Standardtuer() {
        super(); // Optionaler Aufruf des Konstruktors der Superklasse
    }

    /**
     * Gibt die benötigte Anzahl Holzeinheiten für die Produktion einer Standardtür zurück.
     * 
     * @return Anzahl der Holzeinheiten (int)
     */ 
    public static int gibHolzeinheiten() {
        return HOLZEINHEITEN;
    }

    /**
     * Gibt die benötigte Anzahl Schrauben für die Produktion einer Standardtür zurück.
     * 
     * @return Anzahl der Schrauben (int)
     */ 
    public static int gibSchrauben() {
        return SCHRAUBEN;
    }

    /**
     * Gibt die benötigte Anzahl Farbeinheiten für die Produktion einer Standardtür zurück.
     * 
     * @return Anzahl der Farbeinheiten (int)
     */  
    public static int gibFarbeinheiten() {
        return FARBEINHEITEN;
    }

    /**
     * Gibt die benötigte Anzahl Kartoneinheiten für die Produktion einer Standardtür zurück.
     * 
     * @return Anzahl der Kartoneinheiten (int)
     */
    public static int gibKartoneinheiten() {
        return KARTONEINHEITEN;
    }

    /**
     * Gibt die Produktionszeit für die Herstellung einer Standardtür zurück.
     * 
     * @return Produktionszeit in Minuten (int)
     */ 
    public static int gibProduktionszeit() {
        return PRODUKTIONSZEIT;
    }
}
