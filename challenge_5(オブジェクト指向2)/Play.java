/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshi
 */
public class Play extends HttpServlet {

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
            Dealer d = new Dealer();
            User u = new User();
            ArrayList<Integer> card1 = new ArrayList<Integer>();
            ArrayList<Integer> card2 = new ArrayList<Integer>();
            // それぞれカードを2枚ずつ配布
            card1 = d.deal();
            card2 = d.deal();
            ArrayList<Integer> dealer_card = new ArrayList<Integer>();
            ArrayList<Integer> user_card = new ArrayList<Integer>();
            // ディーラーとユーザーの手札を決定
            dealer_card = d.setCard(card1);
            user_card = u.setCard(card2);
            
            // ディーラーとユーザーの点数を計算
            int d_sum = d.calculation(dealer_card);
            int u_sum = u.calculation(user_card);
            
            // ディーラーの点数が17以上になるまで手札を増やす(5回)
            // 17以上になったら手札をopen
            for (int i = 0; i < 5; i++) {
                if (d.checkSum(d_sum)) {
                    d.open(d_sum);
                    break;
                } else {
                    d.hit(dealer_card);
                    d_sum = d.calculation(dealer_card);
                }
            }
            
            // ユーザーの点数が17以上になるまで手札を増やす(5回)
            // 17以上になったら手札をopen
            for (int i = 0; i < 5; i++) {
                if (u.checkSum(u_sum)) {
                    u.open(u_sum);
                    break;
                } else {
                    d.hit(user_card);
                    u_sum = u.calculation(user_card);
                }
            }
            
            String u_card = user_card.toString();
            out.println("あなたの手札は、、、" + u_card + "<br>");
            out.println("ディーラーの点数: " + d.open(d_sum) + "<br>");
            out.println("あなたの点数: " + u.open(u_sum) + "<br>");
            
            // ブラックジャックになった時の表示
            if (u_sum == 21 && d_sum == 21) {
                out.print("2人ともBLACK JACK!!");
            } else if (u_sum == 21) {
                out.print("BLACK JACK!! スゴイね！");
            } else if (d_sum == 21) {
                out.print("ディーラーがBLACK JACK!! ドンマイ！");
            }
            
            // 勝敗の表示
            if (d_sum < 22 && d_sum > u_sum) {
                out.println("残念... あなたの負け" + "<br>");
            } else if (u_sum > 21 && d_sum < 22) {
                out.println("残念... あなたの負け" + "<br>");
            } else if (d_sum == u_sum) {
                out.println("引き分け～" + "<br>");
            } else if (d_sum > 21 && u_sum > 21) {
                out.println("引き分け～" + "<br>");
            } else {
                out.println("やったね！ あなたの勝ち^^" + "<br>");
            }
            out.println("FINISH");
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
