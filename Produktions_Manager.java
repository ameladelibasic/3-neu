import java.util.LinkedList;

public class Produktions_Manager implements Runnable {
    private LinkedList<Bestellung> zuVerarbeitendeBestellungen = new LinkedList<>();
    private LinkedList<Bestellung> inProduktionBestellungen = new LinkedList<>();
    private Holzbearbeitungs_Roboter holzbearbeitungsRoboter;

    public Produktions_Manager() {
        holzbearbeitungsRoboter = new Holzbearbeitungs_Roboter();
        holzbearbeitungsRoboter.start();
    }

    public void bestellungHinzufuegen(Bestellung bestellung) {
        synchronized (zuVerarbeitendeBestellungen) {
            zuVerarbeitendeBestellungen.add(bestellung);
        }
    }

    private void starteProduktion(Bestellung bestellung) {
        for (Produkt produkt : bestellung.gibBestellteProdukte()) {
            holzbearbeitungsRoboter.produktHinzufuegen(produkt);
            int bearbeitungszeit = produkt instanceof Standardtuer ? 10 : 30;
            produkt.setBearbeitungszeit(bearbeitungszeit);
        }
    }

    private void pruefeBestellungen() {
        synchronized (inProduktionBestellungen) {
            for (Bestellung bestellung : inProduktionBestellungen) {
                boolean abgeschlossen = true;
                for (Produkt produkt : bestellung.gibBestellteProdukte()) {
                    if (produkt.getBearbeitungszeit() > 0) {
                        abgeschlossen = false;
                        break;
                    }
                }
                if (abgeschlossen) {
                    bestellung.setzeBestellBestaetigung(true);
                    System.out.println("Bestellung Nr. " + bestellung.gibBestellungsNr() + " ist abgeschlossen.");
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            Bestellung bestellung = null;
            synchronized (zuVerarbeitendeBestellungen) {
                if (!zuVerarbeitendeBestellungen.isEmpty()) {
                    bestellung = zuVerarbeitendeBestellungen.removeFirst();
                    inProduktionBestellungen.add(bestellung);
                }
            }

            if (bestellung != null) {
                starteProduktion(bestellung);
            }

            pruefeBestellungen();

            try {
                Thread.sleep(1000); // kurze Pause
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Produktions_Manager manager = new Produktions_Manager();
        Thread managerThread = new Thread(manager);
        managerThread.start();

        // Testbestellung hinzufügen
        Bestellung testBestellung = new Bestellung(3, 2, 1); // Beispielwerte
        manager.bestellungHinzufuegen(testBestellung);
    }
}