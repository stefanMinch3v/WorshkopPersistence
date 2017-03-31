package ControlLayer;

import DBLayer.OrderDB;
import DBLayer.OrderLineDB;
import ModelLayer.Clothing;
import ModelLayer.Equipment;
import ModelLayer.Gun;
import ModelLayer.Order;
import com.sun.istack.internal.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by Red John on 29-Mar-17.
 */
public class OrderController {
    OrderDB orderDB = OrderDB.getInstance();
    OrderLineDB orderLineDB = OrderLineDB.getInstance();
    public boolean create(ArrayList<Equipment>equipments, ArrayList<Clothing> clothings, ArrayList<Gun> guns, Date date, int totalAmount, boolean deliveryStatus, Date deliveryDate, int invoiceId, int customerId) throws SQLException {
        int orderId = orderDB.create(date,totalAmount,deliveryStatus,deliveryDate,invoiceId,customerId).getId();
        for (Equipment equipment : equipments) {
            orderLineDB.create(orderId,equipment.getBarcode(),equipment.getQuantity());
        }
        for (Clothing clothing : clothings) {
            orderLineDB.create(orderId,clothing.getBarcode(),clothing.getQuantity());
        }
        for (Gun gun : guns) {
            orderLineDB.create(orderId,gun.getBarcode(),gun.getQuantity());
        }
        return true;
    }
    @Nullable
    public Order readById(int id){
        try {
            return orderDB.readById(id);
        }catch (SQLException e){
            return null;
        }
    }
    @Nullable
    public Order update(int id, Object object, int index){
        try {
            return orderDB.update(id, object, index);
        }catch (SQLException e){
            return null;
        }
    }
    public boolean delete(int id){
        try {
            return orderDB.delete(id);
        }catch (SQLException e){
            return false;
        }
    }
}
