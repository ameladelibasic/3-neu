/**
 * Die Klasse Produkt repräsentiert die abstrakte Grundlage für verschiedene Produktarten wie 
 * Standardtüren und Premiumtüren. Sie enthält gemeinsame Eigenschaften und Methoden, 
 * die für alle Produkte gelten.
 * 
 * Der Zustand eines Produkts kann durch eine ganze Zahl repräsentiert werden, die den Produktions- 
 * und Lieferstatus beschreibt.
 * 
 * Mögliche Zustände:
 * - 0: Bestellt
 * - 1: In Produktion
 * - 2: Bereit für Auslieferung
 * - 3: Ausgeliefert
 * 
 * Diese Klasse kann erweitert werden, um zusätzliche spezifische Funktionalitäten für unterschiedliche 
 * Produkte bereitzustellen.
 * 
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class Produkt {

    /**
     * Gibt den Zustand des Produkts an:
     * 0: Bestellt
     * 1: In Produktion
     * 2: Bereit für Auslieferung
     * 3: Ausgeliefert
     */
    private int zustand; // Standardwert: 0 (Bestellt)

    /**
     * Konstruktor der Klasse Produkt.
     * Initialisiert das Produkt mit dem Standardzustand (0: Bestellt).
     */
    public Produkt() {
        this.zustand = 0; // Zustand wird standardmässig auf "Bestellt" gesetzt
    }

    /**
     * Gibt den aktuellen Zustand des Produkts zurück.
     * 
     * @return Der aktuelle Zustand des Produkts (int)
     */
    public int aktuellerZustand() {
        return this.zustand;
    }

    /**
     * Ändert den Zustand des Produkts.
     * 
     * @param zustand Der neue Zustand des Produkts (0 bis 3)
     */
    public void zustandAendern(int zustand) {
        if (zustand >= 0 && zustand <= 3) {
            this.zustand = zustand;
        } else {
            throw new IllegalArgumentException("Ungültiger Zustand: " + zustand + ". Der Zustand muss zwischen 0 und 3 liegen.");
        }
    }
}
