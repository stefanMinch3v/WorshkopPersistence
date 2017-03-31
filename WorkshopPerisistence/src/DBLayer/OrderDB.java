package DBLayer;

import ModelLayer.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class OrderDB implements OrderDBIF {
    private static OrderDB instance =null;
    public static OrderDB getInstance(){
        if (instance==null){
            instance= new OrderDB();
        }
        return instance;
    }

    public static void main(String[] args) {
        try{
            new OrderDB().create(new java.sql.Date(new Date().getTime()), 10, true,new java.sql.Date(new Date().getTime()), 3, 3);
            System.out.println("kokot");
        }
        catch (Exception ex)
        {ex.getMessage();
        }
    }
    @Override
    public Order create(java.sql.Date date, int totalAmount, boolean deliveryStatus, java.sql.Date deliveryDate, int invoiceId, int customerId) throws SQLException {

        Order o=null;
        String sql = String.format("INSERT INTO [order] (date, total_Amount, delivery_Status, delivery_Date, invoice_Id, customer_Id) VALUES ('"+date+"',"+totalAmount+", '"+deliveryStatus+"', '"+deliveryDate+"', "+invoiceId+", "+customerId+")");
        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        String sql2= "SELECT TOP 1 id FROM [order] order by id desc";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql2);
            if(rs.next()) {
               int id = rs.getInt(1);// create method buildObject
                o = new Order(id, date, totalAmount, deliveryStatus, deliveryDate, invoiceId, customerId);
                o.setId(id);
                String sql3 = "SELECT TOP 1 is_company from customer where id="+customerId;
                ResultSet resultSet = st.executeQuery(sql3);
                Boolean isCustomerPrivate = resultSet.getBoolean(1);
                if (!isCustomerPrivate){
                    InvoiceDB.getInstance().create(date, (totalAmount-totalAmount*0.05));
                }else{
                    if (totalAmount<2500) {
                        InvoiceDB.getInstance().create(date, (totalAmount+45));
                    }else{
                        InvoiceDB.getInstance().create(date, totalAmount);
                    }
                }

            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
           DBConnection.closeConnection();
        }
        return o;
    }

    @Override
    public Order update(int id, Object object, int index) throws SQLException {
        String sql;
        Order o = new Order();
        switch (index) {
            case 1:
                sql = String.format("UPDATE Order SET deliveryStatus = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                java.sql.Date date= new java.sql.Date(new java.util.Date().getTime());
                sql = String.format("UPDATE Order SET deliveryDate =" +"'"+date+"'"+  "WHERE id = '%d'", id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;

            default:
                break;
        }

        return o;
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
    public Order readById(int id) throws SQLException {
       Order  o = null;

        String sql = "SELECT date, totalAmount, deliveryStatus, deliveryDate, invoiceId, customerId FROM Order WHERE Id = " + id;

        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                o = buildObject(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return o;
    }
    @Override
    public ArrayList<Order> readAll() throws SQLException {
        ArrayList<Order> o = new ArrayList<>();
        String sql = "SELECT * FROM Order";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                o = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return o;
    }
    private Order buildObject(ResultSet rs) throws SQLException{
        Order o = new Order();
        try {
            o.setDate(rs.getDate("date"));
            o.setTotalAmount(rs.getInt("total_Amount"));
            o.setDeliveryStatus(rs.getBoolean("delivery_Status"));
            o.setDeliveryDate(rs.getDate("delivery_Date"));
            o.setInvoiceId(rs.getInt("invoice_Id"));
            o.setCustomerId(rs.getInt("customer_Id"));
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return o;
    }

    private ArrayList<Order> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<Order> cs = new ArrayList<Order>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }
        return cs;
    }
}
