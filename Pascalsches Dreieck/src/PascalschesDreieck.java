public class PascalschesDreieck {
    public static long[][] pascalschesDreieck(int hoehe) {
        long[][] drei = new long[hoehe][];
        drei[0] = new long[1];
        for (int i = 1; i < hoehe; i++) {
            drei[i] = new long[drei[i - 1].length + 1];
        }
        drei[0][0] = drei[1][0] = drei[1][1] = 1;
        for (int i = 2; i < hoehe; i++) {
            drei[i][0] = drei[i][drei[i].length - 1] = 1;
        }

        for (int i = 2; i < hoehe; i++) {
            for (int j = 1; j < drei[i].length - 1; j++) {
                drei[i][j] = drei[i - 1][j - 1] + drei[i - 1][j];
            }

        }
        return drei;

    }
    public static String arrayToStep(long[][] pasDrei) {
        StringBuilder stext = new StringBuilder();
        for (int i = 0; i < pasDrei.length; i++) {
            for (int j = 0; j < pasDrei[i].length; j++) {
                stext.append(pasDrei[i][j]).append(" ");
            }
            stext.append("\n");
        }
        return stext.toString();
    }
    public static String arrayToTriangle(long[][] pasDrei) {
        StringBuilder stext = new StringBuilder();
        int row = pasDrei.length;

        for (int i = 0; i < row; i++) {
            int space  = (row - i - 1) * 12 / 2;
            stext.append(" ".repeat(space));
            for (int j = 0; j < pasDrei[i].length; j++) {
                stext.append( String.format("%12d", pasDrei[i][j]) );
            }
            stext.append("\n");
        }
        return stext.toString();
    }
}
