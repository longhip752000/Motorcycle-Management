/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import longbv.utils.DBHelpers;

/**
 *
 * @author longh
 */
public class UserDAO implements Serializable {

    public boolean checkLogin(String userID, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pm = null;
        ResultSet rs = null;

        try {
            con = DBHelpers.makeConnection();

            if (con != null) {
                String sql = "Select fullName, status "
                        + "From tblUser "
                        + "Where userID = ? and password = ?";

                pm = con.prepareStatement(sql);

                pm.setString(1, userID);
                pm.setString(2, password);
                
                rs = pm.executeQuery();
                
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pm != null) {
                pm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
