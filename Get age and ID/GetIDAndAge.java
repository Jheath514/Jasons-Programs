import java.util.InputMismatchException;
import java.util.Scanner;

public class GetIDAndAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.print("Enter an integer ID number (0-999): ");
                int id = scanner.nextInt();
                
                System.out.print("Enter an integer age (0-119): ");
                int age = scanner.nextInt();
                
                if (id == 0 && age == 0) {
                    System.out.println("Terminating program.");
                    break;
                }
                
                if (id < 0 || id > 999 || age < 0 || age > 119) {
                    throw new DataEntryException();
                } else {
                    System.out.println("ID: " + id + ", Age: " + age);
                }
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException: Please enter valid integers.");
                scanner.next(); // Clear the input buffer
            } catch (DataEntryException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
