package jhahn.model;

public record MastermindState(int correctnumber, int correctplace, boolean won, int round) {

    public int getCorrectnumber() {
        return correctnumber;
    }
    public int getCorrectplace() {
        return correctplace;
    }
    public boolean isWon() {
        return won;
    }
    public int getRound() {
        return round;
    }
}
