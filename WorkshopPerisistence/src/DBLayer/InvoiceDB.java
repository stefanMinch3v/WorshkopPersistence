package DBLayer;

import ModelLayer.Invoice;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by USER on 30.3.2017 г..
 */
//creates single class but it should be automated
public class InvoiceDB implements InvoiceDBIF {
    public static void main(String[] args) {
        try {
            System.out.println(InvoiceDB.getInstance().readById(3));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static InvoiceDB instance =null;
    public static InvoiceDB getInstance(){
        if (instance==null){
            instance= new InvoiceDB();
        }
        return instance;
    }

    private InvoiceDB() {
    }


    @Override
    public Invoice create(java.util.Date paymentDate, double actualAmount) throws SQLException {
        Invoice invoice = new Invoice(paymentDate, actualAmount);
        String sql = String.format("INSERT INTO invoice (payment_date, actual_amount) VALUES ('"+paymentDate+"','%f')", actualAmount);

        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return invoice;
    }

    @Override
    public Invoice readById(int id) throws SQLException {
        String sql = "SELECT * FROM invoice WHERE Id =" + id;
        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                return new Invoice(rs.getDate(2),rs.getDouble(3));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<Invoice> readAll() throws SQLException {
        return null;
    }

}
