import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DisplaySortedLists {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Integer> integerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter words to add to the String list. Enter 'done' to stop.");

        while (true) {
            System.out.print("Enter a word: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            stringList.add(input);
            Collections.sort(stringList);
            displayList(stringList);
        }

        
        System.out.println("\nEnter integers to add to the Integer list. Enter '0' to stop.");

        while (true) {
            System.out.print("Enter an integer: ");
            int input;

            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                continue;
            }

            if (input == 0) {
                break;
            }

            integerList.add(input);
            Collections.sort(integerList);
            displayList(integerList);
        }

        scanner.close();
    }

    
    private static <T> void displayList(ArrayList<T> list) {
        System.out.print("Sorted List: ");
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
