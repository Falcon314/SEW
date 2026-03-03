package jhahn.playerContent;

public class Item {
    private String name;
    private int cost;

    public Item(String name, int cost) {
        this.name = "Default";
        this.cost = 0;
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        if (cost >= 0.0) {
            this.cost = cost;
        }
    }

    @Override
    public String toString() {
        return name + " (" + cost + " Gold)";
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.cost;
    }

    public boolean equals(Item that) {
        if (this == that) return true;
        if (that == null) return false;
        if (!this.name.equals(that.getName())) return false;
        if (this.cost != that.getCost()) return false;
        return true;
    }
}
