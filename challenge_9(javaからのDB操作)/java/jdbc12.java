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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshi
 */
public class jdbc12 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.sql.SQLException
     * @throws java.lang.IllegalAccessException
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            request.setCharacterEncoding("UTF-8");
        
            // データの受け取り
            String name = request.getParameter("txtName");
            String age = request.getParameter("txtAge");
            String birthday = request.getParameter("txtBirthday");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");
            
            String sql = "select * from profiles where ";
            int i = 0;
            
            // パース
            String db_name = "%" + name + "%";
            Integer db_age = Integer.parseInt(age);
            
            // where句にパラメータをセット
            
            if (!name.equals("")) {
                sql += "name like ? ";
            } else {
                sql += "";
            }
            
            if (!name.equals("") && !age.equals("")) {
                sql += "and age=? ";
            } else if (!age.equals("")) {
                sql += "age=? ";
            } else {
                sql += "";
            }

            if (!name.equals("") && !age.equals("") && !birthday.equals("")) {
                sql += "and birthday=?;";
            } else if (!name.equals("") && !birthday.equals("")) {
                sql += "and birthday=?;";
            } else if (!age.equals("") && !birthday.equals("")) {
                sql += "and birthday=?;";
            } else if (!birthday.equals("")) {
                sql += "birthday=?;";
            } else {
                sql += ";";
            }
            
            db_st = db_con.prepareStatement(sql);
            
            if (!name.equals("")) {
                ++i;
                db_st.setString(i, db_name);
            }
            if (!age.equals("")) {
                ++i;
                db_st.setInt(i, db_age);
            }
            if (!birthday.equals("")) {
                ++i;
                Date db_birthday = (Date) dateFormat.parse(birthday);
                db_st.setDate(i, new java.sql.Date(db_birthday.getTime()));
            }
            
            // SQLを実行
            db_data = db_st.executeQuery();
            
            while(db_data.next()) {
                out.print("<br>"+"ID："+db_data.getString("profilesID")+"　名前："+db_data.getString("name")+"　電話番号："+db_data.getString("tell")+"　年齢："+db_data.getString("age")+"　生年月日："+db_data.getDate("birthday")+"<br>");
            }
            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(jdbc_kadai12.class.getName()).log(Level.SEVERE, null, ex);
        }
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
