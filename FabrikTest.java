import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Testklasse FabrikTest überprüft die Funktionalität der Klasse Fabrik.
 * Dabei werden verschiedene Szenarien getestet, einschliesslich:
 * - Das Aufgeben von Bestellungen mit gültigen und ungültigen Werten.
 * - Die Berechnung der Lieferzeiten für Bestellungen.
 * - Die korrekte Verwaltung und Auffüllung des Lagers.
 * 
 * Diese Tests dienen zur Sicherstellung der Robustheit und Korrektheit der Implementierung.
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class FabrikTest {
    String nameTestClasse = "FabrikTest";

    @BeforeEach
    public void setUp() {
        System.out.println("Testlauf " + nameTestClasse + " Start");
        System.out.println();
    }

    @AfterEach
    public void tearDown() {
        System.out.println();
        System.out.println("Testlauf " + nameTestClasse + " Ende");
        System.out.println("------------------------");
    }

    @Test
    /**
     * Testet das erfolgreiche Aufgeben von Bestellungen mit gültigen Werten
     */
    public void testeGueltigeBestellung() {
        Fabrik fabrik = new Fabrik();

        // Aufgeben einer gültigen Bestellung
        fabrik.bestellungAufgeben(3, 4);
        assertEquals(1, fabrik.gibBestellungen().size());

        Bestellung ersteBestellung = fabrik.gibBestellungen().get(0);
        assertEquals(3, ersteBestellung.gibAnzahlStandardTueren());
        assertEquals(4, ersteBestellung.gibAnzahlPremiumTueren());
        assertEquals(7, ersteBestellung.gibBestellteProdukte().size());

        System.out.println("Test für gültige Bestellung erfolgreich.");
    }

    @Test
    /**
     * Testet, dass ungültige Bestellungen nicht verarbeitet werden
     */
    public void testeUngueltigeBestellung() {
        Fabrik fabrik = new Fabrik();

        // Aufgeben von ungültigen Bestellungen
        fabrik.bestellungAufgeben(0, 0);       // Beide Werte 0
        fabrik.bestellungAufgeben(-1, 5);      // Negativer Wert
        fabrik.bestellungAufgeben(15_000, 1);  // Wert über der Grenze

        // Sicherstellen, dass keine Bestellungen verarbeitet wurden
        assertEquals(0, fabrik.gibBestellungen().size());

        System.out.println("Test für ungültige Bestellung erfolgreich.");
    }

    @Test
    /**
     * Testet die Lieferzeitberechnung
     */
    public void testeLieferzeitBerechnung() {
        Fabrik fabrik = new Fabrik();

        // Aufgeben einer Bestellung
        fabrik.bestellungAufgeben(2, 2);

        Bestellung bestellung = fabrik.gibBestellungen().get(0);
        int erwarteteLieferzeit = (2 * Standardtuer.gibProduktionszeit() + 2 * Premiumtuer.gibProduktionszeit()) + 1; // Produktionszeit + Standardlieferzeit
        assertEquals(erwarteteLieferzeit, bestellung.gibLieferzeit());

        System.out.println("Test für Lieferzeitberechnung erfolgreich.");
    }

    @Test
    /**
     * Testet das Auffüllen des Lagers nach einer Bestellung mit fehlenden Materialien
     */
    public void testeLagerAuffuellen() {
        Fabrik fabrik = new Fabrik();

        // Simuliere eine Bestellung, die das Lager auffüllt
        fabrik.bestellungAufgeben(9_000, 9_000); // Eine Bestellung, die die Lagergrenze erreicht

        // Erwartung: Lager wird aufgefüllt (durch Konsolenausgabe erkennbar)
        assertEquals(1, fabrik.gibBestellungen().size());
        System.out.println("Test für Lagerauffüllung erfolgreich.");
    }
}
