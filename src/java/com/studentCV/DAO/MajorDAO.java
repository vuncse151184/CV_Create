/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.MajorDTO;
import com.studentCV.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author tungp
 */
public class MajorDAO {

    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    private void closeConnection() throws SQLException {
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

    public ArrayList<MajorDTO> getAllMajor() throws NamingException, SQLException {

        String sql = "SELECT [MajorId]\n"
                + "      ,[MajorName]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[Major]";

        ArrayList<MajorDTO> lst = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("MajorId");
                    String name = rs.getString("MajorName");
                    boolean status = rs.getBoolean("Status");

                    MajorDTO major = new MajorDTO(id, name, status);

                    lst.add(major);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(MajorDTO major) throws SQLException {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Major]"
                    + "      ,([MajorId]\n"
                    + "      ,[MajorName]\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, major.getMajorId());
            pstm.setString(2, major.getMajorName());
            pstm.setBoolean(3, true);

            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(MajorDTO major) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Major] SET"
                + "      ,[MajorName]=?\n"
                + "      ,[Status]=?\n"
                + " WHERE MajorId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setString(1, major.getMajorName());
                pstm.setString(2, major.getMajorId());
                pstm.setBoolean(3, false);
                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean update(MajorDTO major) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Major] SET"
                + "      ,[MajorName]=?\n"
                + "      ,[Status]=?\n"
                + " WHERE MajorId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setString(1, major.getMajorName());
                pstm.setString(2, major.getMajorId());
                pstm.setBoolean(3, major.isStatus());
                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public MajorDTO getMajorById(String id) throws Exception {
        MajorDTO result = null;
        try {
            String sql = "SELECT [MajorId]\n"
                    + "      ,[MajorName]\n"
                    + "      ,[Status]\n"
                    + "  FROM [StudentCV].[dbo].[Major]"
                    + "Where MajorId=?\n";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("MajorName");
                boolean status = rs.getBoolean("Status");

                result = new MajorDTO(id, name, status);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
