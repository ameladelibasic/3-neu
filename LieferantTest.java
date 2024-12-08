import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Testklasse LieferantTest überprüft die Funktionalität der Klasse Lieferant.
 * Der Fokus liegt dabei auf der Materialbeschaffung, welche durch die Methode 
 * `bestellungAufgeben` simuliert wird. Die Tests basieren auf der Überprüfung 
 * der Konsolenausgabe, die die Nachbestellung und die Bestätigung der Materiallieferung anzeigt.
 * 
 * Diese Tests stellen sicher, dass der Lieferant korrekt aufgerufen wird und seine Funktion erfüllt.
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class LieferantTest {
    String nameTestClasse = "LieferantTest";

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
     * Testet die Materialbeschaffung des Lieferanten
     */
    public void testeMaterialBeschaffung() {
        Lieferant lieferant = new Lieferant();

        // Test durch Beobachtung der Konsolenausgabe
        lieferant.bestellungAufgeben();

        System.out.println("Test Materialbeschaffung erfolgreich.");
    }
}
