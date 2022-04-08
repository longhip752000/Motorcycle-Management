/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.motorcycle;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import longbv.utils.DBHelpers;

/**
 *
 * @author longh
 */
public class MotorcycleDAO implements Serializable {

    public ArrayList<MotorcycleDTO> getAll() {
        Connection con = null;
        PreparedStatement pm = null;
        ResultSet rs = null;

        ArrayList<MotorcycleDTO> motors = new ArrayList<>();

        try {
            //1. connect DB
            con = DBHelpers.makeConnection();
            //2. create sql statement
            String sql = "Select motorcycleID, model, year, condition, price, quantity, warranty, brandID "
                    + "From TblBike";
            //3. create statement set sql
            pm = con.prepareStatement(sql);
            //4. excute SQL query
            rs = pm.executeQuery();
            while (rs.next()) {

                String motorId = rs.getString("motorcycleID");
                String model = rs.getString("model");
                Date year = rs.getDate("year");
                String conditon = rs.getString("condition");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String warranty = rs.getString("warranty");
                String brandID = rs.getString("brandID");

                MotorcycleDTO motor = new MotorcycleDTO(motorId, model, year, conditon, price, quantity, warranty, brandID);
                motors.add(motor);
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
        return motors;
    }

    public MotorcycleDTO getMotorByID(String motorID) {
        Connection con = null;
        PreparedStatement pm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBHelpers.makeConnection();
            //2. create sql statement
            String sql = "Select model, year, condition, price, quantity, warranty, brandID "
                    + "From TblBike "
                    + "Where motorcycleID = ?";
            //3. create statement set sql
            pm = con.prepareStatement(sql);
            pm.setString(1, motorID);
            //4. excute SQL query
            rs = pm.executeQuery();
            if (rs.next()) {
                
                String model = rs.getString("model");
                Date year = rs.getDate("year");
                String conditon = rs.getString("condition");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String warranty = rs.getString("warranty");
                String brandID = rs.getString("brandID");

                MotorcycleDTO motor = new MotorcycleDTO(motorID, model, year, conditon, price, quantity, warranty, brandID);
                return motor;
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
        return null;
    }

    public boolean checkMotorExistInBrand(String brandID) {
        Connection con = null;
        PreparedStatement pm = null;
        ResultSet rs = null;

        try {
            //1. connect DB
            con = DBHelpers.makeConnection();
            //2. create sql statement
            String sql = "Select motorcycleID, model, year, condition, price, quantity, warranty "
                    + "From TblBike "
                    + "Where brandID = ?";
            //3. create statement set sql
            pm = con.prepareStatement(sql);
            pm.setString(1, brandID);
            //4. excute SQL query
            rs = pm.executeQuery();
            if (rs.next()) {
                
                return true;
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
        return false;
    }
    
    public boolean addMotor(MotorcycleDTO motor) {
        Connection con = null;
        PreparedStatement pm = null;
        int rs = 0;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "Insert into TblBike(motorcycleID, model, year, condition, price, quantity, warranty, brandID) "
                        + "values (?, ?, ?, ?, ?, ?, ?, ?)";
                //create statement to DBI
                pm = con.prepareStatement(sql);

                pm.setString(1, motor.getMotorID());
                pm.setString(2, motor.getModel());
                pm.setTimestamp(3, new Timestamp(motor.getYear().getTime()));
                pm.setString(4, motor.getCondition());
                pm.setDouble(5, motor.getPrice());
                pm.setInt(6, motor.getQuantity());
                pm.setString(7, motor.getWarranty());
                pm.setString(8, motor.getBrandID());

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

    public boolean updateMotor(MotorcycleDTO motor) {
        Connection con = null;
        PreparedStatement pm = null;
        int rs = 0;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "Update TblBike "
                        + "Set model = ?, year = ?, condition = ?, price = ?, quantity = ?, warranty = ?, brandID = ? "
                        + "Where motorcycleID = ?";
                //create statement to DBI
                pm = con.prepareStatement(sql);
                pm.setString(1, motor.getModel());
                pm.setTimestamp(2, new Timestamp(motor.getYear().getTime()));
                pm.setString(3, motor.getCondition());
                pm.setDouble(4, motor.getPrice());
                pm.setInt(5, motor.getQuantity());
                pm.setString(6, motor.getWarranty());
                pm.setString(7, motor.getBrandID());
                pm.setString(8, motor.getMotorID());

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

    public boolean deleteMotor(String motorcycleID) {
        Connection con = null;
        PreparedStatement pm = null;
        int rs = 0;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "Delete TblBike "
                        + "Where motorcycleID = ?";
                //create statement to DBI
                pm = con.prepareStatement(sql);

                pm.setString(1, motorcycleID);

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
