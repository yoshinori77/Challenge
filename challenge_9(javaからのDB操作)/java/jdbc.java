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
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import static jdk.nashorn.internal.objects.Global.setDate;

/**
 *
 * @author yoshi
 */
public class jdbc extends HttpServlet {

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");
            // 課題2
            // メンバーを追加
            db_st = db_con.prepareStatement("insert into profiles(profilesID, name, tell, age, birthday) values(?, ?, ?, ?, ?);");
            db_st.setInt(1, 6);
            db_st.setString(2, "山田しもん");
            db_st.setString(3, "080-1234-5678");
            db_st.setInt(4, 32);
            db_st.setDate(5,new java.sql.Date(dateFormat.parse("1988-04-01").getTime()));
            db_st.executeUpdate();
            
            // 課題3
            db_st = db_con.prepareStatement("select * from profiles;");
            db_data = db_st.executeQuery();
            while(db_data.next()) {
                out.print("ID："+db_data.getString("profilesID")+"　名前："+db_data.getString("name")+"　電話番号："+db_data.getString("tell")+"　年齢："+db_data.getString("age")+"　生年月日："+db_data.getDate("birthday")+"<br>");
            }
            
            // 課題4
            db_st = db_con.prepareStatement("select * from profiles where profilesID=?;");
            db_st.setInt(1, 1);
            db_data = db_st.executeQuery();
            while(db_data.next()) {
                out.print("<br>"+"ID："+db_data.getString("profilesID")+"　名前："+db_data.getString("name")+"　電話番号："+db_data.getString("tell")+"　年齢："+db_data.getString("age")+"　生年月日："+db_data.getDate("birthday")+"<br>");
            }
            
            // 課題5
            db_st = db_con.prepareStatement("select * from profiles where name like ?;");
            db_st.setString(1, "%茂%");
            db_data = db_st.executeQuery();
            while(db_data.next()) {
                out.print("<br>"+"ID："+db_data.getString("profilesID")+"　名前："+db_data.getString("name")+"　電話番号："+db_data.getString("tell")+"　年齢："+db_data.getString("age")+"　生年月日："+db_data.getDate("birthday")+"<br>");
            }
            
            out.print("<br>");
            
            // 課題6
            db_st = db_con.prepareStatement("delete from profiles where profilesID=?;");
            db_st.setInt(1,6);
            db_st.executeUpdate();
            
            db_st = db_con.prepareStatement("select * from profiles;");
            db_data = db_st.executeQuery();
            while(db_data.next()) {
                out.print("ID："+db_data.getString("profilesID")+"　名前："+db_data.getString("name")+"　電話番号："+db_data.getString("tell")+"　年齢："+db_data.getString("age")+"　生年月日："+db_data.getDate("birthday")+"<br>");
            }
            out.print("<br>");
            
            // 課題7
            db_st = db_con.prepareStatement("update profiles set name=?, age=?, birthday=? where profilesID=1;");
            db_st.setString(1,"松岡修造");
            db_st.setInt(2,48);
            db_st.setDate(3,new java.sql.Date(dateFormat.parse("1967-11-06").getTime()));
            db_st.executeUpdate();
            
            db_st = db_con.prepareStatement("select * from profiles;");
            db_data = db_st.executeQuery();
            while(db_data.next()) {
                out.print("ID："+db_data.getString("profilesID")+"　名前："+db_data.getString("name")+"　電話番号："+db_data.getString("tell")+"　年齢："+db_data.getString("age")+"　生年月日："+db_data.getDate("birthday")+"<br>");
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
