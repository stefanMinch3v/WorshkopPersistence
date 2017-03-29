package DBLayer;

import ModelLayer.Order;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public interface  OrderDBIF {

    Order create (Date date, int totalAmount, String deliveryStatus, Date deliveryDate, int invoiceId, int customerId) throws SQLException;
    Order update (String deliveryStatus, String deliveryDate) throws SQLException;
    boolean delete (int id) throws SQLException;
    Order readById (int id) throws  SQLException;
    List<Order> readAll() throws SQLException;
}
