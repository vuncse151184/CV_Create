/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.StudentDTO;
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
public class StudentDAO {

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

    public ArrayList<StudentDTO> getAllStudent() throws NamingException, SQLException {

        String sql = "SELECT [StudentId]\n"
                + "      ,[JobPosition]\n"
                + "      ,[EduQua]\n"
                + "      ,[Experience]\n"
                + "      ,[StuName]\n"
                + "      ,[PhoneNum]\n"
                + "      ,[Addr]\n"
                + "      ,[Email]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[Student]";

        ArrayList<StudentDTO> lst = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("StudentId");
                    String job = rs.getString("JobPosition");
                    String edu = rs.getString("EduQua");
                    int exp = rs.getInt("Experience");
                    String name = rs.getString("StuName");
                    String phone = rs.getString("PhoneNum");
                    String addr = rs.getString("Addr");
                    String email = rs.getString("Email");
                    boolean status = rs.getBoolean("Status");

                    StudentDTO stu = new StudentDTO(id, job, edu, exp, name, phone, addr, email, status);

                    lst.add(stu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(StudentDTO stu) throws SQLException, NamingException {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Student]"
                    + "(      [JobPosition]\n"
                    + "      ,[EduQua]\n"
                    + "      ,[Experience]\n"
                    + "      ,[StuName]\n"
                    + "      ,[PhoneNum]\n"
                    + "      ,[Addr]\n"
                    + "      ,[Email]\n"
                    + "      ,[Status]\n)"
                    + "Values(?,?,?,?,?,?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, stu.getJobPosition());
            pstm.setString(2, stu.getEduQua());
            pstm.setInt(3, stu.getExperience());
            pstm.setString(4, stu.getStuName());
            pstm.setString(5, stu.getPhoneNum());
            pstm.setString(6, stu.getAddr());
            pstm.setString(7, stu.getEmail());
            pstm.setBoolean(8, true);

            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From Student\n"
                    + "Where StudentId=?";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(StudentDTO stu) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Student] SET"
                + " JobPosition=?"
                + ", EduQua=?"
                + ", Experience=?"
                + ", StuName=?"
                + ", PhoneNum=?"
                + ", Addr=?"
                + ", Email=?"
                + ", Status=?"
                + " WHERE StudentId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setString(1, stu.getJobPosition());
                pstm.setString(2, stu.getEduQua());
                pstm.setInt(3, stu.getExperience());
                pstm.setString(4, stu.getStuName());
                pstm.setString(5, stu.getPhoneNum());
                pstm.setString(8, stu.getAddr());
                pstm.setString(7, stu.getEmail());
                pstm.setBoolean(8, stu.isStatus());
                pstm.setInt(9, stu.getStudentId());
                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public StudentDTO getStudentById(int id) throws Exception {
        StudentDTO result = null;
        try {
            String sql = "SELECT [StudentId]\n"
                    + " ,[JobPosition]\n"
                    + ",[EduQua]\n"
                    + " ,[Experience]\n"
                    + " ,[StuName]\n"
                    + " ,[PhoneNum]\n"
                    + " ,[Addr]\n"
                    + " ,[Email]\n"
                    + " ,[Status]\n"
                    + " FROM [StudentCV].[dbo].[Student]\n"
                    + "Where StudentId=?\n";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String jobPosition = rs.getString("JobPosition");
                String eduQua = rs.getString("EduQua");
                int experience = rs.getInt("Experience");
                String stuName = rs.getString("StuName");
                String phoneNum = rs.getString("PhoneNum");
                String addr = rs.getString("Addr");
                String email = rs.getString("Email");
                boolean status = rs.getBoolean("Status");
                result = new StudentDTO(id, jobPosition, eduQua, experience, stuName, phoneNum, addr, email, status);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public StudentDTO getStudentByEmail(String email) throws Exception {
        StudentDTO result = null;
        try {
            String sql = "SELECT [StudentId],[JobPosition],[EduQua],[Experience],[StuName],[PhoneNum],[Addr],[Email],[Status]\n"
                    + "FROM [StudentCV].[dbo].[Student]\n"
                    + "Where Email like '"+email+"'";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String jobPosition = rs.getString("JobPosition");
                String eduQua = rs.getString("EduQua");
                int experience = rs.getInt("Experience");
                String stuName = rs.getString("StuName");
                String phoneNum = rs.getString("PhoneNum");
                String addr = rs.getString("Addr");
                int id = rs.getInt("StudentID");
                boolean status = rs.getBoolean("Status");
                result = new StudentDTO(id, jobPosition, eduQua, experience, stuName, phoneNum, addr, email, status);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}