package DBLayer;

import ModelLayer.Clothing;
import ModelLayer.Equipment;
import ModelLayer.Gun;
import ModelLayer.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 29.3.2017 г..
 */
public interface ProductDBIF {
    Gun createGun (String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String material, String caliber) throws SQLException;
    Clothing createClothing(String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId,String size, String color) throws SQLException;
    Equipment createEquipment(String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId,String type, String description) throws SQLException;
    Product update (String barcode, Object object, int index) throws SQLException;
    boolean delete (String barcode) throws SQLException;
    Product readByBarcode (String barcode) throws  SQLException;
    //ArrayList<Product> readAll() throws SQLException;
}
