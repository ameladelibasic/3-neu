import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Klasse ProduktTest
 *
 * 
 * @author Amela Delibasic, Lino Reye, Naya Zumstein, Nikolai Pröbstle und Yannick Albrecht (GBI, Gruppe 12)
 * @version Aufgabe 2 (24. November 2024)
 */
public class ProduktTest {
    String nameTestClasse = "ProduktTest"; // Name der Testklasse

    /**
     * Konstruktor von ProduktTest
     */
    public ProduktTest() {
    }

    /**
     * Anweisungen vor jedem Testlauf
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Testlauf " + nameTestClasse + " Start");
        System.out.println();
    }

    /**
     * Anweisungen nach jedem Testlauf
     */
    @AfterEach
    public void tearDown() {
        System.out.println();
        System.out.println("Testlauf " + nameTestClasse + " Ende");
        System.out.println("------------------------");
    }

    @Test
    /**
     * Testet die Zustandsänderungen eines Produkts
     */
    public void testeZustandsAenderung() {
        Produkt produkt = new Produkt();
        assertEquals(0, produkt.aktuellerZustand());

        produkt.zustandAendern(1);
        assertEquals(1, produkt.aktuellerZustand());

        produkt.zustandAendern(3);
        assertEquals(3, produkt.aktuellerZustand());

        System.out.println("Test Zustandsänderung erfolgreich.");
    }

    @Test
    /**
     * Testet, dass ein ungültiger Zustand eine Exception auslöst
     */
    public void testeUngueltigerZustand() {
        Produkt produkt = new Produkt();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            produkt.zustandAendern(5);
        });

        assertEquals("Ungültiger Zustand: 5. Der Zustand muss zwischen 0 und 3 liegen.", exception.getMessage());
        System.out.println("Test ungültiger Zustand erfolgreich.");
    }
}
