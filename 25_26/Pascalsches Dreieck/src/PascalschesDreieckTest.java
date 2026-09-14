public class PascalschesDreieckTest {
    public static void main(String[] args) {
        long[][] drei = PascalschesDreieck.pascalschesDreieck(11);
        String text = PascalschesDreieck.arrayToStep(drei);
        System.out.println(text);
        String text2 = PascalschesDreieck.arrayToTriangle(drei);
        System.out.println(text2);
    }
}
