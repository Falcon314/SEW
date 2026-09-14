public class Musikalbum {
    private String albumName;
    private String albumInterpret;
    private Musikstueck[] musikstuecke;

    /**
     * Konstruktor MusikAlbum
     *
     * @param albumtitel übernimmt den Titel für das Album
     * @param albuminterpret übernimmt den Interpreten für das Album
     * @param anzahlMusikstuecke übernimmt die Anzahl an Musikstücken für das Album
     */
    public Musikalbum(String albumtitel, String albuminterpret, byte anzahlMusikstuecke) {
        this.setAlbumName(albumtitel);
        this.setAlbumInterpret(albuminterpret);
        if (anzahlMusikstuecke > 0) {
            this.musikstuecke = new Musikstueck[anzahlMusikstuecke];
        }
    }

    /**
     * Methode addMusikstueck
     *
     * @param musikstueck übernimmt ein Musikstück und fügt es beim ersten freien Platz ein
     * @return gibt zurück, ob das Hinzufügen erfolgreich war
     */
    public boolean addMusikstueck(Musikstueck musikstueck) {
        for (int i = 0; i < this.musikstuecke.length;++i) {
            if (this.musikstuecke[i] == null) {
                this.musikstuecke[i] = musikstueck;
                return true;
            }
        }
        return false;
    }

    /**
     * Methode musikstueck
     *
     * @param title übernimmt einen Titel für ein Musikstück, das dem Album hinugefügt wird
     * @param interpret übernimmt einen Interpreten für ein Musikstück, das dem Album hinugefügt wird
     * @param laenge übernimmt eine Länger für ein Musikstück, das dem Album hinugefügt wird
     * @return gibt zurück, ob dasshinzufügen des neu erstellten Musikstücks erfolgreich war
     */
    public boolean addMusikstueck(String title, String interpret, int laenge) {
        boolean erfolgreich = this.addMusikstueck( new Musikstueck( title, interpret, laenge ) );
        return  erfolgreich;
    }

    /**
     * Methode setAlbumName
     *
     * @param albumName übernimmt einen Namen für das Album
     */
    public void setAlbumName(String albumName) {
        if (albumName != null && !albumName.isEmpty()) {
            this.albumName = albumName;
        }
    }

    /**
     * Methode setAlbumInterpret
     *
     * @param albumInterpret übernimmt einen Interpreten für das Album
     */
    public void setAlbumInterpret(String albumInterpret) {
        if (albumInterpret != null && !albumInterpret.isEmpty()) {
            this.albumInterpret = albumInterpret;
        }
    }

    /**
     * Methode getAlbumName
     *
     * @return gib den Namen des Albums zurück
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Methode getAlbumInterpret
     *
     * @return gibt den Interpreten des Albums zurück
     */
    public String getAlbumInterpret() {
        return albumInterpret;
    }

    /**
     * Methode zeigeDauer
     *
     * @return gibt die Gesamtdauer des Albums
     */
    public String zeigeDauer() {
        int laenge = 0;
        for (int i = 0; i < this.musikstuecke.length; i++) {
            if (this.musikstuecke[i] != null) {
                laenge += this.musikstuecke[i].getLaenge();
            }
        }
        int minuten = laenge / 60;
        int sekunden = laenge-(minuten*60);
        return minuten+":"+sekunden;
    }

    /**
     * Methode listMusikstuecke
     *
     * @return gibt einen Text mAit einer formatierten Liste der Inhalte des Albums
     */
    public String listMusikstuecke() {
        String text = "";
        for (int i = 0; i < this.musikstuecke.length; i++) {
            if (musikstuecke[i] != null) {
                text += this.musikstuecke[i].zeigeDaten()+"\n---------------------\n";
            }
        }
        return text;
    }

    /**
     * removeMusikstueck
     *
     * @param nummertitel übernimmt den Index, andem das Musikstück im Ablum gelöscht werden soll
     * @return gibt zurück, ob das heraus löschen erfolgreich war
     */
    public boolean removeMusikstueck(int nummertitel) {
        if (nummertitel >= 0 && nummertitel < this.musikstuecke.length) {
            musikstuecke[nummertitel] = null;
            try {
                for (int i = nummertitel; i < this.musikstuecke.length - 1; i++) {
                    this.musikstuecke[i] = this.musikstuecke[i + 1];
                }
                this.musikstuecke[this.musikstuecke.length-1] = null;
                return true;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return false;
    }
}
