package jhahn.view;

import jhahn.model.MastermindState;

public interface MastermindGUI {
    /**
     * bereitet die GUI auf ein neues Spiel vor.
     * alle Textfelder werden geleert und aktiviert.
     * "Neu"-Button wird deaktiviert, "Check"-Button und "Lösung"-Button werden aktiviert.
     * In der Statuszeile wird "Los geht's!" angezeigt.
     * OPTIONAL: für die FormenPanels wird eine zufällige Form und Farbe gesetzt.
     */
    void startGame();

    /**
     * stellt die vom Parameter 'state' erhaltenen Werte dar.
     * Für jede erratene Zahl an der richtigen Position soll eine form in der oberen Zeile angezeigt werden,
     * für jede erratene Zahl an falscher Position wird eine Form in der unteren Zeile angezeigt.
     * Wurde das Spiel gewonnen, soll in der Statuszeile "Hurra! Gewonnen!" angezeigt werden, die Textfelder, "Check"- und "Lösung"-Button deaktiviert werden und der "Neu"-Button aktiviert werden.
     * @param state enthält die Werte die angezeigt werden sollen.
     */
    void setState(MastermindState state);

    /**
     * zeigt die Nummern-Kombination aus dem Parameter in den Textfeldern an.
     * Die Textfelder, "Check"- und "Lösung"-Button werden deaktiviert, der "Neu"-Button aktiviert.
     * In der Statusleiste wird "Cheater, verloren" angezeigt.
     * @param numbers Nummern-Kombination die in den Textfeldern angezeigt werden sollen
     */
    void showSolution(int[] numbers);

    /**
     * liefert die in den Textfeldern eingegebenen Zahlen als Array zurück.
     * @return das Zahlen Array von den Textfeldern.
     */
    int[] getNumbers();

    /**
     * zeigt die übergebene Nachricht in der Statusleiste an.
     * OPTIONAL: Error=ROT; normal=Schwarz
     * @param message Nachricht die angezeigt werden soll
     */
    void showError(String message);
}
