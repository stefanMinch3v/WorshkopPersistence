package ModelLayer;

/**
 * Created by Admin on 3/29/2017.
 */
public class Gun extends Product{

    private String material;
    private String caliber;

    public Gun (String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId,String material, String caliber) {
        super(barcode, category, quantity, name, purchasePrice, salePrice, minSupply, supId);
        this.material = material;
        this.caliber = caliber;
    }

    public String getMaterial() {
        return material;
    }

    public String getCaliber() {
        return caliber;
    }
}
