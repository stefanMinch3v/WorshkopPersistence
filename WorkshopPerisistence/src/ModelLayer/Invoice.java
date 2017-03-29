package ModelLayer;

import java.util.Date;

/**
 * Created by Admin on 3/29/2017.
 */
public class Invoice {
    private int Id;
    private Date paymentDate;
    private double actualAmount;
    private int orderId;

    public Invoice(Date paymentDate, double actualAmount, int orderId) {
        this.paymentDate = paymentDate;
        this.actualAmount = actualAmount;
        this.orderId = orderId;
    }

    public int getId() {
        return Id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "paymentDate=" + getPaymentDate() +
                ", actualAmount=" + getActualAmount() +
                ", orderId=" + getOrderId() +
                '}';
    }
}
