/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.SkillDTO;
import com.studentCV.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tungn
 */
public class SkillDAO {

    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    private void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public ArrayList<SkillDTO> getAllSkill() throws SQLException {
        String sql = "SELECT [SkillId]\n"
                + "      ,[SkillName]\n"
                + "      ,[SkillType]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[Skill]";
        ArrayList<SkillDTO> lst = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("SkillId");
                    String name = rs.getString("SkillName");
                    String type = rs.getString("SkillType");
                    boolean status = rs.getBoolean("Status");

                    SkillDTO skill = new SkillDTO(id, name, type, status);
                    lst.add(skill);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(SkillDTO skill) throws SQLException {
        boolean check = false;
        String sql = "Insert INTO [StudentCV].[dbo].[Skill]"
                + "(SkillId,SkillName,SkillType,Status)"
                + "Value (?,?,?,?)";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, skill.getSkillId());
                pstm.setString(2, skill.getSkillName());
                pstm.setString(3, skill.getSkillType());
                pstm.setBoolean(4, true);

                check = pstm.executeUpdate() > 0;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean update(SkillDTO skill) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[Skill] SET"
                + "SkillName=?,"
                + "SkillType=?"
                + "Status=?"
                + "WHERE SkillId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, skill.getSkillName());
                pstm.setString(2, skill.getSkillType());
                pstm.setBoolean(3, skill.isStatus());
                pstm.setString(4, skill.getSkillId());

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(SkillDTO skill) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[Skill] SET"
                + "SkillName=?,"
                + "SkillType=?"
                + "Status=?"
                + "WHERE SkillId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, skill.getSkillName());
                pstm.setString(2, skill.getSkillType());
                pstm.setBoolean(3, false);
                pstm.setString(4, skill.getSkillId());

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public SkillDTO getSkillById(String id) throws SQLException {
        String sql = "SELECT [SkillId]\n"
                + "      ,[SkillName]\n"
                + "      ,[SkillType]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[Skill]"
                + "  WHERE SkillId=?";
        SkillDTO skill = new SkillDTO();
        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, id);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("SkillName");
                    String type = rs.getString("SkillType");
                    boolean status = rs.getBoolean("Status");

                    skill = new SkillDTO(id, name, type, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return skill;
    }
}
