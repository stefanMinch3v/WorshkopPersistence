package ControlLayer;

import DBLayer.SupplierDB;
import ModelLayer.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Admin on 3/30/2017.
 */
public class SupplierController {
    private SupplierDB sDB;

    public SupplierController() {
        sDB = SupplierDB.getInstance();
    }

    //Create
    public boolean createSupplier(String name, String address, String country, String phone, String email) {
        try{
            return (sDB.create(name, address, country, phone, email) != null);
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }

    }


    //Delete
    public boolean deleteSupplier(int id) {
        try {
            return sDB.delete(id);
        } catch(SQLException ex) {
            ex.getMessage();
            return false;
        }
    }


    //Update
    public boolean updateSupplier(int id, String object, int index) {
        try {
           return (sDB.update(id, object, index) != null);
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }


    //Read specific supplier
    public Supplier readSupplierById(int id) {
          try {
              return sDB.readById(id);
          } catch (SQLException ex) {
              return null;
          }
    }


    //Read all
    public ArrayList<Supplier> readAllSuppliers() {
        try {
            return sDB.readAll();
        } catch (SQLException ex) {
            ex.getMessage();
            return null;
        }
    }
}
