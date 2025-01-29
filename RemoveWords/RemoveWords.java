import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveWords {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        
        System.out.println("Enter strings to add to the list. Enter 'done' to stop.");

        while (true) {
            System.out.print("Enter a string: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            stringList.add(input);
        }

        
        System.out.println("\nStrings in the list:");
        displayList(stringList);

        
        System.out.println("\nEnter strings to eliminate from the list. Enter 'done' to stop.");

        while (true) {
            System.out.print("Enter a string to eliminate: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            
            if (stringList.remove(input)) {
                System.out.println("String removed. Updated list:");
                displayList(stringList);
            } else {
                System.out.println("String not found in the list. Try again.");
            }

            
            if (stringList.isEmpty()) {
                System.out.println("The list is empty. Exiting the program.");
                break;
            }
        }

        scanner.close();
    }

    
    private static void displayList(ArrayList<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
