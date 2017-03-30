package ModelLayer;

import java.util.Date;

/**
 * Created by Admin on 3/29/2017.
 */
public class Order {
    private Date date;
    private int totalAmount;
    private String deliveryStatus;
    private Date deliveryDate;
    private int invoiceId;
    private int customerId;

    public Order(){

    }
    public Order(Date date, int totalAmount, String deliveryStatus, Date deliveryDate, int invoiceId, int customerId) {
        this.date = date;
        this.totalAmount = totalAmount;
        this.deliveryStatus = deliveryStatus;
        this.deliveryDate = deliveryDate;
        this.invoiceId = invoiceId;
        this.customerId = customerId;
    }





    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


}
