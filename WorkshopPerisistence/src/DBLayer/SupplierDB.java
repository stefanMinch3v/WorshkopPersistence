package DBLayer;

import ModelLayer.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
/**
 * Created by Admin on 3/29/2017.
 */
public class SupplierDB implements SupplierDBIF {

    @Override
    public Supplier create(String name, String address, String country, String phone, String email) throws SQLException {
        Supplier s = new Supplier(name, address, country, phone, email);

        String sql = String.format("INSERT INTO Supplier (name, address, country, phone_number, email) VALUES "
                + "('%s', '%s', '%s', '%s', '%s')", name, address, country, phone, email);
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
        Supplier s = null;

        String sql = "SELECT id, name, address, country, phone_number, email FROM Supplier WHERE Id = " + id;

        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                s = buildObject(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    @Override
    public ArrayList<Supplier> readAll() throws SQLException {
        ArrayList<Supplier> s = new ArrayList<>();
        String sql = "SELECT * FROM Supplier";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                s = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return s;
    }

    private Supplier buildObject(ResultSet rs) throws SQLException{
        Supplier s = new Supplier();
        try {
            s.setName(rs.getString("name"));
            s.setAddress(rs.getString("address"));
            s.setCountry(rs.getString("country"));
            s.setPhone(rs.getString("phone"));
            s.setEmail(rs.getString("email"));
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    private ArrayList<Supplier> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<Supplier> cs = new ArrayList<Supplier>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }

        return cs;
    }
    //Validate data
    /*private ArrayList<String> validate(String name, String address, int zip, boolean isCompany, String phoneNumber){
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
    }*/
}
