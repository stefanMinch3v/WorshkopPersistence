package ModelLayer;

import java.util.Date;

/**
 * Created by Admin on 3/29/2017.
 */
public class Order {
    private int id;
    private Date date;
    private int totalAmount;
    private boolean deliveryStatus;
    private Date deliveryDate;
    private int invoiceId;
    private int customerId;

    public Order(){

    }
    public Order(int id,Date date, int totalAmount, boolean deliveryStatus, Date deliveryDate, int invoiceId, int customerId) {
        this.id = id;
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

    public int getId(){return id;}

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setId(int id) {
        this.id = id;
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
