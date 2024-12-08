import java.util.LinkedList;

public class Holzbearbeitungs_Roboter extends Roboter {
    public Holzbearbeitungs_Roboter() {
        super();
    }

    @Override
    public void run() {
        while (true) {
            Produkt produkt = null;
            synchronized (produktionsListe) {
                if (!produktionsListe.isEmpty()) {
                    produkt = produktionsListe.removeFirst();
                }
            }

            if (produkt != null) {
                produziereProdukt(produkt);
            }

            try {
                Thread.sleep(500); // kurze Pause
            } catch (InterruptedException e) {
                System.out.println("Fehler beim Warten: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    private void produziereProdukt(Produkt produkt) {
        try {
            if (produkt instanceof Standardtuer) {
                Thread.sleep(600000); // 10 Minuten
            } else if (produkt instanceof Premiumtuer) {
                Thread.sleep(1800000); // 30 Minuten
            }
            System.out.println("Produkt wurde bearbeitet: " + produkt);
            produkt.setBearbeitungszeit(0); // Markiere als bereit für den nächsten Schritt
        } catch (InterruptedException e) {
            System.out.println("Fehler bei der Produktbearbeitung: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}