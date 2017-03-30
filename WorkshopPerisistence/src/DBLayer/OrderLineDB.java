package DBLayer;

import ModelLayer.OrderLine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrderLineDB implements OrderLineDBIF {
    private OrderLine orderline;

    @Override
    public OrderLine create(int orderId, int productBarcode, int quantity) throws SQLException {
        String sql = String.format("INSERT INTO OrderLine (order_Id, product_Barcode, quantity) VALUES "
                + "('%s', '%s', '%s')", orderId, productBarcode, quantity);

        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        OrderLine ol = new OrderLine(orderId, productBarcode, quantity);

        return ol;


    }


    @Override
    public boolean delete(int id) throws SQLException {
        boolean ok = true;
        String sql = String.format("DELETE FROM Order WHERE id = '%d'", id);
        try (
                Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
            stmt.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return ok;
    }
    @Override
    public OrderLine readById(int id) throws SQLException {
        OrderLine  ol = null;

        String sql = "SELECT date, totalAmount, deliveryStatus, deliveryDate, invoiceId, customerId FROM Order WHERE Id = " + id;

        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                ol = buildObject(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return ol;
    }
    @Override
    public ArrayList<OrderLine> readAll() throws SQLException {
        ArrayList<OrderLine> ol = new ArrayList<>();
        String sql = "SELECT * FROM Order";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                ol = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return ol;
    }
    private OrderLine buildObject(ResultSet rs) throws SQLException{
        OrderLine ol = new OrderLine();
        try {
            ol.setOrderId(rs.getInt("order_id"));
            ol.setProductBarcode(rs.getInt("product_barcode"));
            ol.setQuantity(rs.getInt("quantity"));

        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return ol;
    }

    private ArrayList<OrderLine> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<OrderLine> cs = new ArrayList<OrderLine>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }

        return cs;
    }
}
