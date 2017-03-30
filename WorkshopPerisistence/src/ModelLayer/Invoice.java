package ModelLayer;

import java.util.Date;

/**
 * Created by Admin on 3/29/2017.
 */
public class Invoice {
    private int Id;
    private Date paymentDate;
    private double actualAmount;

    public Invoice(Date paymentDate, double actualAmount) {
        this.paymentDate = paymentDate;
        this.actualAmount = actualAmount;
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

    @Override
    public String toString() {
        return "Invoice{" +
                "Id=" + Id +
                ", paymentDate=" + paymentDate +
                ", actualAmount=" + actualAmount +
                '}';
    }
}
