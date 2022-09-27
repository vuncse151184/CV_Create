/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.studenCV.Controller;

import com.studentCV.DAO.JobDAO;
import com.studentCV.DTO.JobDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="JobDetailsServlet", urlPatterns={"/JobDetailsServlet"})
public class JobDetailsServlet extends HttpServlet {
    private final String JOB_DETAILS_PAGE = "job_details.jsp";

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = JOB_DETAILS_PAGE;
        String jobID = request.getParameter("jobId");

        JobDTO result;
        JobDAO daoJob = new JobDAO();
        try {
            if (jobID != null) {
                System.out.println("In show details servlet");
                int id = Integer.parseInt(jobID); 
                result = daoJob.getJobById(id);
                if (result != null) {
                    int dist = result.jobPostDate.compareTo(LocalDate.now());
                    request.setAttribute("days_until", dist);
                    request.setAttribute("DETAILS_RESULT", result);
                }            
            } else {
                //do nothing ?
                //if there is no param
            }
        }   catch (SQLException ex) {
            log("JobDetailsServlet   _ SQL " + ex.getMessage());
        }   catch (NamingException ex) {
            log("JobDetailsServlet   _ NamingException " + ex.getMessage());
        }   catch (Exception ex) {
            log("JobDetailsServlet   _ Exception " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
