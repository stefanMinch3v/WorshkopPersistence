package DBLayer;

import ModelLayer.Order;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class OrderDB implements OrderDBIF {
    @Override
    public Order create(Date date, int totalAmount, String deliveryStatus, Date deliveryDate, int invoiceId, int customerId) throws SQLException {
        return null;
    }

    @Override
    public Order update(String deliveryStatus, String deliveryDate) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Order readById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Order> readAll() throws SQLException {
        return null;
    }
}
