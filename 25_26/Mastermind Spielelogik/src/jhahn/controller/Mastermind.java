package jhahn.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jhahn.view.*;
import jhahn.model.*;

public class Mastermind implements ActionListener {
    private MastermindFrame view;
    private MastermindLogic model;

    public Mastermind() {
        this.view = new MastermindFrame(this);
        this.model = new MastermindLogic();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "neu":
                model.newGame();
                view.startGame();
                break;
            case "check":
                try {
                    int[] numbers;
                    try {
                        numbers = view.getNumbers();
                    } catch (NumberFormatException ex) {
                        view.showError("Keine Zahl eingegeben!");
                        break;
                    }
                    MastermindState state = model.calculateState(numbers);
                    view.setState(state);
                } catch (NoGameException ex) {
                    view.showError(ex.getMessage());
                }
                break;
            case "losung":
                int[] solution = model.getSolution();
                view.showSolution(solution);
                break;
        }
    }
    public static void main(String[] args) {
        new Mastermind();
    }
}