package ControlLayer;

import DBLayer.SupplierDB;
import ModelLayer.Supplier;

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
    public boolean createSupplier(String name, String address, String country, String phone, String email) throws Exception{
        boolean ok = true;
        try{
            sDB.create(name, address, country, phone, email);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return ok;
    }


    //Delete
    public boolean deleteSupplier(int id) throws Exception{
        return sDB.delete(id);
    }


    //Update
    public boolean updateSupplier(int id, String object, int index) throws Exception{
        boolean ok = true;
        try {
            sDB.update(id, object, index);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return ok;
    }


    //Read specific supplier
    public Supplier readSupplierById(int id) throws Exception {
          return sDB.readById(id);
    }


    //Read all
    public ArrayList<Supplier> readAllSuppliers() throws Exception{
        return sDB.readAll();
    }
}
