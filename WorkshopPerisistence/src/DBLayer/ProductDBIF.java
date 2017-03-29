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
public interface ProductDBIF {
    Gun createGun (int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String size, String color) throws SQLException;
    Clothing createClothing(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId,String size, String color);
    Equipment createEquipment(int barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId,String size, String color);
    Product update (Product product) throws SQLException;
    boolean delete (int id) throws SQLException;
    Product readById (int id) throws  SQLException;
    List<Product> readAll() throws SQLException;
}
