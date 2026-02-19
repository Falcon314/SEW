/**
 * Ein Programm, das eine Liste an Produkten ausgibt,
 * dazu den Preis und die Menge und dann Gesamtpreis
 * @author Falcon314
 * @version 2024-11-05
 */
public class formatierteAusgaben {
    public static void main(String[] args) {
        // Deklaration und Initialisierung von dem array für den Preisnamen
        String[] pname = {"Apfel", "Banane", "Pkg. Kirsche"};
        // Deklaration und Initialisierung von dem Array für den Preis
        double[] preis = {1.50, 0.74, 2.15};
        // Deklaration und Initialisierung von dem Array für die Menge
        int[] menge = {10, 20, 3};
        // Deklaration und Initialisierung von dem Array für den Gesamtpreis
        double[] gpreis = {preis[0]*menge[0],preis[1]*menge[1],preis[2]*menge[2],};
        // Ausgabe von der Überschrift der Tabelle
        System.out.format(String.format("%-22s %-10s %-7s %s\n","Produktname", "Preis", "Menge", "Gesamtpreis"));
        // Ausgabe von der Trennlinie der Tabelle
        System.out.println("-----------------------------------------------------");
        // Eine for-Schleife für die Ausgabe von den Tabellen-Objekten nach der Reihe im Array, gemessen an der Länge des ersten Arrays (pname)
        for (int i=0; i<pname.length;i++) {
            System.out.format(String.format("%-22s %-10.2f %-7d %-14.2f\n",pname[i], preis[i], menge[i], gpreis[i]));
        }
    }
}