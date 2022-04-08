/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.controller;

import java.util.Date;
import longbv.motorcycle.MotorcycleDAO;
import longbv.motorcycle.MotorcycleDTO;
import longbv.request.MotorcycleRequest;
import longbv.utils.Notification;
import longbv.utils.ValidatorBrand;
import longbv.utils.ValidatorMotor;

/**
 *
 * @author longh
 */
public class MotorcycleController {

    public static Notification saveMotor(MotorcycleRequest mRequest, boolean mode){
        //lay request ra
        String motorID = mRequest.getMotorID();
        String model = mRequest.getModel();
        String yearStr = mRequest.getYear();
        String condition = mRequest.getCondition();
        String priceStr = mRequest.getPrice();
        String quantityStr = mRequest.getQuantity();
        String warranty = mRequest.getWarranty();
        String brandID = mRequest.getBrandID();
        
        if(!ValidatorMotor.isValidID(motorID, mode).isResult()){
            return ValidatorMotor.isValidID(motorID, mode);
        }
        String cur_id = (String)ValidatorMotor.isValidID(motorID, mode).getData();
        
        if(!ValidatorMotor.isValidModel(model).isResult()){
            return ValidatorMotor.isValidModel(model);
        }
        String cur_model = (String)ValidatorMotor.isValidModel(model).getData();
        
        if(!ValidatorMotor.isValidYear(yearStr).isResult()){
            return ValidatorMotor.isValidYear(yearStr);
        }
        
        Date year = (Date)ValidatorMotor.isValidYear(yearStr).getData();
        
        if(!ValidatorMotor.isValidCondition(condition).isResult()){
            return ValidatorMotor.isValidCondition(condition);
        }
        String cur_condition = (String)ValidatorMotor.isValidCondition(condition).getData();
        
        if(!ValidatorMotor.isValidPrice(priceStr).isResult()){
            return ValidatorMotor.isValidPrice(priceStr);
        }
        
        double price = (double)ValidatorMotor.isValidPrice(priceStr).getData();
        
        if(!ValidatorMotor.isValidQuantity(quantityStr).isResult()){
            return ValidatorMotor.isValidQuantity(quantityStr);
        }
        
        int quantity = (int)ValidatorMotor.isValidQuantity(quantityStr).getData();
        
        if(!ValidatorMotor.isValidWarranty(warranty).isResult()){
            return ValidatorMotor.isValidWarranty(warranty);
        }
        String cur_warranty = (String)ValidatorMotor.isValidWarranty(warranty).getData();
        
        
        MotorcycleDTO motor = new MotorcycleDTO(cur_id, cur_model, year, cur_condition, price, quantity, cur_warranty, brandID);
        
        return new Notification(true, "Add successfully!", motor);
        //xong validator
    }
}
