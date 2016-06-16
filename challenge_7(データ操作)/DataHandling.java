/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshi
 */
public class DataHandling extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // 課題1
            /* TODO output your page here. You may use following sample code. */
            
//            sample.jspへフォームする
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DataHandling</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(" <form action=\"./sample.jsp\" method=\"post\">\n");
            out.println("<br>" + "名前: " + "<p><input type=\"text\" name=\"txtName\"></p>\n");
            out.println("<br>" + "性別: " + "<p>男性<input type=\"radio\" name=\"man\">女性<input type=\"radio\" name=\"woman\"></p>\n");
            out.println("<br>" + "趣味" + "<p><textarea name=\"mulText\"></textarea></p>\n");
            out.println("<input type=\"submit\" name=\"btnSubmit\">\n");
            out.println("</form>\n");
            out.println("</body>");
            out.println("</html>");
            
            // Datahandling_5.jspへフォームする
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DataHandling</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(" <form action=\"./Datahandling_5.jsp\" method=\"post\">\n");
            out.println("<br>" + "名前: " + "<p><input type=\"text\" name=\"txtName\"></p>\n");
            out.println("<br>" + "性別: " + "<p>男性<input type=\"radio\" name=\"man\">女性<input type=\"radio\" name=\"woman\"></p>\n");
            out.println("<br>" + "趣味" + "<p><textarea name=\"mulText\"></textarea></p>\n");
            out.println("<input type=\"submit\" name=\"btnSubmit\">\n");
            out.println("</form>\n");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
