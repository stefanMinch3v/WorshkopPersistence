package ModelLayer;

/**
 * Created by Admin on 3/29/2017.
 */
public class OrderLine {
    private int orderId;
    private int productBarcode;
    private int quantity;

    public OrderLine(){}
    public OrderLine(int orderId, int productBarcode, int quantity) {
        this.orderId = orderId;
        this.productBarcode = productBarcode;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(int productBarcode) {
        this.productBarcode = productBarcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
