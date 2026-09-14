public class SpielerTest {
    public static void main(String[] args) {
        Spieler sp11, sp12, sp21, sp22, sp31, sp32, sp41, sp42;
        int armeeGroesse = 3;

        System.out.println("SpielerTest: Testet die Methoden clone() und equals(), vor allem ob es eine tiefe clone ist");

        /*
         * Überprüfung 1
         */
        System.out.println("Durchgang 1: Clone and Equals(True)");
        sp11 = new Spieler("Jason", 50, armeeGroesse);
        for (int i=0;i<armeeGroesse;i++) {
            sp11.rufeMonster(new Monster());
        }

        System.out.println("Spieler 1, Name: Jason, Leben: 50, 3 Zufallsmonster: ");
        System.out.println(sp11.status() + "\n");
        System.out.println("Kopie von Spieler 1: ");
        sp12 = sp11.clone();
        System.out.println(sp12.status() + "\n");
        System.out.println("Überprüfung von equals, Spieler1 und Spieler2 werden verglichen (nachdem geklont, sollte ident sein)");
        System.out.println(sp11.equals(sp12));
        System.out.println("---------------------------------------");

        /*
         * Überprüfung 2
         */
        System.out.println("\nDurchgang 2: 2 gleiche Spieler aber unterschiedliche Monster und equals(false)");
        sp21 = new Spieler("Jason", 50, armeeGroesse);
        for (int i=0;i<armeeGroesse;i++) {
            sp21.rufeMonster(new Monster());
        }
        sp22 = new Spieler("Jason", 50, armeeGroesse);
        for (int i=0;i<armeeGroesse;i++) {
            sp22.rufeMonster(new Monster());
        }
        System.out.println("Spieler 1, Name: Jason, Leben: 50, 3 Zufallsmonster: ");
        System.out.println(sp21.status() + "\n");
        System.out.println("Spieler 2, Name: Jason, Leben: 50, 3 ZufallsMonster: ");

        System.out.println(sp22.status() + "\n");
        System.out.println("Überprüfung von equals, Spieler1 und Spieler2 werden verglichen (nachdem 6 Zufallsmonser, sollte unterschiedlich sein)");
        System.out.println(sp21.equals(sp22));
        System.out.println("---------------------------------------");


        /*
         * Überprüfung 3
         */
        System.out.println("\nDurchgang 3: 2 gleiche Spieler, unterschiedliche Monsteranzahl und equals(false)");
        sp31 = new Spieler("Jason", 50, 3);
        for (int i=0;i<3;i++) {
            sp31.rufeMonster(new Monster());
        }
        sp32 = new Spieler("Jason", 50, 4);
        for (int i=0;i<4;i++) {
            sp32.rufeMonster(new Monster());
        }
        System.out.println("Spieler 1, Name: Jason, Leben: 50, 3 Zufallsmonster: ");
        System.out.println(sp31.status() + "\n");

        System.out.println("Spieler 2, Name: Jason, Leben: 50, 4 ZufallsMonster: ");
        System.out.println(sp32.status() + "\n");

        System.out.println("Überprüfung von equals, Spieler1 und Spieler2 werden verglichen (nachdem 6 Zufallsmonser, sollte unterschiedlich sein)");
        System.out.println(sp31.equals(sp32));
        System.out.println("---------------------------------------");


        /*
         * Überprüfung 4
         */
        System.out.println("\nDurchgang 4: 2 idente, unabhängig erstellte Spieler und equals(true)");
        sp41 = new Spieler("Jason", 50, armeeGroesse);
        for (int i=0;i<armeeGroesse;i++) {
            sp41.rufeMonster(new Monster("Monster", 2, 2));
        }
        sp42 = new Spieler("Jason", 50, armeeGroesse);
        for (int i=0;i<armeeGroesse;i++) {
            sp42.rufeMonster(new Monster("Monster", 2, 2));
        }
        System.out.println("Spieler 1, Name: Jason, Leben: 50, 3 Zufallsmonster: ");
        System.out.println(sp41.status() + "\n");

        System.out.println("Spieler 2, Name: Jason, Leben: 50, 4 ZufallsMonster: ");
        System.out.println(sp42.status() + "\n");

        System.out.println("Überprüfung von equals, Spieler1 und Spieler2 werden verglichen (nachdem 6 Zufallsmonser, sollte unterschiedlich sein)");
        System.out.println(sp41.equals(sp42));
        System.out.println("---------------------------------------");
    }
}
