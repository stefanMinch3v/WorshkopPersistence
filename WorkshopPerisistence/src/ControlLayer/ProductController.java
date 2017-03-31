package ControlLayer;

import DBLayer.ProductDB;

import java.sql.SQLException;

/**
 * Created by Red John on 29-Mar-17.
 */
public class ProductController {
    ProductDB productDB;

    public ProductController() {

    }

    public boolean createGun(String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String material, String caliber){

        try {
            productDB.createGun(barcode, category, quantity, name, purchasePrice, salePrice, minSupply, supId, material, caliber);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean createEquipment(String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String size, String color){
        try {
            productDB.createEquipment(barcode, category, quantity, name, purchasePrice, salePrice, minSupply, supId, size, color);

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean createClothing(String barcode, String category, int quantity, String name, double purchasePrice, double salePrice, int minSupply, int supId, String size, String color){
        try {
            productDB.createClothing(barcode, category, quantity, name, purchasePrice, salePrice, minSupply, supId, size, color);

        } catch (SQLException e) {
            return false;
        }
        return true;

    }
}

