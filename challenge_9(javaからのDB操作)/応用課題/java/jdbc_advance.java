/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yoshi
 */
public class jdbc_advance extends HttpServlet {

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
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            request.setCharacterEncoding("UTF-8");

            // データの受け取り
            String name = request.getParameter("txtName");
            String password = request.getParameter("txtPassword");
            
            // データベースへ接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");
            
            // データベースからユーザーの氏名とパスワードを取得
            db_st = db_con.prepareStatement("select * from user where name=? && password=?;");
            
            db_st.setString(1, name);
            db_st.setString(2, password);
            
            // SQLを実行
            db_data = db_st.executeQuery();
            
            // userテーブルに保存されたユーザーと一致したら
            // ログイン情報をセッションに格納する
            HttpSession hs = request.getSession();
            if (db_data.next()) {
              if (name.equals(db_data.getString(2)) && password.equals(db_data.getString(8))) {
                hs.setAttribute("currentUserName", name);
                hs.setAttribute("loginFlag", true);
                request.getRequestDispatcher("/successLogin.jsp").forward(request, response);
              }  
            } else {
                hs.setAttribute("loginFlag", false);
                request.getRequestDispatcher("/failureLogin.jsp").forward(request, response);
            }
            
            db_con.close();
            db_st.close();
            db_data.close();
            
        } catch (SQLException e_sql) {
            out.println("接続時にエラーが発生しました："+e_sql.toString());
        } catch (Exception e) {
            out.println("接続時にエラーが発生しました："+e.toString());
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.print(e_con.getMessage());
                }
            }
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
