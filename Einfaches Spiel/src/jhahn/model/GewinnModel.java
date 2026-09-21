package jhahn.model;

import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    private static final Random random = new Random();

    public GewinnModel() {
        gesamtPunkte = 30;
    }
    public void berechneComputerZahl() {
        computerZahl = random.nextInt(1,10);
    }
    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();
        if (this.spielerZahl == this.computerZahl) {
            this.rundenErgebnis = 20;
        } else if (this.spielerZahl == this.computerZahl + 1 || this.spielerZahl == this.computerZahl - 1) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }
        this.gesamtPunkte += this.rundenErgebnis;
    }
    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }
    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }
    public int getComputerZahl() {
        return computerZahl;
    }
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

}
