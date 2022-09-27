/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.CV_CompanyDTO;
import com.studentCV.DTO.Company_CareerDTO;
import com.studentCV.DTO.Stu_JobDTO;
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
public class CV_CompanyDAO {

    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public CV_CompanyDAO() {
    }

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

    public ArrayList<CV_CompanyDTO> getAllCv_Company() throws NamingException, SQLException {

        String sql = "SELECT [CvId]\n"
                + "      ,[CompanyId]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[CV_company]";

        ArrayList<CV_CompanyDTO> lst = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    int cvId = rs.getInt("CvId");
                    String coId = rs.getString("CompanyId");
                    Boolean status = rs.getBoolean("Status");

                    CV_DAO cvDAO = new CV_DAO();
                    CompanyDAO coDAO = new CompanyDAO();

                    CV_CompanyDTO cv_com = new CV_CompanyDTO(cvDAO.getCVbyID(cvId), coDAO.getCompanybyId(coId), status);

                    lst.add(cv_com);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(CV_CompanyDTO cv_com) throws SQLException {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[CV_company]"
                    + "      ,[CompanyId])\n"
                    + "      ,[Status])\n"
                    + "Values(?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cv_com.getCompany().getCompanyId());
            pstm.setBoolean(2, cv_com.isStatus());

            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean update(CV_CompanyDTO cv_com) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[CV_company] SET"
                + "Status=?"            
                + "WHERE CvId=? AND CompanyId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setBoolean(1, cv_com.isStatus());
                pstm.setInt(2, cv_com.getCv().getCvId());
                pstm.setString(3, cv_com.getCompany().getCompanyId());

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(CV_CompanyDTO cv_com) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[CV_company] SET"
                + "Status=?"            
                + "WHERE CvId=? AND CompanyId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setBoolean(1, cv_com.isStatus());
                pstm.setInt(2, cv_com.getCv().getCvId());
                pstm.setString(3, cv_com.getCompany().getCompanyId());

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
}
