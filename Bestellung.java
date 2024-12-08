import java.util.ArrayList;

/**
 * Die Klasse Bestellung verwaltet die ArrayList `bestellteProdukte`, in der alle bestellten Produkte gespeichert werden. 
 * Produkte können entweder Standardtüren oder Premiumtüren sein. 
 * Die Klasse enthält globale Variablen, um die Liste der bestellten Produkte, die Bestellbestätigung, 
 * die Beschaffungszeit, die Lieferzeit, die Bestellnummer sowie die Anzahl der bestellten Standardtüren 
 * und Premiumtüren zu verwalten.
 *
 * Zusätzliche Funktionen ermöglichen die Verwaltung und Abfrage der Bestellung, einschliesslich der Berechnung 
 * von Beschaffungszeiten und Lieferzeiten.
 * 
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class Bestellung {
    // Globale Klassenvariablen
    private int anzahlStandardTueren; 
    private int anzahlPremiumTueren;
    private int bestellungsNr; // Bestellnummer als fortlaufender Integer
    private int beschaffungsZeit; // Beschaffungszeit in Tagen
    private int lieferzeit; // Lieferzeit in Tagen
    private boolean bestellBestaetigung; // Bestellstatus: false = nicht bestätigt, true = bestätigt
    private ArrayList<Produkt> bestellteProdukte; // Liste aller bestellten Produkte
    
    /**
     * Konstruktor für die Objekte der Klasse Bestellung.
     * Initialisiert eine Bestellung mit einer bestimmten Anzahl Standard- und Premiumtüren sowie einer Bestellnummer.
     * Validiert die Eingabewerte, um sicherzustellen, dass keine ungültigen Bestellungen erstellt werden können.
     * 
     * @param anzahlStandardTueren Anzahl der bestellten Standardtüren
     * @param anzahlPremiumTueren Anzahl der bestellten Premiumtüren
     * @param bestellungsNr Bestellnummer für die Bestellung
     * @throws IllegalArgumentException bei ungültigen Eingabewerten (z. B. negative Mengen)
     */
    public Bestellung(int anzahlStandardTueren, int anzahlPremiumTueren, int bestellungsNr) {
        // Überprüfung der Eingabeparameter
        if (anzahlStandardTueren < 0 || anzahlPremiumTueren < 0) {
            throw new IllegalArgumentException("Ungültige Bestellmenge. Kann nicht negativ sein.");
        }
        if (anzahlStandardTueren == 0 && anzahlPremiumTueren == 0) {
            throw new IllegalArgumentException("Die Bestellung muss mindestens ein Produkt enthalten.");
        }
        if (anzahlStandardTueren > 10_000 || anzahlPremiumTueren > 10_000) {
            throw new IllegalArgumentException("Bestellmenge ist zu gross. Maximal 10 Tausend pro Artikel.");
        }

        // Initialisierung der Attribute
        this.anzahlStandardTueren = anzahlStandardTueren;
        this.anzahlPremiumTueren = anzahlPremiumTueren;
        this.bestellungsNr = bestellungsNr;
        this.bestellBestaetigung = false; // Standardmässig nicht bestätigt
        this.bestellteProdukte = new ArrayList<>();
        this.beschaffungsZeit = -1; // Default-Wert für nicht gesetzte Beschaffungszeit
        this.lieferzeit = -1; // Default-Wert für nicht gesetzte Lieferzeit

        // Hinzufügen der Produkte zur Liste
        fuelleBestellteProdukte(anzahlStandardTueren, anzahlPremiumTueren);
    }

    /**
     * Fügt die bestellten Produkte (Standard- und Premiumtüren) zur Liste `bestellteProdukte` hinzu.
     * @param anzahlStandardTueren Anzahl der bestellten Standardtüren
     * @param anzahlPremiumTueren Anzahl der bestellten Premiumtüren
     */
    private void fuelleBestellteProdukte(int anzahlStandardTueren, int anzahlPremiumTueren) {
        for (int i = 0; i < anzahlStandardTueren; i++) {
            bestellteProdukte.add(new Standardtuer());
        }
        for (int i = 0; i < anzahlPremiumTueren; i++) {
            bestellteProdukte.add(new Premiumtuer());
        }
    }
    
    /**
     * Gibt die Liste der bestellten Produkte zurück.
     * @return Eine Kopie der Liste der bestellten Produkte (ArrayList)
     */
    public ArrayList<Produkt> gibBestellteProdukte() {
        return new ArrayList<>(bestellteProdukte); // Rückgabe einer Kopie der Liste
    }

    /**
     * Setzt die Beschaffungszeit für die Bestellung.
     * @param beschaffungsZeit die Anzahl der Tage, die für die Beschaffung benötigt werden (int).
     */
    public void setzeBeschaffungsZeit(int beschaffungsZeit) {
        this.beschaffungsZeit = beschaffungsZeit;
    }

    /**
     * Setzt die Lieferzeit für die Bestellung.
     * @param lieferzeit die gesamte Lieferzeit in Tagen (int).
     */
    public void setzeLieferzeit(int lieferzeit) {
        this.lieferzeit = lieferzeit;
    }

    /**
     * Gibt die Beschaffungszeit für die Bestellung zurück.
     * @return die Anzahl der Tage, die für die Beschaffung benötigt werden (int).
     */
    public int gibBeschaffungsZeit() {
        return this.beschaffungsZeit;
    }

    /**
     * Gibt die Lieferzeit für die Bestellung zurück.
     * @return die gesamte Lieferzeit in Tagen (int).
     */
    public int gibLieferzeit() {
        return this.lieferzeit;
    }

    /**
     * Prüft, ob die Bestellung bestätigt wurde.
     * @return true, wenn die Bestellung bestätigt ist, andernfalls false.
     */
    public boolean istBestellt() {
        return bestellBestaetigung;
    }

    /**
     * Setzt den Status der Bestellbestätigung.
     * @param bestaetigung ein Boolean-Wert, der angibt, ob die Bestellung bestätigt wurde (true) oder nicht (false).
     */
    public void setzeBestellBestaetigung(boolean bestaetigung) {
        this.bestellBestaetigung = bestaetigung;
    }

    /**
     * Gibt die Anzahl der bestellten Standardtüren zurück.
     * @return die Anzahl der Standardtüren in der Bestellung (int).
     */    
    public int gibAnzahlStandardTueren() {
        return anzahlStandardTueren;
    }

    /**
     * Gibt die Anzahl der bestellten Premiumtüren zurück.
     * @return die Anzahl der Premiumtüren in der Bestellung (int).
     */
    public int gibAnzahlPremiumTueren() {
        return anzahlPremiumTueren;
    }

    /**
     * Gibt die Bestellnummer für die Bestellung zurück.
     * @return die Bestellnummer der Bestellung (int).
     */
    public int gibBestellungsNr() {
        return bestellungsNr;
    }
}
