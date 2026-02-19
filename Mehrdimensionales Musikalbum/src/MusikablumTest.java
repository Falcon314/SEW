public class MusikablumTest {
    public static void main(String[] args) {
        // Erstellung des Musikalbums
        System.out.println("Erstellung des Musikalbums");
        Musikalbum album = new Musikalbum("Titel", "ich", 2);

        // Hinzufügen von 2 Musikstücken auf den ersten Tonträger
        System.out.println("Hinzufügen von 2 Musikstücken auf den ersten Tonträger");
        album.addMusikstueck("titel1", "interpret1",300 ,1);
        album.addMusikstueck("titel2", "interpret1",600 ,1);

        // Hinzufügen von 2 Musikstücken auf den zweiten Tonträger
        System.out.println("Hinzufügen von 2 Musikstücken auf den zweiten Tonträger");
        album.addMusikstueck("titel3", "interpret2",300 ,2);
        album.addMusikstueck("titel4", "interpret2",600 ,2);

        // Hinzufühen von einem 3. Tonträger
        System.out.println("Hinzufügen von einem 3. Tonträger");
        album.addTontraeger();

        // Hinzufügen von 2 Musikstücken auf den dritten Tonträger
        System.out.println("Hinzufügen von 2 Musikstücken auf den dritten Tonträger");
        album.addMusikstueck("titel5", "interpret3",300 ,3);
        album.addMusikstueck("titel6", "interpret3",600 ,3);

        // Hinzufügen von einem 4. Tonträger auf 2. Position
        System.out.println("Hinzufügen von einem 4. Tonträger auf 2. Position");
        album.addTontraeger(2);

        // Ausgabe der Musikstücke einzeln 1-4
        System.out.println("Ausgabe der Musikstücke einzeln 1-4");
        System.out.println(album.listMusikstuecke(1));
        System.out.println(album.listMusikstuecke(2));
        System.out.println(album.listMusikstuecke(3));
        System.out.println(album.listMusikstuecke(4));


        // Ausgabe aller Musikstücke
        System.out.println("Ausgabe aller Musikstücke");
        System.out.println(album.listMusikstuecke(0));

        // Löschung des Tonträgers auf 3 Position
        System.out.println("Löschung des Tonträgers auf 3 Position");
        album.removeTontraeger(3);

        // Ausgabe aller Musikstücke
        System.out.println("Ausgabe aller Musikstücke");
        System.out.println(album.listMusikstuecke(0));

        // Löschung des 1. Musikstückes auf dem 1 Tonträger
        System.out.println("Löschung des 1. Musikstückes auf dem 1 Tonträger");
        album.removeMusikstueck(1,1);

        // Ausgabe aller Musikstücke
        System.out.println("Ausgabe aller Musikstücke");
        System.out.println(album.listMusikstuecke(0));
    }
}
