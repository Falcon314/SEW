package jhahn;
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
        if (cost >= 0) {
            this.cost = cost;
        }
    }


    public String itemData() {
        return name + " (" + cost + " Gold)";
    }

}
