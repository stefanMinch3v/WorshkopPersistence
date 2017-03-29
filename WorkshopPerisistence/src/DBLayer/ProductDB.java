package DBLayer;

import ModelLayer.Clothing;
import ModelLayer.Equipment;
import ModelLayer.Gun;
import ModelLayer.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by USER on 29.3.2017 г..
 */
public class ProductDB implements ProductDBIF{

    @Override
    public Gun createGun(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String size, String color) throws SQLException {
        return null;
    }

    @Override
    public Clothing createClothing(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String size, String color) {
        return null;
    }

    @Override
    public Equipment createEquipment(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String size, String color) {
        return null;
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
