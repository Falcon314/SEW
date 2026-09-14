public class Musikalbum {
    private String albumName;
    private String albumInterpret;
    private Musikstueck[] musikstuecke;

    /**
     * Konstruktor MusikAlbum
     *
     * @param albumtitel übernimmt den Titel für das Album
     * @param albuminterpret übernimmt den Interpreten für das Album
     */
    public Musikalbum(String albumtitel, String albuminterpret) {
        this.setAlbumName(albumtitel);
        this.setAlbumInterpret(albuminterpret);
    }

    /**
     * Methode addMusikstueck
     *
     * @param musikstueck übernimmt ein Musikstück und fügt es beim ersten freien Platz ein
     * @return gibt zurück, ob das Hinzufügen erfolgreich war
     */
    public boolean addMusikstueck(Musikstueck musikstueck) {
        boolean arrayKorrekt = false;
        if (this.musikstuecke == null) {
            this.musikstuecke = new Musikstueck[1];
            arrayKorrekt = true;
        } else {
            arrayKorrekt = this.arrayVergroessern();
        }
        if (arrayKorrekt) {
            musikstuecke[musikstuecke.length-1] = musikstueck;
            return true;
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
        return this.addMusikstueck( new Musikstueck( title, interpret, laenge ) );
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
        String minString, sekString, stuString;
        int minuten = laenge / 60;
        int sekunden = laenge % 60;
        int stunden = laenge / 3600;
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
        if (stunden < 10) {
            stuString = "0"+stunden;
        } else {
            stuString = ""+ stunden;
        }
        return stunden+":"+minuten+":"+sekunden;
    }

    /**
     * Methode listMusikstuecke
     *
     * @return gibt einen Text mit einer formatierten Liste der Inhalte des Albums
     */
    public String listMusikstuecke() {
        if (this.musikstuecke != null) {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < this.musikstuecke.length; i++) {
                if (musikstuecke[i] != null) {
                    text.append(i+1).append(". ")
                            .append(this.musikstuecke[i].getTitel())
                            .append(" von ")
                            .append(this.musikstuecke[i].getInterpret())
                            .append(" ("+this.musikstuecke[i].zeigeDauer()+")")
                            .append("\n");
                }
            }
            return text.toString();
        }
        return "Keine Songs";
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
                this.arrayVerkleinern();
                return true;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Methode arrayVergoessern
     *
     * Vergrößert das Array "musikstueke" um 1 um ein weiteres Musikstück zu speichern
     * */
    private boolean arrayVergroessern() {
        if (this.musikstuecke != null) {
            Musikstueck[] tempMusikstuecke = new Musikstueck[this.musikstuecke.length + 1];
            for (int i = 0; i < tempMusikstuecke.length - 1; i++) {
                tempMusikstuecke[i] = this.musikstuecke[i];
            }
            this.musikstuecke = tempMusikstuecke;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode arrayVerkleinern
     *
     * Verkleinert das Array "musikstueke" um 1 um keine "null" Werte zu beinhalten
     * */
    private void arrayVerkleinern() {
        if (this.musikstuecke != null) {
            Musikstueck[] tempMusikstuecke = new Musikstueck[this.musikstuecke.length - 1];
            for (int i = 0; i <= tempMusikstuecke.length-1; i++) {
                tempMusikstuecke[i] = this.musikstuecke[i];
            }
            this.musikstuecke = tempMusikstuecke;
        }
    }
}
