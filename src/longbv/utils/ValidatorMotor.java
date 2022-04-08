/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import longbv.brand.BrandDTO;
import longbv.motorcycle.MotorcycleDAO;
import longbv.motorcycle.MotorcycleDTO;

/**
 *
 * @author longh
 */
public class ValidatorMotor {

    private static final boolean VALID = true;
    private static final boolean INVALID = false;
    private static final boolean ADD_MODE = false;
    private static final boolean UPDATE_MODE = true;

    public static Notification isValidID(String motorID, boolean mode) {
        if (motorID.isEmpty()) {
            return new Notification(INVALID, "Please input ID!");
        }

        String regexCode = "^[a-zA-Z0-9]{1,10}$";
        if (!motorID.matches(regexCode)) {
            return new Notification(INVALID, "ID has max length is 10, is not contains special characters");
        }
        
        if (mode == ADD_MODE) {
            if (new MotorcycleDAO().getMotorByID(motorID) != null) {
                return new Notification(INVALID, "ID has duplicated!");
            }
        }
        return new Notification(VALID, "", motorID);
    }

    public static Notification isValidModel(String model) {
        if (model.isEmpty()) {
            return new Notification(INVALID, "Please input model!");
        }
        String regexCode = "^[a-zA-Z0-9 -]{1,50}$";
        if (!model.matches(regexCode)) {
            return new Notification(INVALID, "Model has max length is 50, is not contains special characters");
        }
        return new Notification(VALID, "", model);
    }

    public static Notification isValidYear(String year) {
        if (year.isEmpty()) {
            return new Notification(INVALID, "Please input year!");
        }
        Date validDate;
        try {
            DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
            format.setLenient(false);
            validDate = format.parse(year);
        } catch (ParseException ex) {
            return new Notification(INVALID, "Invalid format(MM-dd-yyyy)!");
        }
        if (validDate.after(new Date())) { //new Date la lay ngay hien tai
            return new Notification(INVALID, "The raise date of motorcycle can't higher than current date, it cannot be made in the future!");
        }
        return new Notification(VALID, "", validDate);
    }

    public static Notification isValidCondition(String condition) {
        if (condition.isEmpty()) {
            return new Notification(INVALID, "Please input condition!");
        }
        String regexCode = "^[a-zA-Z0-9 ]{1,50}$";
        if (!condition.matches(regexCode)) {
            return new Notification(INVALID, "Model has max length is 50, is not contains special characters");
        }
        return new Notification(VALID, "", condition);     
    }

    public static Notification isValidPrice(String priceStr) {
        if (priceStr.isEmpty()) {
            return new Notification(INVALID, "Please input price!");
        }

        Double price;

        try {
            price = Double.parseDouble(priceStr);
            if (price < 0) {
                return new Notification(INVALID, "Price must be higher than 0");
            }
        } catch (NumberFormatException ex) {
            return new Notification(INVALID, "Price is not valid format!");
        }
        return new Notification(VALID, "", price);
    }

    public static Notification isValidQuantity(String quantityStr) {
        if (quantityStr.isEmpty()) {
            return new Notification(INVALID, "Please input quantity!");
        }
        Integer quantity = null;
        try {
            quantity = Integer.parseInt(quantityStr);
            if (quantity < 0) {
                return new Notification(INVALID, "Quantity must be higher than 0 ");
            }
        } catch (NumberFormatException ex) {
            return new Notification(INVALID, "Quantity is not valid format!");
        }
        return new Notification(VALID, "", quantity);
    }

    public static Notification isValidWarranty(String warranty) {
        if (warranty.isEmpty()) {
            return new Notification(INVALID, "Please input warranty!");
        }
        String regexCode = "^[a-zA-Z0-9 ]{1,50}$";
        if (!warranty.matches(regexCode)) {
            return new Notification(INVALID, "Warranty has max length is 50, is not contains special characters");
        }
        return new Notification(VALID, "", warranty);
    }
}
