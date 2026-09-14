package jhahn.model;

import java.util.Random;

public class GameModel {
    private String playerChoice; // Attribut für die Spieler-Auswahl
    private String computerChoice; // Attribut für die Computer-Auswahl
    private String result; // Attribut für das Resultat

    public void playRound(String playerChoice) {
        this.playerChoice = playerChoice; // Setzung von Spielerentscheidung
        this.computerChoice = generateComputerChoice(); // Generation von Computerentscheidung
        this.result = determineWinner(); // Setze Resultat-String, anhand von Spiel ausgang
    }

    private String generateComputerChoice() {
        String[] options = {"Schere", "Stein", "Papier"};
        Random rand = new Random();
        return options[rand.nextInt(3)];
    }

    private String determineWinner() {
        if (playerChoice.equals(computerChoice)) { // Wenn gleich → Unentschieden
            return "Unentschieden! Du: " + playerChoice + ", Computer: " + computerChoice;
        } else if ((playerChoice.equals("Schere") && computerChoice.equals("Papier")) ||
                   (playerChoice.equals("Stein") && computerChoice.equals("Schere")) ||
                   (playerChoice.equals("Papier") && computerChoice.equals("Stein"))) {
                    // Falls spieler mit Schere/Stein/Papier gewinnt → Spieler gewinnt
            return "Du gewinnst! Du: " + playerChoice + ", Computer: " + computerChoice;
        } else { // Anderenfalls gewinnt Computer
            return "Computer gewinnt! Du: " + playerChoice + ", Computer: " + computerChoice;
        }
    }

    public String getResult() {
        return result;
    } // gibt Resultat-String zurück
}
