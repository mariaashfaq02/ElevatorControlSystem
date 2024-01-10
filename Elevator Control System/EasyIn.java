import java.util.InputMismatchException;
import java.util.Scanner;

public class EasyIn {
    private static Scanner scanner = new Scanner(System.in);

    public static char getChar() {
        String input = getString();
        if (input.length() > 0) {
            return input.charAt(0);
        } else {
            return '\0'; // Return null character for an empty input
        }
    }

    public static int getInt() {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                return value;
            } catch (InputMismatchException e) {
                // Consume the invalid input
                scanner.next();
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static void pause(String message) {
        System.out.print(message);
        getString(); // Wait for user to press Enter
    }
}
