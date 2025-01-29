import java.util.Scanner;

public class IndirectRecursionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int userInput = scanner.nextInt();

        
        firstMethod(userInput);

        scanner.close();
    }

    private static void firstMethod(int number) {
        if (number > 0) {
            System.out.println("First Method: " + number);
            
            secondMethod(number - 1);
        }
    }

    private static void secondMethod(int number) {
        if (number > 0) {
            System.out.println("Second Method: " + number);

            
            firstMethod(number - 1);
        }
    }
}
