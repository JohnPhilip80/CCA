package edu.mce.john.mobile.repositories;

import edu.mce.john.mobile.interfaces.MobileCRUD;
import edu.mce.john.mobile.models.Mobile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MobileRepository implements MobileCRUD {
    private List<Mobile> mobiles;

    public MobileRepository() {
        mobiles = new ArrayList<Mobile>();
    }

    @Override
    public int createMobile(Mobile mobile) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO mobile (brand,model,year_launched,price) VALUES (?,?,?,?)";
        int rowsInserted = 0;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_db",
                    "root","Admin@123");
            ps = con.prepareStatement(query);
            ps.setString(1,mobile.getBrand());
            ps.setString(2, mobile.getModel());
            ps.setInt(3, mobile.getYearLaunched());
            ps.setDouble(4, mobile.getPrice());
            rowsInserted = ps.executeUpdate();
            ps.close();
            con.close();
        }catch (SQLException e) {
            System.err.println("Error While creating new Mobile: " + e.getMessage());
        }

        return rowsInserted;
    }

    @Override
    public List<Mobile> readMobiles() {
        mobiles.clear();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT id,brand,model,year_launched,price FROM mobile";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_db",
                    "root","Admin@123");
            ps = con.prepareStatement(query);
            rs=ps.executeQuery();

            while(rs.next()) {
                Long id = rs.getLong(1);
                String brand = rs.getString(2);
                String model = rs.getString(3);
                Integer yearLaunched = rs.getInt(4);
                Double price = rs.getDouble(5);
                mobiles.add(new Mobile(id,brand,model,yearLaunched,price));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error while reading all Mobiles: " + e.getMessage());
        }
        return mobiles;
    }

    @Override
    public int updateMobile(Mobile mobile) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "UPDATE mobile SET brand=?,model=?,year_launched=?,price=? WHERE id = ?";
        int rowsUpdated = 0;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_db",
                    "root","Admin@123");
            ps = con.prepareStatement(query);
            ps.setString(1,mobile.getBrand());
            ps.setString(2, mobile.getModel());
            ps.setInt(3, mobile.getYearLaunched());
            ps.setDouble(4, mobile.getPrice());
            ps.setLong(5, mobile.getId());
            rowsUpdated = ps.executeUpdate();
            ps.close();
            con.close();
        }catch (SQLException e) {
            System.err.println("Error while updating Mobile: " + e.getMessage());
        }
        return rowsUpdated;
    }

    @Override
    public int deleteMobile(Long id) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "DELETE FROM mobile WHERE id = ?";
        int rowsDeleted = 0;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_db",
                    "root","Admin@123");
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rowsDeleted = ps.executeUpdate();
            ps.close();
            con.close();
        }catch (SQLException e) {
            System.err.println("Error While deleting Mobile: " + e.getMessage());
        }
        return rowsDeleted;
    }

    @Override
    public Mobile readMobile(Long id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Mobile mobile = null;
        String query = "SELECT id,brand,model,year_launched,price FROM mobile WHERE id=?";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_db",
                    "root","Admin@123");
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while(rs.next()) {
                String brand = rs.getString(2);
                String model = rs.getString(3);
                Integer yearLaunched = rs.getInt(4);
                Double price = rs.getDouble(5);
                mobile = new Mobile(id,brand,model,yearLaunched,price);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error While reading a Mobile: " + e.getMessage());
        }
        return mobile;
    }
}







