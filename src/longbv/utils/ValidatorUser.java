/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author longh
 */
public class ValidatorUser {
    public static boolean checkUserID(String userID){
        if (userID.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input ID!");
            return false;
        }
        String regexCode = "^[a-zA-Z0-9]{1,10}$";
        if (userID.length() > 10) {
            JOptionPane.showMessageDialog(null, "ID has max length is 10, is not contains special characters");
            return false;
        }
        return true;
    }
    

    public static boolean checkPassword(String password) {
        if (password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input password!");
            return false;
        }
        if (password.length() > 50 || password.length() < 3) {
            JOptionPane.showMessageDialog(null, "Password has length 3 - 50");
            return false;
        }
        return true;
    }
}
