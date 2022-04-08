/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.brand;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import longbv.utils.DBHelpers;

/**
 *
 * @author longh
 */
public class BrandDAO implements Serializable {

    public ArrayList<BrandDTO> getAll() {
        Connection con = null;
        PreparedStatement pm = null;
        ResultSet rs = null;

        ArrayList<BrandDTO> brands = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelpers.makeConnection();
            //2. create sql statement
            String sql = "Select brandID, brandName, country, description "
                    + "From TblBrand";
            //3. create statement set sql
            pm = con.prepareStatement(sql);
            //4. excute SQL query
            rs = pm.executeQuery();
            while (rs.next()) {
                String brandID = rs.getString("brandID");
                String brandName = rs.getString("brandName");
                String country = rs.getString("country");
                String description = rs.getString("description");
                BrandDTO brand = new BrandDTO(brandID, brandName, country, description);
                brands.add(brand);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pm != null) {
                    pm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
        return brands;
    }

    public String getBrandNameByID(String brandID) {
        Connection con = null;
        PreparedStatement pm = null;
        ResultSet rs = null;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "Select brandName "
                        + "From TblBrand "
                        + "Where brandID = ?";
                //create statement to DBI
                pm = con.prepareStatement(sql);

                pm.setString(1, brandID);

                rs = pm.executeQuery();
                if (rs.next()) {
                    return rs.getString("brandName");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pm != null) {
                    pm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
        return null;
    }

    public boolean addBrand(BrandDTO brand) {
        Connection con = null;
        PreparedStatement pm = null;
        int rs = 0;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "Insert into TblBrand(brandID, brandName, country, description) "
                        + "values (?, ?, ?, ?)";
                //create statement to DBI

                pm = con.prepareStatement(sql);

                pm.setString(1, brand.getBrandID());
                pm.setString(2, brand.getBrandName());
                pm.setString(3, brand.getCountry());
                pm.setString(4, brand.getDescription());

                rs = pm.executeUpdate();
                if (rs != 0) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (pm != null) {
                    pm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean updateBrand(BrandDTO brand) {
        Connection con = null;
        PreparedStatement pm = null;
        int rs = 0;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "Update TblBrand "
                        + "Set brandName = ?, country = ?, description = ? "
                        + "Where brandID = ?";
                //create statement to DBI
                pm = con.prepareStatement(sql);

                pm.setString(1, brand.getBrandName());
                pm.setString(2, brand.getCountry());
                pm.setString(3, brand.getDescription());
                pm.setString(4, brand.getBrandID());
                rs = pm.executeUpdate();
                if (rs != 0) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (pm != null) {
                    pm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean deleteBrand(String brandID) {
        Connection con = null;
        PreparedStatement pm = null;
        int rs = 0;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "Delete TblBrand "
                        + "Where brandID = ?";
                //create statement to DBI
                pm = con.prepareStatement(sql);

                pm.setString(1, brandID);

                rs = pm.executeUpdate();
                if (rs != 0) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (pm != null) {
                    pm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
        return false;
    }
}
