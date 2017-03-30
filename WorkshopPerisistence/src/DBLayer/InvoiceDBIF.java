package DBLayer;

import ModelLayer.Invoice;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by USER on 30.3.2017 г..
 */
public interface InvoiceDBIF {
    Invoice create (Date paymentDate, double actualAmount) throws SQLException;
    Invoice readById (int id) throws  SQLException;
    ArrayList<Invoice> readAll() throws SQLException;
}
