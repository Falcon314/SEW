public class EinAusgabe {
    public static void main(String[] args) {
        Musikalbum musikAlbum = new Musikalbum("Mein Album", "Jason Hahn", (byte) 3);
        musikAlbum.addMusikstueck("Nie mehr", "CRO", 183);
        musikAlbum.addMusikstueck("Hdgdl (feat. Joon Kim)", "Julien Bam", 124);
        musikAlbum.addMusikstueck("LiEBE AUF DER RÜCKBANK", "FiNCH und Tream", 189);


        System.out.println("Der Name des Albums: " + musikAlbum.getAlbumName());
        System.out.println("Der Interpret des Albums: " + musikAlbum.getAlbumInterpret());
        System.out.println("\nLänge des Albums: " + musikAlbum.zeigeDauer());
        System.out.println("Titel im Album: ");
        System.out.println("\n---------------------");
        System.out.println(musikAlbum.listMusikstuecke());

        musikAlbum.removeMusikstueck(1);
        System.out.println("Der Name des Albums: " + musikAlbum.getAlbumName());
        System.out.println("Der Interpret des Albums: " + musikAlbum.getAlbumInterpret());
        System.out.println("\nLänge des Albums: " + musikAlbum.zeigeDauer());
        System.out.println("Titel im Album: ");
        System.out.println("\n---------------------");
        System.out.println(musikAlbum.listMusikstuecke());
    }
}
