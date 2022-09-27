/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.Stu_SkillDTO;
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
public class Stu_SkillDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

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

    public ArrayList<Stu_SkillDTO> getAllStu_Skill() throws SQLException {
        ArrayList<Stu_SkillDTO> lst = new ArrayList<>();
        String sql = "SELECT [StudentId]\n"
                + "      ,[SkillId]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[Stu_Skill]";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int studenId = rs.getInt("StudentId");
                    String skillId = rs.getString("SkillId");
                    boolean status = rs.getBoolean("Status");
                    StudentDAO stuDao = new StudentDAO();
                    SkillDAO skillDao = new SkillDAO();
                    Stu_SkillDTO stu_skill = new Stu_SkillDTO(stuDao.getStudentById(studenId), skillDao.getSkillById(skillId), status);
                    lst.add(stu_skill);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(Stu_SkillDTO stu_skill) throws SQLException {
        boolean check = false;
        String sql = "Insert INTO [StudentCV].[dbo].[Stu_Skill]"
                + " (StudentId,SkillId,Status)"
                + " Value(?,?,?)";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, stu_skill.getStudent().getStudentId());
                pstm.setString(2, stu_skill.getSkill().getSkillId());
                pstm.setBoolean(3, true);

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(Stu_SkillDTO stu_skill) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[Stu_Skill] SET"
                + "Status=?"
                + "WHERE StudentId=? AND SkillId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setBoolean(1, stu_skill.isStatus());
                pstm.setString(2, stu_skill.getSkill().getSkillId());
                pstm.setInt(3, stu_skill.getStudent().getStudentId());

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public boolean delete(Stu_SkillDTO stu_skill) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[Stu_Skill] SET"
                + "Status=?"
                + "WHERE StudentId=? AND SkillId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setBoolean(1, false);
                pstm.setString(2, stu_skill.getSkill().getSkillId());
                pstm.setInt(3, stu_skill.getStudent().getStudentId());

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
}
