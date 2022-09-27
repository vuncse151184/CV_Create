/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.Company_CareerDTO;
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
public class Company_Career {

    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public Company_Career() {
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

    public ArrayList<Company_CareerDTO> getAllCompany_Career() throws NamingException, SQLException {

        String sql = "SELECT [CareerId]\n"
                + "      ,[CompanyId]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[Company_career]";

        ArrayList<Company_CareerDTO> lst = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    int caId = rs.getInt("CareerId");
                    String coId = rs.getString("CompanyId");
                    Boolean status = rs.getBoolean("Status");

                    CareerDAO caDAO = new CareerDAO();
                    CompanyDAO coDAO = new CompanyDAO();

                    Company_CareerDTO c_career = new Company_CareerDTO(caDAO.getCareerById(caId), coDAO.getCompanybyId(coId), status);

                    lst.add(c_career);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(Company_CareerDTO com) throws SQLException {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Company_career]"
                    + "(      [CareerId]\n"
                    + "      ,[CompanyId])\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, com.getCareer().getCareerId());
            pstm.setString(2, com.getCompany().getCompanyId());
            pstm.setBoolean(3, com.isStatus());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean update(Company_CareerDTO com) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[Company_career] SET"
                + "Status=?"
                + "WHERE CareerId=? AND CompanyId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setBoolean(1, com.isStatus());
                pstm.setInt(2, com.getCareer().getCareerId());
                pstm.setString(3, com.getCompany().getCompanyId());

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(Company_CareerDTO com) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[Company_career] SET"
                + "Status=?"
                + "WHERE CareerId=? AND CompanyId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setBoolean(1, com.isStatus());
                pstm.setInt(2, com.getCareer().getCareerId());
                pstm.setString(3, com.getCompany().getCompanyId());

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
