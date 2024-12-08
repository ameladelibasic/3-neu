import java.util.LinkedList;

abstract class Roboter extends Thread {
    protected LinkedList<Produkt> produktionsListe = new LinkedList<>();

    public void produktHinzufuegen(Produkt produkt) {
        synchronized (produktionsListe) {
            produktionsListe.add(produkt);
        }
    }

    @Override
    public abstract void run();
}