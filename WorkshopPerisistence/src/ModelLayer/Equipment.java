package ModelLayer;

/**
 * Created by Admin on 3/29/2017.
 */
public class Equipment extends Product{

    private String type;
    private String description;

    public Equipment (String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId,String type, String description) {
        super(barcode, category, quantity, name, purchasePrice, salePrice, minSupply, supId);
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
