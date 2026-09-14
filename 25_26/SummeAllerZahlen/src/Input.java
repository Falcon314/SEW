import java.util.Scanner;
public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    public static int readInt(String prompt) {
        System.out.print(prompt);
        while(true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Ungültig");
            }
        }
    }
}
