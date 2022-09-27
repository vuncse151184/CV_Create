/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.studenCV.Controller;

import com.studentCV.DAO.JobDAO;
import com.studentCV.DTO.JobDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name="SearchJobServlet", urlPatterns={"/searchJob"})
public class SearchJobServlet extends HttpServlet {

    private final String SEARCH_PAGE    = "job_listing.jsp";
    private final String ERROR_PAGE     = "job_listing.jsp";

   
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
        String url = ERROR_PAGE;
        String searchValue = request.getParameter("searchJobValue");
        String searchValueFilter = request.getParameter("selectJob");
        List<JobDTO> result = null;
        JobDAO daoJob = new JobDAO();
        try {
            System.out.println("In search servlet");
            if  (searchValue != null && searchValueFilter != null){
                if (searchValue.equals("") && (searchValueFilter.equals("") || searchValueFilter.equals("All"))) {
                    System.out.println("If empty go all");
                    result = daoJob.getAllJob();                
                } else {
                    System.out.println("If not empty search value");                
                    result = daoJob.searchByType(searchValue,searchValueFilter);               
                }
            } else {
                System.out.println("If null go all");
                result = daoJob.getAllJob();
                //likely from incomplete url
            }
            request.setAttribute("SEARCHRESULT", result);
            url = SEARCH_PAGE;
        }   catch (SQLException ex) {
            log("SearchJobServlet   _ SQL " + ex.getMessage());
        }   catch (NamingException ex) {
            log("SearchJobServlet   _ NamingException " + ex.getMessage());
        }   catch (Exception ex) {
            log("SearchJobServlet   _ Exception " + ex.getMessage());
        } 
        finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            //response.sendRedirect(url); 
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
