public class DataEntryException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid integer data entered.";
    }
}
