/*
 * Dieses Skript nimmt eine Eingabe von dem Benutzer und rechnet die
 * Summe aller Zahlen zwischen 0 und inkl. der eingegebenen Zahl und
 * gibt die ausgerechnete Summe aus, wenn allerdings '0' eingegeben
 * wird ausgegeben wie viele Summen insgesamt, in der Laufzeit,
 * getätigten Summen-Rechnungen gemacht wurden und beendet das Programm
 * dann.
 * @author Falcon314
 * @version 2024-11-27
 */
public class SummeAllerZahlen {
    public static void main(String[] args) {
        // Der Benutzer wir aufgefordert, eine Zahl einzugeben, die als Endpunkt der Summe gilt.
        int eingabe = Input.readInt("Gib eine Zahl ein, die als Endpunkt der Summe gilt: ");
        // Die eingegebene Zahl wird für spätere Ausgaben gespeichert.
        int eingegebeneZahl = eingabe;
        // Zähler für die Anzahl der durchgeführten Berechnungen.
        int durchlaeufe = 0;
        // Solange der Benutzer keine '0' eingibt, wird das Programm weiterlaufen.
        while (eingegebeneZahl != 0) {
            // Erhöhe die Anzahl der durchgeführten Summenberechnungen.
            durchlaeufe++;
            // Variable dür die Berechnung der Summe.
            int sum = 0;
            // Falls die Eingabe eine positive Zahl ist,
            // berechne die Summe aller Zahlen bis zur Eingabe
            if (eingabe >= 0) {
                // Solange die Eingabe größer als 0 ist, summiere die Zahlen.
                while (eingabe > 0) {
                    sum += eingabe; // Addiere die aktuelle Zahl zur Summe.
                    eingabe--; // Reduziere die Zahl um 1.
                }
            }
            // Falls die Eingabe eine negative Zahl ist,
            // berechne die Summe aller Zahlen bis zur Eingabe.
            else {
                while (eingabe < 0) {
                    sum += eingabe; // Addiere die aktuelle Zahl zur Summe.
                    eingabe++; // Erhöhe die Zahl um 1.
                }
            }
            // Ausgabe der berechneten Summe.
            System.out.println("Die Summer aller Zahlen von 0 bis "+eingegebeneZahl+" ist "+sum);
            // Der Benutzer wird wieder aufgefordert, eine weitere Zahl einzugeben.
            eingabe = Input.readInt("Gib eine weitere Zahl ein, die als Endpunkt der Summe gilt: ");
            // Die neue Eingabe wird für spätere Ausgaben gespeichert.
            eingegebeneZahl = eingabe;
        }
        // Wenn der Benutzer '0' eingibt, wird die Gesamtzahl der durchgeführten Berechnungen ausgegeben
        System.out.println("Es wurden von "+durchlaeufe+" Werten die Summen berechnet.");
    }
}
