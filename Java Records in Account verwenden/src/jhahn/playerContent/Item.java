package jhahn.playerContent;

import java.util.Objects;

public record Item(String name, double cost) {
    /**
     * Konstruiert ein Item mit dem angegebenen Namen und Standardkosten von 0.0.
     * @param name der Name des Items
     * @throws IllegalArgumentException wenn der Name null ist
     */
    public Item(String name) {
        this(name, 0.0);
    }
    /**
     * Konstruiert ein Item mit dem angegebenen Namen und Kosten.
     * @param name der Name des Items
     * @param cost die Kosten des Items
     * @throws IllegalArgumentException wenn die Kosten negativ sind oder der Name null ist
     */
    public Item{
        if (cost < 0) throw new IllegalArgumentException("Cost must be non-negative");
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
    }

    /**
     * Gibt den Namen des Items zurück.
     * @return der Name
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt die Kosten des Items zurück.
     * @return die Kosten
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gibt die Kosten des Items als gerundeten Integer zurück.
     * @return die Kosten als Integer
     */
    public int betragInteger() {
        return (int) Math.round(cost);
    }

    /**
     * Gibt eine String-Darstellung im gewünschten Format zurück.
     * @return die String-Darstellung
     */
    @Override
    public String toString() {
        return "[name=" + name + ", cost=" + cost + "]";
    }

    /**
     * Gibt den Hash-Code für dieses Item zurück.
     * @return der Hash-Code
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + (int )cost;
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
