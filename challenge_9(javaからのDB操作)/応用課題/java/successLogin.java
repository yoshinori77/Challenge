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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshi
 */
public class successLogin extends HttpServlet {

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
            
            // データベースへ接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");
            
            // データベースからユーザーの氏名とパスワードを取得
            db_st = db_con.prepareStatement("insert into item(itemID, itemName, price, area) values(?, ?, ?, ?)");
            
            // データの受け取り
            String itemID = request.getParameter("txtID");
            String itemName = request.getParameter("txtName");
            String price = request.getParameter("txtPrice");
            String area = request.getParameter("txtArea");
//            String birthday = request.getParameter("txtBirthday");
//            String address = request.getParameter("txtAddress");
//            String itemID = request.getParameter("txtItemID");
//            String password = request.getParameter("txtPassword");
            
            // 型変換
            int p_itemID = Integer.parseInt(itemID);
            int p_price = Integer.parseInt(price);
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date p_birthday = (Date) dateFormat.parse(birthday);
//            int p_itemID = Integer.parseInt(itemID);
            
            // sqlのパラメータに値をセット
            db_st.setInt(1, p_itemID);
            db_st.setString(2, itemName);
            db_st.setInt(3, p_price);
            db_st.setString(4, area);
//            db_st.setDate(5, new java.sql.Date(p_birthday.getTime()));
//            db_st.setString(6, address);
//            db_st.setInt(7, p_itemID);
//            db_st.setString(8, password);
            
            // SQLを実行
            db_st.executeUpdate();
            
             request.getRequestDispatcher("/index.jsp").forward(request, response);
            
             
         db_con.close();
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
