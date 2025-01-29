import java.util.Scanner;

public class SqrtException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer to find its square root: ");
        String input = scanner.nextLine();

        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: Input is not a valid integer. Setting number to 0.");
        }

        try {
            if (number < 0) {
                throw new ArithmeticException("Cannot take the square root of a negative number.");
            } else {
                double squareRoot = Math.sqrt(number);
                System.out.println("Square root of " + number + " is: " + squareRoot);
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
