/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.motorcycle;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author longh
 */
public class MotorcycleDTO implements Serializable{
    private String motorID;
    private String model;
    private Date year;
    private String condition;
    private double price;
    private int quantity;
    private String warranty;
    private String brandID;

    public MotorcycleDTO() {
    }

    public MotorcycleDTO(String motorID, String model, Date year, String condition, double price, int quantity, String warranty, String brandID) {
        this.motorID = motorID;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.warranty = warranty;
        this.brandID = brandID;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getMotorID() {
        return motorID;
    }

    public void setMotorID(String motorID) {
        this.motorID = motorID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
    
}
