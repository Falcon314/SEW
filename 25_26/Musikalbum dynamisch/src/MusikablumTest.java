public class MusikablumTest {
    public static void main(String[] args) {
        Musikalbum album = new Musikalbum("Titel", "ich");
        System.out.println(album.listMusikstuecke());
        System.out.println("==============================");
        album.addMusikstueck("title", "ich", 400);
        System.out.println(album.listMusikstuecke());
        System.out.println("==============================");
        album.addMusikstueck("2.12", "Du", 800);
        System.out.println(album.listMusikstuecke());
        System.out.println("==============================");
        album.removeMusikstueck(1);
        System.out.println(album.listMusikstuecke());
        System.out.println("==============================");
    }
}
