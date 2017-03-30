package DBLayer;

import ModelLayer.Clothing;
import ModelLayer.Equipment;
import ModelLayer.Gun;
import ModelLayer.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 29.3.2017 г..
 */
public class ProductDB implements ProductDBIF{

    @Override
    public Gun createGun(String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String material, String caliber) throws SQLException {

        Gun gun = new Gun(barcode, category, quantity, name, purchasePrice, salePrice, minSupply, supId, material, caliber);

        String sql1 = String.format("INSERT INTO gun_replicas(product_barcode,material,caliber) VALUES " +
                "('%s','%s','%s')",barcode,material,caliber);
        String sql2 = String.format("INSERT INTO product (barcode, category, quantity,name,purchasePrice,salePrice,minSupply,supId) VALUES "
                + "('%d', '%s','%d', '%s','%d','%d','%d','%d')", barcode, category, quantity,name,purchasePrice,salePrice,minSupply,supId);
        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql2);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql1);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return gun;
        }


    @Override
    public Clothing createClothing(String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String size, String color) throws SQLException {

        Clothing clothing = new Clothing(barcode, category, quantity, name, purchasePrice, salePrice, minSupply, supId, size, color);

        String sql1 = String.format("INSERT INTO product (barcode, category, quantity,name,purchasePrice,salePrice,minSupply,supId) VALUES "
                + "('%d', '%s','%d', '%s','%d','%d','%d','%d')", barcode, category, quantity,name,purchasePrice,salePrice,minSupply,supId);
        String sql2 = String.format("INSERT INTO clothes(product_barcode,size,color) VALUES " +
                "('%s','%s','%s')",barcode,size,color);

        try (Connection conn = DBConnection.getInstance().getDBcon();
              Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql1);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql2);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return clothing;
    }

    @Override
    public Equipment createEquipment(String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String type, String description) throws SQLException {
        Equipment equipment = new Equipment(barcode, category, quantity, name, purchasePrice, salePrice, minSupply, supId, type, description);

        String sql1 = String.format("INSERT INTO product (barcode, category, quantity,name,purchasePrice,salePrice,minSupply,supId) VALUES "
                + "('%d', '%s','%d', '%s','%d','%d','%d','%d')", barcode, category, quantity,name,purchasePrice,salePrice,minSupply,supId);
        String sql2 = String.format("INSERT INTO equipment (product_barcode,type,description) VALUES " +
                "('%s','%s','%s')",barcode,type,description);

        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql1);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql2);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return equipment;
    }

    @Override
    public Product update(String barcode, Object object, int index) throws SQLException {
        Product p = null;
        String sql;
        switch (index) {
            case 1:
                sql = String.format("UPDATE Product SET quantity = '%d' WHERE barcode = '%s'", object, barcode);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                sql = String.format("UPDATE Product SET purchase_price = '%d' WHERE barcode = '%s'", object, barcode);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 3:
                sql = String.format("UPDATE Product SET selling_price = '%d' WHERE barcode = '%s'", object, barcode);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 4:
                sql = String.format("UPDATE Product SET min_stock = '%d' WHERE barcode = '%s'", object, barcode);
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

        return null;
    }

    @Override
    public boolean delete(String barcode) throws SQLException {
        boolean ok = true;
        String sql = String.format("DELETE FROM Product WHERE barcode = '%s'", barcode);
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
    public Product readByBarcode(String barcode) throws SQLException {
        Product p = null;

        String sql = "SELECT * FROM product WHERE barcode = " + barcode;
        String sql1 = "SELECT * FROM clothes WHERE barcode = " + barcode;
        String sql2 = "SELECT * FROM equipment WHERE barcode = " + barcode;
        String sql3 = "SELECT * FROM gun_replicas WHERE barcode = " + barcode;
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                int cat = rs.getInt(2);
                switch(cat) {
                    case 1:
                        ResultSet rs1 = st.executeQuery(sql1);
                        Clothing clothing = new Clothing(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8),rs1.getString(2),rs1.getString(3));
                        return clothing;
                    case 2:
                        ResultSet rs2 = st.executeQuery(sql2);
                        Equipment equipment = new Equipment(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8),rs2.getString(2),rs2.getString(3));
                        return equipment;
                    case 3:
                        ResultSet rs3 = st.executeQuery(sql3);
                        Gun gun = new Gun(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8),rs3.getString(2),rs3.getString(3));
                        return gun;
                    default:
                        return null;
                }
            }
            return null;
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<Product> readAll() throws SQLException {

        return null;
    }
}
