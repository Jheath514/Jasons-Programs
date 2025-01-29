import java.time.LocalDate;

public class Invention {
    private String description;
    private Inventor inventor;
    private LocalDate inventionDate;

    public Invention(String description, Inventor inventor, LocalDate inventionDate) {
        this.description = description;
        this.inventor = inventor;
        this.inventionDate = inventionDate;
    }

    @Override
    public String toString() {
        return "Invention Description: " + description + "\nInventor: " + inventor.getName() + " from " + inventor.getCountry() + "\nInvention Date: " + inventionDate;
    }
}
