package DBLayer;

import ModelLayer.OrderLine;

import java.sql.SQLException;
import java.util.List;


public interface  OrderLineDBIF {

    OrderLine create (int orderId, int productBarcode, int quantity) throws SQLException;
    boolean delete (int id) throws SQLException;
    OrderLine readById (int id) throws  SQLException;
    List<OrderLine> readAll() throws SQLException;
}