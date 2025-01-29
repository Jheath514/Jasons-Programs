import java.time.LocalDate;
import java.util.Scanner;

public class InventionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Invention Description:");
        String description = scanner.nextLine();

        System.out.println("Enter Inventor's Name:");
        String inventorName = scanner.nextLine();

        System.out.println("Enter Inventor's Country of Origin:");
        String inventorCountry = scanner.nextLine();

        System.out.println("Enter Invention Date (YYYY-MM-DD):");
        String inventionDateString = scanner.nextLine();
        LocalDate inventionDate = LocalDate.parse(inventionDateString);

        Inventor inventor = new Inventor(inventorName, inventorCountry);
        Invention invention = new Invention(description, inventor, inventionDate);

        System.out.println("\nInvention Details:\n" + invention);
    }
}
