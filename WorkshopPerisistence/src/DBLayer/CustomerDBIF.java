package DBLayer;
import ModelLayer.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by USER on 29.3.2017 г..
 */
public interface CustomerDBIF {
    Customer create (String name, String address, int zip, boolean isCompany, String phoneNumber) throws SQLException;
    Customer update (int id, Object object, int index) throws SQLException;
    boolean delete (int id) throws SQLException;
    Customer readById (int id) throws  SQLException;
    List<Customer> readAll() throws SQLException;
}
