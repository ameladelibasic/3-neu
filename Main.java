/**
 * Die Testklasse `Main` überprüft die Funktionalität der Klasse `Fabrik` durch das Simulieren verschiedener Bestellszenarien. 
 * Es werden gültige und ungültige Eingaben getestet, um die Robustheit und Korrektheit der Implementierung sicherzustellen.
 * 
 * Szenarien umfassen:
 * - Gültige Bestellungen mit verschiedenen Kombinationen von Standard- und Premiumtüren.
 * - Ungültige Eingaben wie negative Werte oder übermässig grosse Bestellungen.
 * - Testfälle mit leerer Bestellung.
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class Main {
    /**
     * Hauptmethode der Klasse, die verschiedene Testfälle für die Bestellfunktionalität in der Fabrik ausführt. 
     * Nach jeder Bestellung wird der aktuelle Status aller Bestellungen ausgegeben, um die Ergebnisse zu überprüfen.
     * 
     * Getestete Szenarien:
     * - Gültige Bestellungen mit Standard- und Premiumtüren.
     * - Negative Eingaben.
     * - Übermässig grosse Bestellmengen.
     * - Leere Bestellungen (0 Standard- und Premiumtüren).
     */
    public static void main(String[] args) {
        // Erstellung einer Test-Fabrik
        Fabrik testFabrik = new Fabrik();

        System.out.println("Willkommen bei der AEKI Fabrik.");
        System.out.println("Tests starten...\n");

        // Test 1: Gültige Bestellung (2 Standardtüren, 2 Premiumtüren)
        System.out.println("Test 1: Bestellung mit 2 Standardtüren und 2 Premiumtüren");
        testFabrik.bestellungAufgeben(2, 2);
        testFabrik.bestellungAusgeben();

        // Test 2: Gültige Bestellung (5 Standardtüren, 0 Premiumtüren)
        System.out.println("\nTest 2: Bestellung mit 5 Standardtüren und 0 Premiumtüren");
        testFabrik.bestellungAufgeben(5, 0);
        testFabrik.bestellungAusgeben();

        // Test 3: Gültige Bestellung (0 Standardtüren, 6 Premiumtüren)
        System.out.println("\nTest 3: Bestellung mit 0 Standardtüren und 6 Premiumtüren");
        testFabrik.bestellungAufgeben(0, 6);
        testFabrik.bestellungAusgeben();

        // Test 4: Ungültige Bestellung (-5 Standardtüren, 6 Premiumtüren)
        System.out.println("\nTest 4: Ungültige Bestellung mit -5 Standardtüren und 6 Premiumtüren");
        testFabrik.bestellungAufgeben(-5, 6);
        testFabrik.bestellungAusgeben();

        // Test 5: Ungültige Bestellung (1.000.000 Standardtüren, 6 Premiumtüren)
        System.out.println("\nTest 5: Ungültige Bestellung mit 1.000.000 Standardtüren und 6 Premiumtüren");
        testFabrik.bestellungAufgeben(1_000_000, 6);
        testFabrik.bestellungAusgeben();

        // Test 6: Leere Bestellung (0 Standardtüren, 0 Premiumtüren)
        System.out.println("\nTest 6: Leere Bestellung mit 0 Standardtüren und 0 Premiumtüren");
        testFabrik.bestellungAufgeben(0, 0);
        testFabrik.bestellungAusgeben();

        System.out.println("\nTests abgeschlossen.");
    }
}
