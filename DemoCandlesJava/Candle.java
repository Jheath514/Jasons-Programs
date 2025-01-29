public class Candle {
    private String color;
    private int height;
    private int price;

    public String getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHeight(int height) {
        this.height = height;
        this.price = height * 2; // Price determined as $2 per inch
    }
}
