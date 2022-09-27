/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.Stu_MajorDTO;
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
public class Stu_MajorDAO {

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

    public ArrayList<Stu_MajorDTO> getAllStu_Major() throws NamingException, SQLException {

        String sql = "SELECT [Stu_Major]\n"
                + "      ,[StudentId]\n"
                + "      ,[MajorId]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[Stu_Major]";

        ArrayList<Stu_MajorDTO> lst = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    int stuId = rs.getInt("StudentId");
                    String majorId = rs.getString("MajorId");
                    boolean status = rs.getBoolean("Status");

                    StudentDAO stuDao = new StudentDAO();
                    MajorDAO majorDao = new MajorDAO();

                    Stu_MajorDTO stu_major = new Stu_MajorDTO(stuDao.getStudentById(stuId), majorDao.getMajorById(majorId), status);

                    lst.add(stu_major);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(Stu_MajorDTO stu_major) throws SQLException {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Stu_Major]"
                    + "(      [StudentId]\n"
                    + "(      [MajorId]\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, stu_major.getStudent().getStudentId());
            pstm.setString(2, stu_major.getMajor().getMajorId());
            pstm.setBoolean(3, true);

            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }
    
    public boolean update(Stu_MajorDTO stu_major) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Stu_Major] SET"
                + "      ,[Status]=?\n"
                + " WHERE MajorId=? AND StudentId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setBoolean(1, stu_major.isStatus());
                pstm.setString(2, stu_major.getMajor().getMajorId());
                pstm.setInt(3, stu_major.getStudent().getStudentId());
                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public boolean delete(Stu_MajorDTO stu_major) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Stu_Major] SET"
                + "      ,[Status]=?\n"
                + " WHERE MajorId=? AND StudentId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setBoolean(1, false);
                pstm.setString(2, stu_major.getMajor().getMajorId());
                pstm.setInt(3, stu_major.getStudent().getStudentId());
                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
