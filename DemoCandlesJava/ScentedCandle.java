public class ScentedCandle extends Candle {
    private String scent;

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        setPrice(height * 3); // Price of ScentedCandle set at $3 per inch
    }
}
