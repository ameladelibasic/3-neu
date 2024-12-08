import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Testklasse BestellungTest überprüft die Funktionalität der Klasse Bestellung.
 * Dabei werden verschiedene Szenarien getestet, einschließlich:
 * - Hinzufügen und Verwaltung von Produkten in einer Bestellung.
 * - Berechnung und Setzen von Beschaffungs- und Lieferzeiten.
 * - Überprüfung der Bestellbestätigung.
 * - Umgang mit ungültigen Eingaben für Bestellungen.
 * 
 * Diese Tests dienen zur Sicherstellung der Korrektheit und Robustheit der Implementierung.
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class BestellungTest {
    String nameTestClasse = "BestellungTest";

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
     * Testet das korrekte Hinzufügen von Produkten zur Bestellung
     */
    public void testeProdukteHinzufuegen() {
        // Erstellen einer Bestellung mit 3 Standardtüren und 2 Premiumtüren
        Bestellung bestellung = new Bestellung(3, 2, 1);

        // Überprüfung der Anzahl bestellter Produkte
        assertEquals(5, bestellung.gibBestellteProdukte().size());
        assertEquals(3, bestellung.gibAnzahlStandardTueren());
        assertEquals(2, bestellung.gibAnzahlPremiumTueren());

        // Überprüfen, ob die Produkte korrekt instanziiert wurden
        int standardTueren = 0;
        int premiumTueren = 0;
        for (Produkt produkt : bestellung.gibBestellteProdukte()) {
            if (produkt instanceof Standardtuer) {
                standardTueren++;
            } else if (produkt instanceof Premiumtuer) {
                premiumTueren++;
            }
        }

        assertEquals(3, standardTueren);
        assertEquals(2, premiumTueren);

        System.out.println("Test Produkte hinzufügen erfolgreich.");
    }

    @Test
    /**
     * Testet die Beschaffungs- und Lieferzeit der Bestellung
     */
    public void testeZeiten() {
        // Erstellen einer Bestellung
        Bestellung bestellung = new Bestellung(2, 2, 1);

        // Setzen von Beschaffungszeit und Lieferzeit
        bestellung.setzeBeschaffungsZeit(2);
        bestellung.setzeLieferzeit(5);

        // Überprüfen der gesetzten Zeiten
        assertEquals(2, bestellung.gibBeschaffungsZeit());
        assertEquals(5, bestellung.gibLieferzeit());

        System.out.println("Test Beschaffungs- und Lieferzeit erfolgreich.");
    }

    @Test
    /**
     * Testet die Bestellbestätigung
     */
    public void testeBestellBestaetigung() {
        // Erstellen einer Bestellung
        Bestellung bestellung = new Bestellung(1, 1, 1);

        // Anfangszustand überprüfen
        assertFalse(bestellung.istBestellt());

        // Bestätigung setzen
        bestellung.setzeBestellBestaetigung(true);
        assertTrue(bestellung.istBestellt());

        System.out.println("Test Bestellbestätigung erfolgreich.");
    }

    @Test
    /**
     * Testet ungültige Parameter für die Bestellung
     */
    public void testeUngueltigeBestellung() {
        // Test mit ungültigen Werten (z. B. negative Mengen)
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            new Bestellung(-1, 2, 1);
        });
        assertEquals("Ungültige Bestellmenge. Kann nicht negativ sein.", exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Bestellung(0, 0, 1);
        });
        assertEquals("Die Bestellung muss mindestens ein Produkt enthalten.", exception2.getMessage());

        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
            new Bestellung(15_000, 1, 1);
        });
        assertEquals("Bestellmenge ist zu gross. Maximal 10 Tausend pro Artikel.", exception3.getMessage());

        System.out.println("Test ungültige Bestellung erfolgreich.");
    }
}
