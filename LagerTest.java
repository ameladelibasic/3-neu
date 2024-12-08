import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Klasse LagerTest
 *
 * Überprüft die Funktionalität der Klasse Lager, einschliesslich:
 * - Berechnung der Beschaffungszeit
 * - Auffüllen des Lagers
 * - Ausgabe der Lagerbestände
 * 
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class LagerTest {
    String nameTestClasse = "LagerTest";

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
     * Testet die Berechnung der Beschaffungszeit bei ausreichendem und unzureichendem Lagerbestand
     */
    public void testeBeschaffungszeit() {
        Lager lager = new Lager();

        // Bestellung, die vom aktuellen Lagerbestand abgedeckt wird
        Bestellung bestellung1 = new Bestellung(2, 2, 1);
        int beschaffungszeit1 = lager.gibBeschaffungszeit(bestellung1);
        assertEquals(0, beschaffungszeit1);

        // Erwartung: Eine zu grosse Bestellung wirft eine IllegalArgumentException
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Bestellung(15_000, 10_000, 2)
        );
        assertEquals("Bestellmenge ist zu gross. Maximal 10 Tausend pro Artikel.", exception.getMessage());

        System.out.println("Test Berechnung der Beschaffungszeit erfolgreich.");
    }




        @Test
    /**
     * Testet das Auffüllen des Lagers
     */
    public void testeLagerAuffuellen() {
        Lager lager = new Lager();
    
        // Reduziere den Lagerbestand manuell, um den Auffüllprozess zu testen
        Bestellung grosseBestellung = new Bestellung(9_000, 9_000, 1); // Verbrauch von Materialien simulieren
        lager.gibBeschaffungszeit(grosseBestellung);
    
        // Auffüllen des Lagers
        lager.lagerAuffuellen();

        // Erwartung: Alle Materialarten sollten wieder auf ihren Maximalwerten sein
        assertEquals(10_000, lager.gibHolzeinheiten(), "Holzeinheiten nicht korrekt aufgefüllt.");
        assertEquals(10_000, lager.gibSchrauben(), "Schrauben nicht korrekt aufgefüllt.");
        assertEquals(5_000, lager.gibFarbeinheiten(), "Farbeinheiten nicht korrekt aufgefüllt.");
        assertEquals(5_000, lager.gibKartoneinheiten(), "Kartoneinheiten nicht korrekt aufgefüllt.");
        assertEquals(5_000, lager.gibGlaseinheiten(), "Glaseinheiten nicht korrekt aufgefüllt.");

        System.out.println("Test Auffüllen des Lagers erfolgreich.");
    }


    @Test
    /**
     * Testet die Ausgabe der Lagerbestände
     */
    public void testeLagerBestandAusgabe() {
        Lager lager = new Lager();

        // Erwartung: Lagerbestand wird korrekt ausgegeben
        System.out.println("Test Lagerbestandsausgabe:");
        lager.lagerBestandAusgeben();
    }
}
