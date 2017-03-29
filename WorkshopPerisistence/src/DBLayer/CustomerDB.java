package DBLayer;

import ModelLayer.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 29.3.2017 г..
 */
public class CustomerDB implements CustomerDBIF{
    public static void main(String[] args) {
        try {
            //Customer customer = new CustomerDB().create("Dimitar2", "No address", 9400, false, "56665530");
            //new CustomerDB().readAll();
            System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public Customer create(String name, String address, int zip, boolean isCompany, String phoneNumber) throws SQLException {
        ArrayList<String> errorsBag = validate(name, zip, phoneNumber);
        if (errorsBag!=null){
            return null;
        }else {
            Customer customer = new Customer(name, address, zip, isCompany, phoneNumber);
            int isCompany2 = (isCompany) ? 1 : 0;
            String sql = String.format("INSERT INTO customer (name, address, zip, is_company, phone_number) VALUES ('%s', '%s', '%d', '%d', '%s')", name, address, zip, isCompany2, phoneNumber);

            try (Connection conn = DBConnection.getInstance().getDBcon();
                 Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }

            return customer;
        }
    }

    @Override
    public Customer update(int id, Object object, int index) throws SQLException {
            String sql;
            switch (index) {
                case 1:
                    sql = String.format("UPDATE customer SET name = '%s' WHERE id = '%d'", object, id);
                    try (
                            Statement stmt2 = DBConnection.getInstance().getDBcon().createStatement()) {
                        stmt2.executeUpdate(sql);
                    } catch(SQLException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                case 2:
                    sql = String.format("UPDATE customer SET address = '%s' WHERE id = '%d'", object, id);
                    try (
                            Statement stmt2 = DBConnection.getInstance().getDBcon().createStatement()) {
                        stmt2.executeUpdate(sql);
                    } catch(SQLException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                case 3:
                    sql = String.format("UPDATE customer SET zip = '"+ object +"' WHERE id = '%d'", id);
                    try (
                            Statement stmt2 = DBConnection.getInstance().getDBcon().createStatement()) {
                        stmt2.executeUpdate(sql);
                    } catch(SQLException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                case 4:
                    sql = String.format("UPDATE customer SET is_company = '"+object+"' WHERE id = '%d'", id);
                    try (
                            Statement stmt2 = DBConnection.getInstance().getDBcon().createStatement()) {
                        stmt2.executeUpdate(sql);
                    } catch(SQLException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                case 5:
                    sql = String.format("UPDATE customer SET phone_number = '%s' WHERE id = '%d'", object, id);
                    try (
                            Statement stmt2 = DBConnection.getInstance().getDBcon().createStatement()) {
                        stmt2.executeUpdate(sql);
                    } catch(SQLException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                default:
                    break;
            }
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean ok = true;
        String sql = String.format("DELETE FROM customer WHERE id = '%d'", id);
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
    public Customer readById(int id) throws SQLException {
        Customer customer = null;

        String sql = "SELECT * FROM customer WHERE Id = " + id;

        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                customer = new Customer(rs.getString(2),rs.getString(3),rs.getInt(4), rs.getBoolean(5), rs.getString(6));// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return customer;
    }

    @Override
    public List<Customer> readAll() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = null;

        String sql = "SELECT * FROM customer";

        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                customer = new Customer(rs.getString(2),rs.getString(3),rs.getInt(4), rs.getBoolean(5), rs.getString(6));// create method buildObject
                customers.add(customer);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return customers;
    }
    private ArrayList<String> validate(String name, int zip, String phoneNumber){
        ArrayList<String> errorsBag = new ArrayList<>();
        if (name.length()>50 || name.length()<1){
            errorsBag.add("Name must be between 2 and 49 characters");
        }
        if (zip>=10000 && zip<1000){
            errorsBag.add("Zip code must have 4 digit number");
        }
        if (phoneNumber.length()!=8){
            errorsBag.add("Phone number must contain 8 digits");
        }else{
            try{
               Integer.parseInt(phoneNumber);
            }catch (Exception e){
                errorsBag.add("Phone number must contain only numbers");
            }
        }
        return (errorsBag.size()==0)?null:errorsBag;
    }
}
