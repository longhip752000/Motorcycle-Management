/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.utils;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import longbv.brand.BrandDAO;
import longbv.brand.BrandDTO;

/**
 *
 * @author longh
 */
public class ValidatorBrand {

    private static final boolean VALID = true;
    private static final boolean INVALID = false;
    private static final boolean ADD_MODE = false;
    private static final boolean UPDATE_MODE = true;

    public static Notification isValidBrandID(String brandID, boolean mode) {
        if (brandID.isEmpty()) {
            return new Notification(INVALID, "Please input BrandID!");
        }
        String regexCode = "^[a-zA-Z0-9]{1,10}$";
        if (!brandID.matches(regexCode)) {
            return new Notification(INVALID, "BrandID has max length is 10, is not contains special characters");
        }
        if (mode == ADD_MODE && new BrandDAO().getBrandNameByID(brandID) != null) {
            return new Notification(INVALID, "BrandID is duplicated!");
        }
        return new Notification(VALID, "", brandID);
    }

    public static Notification isValidBrandName(String brandName) {
        if(brandName.isEmpty()){
            return new Notification(INVALID, "Please input brandName!");
        }
        String regexCode = "^[a-zA-Z0-9 -]{1,50}$";
        if (!brandName.matches(regexCode)) {
            return new Notification(INVALID, "BrandName has max length is 50, is not contains special characters");
        }      
        return new Notification(VALID, "", brandName);
    }

    public static Notification isValidCountry(String country) {
        if(country.isEmpty()){
            return new Notification(INVALID, "Please input country!");
        }
        String regexCode = "^[a-zA-Z ]{1,50}$";
        if (!country.matches(regexCode)) {
            return new Notification(INVALID, "Country has max length is 50, is not contains special characters");
        }      
        return new Notification(VALID, "", country);
    }

    public static Notification isValidDesciption(String description) {
        if(description.isEmpty()){
            return new Notification(INVALID, "Please input description!");
        }
        String regexCode = "^[a-zA-Z0-9 ,;-]{1,200}$";
        if (!description.matches(regexCode)) {
            return new Notification(INVALID, "Description has max length is 200, is not contains special characters");
        }      
        return new Notification(VALID, "", description);
    }
}
