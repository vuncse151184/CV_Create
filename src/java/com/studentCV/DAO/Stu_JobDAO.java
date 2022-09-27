/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.Stu_JobDTO;
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
 * @author Asus
 */
public class Stu_JobDAO {

    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public Stu_JobDAO() {
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

    public ArrayList<Stu_JobDTO> getAllStu_Job() throws NamingException, SQLException {

        String sql = "SELECT [StudentId]\n"
                + "      ,[JobId]\n"
                + "      ,[Status]\n"
                + "  FROM [StudentCV].[dbo].[Stu_Job]";

        ArrayList<Stu_JobDTO> lst = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    int stuId = rs.getInt("StudentId");
                    int jobId = rs.getInt("JobId");
                    boolean status = rs.getBoolean("Status");

                    StudentDAO stuDao = new StudentDAO();
                    JobDAO jobDao = new JobDAO();

                    Stu_JobDTO stu_Job = new Stu_JobDTO(stuDao.getStudentById(stuId), jobDao.getJobById(jobId), status);

                    lst.add(stu_Job);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(Stu_JobDTO stu_job) throws SQLException {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Stu_Job]"
                    + "(      [StudentId]\n"
                    + "      ,[JobId]\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, stu_job.getStudent().getStudentId());
            pstm.setInt(2, stu_job.getJob().getJobId());
            pstm.setBoolean(3, true);

            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean update(Stu_JobDTO stu_job) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[Stu_Job] SET"
                + "Status=?"
                + "WHERE StudentId=? AND JobId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setBoolean(1, stu_job.isStatus());
                pstm.setInt(2, stu_job.getStudent().getStudentId());
                pstm.setInt(3, stu_job.getJob().getJobId());

                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(Stu_JobDTO stu_job) throws SQLException {
        boolean check = false;
        String sql = "UPDATE [StudentCV].[dbo].[Stu_Job] SET"
                + "Status=?"
                + "WHERE StudentId=? AND JobId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setBoolean(1, false);
                pstm.setInt(2, stu_job.getStudent().getStudentId());
                pstm.setInt(3, stu_job.getJob().getJobId());

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
