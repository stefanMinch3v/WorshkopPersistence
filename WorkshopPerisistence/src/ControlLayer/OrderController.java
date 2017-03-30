package ControlLayer;

import DBLayer.OrderDB;
import DBLayer.OrderLineDB;
import ModelLayer.Clothing;
import ModelLayer.Equipment;
import ModelLayer.Gun;
import ModelLayer.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
    public Order read(int id) throws SQLException{
        return orderDB.readById(id);
    }

    public Order update(int id, Object object, int index) throws SQLException{
        return orderDB.update(id,object,index);
    }

    public boolean delete(int id) throws SQLException{
        return orderDB.delete(id);
    }

}
