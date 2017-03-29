package DBLayer;

import ModelLayer.Supplier;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
/**
 * Created by Admin on 3/29/2017.
 */
public class SupplierDB implements SupplierDBIF {
    @Override
    public Supplier create(int id, String name, String address, String country, String phone, String email) throws SQLException {
        Supplier s = new Supplier(id, name, address, country, phone, email);

        String sql = String.format("INSERT INTO Supplier (id, name, address, country, phone_number, email) VALUES "
                + "('%d', '%s', '%s', '%s', '%s', '%s')", id, name, address, country, phone, email);
        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    @Override
    public Supplier update(int id, String object, int index) throws SQLException {
        Supplier s = new Supplier(); // it might bug the code ask and fix this
        String sql;
        switch (index) {
            case 1:
                sql = String.format("UPDATE Supplier SET name = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                sql = String.format("UPDATE Supplier SET address = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 3:
                sql = String.format("UPDATE Supplier SET country = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 4:
                sql = String.format("UPDATE Supplier SET phone_number = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 5:
                sql = String.format("UPDATE Supplier SET email = '%s' WHERE id = '%d'", object, id);
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

        return s;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean ok = true;
        String sql = String.format("DELETE FROM Supplier WHERE id = '%d'", id);
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
    public Supplier readById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Supplier> readAll() throws SQLException {
        return null;
    }

}
