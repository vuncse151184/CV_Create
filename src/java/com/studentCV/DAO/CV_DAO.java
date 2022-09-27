/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.CV_DTO;
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
public class CV_DAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public CV_DAO() {

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

    public ArrayList<CV_DTO> getAllCV() throws Exception {

        String sql = "Select CvId,\n"
                + "	StudentId,\n"
                + "     Status\n"
                + "From CV\n";
        ArrayList<CV_DTO> lst = new ArrayList<>();
        try {
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            rs = pstm.executeQuery();
            if (rs.next()) {
                int cvid = rs.getInt("CvId");
                int stdId = rs.getInt("StudentId");
                Boolean status = rs.getBoolean("Status");
                StudentDAO sDao = new StudentDAO();
                CV_DTO c = new CV_DTO(cvid, sDao.getStudentById(stdId), status);
                lst.add(c);
            }
        } finally {
            closeConnection();
        }
        return lst;
    }

    public CV_DTO getCVbyID(int id) throws NamingException, SQLException, Exception {
        CV_DTO result = null;
        String sql = "Select	StudentId,\n"
                + "     Status\n"
                + "From CV\n"
                + "Where CvID=?";

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                pstm.setInt(1, id);
                while (rs.next()) {
                    int sid = rs.getInt("StudentId");
                    Boolean status = rs.getBoolean("Status");
                    StudentDAO sDao = new StudentDAO();
                    result = new CV_DTO(id, sDao.getStudentById(sid), status);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(CV_DTO cv) throws SQLException, Exception {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[CV]"
                    + "      ,([CvId]\n"
                    + "      ,([StudentId]\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, cv.getCvId());
            pstm.setInt(2, cv.getStudent().getStudentId());
            pstm.setBoolean(3, cv.isStatus());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(CV_DTO c) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE [StudentCV].[dbo].[CV] SET"
                    + "      ,[Status]=?\n"
                    + " WHERE CvId=?";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setBoolean(1, c.isStatus());
            pstm.setInt(2, c.getCvId());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(CV_DTO c) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[CV] SET"
                + "      ,([StudentId]\n"
                + "      ,[Status])\n"
                + "Values(?,?)"
                + " WHERE CvId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setInt(1, c.getStudent().getStudentId());
                pstm.setBoolean(2, c.isStatus());
                pstm.setInt(3, c.getCvId());

                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
