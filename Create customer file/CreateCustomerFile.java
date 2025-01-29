import java.io.*;
import java.util.Scanner;

public class CreateCustomerFile {
    public static void main(String[] args) {
        createEmptyCustomerFile();
        populateCustomerFile();
    }

    private static void createEmptyCustomerFile() {
        try (RandomAccessFile customerFile = new RandomAccessFile("CustomerData.dat", "rw")) {
             
            for (int i = 0; i < 1000; i++) {
                customerFile.writeInt(0); 
                customerFile.writeUTF("      "); 
                customerFile.writeInt(0);
            }
            System.out.println("Empty customer file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void populateCustomerFile() {
        try (RandomAccessFile customerFile = new RandomAccessFile("CustomerData.dat", "rw");
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter customer ID (3 digits): ");
                int id = Integer.parseInt(scanner.nextLine());

                if (id < 100 || id > 999) {
                    System.out.println("Invalid ID. Please enter a 3-digit ID.");
                    continue;
                }

                long seekPosition = (long) (id - 1) * 14;
                customerFile.seek(seekPosition);

                if (customerFile.readInt() != 0) {
                    System.out.println("Error: ID already exists. Please enter a different ID.");
                    continue;
                }

                System.out.print("Enter customer last name (6 characters): ");
                String lastName = scanner.nextLine();
                lastName = String.format("%-6s", lastName); 

                System.out.print("Enter customer zip code (5 digits): ");
                int zipCode = Integer.parseInt(scanner.nextLine());

                if (zipCode < 10000 || zipCode > 99999) {
                    System.out.println("Invalid zip code. Please enter a 5-digit zip code.");
                    continue;
                }

                
                customerFile.writeInt(id);
                customerFile.writeUTF(lastName);
                customerFile.writeInt(zipCode);

                System.out.println("Record added successfully.");

                System.out.print("Do you want to add another record? (yes/no): ");
                String choice = scanner.nextLine().toLowerCase();

                if (!choice.equals("yes")) {
                    break;
                }
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
