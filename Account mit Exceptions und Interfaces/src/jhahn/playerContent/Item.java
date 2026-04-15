package jhahn.playerContent;

import java.util.Objects;

public class Item {
    private String name;
    private int cost;

    /**
     * Konstruiert ein Item mit dem angegebenen Namen und Kosten.
     * @param name der Name des Items
     * @param cost die Kosten des Items
     */
    public Item(String name, int cost) {
        this.name = "Default";
        this.cost = 0;
        setName(name);
        setCost(cost);
    }

    /**
     * Gibt den Namen des Items zurück.
     * @return der Name
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Items, wenn er nicht null ist. Wirft eine IllegalArgumentException, wenn der Name null ist.
     * @param name der zu setzende Name
     * @throws IllegalArgumentException wenn der Name null ist
     */
    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        this.name = name;
    }

    /**
     * Gibt die Kosten des Items zurück.
     * @return die Kosten
     */
    public int getCost() {
        return cost;
    }

    /**
     * Setzt die Kosten des Items, wenn sie nicht-negativ sind. Wirft eine IllegalArgumentException, wenn die Kosten negativ sind.
     * @param cost die zu setzenden Kosten
     * @throws IllegalArgumentException wenn die Kosten negativ sind
     */
    public void setCost(int cost) {
        if (cost < 0) throw new IllegalArgumentException("Cost must be non-negative");
        this.cost = cost;
    }

    /**
     * Gibt eine String-Darstellung des Items zurück.
     * @return die String-Darstellung
     */
    @Override
    public String toString() {
        return name + " (" + cost + " Gold)";
    }

    /**
     * Gibt den Hash-Code für dieses Item zurück.
     * @return der Hash-Code
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + cost;
        return result;
    }

    /**
     * Vergleicht dieses Item mit einem anderen auf Gleichheit.
     * @param obj das andere Objekt zum Vergleich
     * @return true, wenn gleich, sonst false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return cost == item.cost && Objects.equals(name, item.name);
    }
}
