package jhahn.accounts;

/**
 * Hiermit werden alle Objekte gekennzeichnet, die eine Textuelle ID von mindestens 15
 * Stellen zurückgeben können.
 * @author Lisa Vittori
 * @version 20.03.2018
 */
public interface Identifizierbar {
	/**
	 * Gibt den Identifier für diesen Account zurück,
	 * mit führenden Nullen auf 10 Stellen aufgefüllt.
	 * @return der Identifier-String
	 */
	public String identifier();
}
