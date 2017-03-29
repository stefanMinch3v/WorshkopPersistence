package ModelLayer;

/**
 * Created by Admin on 3/29/2017.
 */
public class Clothing extends Product{
    private String size;
    private String color;

    public Clothing (int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId,String size, String color) {
        super(barcode, category,quantity,  name, purchasePrice, salePrice, minSupply, supId);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
