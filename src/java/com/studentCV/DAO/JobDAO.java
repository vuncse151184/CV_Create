/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.JobDTO;
import com.studentCV.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Asus
 */
public class JobDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public JobDAO() {

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

    public ArrayList<JobDTO> getAllJob() throws Exception {

        String sql = "Select JobId,CompanyId,JobReq,JobName,Salary,JobType,\n"
                + "JobLocation,JobExperience,JobPostDate,JobDescription,Status\n"
                + "From Job ";
        ArrayList<JobDTO> lst = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);    
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int jid = rs.getInt("JobId");
                    String cid = rs.getString("CompanyId");
                    String jreq = rs.getString("JobReq");
                    String jname = rs.getString("JobName");
                    float salary = rs.getFloat("Salary");
                    String jtype = rs.getString("JobType");
                    String jloc = rs.getString("JobLocation");
                    String jexp = rs.getString("JobExperience");
                    LocalDate jpdate = LocalDate.parse(rs.getString("JobPostDate"));
                    String jdes = rs.getString("JobDescription");
                    boolean status = rs.getBoolean("Status");

                    CompanyDAO c = new CompanyDAO();

                    JobDTO job = new JobDTO(jid, c.getCompanybyId(cid), jreq, jname, salary, jtype, jloc, jexp, jpdate, jdes, status);
                    lst.add(job);
                }
            }
        } finally {
            closeConnection();
        }
        return lst;
    }

    public JobDTO getJobById(int id) throws NamingException, SQLException, Exception {
        JobDTO result = null;
        String sql = "Select CompanyId, "
                + "	JobReq, "
                + "	JobName, "
                + "	Salary, "
                + "	JobType, "
                + "	JobLocation, "
                + "	JobExperience, "
                + "	JobPostDate, "
                + "	JobDescription, "
                + "     Status  "
                + "From Job "
                + "Where JobId =?";

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, id);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String cid = rs.getString("CompanyId");
                    String jname = rs.getString("JobName");
                    String jreq = rs.getString("JobReq");
                    float salary = rs.getFloat("Salary");
                    String jtype = rs.getString("JobType");
                    String jloca = rs.getString("JobLocation");
                    String jexp = rs.getString("JobExperience");
                    LocalDate jpdate = LocalDate.parse(rs.getString("JobPostDate"));
                    String jdes = rs.getString("JobDescription");
                    boolean status = rs.getBoolean("Status");
                    CompanyDAO c = new CompanyDAO();
                    result = new JobDTO(id, c.getCompanybyId(cid), jreq, jname, salary, jtype, jloca, jexp, jpdate, jdes, status);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(JobDTO job) throws SQLException, Exception {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Job]"
                    + "      ,([JobId] "
                    + "      ,([CompanyId] "
                    + "      ,([JobName] "
                    + "      ,([JobReq] "
                    + "      ,([Salary] "
                    + "      ,([JobType] "
                    + "      ,([JobLocation] "
                    + "      ,[JobExperience]) "
                    + "      ,[JobPostDate]) "
                    + "      ,[JobDescription]) "
                    + "      ,[Status]) "
                    + "Values(?,?,?,?,?,?,?,?,?,?,?)";
            con = DBUtils.makeConnection();

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, job.getJobId());
            pstm.setString(2, job.getCompany().getCompanyId());
            pstm.setString(3, job.getJobName());
            pstm.setString(4, job.getJobReq());
            pstm.setFloat(5, job.getSalary());
            pstm.setString(6, job.getJobType());
            pstm.setString(7, job.getJobLocation());
            pstm.setString(8, job.getJobExperience());
            pstm.setDate(9, java.sql.Date.valueOf(job.getJobPostDate()));
            pstm.setString(10, job.getJobDescription());
            pstm.setBoolean(11, job.isStatus());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(JobDTO job) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE [StudentCV].[dbo].[Job] SET"
                    + "      ,[Status]=? "
                    + " WHERE JobId=?";
            con = DBUtils.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setBoolean(1, job.isStatus());
            pstm.setInt(2, job.getJobId());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(JobDTO job) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Job] SET"
                + "      ,([JobId] "
                + "      ,([CompanyId] "
                + "      ,([JobName] "
                + "      ,([JobReq] "
                + "      ,([Salary] "
                + "      ,([JobType] "
                + "      ,([JobLocation] "
                + "      ,[JobExperience]) "
                + "      ,[JobPostDate]) "
                + "      ,[JobDescription]) "
                + "      ,[Status]) "
                + "Values(?,?,?,?,?,?,?,?,?,?,?)"
                + " WHERE JobId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, job.getJobId());
                pstm.setString(2, job.getCompany().getCompanyId());
                pstm.setString(3, job.getJobName());
                pstm.setString(4, job.getJobReq());
                pstm.setFloat(5, job.getSalary());
                pstm.setString(6, job.getJobType());
                pstm.setString(7, job.getJobLocation());
                pstm.setString(8, job.getJobExperience());
                pstm.setDate(9, java.sql.Date.valueOf(job.getJobPostDate()));
                pstm.setString(10, job.getJobDescription());
                pstm.setBoolean(11, job.isStatus());

                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

        public ArrayList<JobDTO> searchByType(String name, String type) throws NamingException, SQLException, Exception {
        JobDTO result = null;
        String sql = "Select JobId,"
                + "     CompanyId, "
                + "	JobReq, "
                + "	JobName, "
                + "	Salary, "
                + "	JobType, "
                + "	JobLocation, "
                + "	JobExperience, "
                + "	JobPostDate, "
                + "	JobDescription, "
                + "     Status  "
                + "From Job "
                + "Where JobName Like ? " 
                + "And JobType = ? ";
        
        ArrayList<JobDTO> lst = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, "%" + name + "%");
                pstm.setString(2, type);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int jid = rs.getInt("JobId");
                    String cid = rs.getString("CompanyId");
                    String jreq = rs.getString("JobReq");
                    String jname = rs.getString("JobName");
                    float salary = rs.getFloat("Salary");
                    String jtype = rs.getString("JobType");
                    String jloc = rs.getString("JobLocation");
                    String jexp = rs.getString("JobExperience");
                    LocalDate jpdate = LocalDate.parse(rs.getString("JobPostDate"));
                    String jdes = rs.getString("JobDescription");
                    boolean status = rs.getBoolean("Status");

                    CompanyDAO c = new CompanyDAO();

                    JobDTO job = new JobDTO(jid, c.getCompanybyId(cid), jreq, jname, salary, jtype, jloc, jexp, jpdate, jdes, status);
                    lst.add(job);
                }
            }
        } finally {
            closeConnection();
        }
        return lst;
    }
}
