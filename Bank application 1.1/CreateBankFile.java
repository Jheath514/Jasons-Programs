import java.io.RandomAccessFile;
import java.io.IOException;

public class CreateBankFile {
    public static void main(String[] args) {
        final int MAX_RECORDS = 10000;
        final String FILE_NAME = "bankData.dat";

        try {
            RandomAccessFile file = new RandomAccessFile(FILE_NAME, "rw");

            
            for (int i = 0; i < MAX_RECORDS; i++) {
                writeRecord(file, i, "", 0.0);
            }

            

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeRecord(RandomAccessFile file, int accountNumber, String lastName, double balance)
            throws IOException {
        file.seek(accountNumber * Record.SIZE);
        Record record = new Record(accountNumber, lastName, balance);
        record.write(file);
    }
}

class Record {
    public static final int SIZE = 38;

    private int accountNumber;
    private String lastName;
    private double balance;

    public Record(int accountNumber, String lastName, double balance) {
        this.accountNumber = accountNumber;
        this.lastName = String.format("%-8s", lastName); // Padding or truncating the last name
        this.balance = balance;
    }

    public void write(RandomAccessFile file) throws IOException {
        file.writeInt(accountNumber);
        file.writeChars(lastName);
        file.writeDouble(balance);
    }
}
