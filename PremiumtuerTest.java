import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Testklasse PremiumtuerTest überprüft die Funktionalität der Klasse Premiumtuer.
 * Dabei werden die statischen Methoden getestet, welche die Materialanforderungen 
 * und Produktionszeiten für eine Premiumtür zurückgeben.
 * 
 * Diese Tests gewährleisten die korrekte Implementierung der für die Produktion 
 * einer Premiumtür benötigten Ressourcen und Zeit.
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class PremiumtuerTest {
    String nameTestClasse = "PremiumtuerTest";

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
     * Testet die statischen Methoden für Materialanforderungen
     */
    public void testeMaterialAnforderungen() {
        assertEquals(4, Premiumtuer.gibHolzeinheiten());
        assertEquals(5, Premiumtuer.gibSchrauben());
        assertEquals(5, Premiumtuer.gibGlaseinheiten());
        assertEquals(1, Premiumtuer.gibFarbeinheiten());
        assertEquals(5, Premiumtuer.gibKartoneinheiten());
        assertEquals(30, Premiumtuer.gibProduktionszeit());

        System.out.println("Test Materialanforderungen Premiumtuer erfolgreich.");
    }
}
