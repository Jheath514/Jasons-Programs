import java.io.RandomAccessFile;
import java.io.IOException;

public class ReadBankAccountsSequentially {
    public static void main(String[] args) {
        final String FILE_NAME = "bankData.dat";

        try {
            RandomAccessFile file = new RandomAccessFile(FILE_NAME, "r");

            
            while (file.getFilePointer() < file.length()) {
                Record record = readRecord(file);
                System.out.println(record.getAccountNumber() + "\t" + record.getLastName() + "\t" + record.getBalance());
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
