package DBLayer;

import ModelLayer.Supplier;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public interface SupplierDBIF {

    Supplier create (int id, String name, String address, String country, String phone, String email) throws SQLException;
    Supplier update (int id, String object, int index) throws SQLException;
    boolean delete (int id) throws SQLException;
    Supplier readById (int id) throws  SQLException;
    List<Supplier> readAll() throws SQLException;
}
