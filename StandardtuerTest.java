import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Testklasse StandardtuerTest überprüft die Funktionalität der Klasse Standardtuer.
 * Dabei werden die statischen Methoden getestet, welche die Materialanforderungen 
 * und Produktionszeiten für eine Standardtür zurückgeben.
 * 
 * Diese Tests gewährleisten die korrekte Implementierung der für die Produktion 
 * einer Standardtür benötigten Ressourcen und Zeit.
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class StandardtuerTest {
    String nameTestClasse = "StandardtuerTest";

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
        assertEquals(2, Standardtuer.gibHolzeinheiten());
        assertEquals(10, Standardtuer.gibSchrauben());
        assertEquals(2, Standardtuer.gibFarbeinheiten());
        assertEquals(1, Standardtuer.gibKartoneinheiten());
        assertEquals(10, Standardtuer.gibProduktionszeit());

        System.out.println("Test Materialanforderungen Standardtuer erfolgreich.");
    }
}
