package DBLayer;

import ModelLayer.Clothing;
import ModelLayer.Equipment;
import ModelLayer.Gun;
import ModelLayer.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by USER on 29.3.2017 г..
 */
public class ProductDB implements ProductDBIF{

    @Override
    public Gun createGun(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String material, String caliber) throws SQLException {

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
    public Clothing createClothing(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String size, String color) throws SQLException {

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
    public Equipment createEquipment(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String type, String description) throws SQLException {
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
    public Product update(Product product) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Product readById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Product> readAll() throws SQLException {
        return null;
    }
}
