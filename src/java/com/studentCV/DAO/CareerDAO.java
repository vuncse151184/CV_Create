/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.CareerDTO;
import com.studentCV.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Asus
 */
public class CareerDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public CareerDAO() {

    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public ArrayList<CareerDTO> getAllCareer() throws Exception {

        String sql = "Select CareerId,\n"
                + "	CareerName,\n"
                + "     Status\n"
                + "From Career\n";
        ArrayList<CareerDTO> lst = new ArrayList<>();
        try {
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            rs = pstm.executeQuery();
            if (rs.next()) {
                int cid = rs.getInt("CareerId");
                String cname = rs.getString("CareerName");
                Boolean status = rs.getBoolean("Status");
                CareerDTO career = new CareerDTO(cid, cname, status);
                lst.add(career);
            }
        } finally {
            closeConnection();
        }
        return lst;
    }

    public CareerDTO getCareerById(int id) throws NamingException, SQLException, Exception {
        CareerDTO result = null;
        String sql = "Select CareerName,\n"
                + "	Status\n"
                + "From Career\n"
                + "Where CareerId =?";

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                pstm.setInt(1, id);
                while (rs.next()) {
                    String cname = rs.getString("CareerName");                   
                    Boolean status = rs.getBoolean("Status");
                    result = new CareerDTO(id, cname, status);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(CareerDTO c) throws SQLException, Exception {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Career]"
                    + "      ,([CareerId]\n"
                    + "      ,([CareerName]\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, c.getCareerId());
            pstm.setString(2, c.getCareerName());
            pstm.setBoolean(3, c.isStatus());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(CareerDTO c) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE [StudentCV].[dbo].[Career] SET"
                    + "      ,[Status]=?\n"
                    + " WHERE CareerId=?";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setBoolean(1, c.isStatus());
            pstm.setInt(2, c.getCareerId());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(CareerDTO c) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Career] SET"
                + "      ,([Specialization]\n"
                + "      ,([CareerName]\n"
                + "      ,[Status])\n"
                + "Values(?,?,?)"
                + " WHERE CareerId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setInt(1, c.getCareerId());
                pstm.setString(2, c.getCareerName());
                pstm.setBoolean(3, c.isStatus());
                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
