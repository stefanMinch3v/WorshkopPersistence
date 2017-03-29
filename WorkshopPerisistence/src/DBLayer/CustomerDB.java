package DBLayer;

import ModelLayer.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 29.3.2017 г..
 */
public class CustomerDB implements CustomerDBIF{

    @Override
    public Customer create(String name, String address, int zip, boolean isCompany, String phoneNumber) throws SQLException {
        return null;
    }

    @Override
    public Customer update(Customer customer) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Customer readById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> readAll() throws SQLException {
        return null;
    }
    private ArrayList<String> validate(String name, String address, int zip, boolean isCompany, String phoneNumber){
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
    }
}
