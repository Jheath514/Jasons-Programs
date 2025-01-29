import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class ReadBankAccountsRandomly {
    public static void main(String[] args) {
        final String FILE_NAME = "bankData.dat";
        final int TERMINATING_VALUE = 9999;

        try {
            RandomAccessFile file = new RandomAccessFile(FILE_NAME, "r");
            Scanner scanner = new Scanner(System.in);

            int accountNumber;
            do {
               
                System.out.print("Enter account number (9999 to terminate): ");
                accountNumber = scanner.nextInt();

                if (accountNumber != TERMINATING_VALUE) {
                    Record record = readRecord(file, accountNumber);
                    System.out.println("Balance for account " + accountNumber + ": " + record.getBalance());
                }

            } while (accountNumber != TERMINATING_VALUE);

            file.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Record readRecord(RandomAccessFile file, int accountNumber) throws IOException {
        file.seek(accountNumber * Record.SIZE);
        return readRecord(file);
    }

    private static Record readRecord(RandomAccessFile file) throws IOException {
        int accountNumber = file.readInt();
        char[] lastNameChars = new char[8];
        for (int i = 0; i < lastNameChars.length; i++) {
            lastNameChars[i] = file.readChar();
        }
        String lastName = new String(lastNameChars).trim();
        double balance = file.readDouble();

        return new Record(accountNumber, lastName, balance);
    }
}
