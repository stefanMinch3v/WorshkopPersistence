package DBLayer;

import ModelLayer.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by USER on 29.3.2017 г..
 */
public class CustomerDB implements CustomerDBIF{

    @Override
    public Customer create(String name, String address, int zip, boolean isCompany, String phoneNumber) throws SQLException {
        return null;
    }

    @Override
    public Customer update(Customer customer) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Customer readById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> readAll() throws SQLException {
        return null;
    }
}
