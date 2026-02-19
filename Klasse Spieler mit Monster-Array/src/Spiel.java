import java.util.Random;

public class Spiel {
    public static void main(String[] args) {
        Spieler sp1, sp2;
        int armeeGroesse = 5;
        int beginGroesse = 3;
        int runde = 1;
        int angreifer = 1;
        int verteidiger = 2;
        Random rand = new Random();

        sp1 = new Spieler("Nicolas", 50, armeeGroesse);
        sp2 = new Spieler("Jason", 50, armeeGroesse);
        for (int i=0; i<beginGroesse;i++) {
            sp1.rufeMonster(new Monster());
            sp2.rufeMonster(new Monster());
        }
        do {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("In der " +runde+ ". Runde ist Spieler "+angreifer+" Angreifer und Spieler "+verteidiger+" Verteidiger.");
            System.out.println("Spieler 1:\n"+sp1.status());
            System.out.println("Spieler 2:\n"+sp2.status());
            System.out.println();
            if (runde%2 == 1) {
                sp2.verteidigtGegen(sp1);
            } else {
                sp1.verteidigtGegen(sp2);
            }

            System.out.println("Status nach der "+runde+". Runde:\n");
            System.out.println("Spieler 1:\n"+sp1.status());
            System.out.println("Speiler 2:\n"+sp2.status());
            System.out.println();

            while (!( sp1.rufeMonster( new Monster() ) )) {
                int randMonster = rand.nextInt(sp1.getMaxArmeeGroesse()-1)+1;
                sp1.opfern(0, randMonster);
            }
            while (!( sp2.rufeMonster( new Monster() ) )) {
                int randMonster = rand.nextInt(sp1.getMaxArmeeGroesse()-1)+1;
                sp2.opfern(0, randMonster);
            }
            runde++;
            int tempInt = angreifer;
            angreifer = verteidiger;
            verteidiger = tempInt;
        }while (!sp1.istBesiegt() && !sp2.istBesiegt() && runde <= 20);

        System.out.println("---------------------------------------------------------------------------------------");
        if (!sp1.istBesiegt() && sp2.istBesiegt()) { System.out.println("Spieler 1 Gewinnt");} // wenn sp1 nicht besiegt(lebt) und sp2 besiegt, gewinnt sp1
        if (sp1.istBesiegt() && !sp2.istBesiegt()) { System.out.println("Spieler 2 Gewinnt");} // wenn sp1 besiegt und sp2 nicht besiegt(lebt), gewinnt sp2
        if (sp1.istBesiegt() && sp2.istBesiegt()) { System.out.println("Unentschieden");} // wenn sp1 besiegt und sp2 besiegt, unentschieden
        if (!sp1.istBesiegt() && !sp2.istBesiegt() && runde > 20) {
            if ( sp1.getLebenspunkte() > sp2.getLebenspunkte() ) { System.out.println("Spieler 1 Gewinnt");} // wenn sp1 mehr Leben als sp2, gewinnt sp1
            if ( sp1.getLebenspunkte() < sp2.getLebenspunkte() ) { System.out.println("Spieler 2 Gewinnt");} // wenn sp2 mehr Leben als sp1, gewinnt sp2
            if ( sp1.getLebenspunkte() == sp2.getLebenspunkte() ) { System.out.println("Unentschieden");} // wenn sp1 gleich viel leben wie sp2, unentschieden
        }
    }
}
