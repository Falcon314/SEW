/**
 * Ein Skript, dass einen
 * tollen Trick ausführt
 * @author Falcon314
 * @version 2024-10-14
 */
public class tollerTrick {
    public static void main(String[] args) {
        System.out.println("Denke dir eine Zahl aus.");
        int input = Input.readInt("Damit ich dir den Trick zeigen kann, gib:\n");
        int answer2 = input * 2;
        System.out.println("Multipliziere die Zahl mit 2!");
        System.out.println("Das Ergebnis ist nun " + answer2);
        answer2 *=5;
        System.out.println("Multipliziere die Zahl mit 5!");
        System.out.println("Das Ergebnis ist nun " + answer2);
        int answerend = answer2 / input;
        System.out.println("Dividiere das Ergebnis durch deine gemerkte btw. eingegebene Zahl!");
        System.out.println("Das Ergebnis ist nun " + answerend);
        answerend -= 7;
        System.out.println("Subtrahiere als letztes die Zahl 7");
    }
}