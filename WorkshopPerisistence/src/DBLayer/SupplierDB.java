package DBLayer;

import ModelLayer.Supplier;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public class SupplierDB implements SupplierDBIF {
    @Override
    public Supplier create(int id, String name, String address, String country, String phone, String email) throws SQLException {
        return null;
    }

    @Override
    public Supplier update(int id, String name) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Supplier readById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Supplier> readAll() throws SQLException {
        return null;
    }
}
