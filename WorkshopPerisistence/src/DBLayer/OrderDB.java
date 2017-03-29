package DBLayer;

import  ModelLayer.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;


public class OrderDB implements OrderDBIF {
    private Order order;
    private Date createdate = order.getDate();
    private Date deliveryDat = order.getDeliveryDate();

    @Override
    public Order create(Date date, int totalAmount, String deliveryStatus, Date deliveryDate, int invoiceId, int customerId) throws SQLException {
        String sql = String.format("INSERT INTO Order (date, totalAmount, deliveryStatus, deliveryDate, invoiceId, customerId) VALUES "
                + "'"+createdate+"'"+"('%d', '%s')"+"'"+deliveryDate+"'"+"('%d','%d')", date, totalAmount, deliveryStatus, deliveryDate, invoiceId, customerId);
        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        Order o = new Order(date, totalAmount, deliveryStatus, deliveryDate, invoiceId, customerId);

        return o;


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
