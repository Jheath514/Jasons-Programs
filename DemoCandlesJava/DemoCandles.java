import java.util.Scanner;

public class DemoCandles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Candle object
        Candle candle = new Candle();
        System.out.println("Enter Candle color:");
        candle.setColor(scanner.nextLine());
        System.out.println("Enter Candle height in inches:");
        candle.setHeight(Integer.parseInt(scanner.nextLine()));

        // ScentedCandle object
        ScentedCandle scentedCandle = new ScentedCandle();
        System.out.println("Enter Scented Candle color:");
        scentedCandle.setColor(scanner.nextLine());
        System.out.println("Enter Scented Candle height in inches:");
        scentedCandle.setHeight(Integer.parseInt(scanner.nextLine()));
        System.out.println("Choose Scent (e.g., gardenia, lavender, vanilla, rose):");
        scentedCandle.setScent(scanner.nextLine());

        // Display Candle details
        System.out.println("\nCandle Details:");
        System.out.println("Color: " + candle.getColor());
        System.out.println("Height: " + candle.getHeight() + " inches");
        System.out.println("Price: $" + candle.getPrice());

        // Display ScentedCandle details
        System.out.println("\nScented Candle Details:");
        System.out.println("Color: " + scentedCandle.getColor());
        System.out.println("Height: " + scentedCandle.getHeight() + " inches");
        System.out.println("Scent: " + scentedCandle.getScent());
        System.out.println("Price: $" + scentedCandle.getPrice());
    }
}
