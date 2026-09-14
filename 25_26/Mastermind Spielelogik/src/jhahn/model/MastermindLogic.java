package jhahn.model;


import java.util.Arrays;
import java.util.Random;

public class MastermindLogic {
    private int round;
    private int[] losung;

    public MastermindLogic() {
        round = 0;
        losung = new int[5];
    }

    public void newGame() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            losung[i] = random.nextInt(10);
        }
        round = 1;

    }

    public int getRoundCount() {
        return round;
    }

    public MastermindState calculateState(int[] numbers) throws NoGameException {
        boolean won = false;
        if (round == 0) throw new NoGameException("Kein Spiel gestartet");
        int correctnumber = 0, correctplace = 0;
        // Array um zu verfolgen, welche Positionen in der Eingabe bereits verarbeitet wurden
        boolean[]  greenNumbers = new boolean[numbers.length];

        // ERSTE SCHLEIFE: Überprüfe, welche Zahlen an der richtigen Position sind (correctplace/GRÜN)
        for (int i = 0; i < numbers.length; i++) {
            // Wenn die Zahl an Position i genau der Lösung-Zahl an Position i entspricht
            if (numbers[i] == losung[i]) {
                // Erhöhe correctplace-Zähler
                correctplace++;
                // Markiere diese Position in der Eingabe als bereits verarbeitet
                greenNumbers[i] = true;
            }
        }

        // ZWEITE SCHLEIFE: Überprüfe, welche Zahlen in der Lösung sind, aber an der FALSCHEN Position (correctnumber/GELB)
        for (int i = 0; i < numbers.length; i++) {
            // Wenn diese Position bereits als "grün" (correct place) markiert wurde, springe zur nächsten Position
            if(greenNumbers[i]) continue;
            // Suche die aktuelle Zahl aus numbers[i] IRGENDWO in der gesamten Lösung
            for (int j = 0; j < losung.length; j++) {
                // Wenn die Zahl gefunden wird
                if (numbers[i] == losung[j]) {
                    // Erhöhe correctnumber-Zähler (richtige Zahl, aber falsche Position/GELB)
                    correctnumber++;
                    // Markiere diese Eingabe-Position als verarbeitet, damit diese Zahl nicht nochmal gezählt wird von 2. Lösung
                    greenNumbers[i] = true;
                    // Stoppe die Suche in der Lösung (break), da wir die Zahl bereits gefunden haben
                    break;
                }
            }
        }


        if (correctplace == 5) won = true;
        else round++;

        MastermindState state = new MastermindState(correctnumber, correctplace, won, this.round);
        return state;
    }

    public int[] getSolution() {
        round = 0;
        return losung;
    }
}
