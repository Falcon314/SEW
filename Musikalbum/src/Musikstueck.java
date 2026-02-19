public class Musikstueck {
    private String titel;
    private String interpret;
    private int laenge; // in Sekunden

    /**
     * Konstruktor Musikstück
     */
    public Musikstueck(){

    }

    /**
     * Konstruktor Musikstück
     *
     * @param titel übergibt den titel des Musikstücks
     * @param interpret übergibt den interpreten des Musikstücks
     * @param laenge übergibt die länge des Musikstücks
     */
    public Musikstueck(String titel, String interpret, int laenge) {
        this.setTitel(titel);
        this.setInterpret(interpret);
        this.setLaenge(laenge);
    }

    /**
     * Methode zeigeDauer
     *
     * @return gibt die länge in Format "mm:ss" zurück
     */
    public String zeigeDauer() {
        int minuten = laenge / 60;
        int sekunden = laenge-(minuten*60);
        String minString;
        String sekString;
        if (minuten < 10) {
            minString = "0"+minuten;
        } else {
            minString = ""+minuten;
        }
        if (sekunden < 10) {
            sekString = "0"+sekunden;
        } else {
            sekString = ""+ sekunden;
        }
        return minString+":"+sekString;
    }

    /**
     * Methode zeigeDaten
     *
     * @return gibt alle Daten der Klasse Musikstück, in einem String, zusammenfasst zurück
     */
    public String zeigeDaten() {
        return "Titel: "+this.titel+"\nInterpret: "+this.interpret+"\nLänge: "+this.zeigeDauer();
    }

    /**
     * Methode setTitel
     *
     * @param titel übergibt den titel für das Musikstück
     */
    public void setTitel(String titel) {
        if (titel != null && !titel.isEmpty()) {
            this.titel = titel;
        }
    }

    /**
     * Methode setTitel
     *
     * @param interpret übergibt den interpreten für das Musikstück
     */
    public void setInterpret(String interpret) {
        if (interpret != null && !interpret.isEmpty()) {
            this.interpret = interpret;
        }
    }

    /**
     * Methode setTitel
     *
     * @param laenge übergibt die länge für das Musikstück
     */
    public void setLaenge(int laenge) {
        if (laenge > 0) {
            this.laenge = laenge;
        }
    }

    /**
     * Methode getTitel
     *
     * @return gibt den Titel des Musikstücks zurück
     */
    public String getTitel() {
        return this.titel;
    }

    /**
     * Methode getInterpret
     *
     * @return gibt den Interpreten des Musikstücks zurück
     */
    public String getInterpret() {
        return this.interpret;
    }

    /**
     * Methode getLaenge
     *
     * @return gibt die Länge des Musikstücks zurück in Sekunden
     */
    public int getLaenge() {
        return this.laenge;
    }
}

