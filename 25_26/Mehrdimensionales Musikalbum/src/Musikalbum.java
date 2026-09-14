public class Musikalbum {
    private String albumName;
    private String albumInterpret;
    private Musikstueck[][] tontraeger;

    /**
     * Konstruktor MusikAlbum
     *
     * @param albumName übernimmt den Titel für das Album
     * @param albumInterpret übernimmt den Interpreten für das Album
     */
    public Musikalbum(String albumName, String albumInterpret, int anzahlTontraeger) {
        this.setAlbumName(albumName);
        this.setAlbumInterpret(albumInterpret);
        this.tontraeger = new Musikstueck[anzahlTontraeger][];
    }

    // ============= addMusikstueck =================
    // ----------------------------------------------
    /**
     * Methode addMusikstueck
     * Fügt ein Musikstück ans Ende eines Tonträgers an
     *
     * @param musikstueck übernimmt ein Musikstück und fügt es ans Ende eines Tonträgers an
     * @param nummerTontraeger übernummt ein Index, welchen Tonträger das Musikstück hinzugefügt wird
     * @return gibt zurück, ob das Hinzufügen erfolgreich war
     */
    public boolean addMusikstueck(Musikstueck musikstueck, int nummerTontraeger) {
        nummerTontraeger-=1;
        if (musikstueck != null && ( nummerTontraeger >= 0 && nummerTontraeger < this.tontraeger.length ) ) {
            if (this.tontraeger[nummerTontraeger] == null) {
                this.tontraeger[nummerTontraeger] = new Musikstueck[1];
            } else {
                Musikstueck[] tms = new Musikstueck[this.tontraeger[nummerTontraeger].length+1];
                for (int i = 0; i < this.tontraeger[nummerTontraeger].length; i++) {
                    tms[i] = this.tontraeger[nummerTontraeger][i];
                }
                this.tontraeger[nummerTontraeger] = tms;
            }
            this.tontraeger[nummerTontraeger][this.tontraeger[nummerTontraeger].length-1] = musikstueck;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode musikstueck
     * Fügt ein Musikstück ans Ende eines Tonträgers an.
     *
     * @param titel übernimmt einen Titel für ein Musikstück, das dem Tonträger hinzugefügt wird
     * @param interpret übernimmt einen Interpreten für ein Musikstück, das dem Tonträger hinzugefügt wird
     * @param dauer übernimmt eine Länger für ein Musikstück, das dem Tonträger hinzugefügt wird
     * @param nummerTontraeger übernummt ein Index, welchen Tonträger das Musikstück hinzugefügt wird
     * @return gibt zurück, ob dasshinzufügen des neu erstellten Musikstücks erfolgreich war
     */
    public boolean addMusikstueck(String titel, String interpret, int dauer, int nummerTontraeger) {
        return this.addMusikstueck( new Musikstueck( titel, interpret, dauer ), nummerTontraeger );
    }

    /**
     * Methode addMusikstueck
     * Fügt ein Musikstück an der angegebenen Nummer des Tonträgers ein.
     *
     * @param musikstueck übernimmt ein Musikstück und fügt es an der angegebenen Nummer des Tonträgers ein
     * @param nummerTitel übernimmt ein Index an welcher stelle das Musikstück im Tonträger hinzugefügt wird
     * @param nummerTontraeger übernimmt ein Index welcher Tonträger genommen wird
     * @return gibt zurück, ob das Hinzufügen erfolgreich war
     */
    public boolean addMusikstueck(Musikstueck musikstueck, int nummerTitel, int nummerTontraeger) {
        nummerTontraeger-=1;
        if (musikstueck != null && ( nummerTontraeger >= 0 && nummerTontraeger < this.tontraeger.length-1 ) ) {
            if (this.tontraeger[nummerTontraeger] == null) {
                return false;
            } else {
                Musikstueck[] tms = new Musikstueck[this.tontraeger[nummerTontraeger].length];
                for (int i = 0; i < this.tontraeger[nummerTontraeger].length; i++) {
                    tms[i] = this.tontraeger[nummerTontraeger][i];
                }
                this.tontraeger[nummerTontraeger] = tms;
            }
            if ( !( nummerTitel >=  0 && nummerTitel < this.tontraeger[nummerTontraeger].length-1 ) ) return false;
            for (int i = this.tontraeger[nummerTontraeger].length-1; i >= nummerTitel; i--) {
                this.tontraeger[nummerTontraeger][i] = this.tontraeger[nummerTontraeger][i-1];
            }
            this.tontraeger[nummerTontraeger][nummerTitel] = musikstueck;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode addMusikstueck
     * Fügt ein Musikstück an der angegebenen Nummer des Tonträgers ein.
     *
     * @param titel übernimmt einen Titel für ein Musikstück, das dem Tonträger hinzugefügt wird
     * @param interpret übernimmt einen Interpreten für ein Musikstück, das dem Tonträger hinzugefügt wird
     * @param dauer übernimmt eine Länger für ein Musikstück, das dem Tonträger hinzugefügt wird
     * @param nummerTitel übernimmt ein Index an welcher stelle das Musikstück im Tonträger hinzugefügt wird
     * @param nummerTontraeger übernimmt ein Index welcher Tonträger genommen wird
     * @return gibt zurück, ob das Hinzufügen erfolgreich war
     * */
    public boolean addMusikstueck(String titel, String interpret, int dauer, int nummerTitel, int nummerTontraeger) {
        return this.addMusikstueck( new Musikstueck(titel, interpret, dauer), nummerTitel, nummerTontraeger);
    }

    // ============= addTonträger =================
    // --------------------------------------------
    /**
     * Methode addTontraeger
     * Fügt einen leeren Tonträger als letzten Tonträger ein.
     * */
    public void addTontraeger() {
        Musikstueck[][] ttt = new Musikstueck[this.tontraeger.length+1][];
        for (int i = 0; i < this.tontraeger.length; i++) {
            ttt[i] = this.tontraeger[i];
        }
        this.tontraeger = ttt;
    }

    /**
     * Methode addTontraeger
     * Fügt einen leeren Tonträger an der angegebenen position ein.
     *
     * @param nummerTontraeger übernimmt einen Index wo ein Tontraeger eingefügt wird
     * @return gibt zurück, ob das Hinzufügen erfolgreich war
     * */
    public boolean addTontraeger(int nummerTontraeger) {
        nummerTontraeger-=1;
        if (nummerTontraeger >= 0 && nummerTontraeger < this.tontraeger.length+1) {
            Musikstueck[][] ttt = new Musikstueck[this.tontraeger.length + 1][];
            for (int i = 0; i < this.tontraeger.length; i++) {
                ttt[i] = this.tontraeger[i];
            }
            this.tontraeger = ttt;
            for (int i = this.tontraeger.length - 1; i >= nummerTontraeger; i--) {
                this.tontraeger[i] = this.tontraeger[i - 1];
            }
            this.tontraeger[nummerTontraeger] = null;
            return true;
        } else {
            return false;
        }
    }

    // ============= removeMusikstueck =================
    // -------------------------------------------------
    /**
     * removeMusikstueck
     * Entfernt ein Musikstück aus dem Album und verkleinert das Array
     *
     * @param nummerTontraeger Nummer des Tonträgers, auf dem das zu entfernende Musikstück sich befindet
     * @param nummerTitel Nummer des Titels, der gelöscht werden soll
     * @return gibt zurück, ob das heraus löschen erfolgreich war
     */
    public boolean removeMusikstueck(int nummerTontraeger, int nummerTitel) {
        nummerTontraeger-=1;
        nummerTitel-=1;
        if (this.tontraeger[nummerTontraeger] != null && nummerTontraeger >= 0 && nummerTontraeger < this.tontraeger.length) {
            if (nummerTitel >= 0 && nummerTitel < this.tontraeger[nummerTontraeger].length) {

                this.tontraeger[nummerTontraeger][nummerTitel] = null;
                for (int i = nummerTitel; i < this.tontraeger[nummerTontraeger].length-1; i++) {
                    this.tontraeger[nummerTontraeger][i] = this.tontraeger[nummerTontraeger][i+1];
                }

                Musikstueck[] tms = new Musikstueck[this.tontraeger[nummerTontraeger].length-1];
                for (int i = 0; i < this.tontraeger[nummerTontraeger].length-1; i++) {
                    tms[i] = this.tontraeger[nummerTontraeger][i];
                }
                this.tontraeger[nummerTontraeger] = tms;
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Methode removeTontraeger
     * Entfernt einen ganzen Tonträger aus der Sammlung.
     * @param nummerTontraeger übernimmt die zahl welcher Tonträger gelöscht wird
     * @return gibt zurück, ob das Löschen erfolgreich war
     * */
    public boolean removeTontraeger(int nummerTontraeger) {
        nummerTontraeger-=1;
        if (nummerTontraeger >= 0 && nummerTontraeger < this.tontraeger.length) {
            this.tontraeger[nummerTontraeger] = null;
            for (int i = nummerTontraeger; i < this.tontraeger.length - 1; i++) {
                this.tontraeger[nummerTontraeger] = this.tontraeger[nummerTontraeger + 1];
            }

            Musikstueck[][] ttt = new Musikstueck[this.tontraeger.length - 1][];
            for (int i = 0; i < this.tontraeger.length - 1; i++) {
                ttt[i] = this.tontraeger[i];
            }
            this.tontraeger = ttt;
            return true;
        } else {
            return false;
        }
    }

    // ============= Setter/Getter =================
    // ---------------------------------------------
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

    // ============= Sonstige =================
    // ----------------------------------------
    /**
     * Methode zeigeDauer
     *
     * @return gibt die Gesamtdauer des Albums
     */
    public String zeigeDauer() {
        int laenge = 0;
        for (int i = 0; i < this.tontraeger.length; i++) {
            if (this.tontraeger[i] != null) {
                for (int j = 0; j < this.tontraeger[i].length; j++) {
                    laenge += this.tontraeger[i][j].getLaenge();
                }
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
        return stuString+":"+minString+":"+sekString;
    }

    /**
     * Methode listMusikstuecke
     *
     * @return gibt einen Text mit einer formatierten Liste der Inhalte des Albums
     */
    public String listMusikstuecke(int nummerTontraeger) {
        nummerTontraeger-=1;
        StringBuilder sb = new StringBuilder();
        if (this.tontraeger != null && ( nummerTontraeger >= 0 && nummerTontraeger < this.tontraeger.length )) {
            sb.append("Der Tonträger: " + (nummerTontraeger+1) ).append("\n").append("Beinhaltet:\n");
            if (this.tontraeger[nummerTontraeger] != null) {
                for (int i = 0; i < this.tontraeger[nummerTontraeger].length; i++) {
                    sb.append(i + 1 + ". ")
                            .append(this.tontraeger[nummerTontraeger][i].getTitel())
                            .append(" von ")
                            .append(this.tontraeger[nummerTontraeger][i].getInterpret())
                            .append(" (")
                            .append(this.tontraeger[nummerTontraeger][i].zeigeDauer())
                            .append(")\n");
                }
            } else {
                sb.append("Keine Songs\n");
            }
            return sb.toString();

        } else if ( this.tontraeger != null && nummerTontraeger == -1 ) {
            for (int i = 0; i < this.tontraeger.length; i++) {
                sb.append("Der Tonträger: " + (i+1) ).append("\n").append("Beinhaltet:\n");
                if (this.tontraeger[i] != null) {
                    for (int j = 0; j < this.tontraeger[i].length; j++) {
                        sb.append(j + 1 + ". ")
                                .append(this.tontraeger[i][j].getTitel())
                                .append(" von ")
                                .append(this.tontraeger[i][j].getInterpret())
                                .append(" (")
                                .append(this.tontraeger[i][j].zeigeDauer())
                                .append(")\n");
                    }
                    sb.append("\n");
                } else {
                    sb.append("Keine Songs\n\n");
                }
            }
            return sb.toString();
        }
        return null;
    }

}
