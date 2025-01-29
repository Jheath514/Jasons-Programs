import java.io.*;

public class BankApplication {
    public static void main(String[] args) {
       
        createBankFile();

        readBankAccountsSequentially();

        
        readBankAccountsRandomly();
    }

    private static void createBankFile() {
        try {
            RandomAccessFile bankFile = new RandomAccessFile("BankData.dat", "rw");

            
            for (int i = 0; i < 10000; i++) {
                bankFile.writeInt(0); 
                bankFile.writeUTF("        "); 
                bankFile.writeDouble(0.0); 
            }

            System.out.println("Blank records created successfully.");

            bankFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readBankAccountsSequentially() {
        try {
            RandomAccessFile bankFile = new RandomAccessFile("BankData.dat", "r");

            System.out.println("\nReading and displaying accounts sequentially:");

            while (bankFile.getFilePointer() < bankFile.length()) {
                int accountNumber = bankFile.readInt();
                String lastName = bankFile.readUTF();
                double balance = bankFile.readDouble();

                System.out.printf("Account Number: %d, Last Name: %s, Balance: %.2f%n",
                        accountNumber, lastName.trim(), balance);
            }

            bankFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readBankAccountsRandomly() {
        try {
            RandomAccessFile bankFile = new RandomAccessFile("BankData.dat", "r");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\nReading and displaying accounts randomly:");

            int userInput;

            do {
                System.out.print("Enter an account number (9999 to exit): ");
                userInput = Integer.parseInt(reader.readLine());

                if (userInput == 9999) {
                    break; 
                }

                long seekPosition = (long) (userInput - 1) * 18;
                bankFile.seek(seekPosition);

                int accountNumber = bankFile.readInt();
                String lastName = bankFile.readUTF();
                double balance = bankFile.readDouble();

                System.out.printf("Account Number: %d, Last Name: %s, Balance: %.2f%n",
                        accountNumber, lastName.trim(), balance);

            } while (true);

            bankFile.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
