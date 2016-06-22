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
public class jdbc_kadai9 extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            // 課題9
            out.println("<html>");
            out.println("<head>");
            out.println("<title>jdbc 課題9</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(" <form action=\"./jdbc_kadai9.jsp\" method=\"post\">\n");
            out.println("<br>" + "ID: " + "<p><input type=\"text\" name=\"txtID\"></p>\n");
            out.println("<br>" + "名前: " + "<p><input type=\"text\" name=\"txtName\"></p>\n");
            out.println("<br>" + "tell: " + "<p><input type=\"text\" name=\"txtTell\"></p>\n");
            out.println("<br>" + "年齢: " + "<p><input type=\"text\" name=\"txtAge\"></p>\n");
            out.println("<br>" + "誕生日: " + "<p><input type=\"text\" name=\"txtBirthday\"></p>\n");
            out.println("<input type=\"submit\" name=\"btnSubmit\">\n");
            out.println("</form>\n");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
