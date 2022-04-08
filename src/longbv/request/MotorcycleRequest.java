/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.request;

/**
 *
 * @author longh
 */
public class MotorcycleRequest {
    private String motorID;
    private String model;
    private String year;
    private String condition;
    private String price;
    private String quantity;
    private String warranty;
    private String brandID;

    public MotorcycleRequest() {
    }

    public MotorcycleRequest(String motorID, String model, String year, String condition, String price, String quantity, String warranty, String brandID) {
        this.motorID = motorID;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.warranty = warranty;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }
    
            
}
