package ModelLayer;

/**
 * Created by Admin on 3/29/2017.
 */
public abstract class Product {

    private int barcode;
    private String category;
    private int quantity;
    private String name;
    private double purchasePrice;
    private double salePrice;
    private int minSupply;
    private int supId;

    // CONSTRUCTOR --------------------------------------------------------------------

    public Product(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId) {
        this.barcode = barcode;
        this.category = category;
        this.quantity = quantity;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minSupply = minSupply;
        this.supId = supId;
    }

    // GETTERS -------------------------------------------------------------------------

    public int getBarcode() {
        return barcode;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public int getMinSupply() {
        return minSupply;
    }

    public int getSupId() {
        return supId;
    }

    // SETTERS------------------------------------------------------------------------

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setMinSupply(int minSupply) {
        this.minSupply = minSupply;
    }

}
