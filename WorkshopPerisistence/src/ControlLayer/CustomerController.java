package ControlLayer;
import DBLayer.*;
import ModelLayer.Customer;
import Validator.Validator;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Red John on 29-Mar-17.
 */
public class CustomerController {
    public boolean create(String name, String address, int zip, boolean isCompany, String phoneNumber){
        ArrayList<String> errorsBag = new ArrayList<>();
        if(Validator.checkName(name)!=null)errorsBag.add(Validator.checkName(name));
        if(Validator.checkZip(zip)!=null)errorsBag.add(Validator.checkZip(zip));
        if(Validator.checkPhone(phoneNumber)!=null)errorsBag.add(Validator.checkPhone(phoneNumber));
        if (errorsBag.size()==0) {
            try {
                return ((CustomerDB.getInstance().create(name, address, zip, isCompany, phoneNumber)) != null);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    public boolean update(int id, Object object, int index){
        try {
            return (CustomerDB.getInstance().update(id, object, index) != null);
        }catch (SQLException e){
            return false;
        }
    }
    public boolean delete(int id){
        try {
            return CustomerDB.getInstance().delete(id);
        }catch (SQLException e){
            return false;
        }
    }
    public Customer readById(int id){
        try {
            return CustomerDB.getInstance().readById(id);
        }catch (SQLException e){
            return null;
        }
    }
    public ArrayList<Customer> readAll(){
        try {
            return CustomerDB.getInstance().readAll();
        }catch (SQLException e){
            return null;
        }
    }
}
