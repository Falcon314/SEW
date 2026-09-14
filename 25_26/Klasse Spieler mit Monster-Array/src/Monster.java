import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Monster.
 *
 * @author Falcon314
 * @version 17.12.2025
 */
public class Monster {
    private String name;
    private int angriff;
    private int verteidigung;
    private int schaden;
    private static final Random rand = new Random();

    /**
     * Monster Konstruktor
     * für ein Random Monster; er ruft den anderen
     * Monster-Konstruktor auf mit Zufallswerten
     */
    public Monster() {
        this( ("Zufallsmonster"+( rand.nextInt(100) + 1 )), ( rand.nextInt(5)+1 ), ( rand.nextInt(5)+1 ) );
    }

    /**
     * Monster Konstruktor
     * für ein Monster mit gesetzen Werten, aber wenn
     * ungültig, dann wird ein random Monster erstellt
     *
     * @param name ; Zum Setzen von dem Namen des Monsters
     * @param angriff ; Zum Setzen von dem Angriff des Monsters
     * @param verteidigung ; Zum Setzen von der Verteidigung des Monsters
     */
    public Monster(String name, int angriff, int verteidigung) {
        if(name !=null && name.length() >= 3 && wertGueltig(angriff) && wertGueltig(verteidigung) ) {
            this.name = name;
            this.angriff = angriff;
            this.verteidigung = verteidigung;
        } else {
            this.name = "Zufallsmonster"+( rand.nextInt(100) + 1 );
            this.angriff = rand.nextInt(5)+1;
            this.verteidigung = rand.nextInt(5)+1;
        }
        this.schaden = 0;
    }

    /**
     * Methode setName
     * zum Setzen des Namens vom Monster nach der Erstellung
     *
     * @param name ; String "name" als Namenssetzung für das Monster
     */
    public void setName(String name) {
        if(name !=null && name.length() >= 3) {
            this.name = name;
        }
    }

    /**
     * Methode setAngriff
     * zum Setzen des Angriffes vom Monster nach der Erstellung
     *
     * @param angriff ; int "angriff" als Angriffssetzung für das Monster
     */
    public void setAngriff(int angriff) {
        if (wertGueltig(angriff)) {
            this.angriff = angriff;
        }
    }

    /**
     * Methode setVerteidigung
     * zum Setzen der Verteidigung vom Monster nach der Erstellung
     *
     * @param verteidigung ; int "verteidigung" als Verteidigungssetzung für das Monster
     */
    public void setVerteidigung(int verteidigung) {
        if (wertGueltig(verteidigung)) {
            this.verteidigung = verteidigung;
        }
    }

    /**
     * Methode getName
     *
     * @return gibt den Namen des Monsters zurück
     */
    public String getName() {
        return this.name;
    }

    /**
     * Methode getAngriff
     *
     * @return gibt den Angriffswert des Monsters zurück
     */
    public int getAngriff() {
        return this.angriff;
    }

    /**
     * Methode getVerteidigung
     *
     * @return gibt den Verteidigungswert des Monsters zurück
     */
    public int getVerteidigung() {
        return this.verteidigung;
    }

    /**
     * Methode getSchaden
     *
     * @return gibt den Wert des vom Monster erlittenen Schaden zurück
     */
    public int getSchaden() {
        return this.schaden;
    }

    /**
     * Methode wertGueltig
     *
     * @param zahl übergebene Zahl die nach Gültigkeit überprüft wird (1 ≤ zahl ≤ 20)
     * @return gibt zurück, ob der übergebene Parameter gültig ist
     */
    public static boolean wertGueltig(int zahl) {
        return zahl >= 1 && zahl <= 20;
    }

    /**
     * Methode löscheSchaden
     * <p>
     *     löscht den schaden des Monsters/setzt den schaden auf 0 zurück
     * </p>
     */
    public void loescheSchaden() {
        this.schaden = 0;
    }

    /**
     * Methode schadenHinzufügen
     *
     * @param schaden addiert den übergebenen wert "schaden"
     *                zum Attribut "schaden" hinzu
     *
     */
    public void schadenHinzufuegen(int schaden) {
        this.schaden += schaden;
    }

    /**
     * Methode istBesiegt
     *
     * @return gibt zurück, ob das monster besiegt ist
     *
     */
    public boolean istBesiegt() {
        return this.schaden > this.verteidigung;
    }

    /**
     * Methode schadenSpieler
     *
     * @return gibt den restlichen Schaden, der das
     *         Monster nicht verteidigen konnte zurück
     */
    public int schadenSpieler() {
        if (this.istBesiegt()) {
            return (this.verteidigung - this.schaden) * -1;
        } else {
            return 0;
        }
    }

    /**
     * Methode monsterDaten
     *
     * @return gibt ein String an Daten, betreffend das Monster selbst, zurück
     */
    public String monsterDaten() {
        String schadenUebertrag;
        if (this.istBesiegt()) {
            schadenUebertrag = " † (" + this.schadenSpieler() +")";
        } else {
            schadenUebertrag = "";
        }
        return this.name + " (" + this.angriff + "/" + this.verteidigung + ") - " + this.schaden + " D" +schadenUebertrag;
    }

    /**
     * Methode verteidigtGegen
     *
     * @param anderesMonster übernimmt ein anderes Monster-Objekt,
     *                       um dagegen zu kämpfen
     *
     */
    public void verteidigtGegen(Monster anderesMonster) {
        this.schadenHinzufuegen(anderesMonster.getAngriff());
        anderesMonster.schadenHinzufuegen(this.getAngriff());
    }

    /**
     * Methode equals
     *
     * @param anderesMonster übernimmt ein anderes Monster-Objekt,
     *                       um es mich sich selbst zu vergleichen
     * @return gibt zurück, ob das übergebene Monster-Objekt gleich ist
     *
     */
    public boolean equals(Monster anderesMonster) {
        if (anderesMonster != null) {
            return (this.name.equals(anderesMonster.getName())) && (this.getAngriff() == anderesMonster.getAngriff()) && (this.getVerteidigung() == anderesMonster.getVerteidigung()) && (this.getSchaden() == anderesMonster.getSchaden());
        } else {
            return false;
        }
    }

    /**
     * Methode clone
     *
     * @return gibt ein duplikat des Monsters zurück als komplett neues Objekt
     */
    @SuppressWarnings("CloneDoesntCallSuperClone")
    public Monster clone() {
        Monster clonedMonster = new Monster(this.name, this.angriff, this.verteidigung);
        clonedMonster.schadenHinzufuegen(this.schaden);
        return clonedMonster;
    }
}