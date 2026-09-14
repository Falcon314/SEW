package jhahn.controller;

import jhahn.model.GameModel;
import jhahn.view.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements    ActionListener {
    private final GameModel model; // Attribut für die Referenz für das GameModel
    private final GameFrame view; // Attribut für die Referenz für das GameView

    public GameController() {
        this.model = new GameModel(); // Setzen von model
        this.view = new GameFrame(this); // Setzen von view

    }

    public void handlePlayerChoice(String choice) {
        model.playRound(choice); // Führt playRound() mit Spielerentscheidung aus
        view.updateResult(model.getResult()); // Updated im View das Label mit dem Resultat-String
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handlePlayerChoice(e.getActionCommand());
    }

    public static void main(String[] args) {
        new GameController();
    }
}

