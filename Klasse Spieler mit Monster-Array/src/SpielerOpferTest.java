public class SpielerOpferTest {
    public static void main(String[] args) {
        Spieler sp1 = new Spieler("Jason", 20, 3);
        sp1.rufeMonster(new Monster());
        sp1.rufeMonster(new Monster());
        sp1.rufeMonster(new Monster());
        System.out.println(sp1.status());
        sp1.opfern(0,1);

        System.out.println(sp1.status());
    }
}
