/**
 * Beschreiben Sie hier die Klasse Spieler.
 *
 * @author Falcon314
 * @version 13.11.2025
 */
public class Spieler {
    private String name;
    private int leben;
    private Monster[] monsterArmee;

    /**
     * Spieler Konstruktor
     *
     * @param name übergibt den Namen für den Spieler
     * @param leben übergibt die Lebenspunkte für den Spieler
     * @param armeeGroesse übernimmt die Größe der MonsterArmee
     */
    public Spieler(String name, int leben, int armeeGroesse) {
        this.name = name;
        this.leben = leben;
        if (armeeGroesse >= 1) {
            this.monsterArmee = new Monster[armeeGroesse];
        } else {
            this.monsterArmee = new Monster[3];
        }
    }

    /**
     * Methode getName
     *
     * @return gibt den Namen als String zurück
     */
    public String getName() {return this.name;}

    /**
     * Methode getLebenspunkte
     *
     * @return gibt die Lebenspunkte als int zurück
     */
    public int getLebenspunkte() {return this.leben;}

    /**
     * Methode getMonster
     *
     * @param index übernimmt eine zahl als Monster-Indexwert
     * @return gibt ein Monster als Monster-Objekt zurück
     */
    public Monster getMonster(int index) {
        if (!(index < 0) && index < monsterArmee.length ) {
            return monsterArmee[index];
        } else {
            return null;
        }
    }

    /**
     * Methode rufeMonster
     * @param monster übernimmt ein Monster-Objekt, um es in die Armee aufzunehmen, wenn möglich
     * @return gibt zurück, ob das Aufnehmen erfolgreich war
     */
    public boolean rufeMonster(Monster monster) {
        if (monster != null) {
            for (int i=0; i< this.monsterArmee.length;i++) {
                if (this.monsterArmee[i] == null) {
                    this.monsterArmee[i] = monster;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Methode rufeMonster,
     *
     * @param name übernimmt einen Namen für ein Monster das erzeugt wird und direkt gerufen wird
     * @param angriff übernimmt einen Angriffswert für ein Monster das erzeugt wird und direkt gerufen wird
     * @param verteidigung übernimmt einen Verteidigungswert für ein Monster das erzeugt wird und direkt gerufen wird
     * @return gibt zurück, ob das Rufen erfolgreich war
     */
    public boolean rufeMonster(String name, int angriff, int verteidigung) {
        return this.rufeMonster(new Monster(name, angriff, verteidigung));
    }

    /**
     * Methode verteidigtGegen
     *
     * @param andererSpieler übernimmt ein anderes Spieler-Objekt,
     *                       um dagegen zu kämpfen
     */
    public void verteidigtGegen(Spieler andererSpieler) {
        for (int i=0;i< monsterArmee.length;i++) {
            if (this.getMonster(i) != null && andererSpieler.getMonster(i) != null) {
                this.getMonster(i).verteidigtGegen(andererSpieler.getMonster(i));
            } else if (this.getMonster(i) == null && andererSpieler.getMonster(i) != null) {
                this.leben -= andererSpieler.getMonster(i).getAngriff();
            }
        }

        this.wendeSchadenAn();
        andererSpieler.wendeSchadenAn();

        this.legeMonsterAb();
        andererSpieler.legeMonsterAb();

        //this.loescheMonsterSchaden();
        //andererSpieler.loescheMonsterSchaden();
    }

    /**
     * Methode wendeSchadenAn
     * <p>
     *     zieht dem Spieler Lebenspunkte ab, wenn ein monster besiegt ist
     *     und noch Angriffspunkte vergeben werden müssen
     * </p>
     */
    public void wendeSchadenAn() {
        for (int i=0;i< monsterArmee.length;i++) {
            if (this.getMonster(i) != null && this.getMonster(i).istBesiegt()) {
                this.leben -= this.getMonster(i).schadenSpieler();
            }
        }
    }

    /**
     * Methode legeMonsterAb
     * <p>
     *  Spieler legt besiege Monster ab, um neue aufnehmen zu können
     * </p>
     */
    public void legeMonsterAb() {
        for (int i=0;i< monsterArmee.length;i++) {
            if (this.getMonster(i) != null && this.getMonster(i).istBesiegt()) {
                this.legeMonsterAb(i);
            }
        }
    }

    /**
     * Methode legeMonsterAb
     *
     * @param index übernimmt einen Indexwert, bei dem das Monster-Objekt gelöscht werden soll
     *              und alle Monster-Objekte sollen nach rücken
     */
    public void legeMonsterAb(int index) {
        if (index > monsterArmee.length-1) {return;}
        monsterArmee[index] = null;
        for (int i=index; i< monsterArmee.length-1;i++) {
            monsterArmee[i] = monsterArmee[i+1];
        }
        monsterArmee[monsterArmee.length-1] = null;

    }

    /**
     * Methode löscheMonsterSchaden
     * <p>
     *     löscht den erlittenen schaden der Monster
     * </p>
     */
    public void loescheMonsterSchaden() {
        for (int i=0;i< monsterArmee.length;i++) {
            if (this.getMonster(i) != null) {
                this.getMonster(i).loescheSchaden();
            }
        }
    }

    /**
     * Methode istBesiegt
     *
     * @return gibt zurück, ob der Spieler besiegt wurde
     */
    public boolean istBesiegt() {
        return this.leben <= 0;
    }

    /**
     * Methode status
     * @return gibt einen String zurück der Daten über den Spieler und dessen Monster beinhaltet
     */
    public String status() {
        StringBuilder statusText = new StringBuilder(this.getName() + " - " + this.getLebenspunkte() + " LP: ");
        for (int i=0;i< monsterArmee.length;i++) {
            statusText.append(" ").append((i + 1)).append(". Monster: ");
            if (this.getMonster(i) != null) {
                statusText.append(this.getMonster(i).monsterDaten());
                if (i < monsterArmee.length-1) {
                    statusText.append(",");
                }
            } else {
                statusText.append("-");
            }
        }
        return statusText.toString();
    }

    /**
     * Methode getMaxArmeeGroesse
     *
     * @return gibt die maximale größe der Armee(des Arrays) zurück
     */
    public int getMaxArmeeGroesse() {
        if (monsterArmee != null) {
            return monsterArmee.length;
        }
        return 0;
    }

    /**
     * Methode setMonster
     *
     * @param monster übernimmt ein Monster-Objekt zum Setzen
     * @param index übernimmt einen Index, um zu bestimmen, wo das Monster-Objekt gespeichert werden soll
     */
    public void setMonster(Monster monster, int index) {
        if (index > monsterArmee.length-1) {return;}
        monsterArmee[index] = monster;
    }

    /**
     * Methode opfern
     *
     * @param opferMonster übernimmt einen Indexwert für ein Monster das die halben Werte von Angriff
     *                     und Verteidigung an das andere Monster abgibt und dann abgelegt wird
     * @param boostMonster übernimm einen Indexwert für ein Monster, das die halben Werte von Angriff
     *                     und Verteidigung vom anderem Monster annimmt
     */
    public void opfern(int opferMonster, int boostMonster) {
        if (opferMonster > monsterArmee.length || boostMonster > monsterArmee.length ) {return;}
        int halberAngriff = (int)Math.ceil(monsterArmee[opferMonster].getAngriff() / 2.0);
        int halbeVerteidigung = (int)Math.ceil(monsterArmee[opferMonster].getVerteidigung() / 2.0);
        monsterArmee[boostMonster].setAngriff(monsterArmee[boostMonster].getAngriff()+halberAngriff);
        monsterArmee[boostMonster].setVerteidigung(monsterArmee[boostMonster].getVerteidigung()+halbeVerteidigung);
        this.legeMonsterAb(opferMonster);
    }

    /**
     * Methode equals
     *
     * @param andererSpieler übernimmt ein anderes Spieler-Objekt,
     *                       um es mich sich selbst zu vergleichen
     * @return gibt zurück, ob das übergebene Spieler-Objekt gleich ist
     *
     */
    public boolean equals(Spieler andererSpieler) {
        int equalness = 0;
        if ( this.name.equals(andererSpieler.getName() ) ) { equalness++;}
        if ( this.leben == andererSpieler.getLebenspunkte() ) { equalness++;}
        if ( this.getMaxArmeeGroesse() == andererSpieler.getMaxArmeeGroesse()) {
            for (int i = 0; i < monsterArmee.length; i++) {
                if (this.getMonster(i) != null && andererSpieler.getMonster(i) != null && this.getMonster(i).equals(andererSpieler.getMonster(i))) {
                    equalness++;
                }
                if (this.getMonster(i) == null && andererSpieler.getMonster(i) == null) {
                    equalness++;
                }
            }
        }
        return equalness == 5;
    }

    /**
     * Methode clone
     *
     * @return gibt ein duplikat des Spielers zurück als komplett neues Objekt
     */
    @SuppressWarnings("CloneDoesntCallSuperClone")
    public Spieler clone() {
        Spieler newSpieler = new Spieler(this.getName(), this.getLebenspunkte(), this.getMaxArmeeGroesse());
        for (int i=0; i< this.monsterArmee.length;i++) {
            if (this.getMonster(i) != null) {
                newSpieler.rufeMonster(this.getMonster(i).clone());
            }
        }
        return newSpieler;
    }
}