package Validator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import DBLayer.*;
import ModelLayer.Supplier;

/**
 * Created by USER on 30.3.2017 г..
 */
public class Validator {
    public static void main(String[] args) {
        checkEmail("dimtiar@abv.bg");
    }
    public static String checkName(String name){
        if (name.length()>50 || name.length()<1){
            return "Name must be between 2 and 49 characters";
        }
        else{
            return null;
        }
    }

    public static String checkZip(int zip){
        if (zip>=10000 && zip<1000){
            return "Zip code must have 4 digit number";
        }else{
            return null;
        }
    }
    public static String checkPhone(String phoneNumber){
        if (phoneNumber.length()!=8){
            return "Phone number must contain 8 digits";
        }else{
            try{
                Integer.parseInt(phoneNumber);
                return null;
            }catch (Exception e){
                return "Phone number must contain only numbers";
            }
        }
    }
    public static String checkBarcode(String barcode){
        String regex = "[A-Z0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(barcode);
        return (matcher.matches())?null:"The barcode must consist only with capital letters and numbers";
    }

    public static String checkCategory(int category){
        if (category<0 || category>2){
            return "The category must be between 0 and 2";
        }
        return null;
    }

    public static String checkPrice(double price){
        if (price<=0){
            return "The price must be positive";
        }
        return null;
    }
    public static String checkMinStock(int minStock){
        if (minStock<=0){
            return "The minimum stock can not be 0";
        }
        return null;
    }
    public static String checkSupplierExists(int supplierId) throws SQLException{
        String sql = "Select TOP 1 * FROM supplier where id=" + supplierId;
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            return (rs.next())?null:"No supplier found with id of "+supplierId;
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    public static String checkEmail(String email) {
        String regex = "[a-zA-Z0-9]+@[a-z]+\\.[a-z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return (matcher.matches()) ? null : "The email is incorrect";
    }

    public static String checkSize(String size){
        return (size.length()>10||size.length()==0)?"The size must be between 1 and 10 characters":null;
    }
    public static String checkColor(String color){
        return (color.length()>30 || color.length()==0)?"The color must be between 1 and 30 characters":null;
    }
    public static String checkType(String type){
        return (type.length()>30 || type.length()==0)?"The type must be between 1 and 30 characters":null;
    }
    public static String checkDescription(String description){
        return (description.length()>200 || description.length()==0)?"The description must be between 1 and 200 characters":null;
    }

    public static String checkMaterial(String material){
        return (material.length()>30 || material.length()==0)?"The material must be between 1 and 30 characters":null;
    }
    public static String checkCaliber(String caliber){
        return (caliber.length()>30 || caliber.length()==0)?"The caliber must be between 1 and 30 characters":null;
    }
}
