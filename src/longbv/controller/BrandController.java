/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.controller;

import longbv.brand.BrandDTO;
import longbv.request.BrandRequest;
import longbv.utils.Notification;
import longbv.utils.ValidatorBrand;

/**
 *
 * @author longh
 */
public class BrandController {
    public static Notification saveBrand(BrandRequest bRequest, boolean mode){
        String brandID = bRequest.getBrandID();
        String brandName = bRequest.getBrandName();
        String country = bRequest.getCountry();
        String description = bRequest.getDescription();
        
        if(!ValidatorBrand.isValidBrandID(brandID, mode).isResult()){
            return ValidatorBrand.isValidBrandID(brandID, mode);
        }
        String cur_id = (String)ValidatorBrand.isValidBrandID(brandID, mode).getData();
        
        if(!ValidatorBrand.isValidBrandName(brandName).isResult()){
            return ValidatorBrand.isValidBrandName(brandName);
        }
        String cur_name = (String)ValidatorBrand.isValidBrandName(brandName).getData();
        
        if(!ValidatorBrand.isValidCountry(country).isResult()){
            return ValidatorBrand.isValidCountry(country);
        }
        String cur_country = (String)ValidatorBrand.isValidCountry(country).getData();
        
        if(!ValidatorBrand.isValidDesciption(description).isResult()){
            return ValidatorBrand.isValidDesciption(description);
        }
        String cur_des = (String)ValidatorBrand.isValidDesciption(description).getData();
        
        BrandDTO brand = new BrandDTO(cur_id, cur_name, cur_country, cur_des);
        
        return new Notification(true, "Add successfully!", brand);
    }
}
