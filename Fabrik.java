import java.util.ArrayList;

/**
 * Die Klasse Fabrik nimmt Bestellungen entgegen und gibt diese auf der Konsole aus. 
 * Die Klasse verwaltet die ArrayList `bestellungen`, die ausschliesslich aus Objekten der Klasse `Bestellung` besteht.
 * Zusätzlich verwaltet die Klasse die laufende Bestellnummer und eine Instanz der Klasse `Lager`, 
 * um Materialverfügbarkeit und Beschaffung zu prüfen.
 * 
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class Fabrik {
    // Globale Klassenvariablen
    private ArrayList<Bestellung> bestellungen; // Liste für Bestellungen
    private int bestellungsNr; // Laufende Bestellnummer
    private Lager lager; // Instanz der Lager-Klasse

    /**
     * Konstruktor der Klasse Fabrik.
     * Initialisiert die globale Liste `bestellungen`, setzt die Bestellnummer auf 0 und erstellt eine Instanz der Klasse `Lager`.
     */
    public Fabrik() {
        bestellungen = new ArrayList<>(); // Initialisierung der ArrayList
        bestellungsNr = 0; // Startwert für Bestellnummer
        lager = new Lager(); // Lager initialisieren
    }

    /**
     * Gibt die Liste aller Bestellungen zurück.
     * 
     * @return Die Liste der Bestellungen (ArrayList)
     */
    public ArrayList<Bestellung> gibBestellungen() {
        return bestellungen;
    }

    /**
     * Die Methode `bestellungAufgeben` ermöglicht die Platzierung einer neuen Bestellung. 
     * Dabei müssen die Anzahl der Standard- und Premiumtüren angegeben werden. 
     * Die Methode überprüft die Eingabe auf Korrektheit und fügt die Bestellung der Liste hinzu, wenn diese gültig ist.
     * 
     * @param standardTueren Anzahl der zu bestellenden Standardtüren (int).
     * @param premiumTueren Anzahl der zu bestellenden Premiumtüren (int).
     */
    public void bestellungAufgeben(int standardTueren, int premiumTueren) {
        if (standardTueren < 0 || premiumTueren < 0) {
            System.out.println("\nUngültige Bestellmenge. Kann nicht negativ sein.");
        } else if (standardTueren == 0 && premiumTueren == 0) {
            System.out.println("\nDie Bestellung muss mindestens ein Produkt enthalten.");
        } else if (standardTueren > 10_000 || premiumTueren > 10_000) {
            System.out.println("\nBestellmenge ist zu gross. Maximal 10 Tausend pro Artikel.");
        } else {
            bestellungsNr++;
            Bestellung neueBestellung = new Bestellung(standardTueren, premiumTueren, bestellungsNr);

            int beschaffungszeit = lager.gibBeschaffungszeit(neueBestellung);
            int produktionszeit = (standardTueren * Standardtuer.gibProduktionszeit()) +
                                  (premiumTueren * Premiumtuer.gibProduktionszeit());
            int lieferzeit = beschaffungszeit + produktionszeit + 1;

            neueBestellung.setzeBeschaffungsZeit(beschaffungszeit);
            neueBestellung.setzeLieferzeit(lieferzeit);
            bestellungen.add(neueBestellung);

            System.out.println("Bestellung " + bestellungsNr + " aufgegeben. Lieferzeit: " + lieferzeit + " Tage.");

            if (beschaffungszeit > 0) {
                lager.lagerAuffuellen();
            }
        }
    }

    public void bestellungAusgeben() {
        if (bestellungen.isEmpty()) {
            System.out.println("Es wurden bisher keine Bestellungen aufgegeben.");
            return;
        }

        System.out.println("\n--- Übersicht aller Bestellungen ---");
        for (Bestellung bestellung : bestellungen) {
            System.out.println("Bestellnummer: " + bestellung.gibBestellungsNr());
            System.out.println("Standardtüren: " + bestellung.gibAnzahlStandardTueren());
            System.out.println("Premiumtüren: " + bestellung.gibAnzahlPremiumTueren());
            System.out.println("Beschaffungszeit: " + bestellung.gibBeschaffungsZeit() + " Tage");
            System.out.println("Lieferzeit: " + bestellung.gibLieferzeit() + " Tage");
            System.out.println("Bestellbestätigung: " + (bestellung.istBestellt() ? "Ja" : "Nein"));
            System.out.println("-----------------------------------");
        }
    }
}
