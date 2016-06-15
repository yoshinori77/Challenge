/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.*;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshi
 */
public class StandardClass extends HttpServlet {

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
            Calendar cal = Calendar.getInstance();
            cal.set(2016,0,1,0,0,0);
            Date calPast = cal.getTime();
            out.print(calPast.getTime());
            
            // 課題2
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            String sdate = sdf.format(date);
            out.print("<br>" + sdate);

            // 課題3
            Calendar c = Calendar.getInstance();
            c.set(2016,10,4,10,0,0);
            Date cFuture = c.getTime();
            out.println("<br>" + cFuture.getTime());
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String sd = s.format(cFuture);
            out.print("<br>" + sd);
            
            // 課題4
            // 2015-12-31 23:59:59のタイムスタンプから2015-1-1 00:00:00を引く
            Calendar cal2 = Calendar.getInstance();
            cal2.set(2015, 0, 1, 0, 0, 0);
            Date date2 = cal2.getTime();
            Calendar cal3 = Calendar.getInstance();
            cal3.set(2015, 11, 31, 23, 59, 59);
            Date date3 = cal3.getTime();
            int subdates = (int) (date3.getTime() - date2.getTime());
            out.print("<br>" + subdates);
            
            // 課題5
            // 氏名のバイト数と文字数
            String name = "山下慶倫";
            byte[] nameByte = name.getBytes();
            int byteToInt = ByteBuffer.wrap(nameByte).getInt();
            out.print("<br>" + byteToInt);
            int nameLength = name.length();
            out.print("<br>" + nameLength);  
            
            // 課題6
            String mailAddress = "yoshinoriyamashita123@gmail.com";
            out.print("<br>" + mailAddress.substring(22));
            
            // 課題7
            String iStudyPhp = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
            String str = iStudyPhp.replace("I", "い");
            out.print("<br>" + str.replace("U", "う"));
            
            // 課題8
            File txt = new File("C:/Users/yoshi/Documents/NetBeansProjects/WebApplication1/src/java/test.txt");
           
            //上書き書き込み
            FileWriter fw = new FileWriter(txt);
            //上書き書き込み
            fw.write("はじめまして、山下慶倫と申します\r\n");
            //上書きクローズ
            fw.close();
            
            // 課題9

            //読み込みモードでオブジェクト生成
            FileReader fr = new FileReader(txt);

            //読み込み用にバッファリング(高速化)
            BufferedReader br = new BufferedReader(fr);

            //一行読み込みして表示
            out.print("<br>" + br.readLine());

            //ファイルクローズ
            br.close();
            
            // 課題10
            File log = new File("C:/Users/yoshi/Documents/NetBeansProjects/WebApplication1/src/java/log.txt");
            
            SimpleDateFormat startFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date startTime = new Date();
            String sNow = startFormat.format(startTime);
            
            //上書き書き込み
            FileWriter wStartLog = new FileWriter(log, true);
            //上書き書き込み
            wStartLog.write(sNow + " 開始" + "\r\n");
            //上書きクローズ
            wStartLog.close();
            
            ExCollection ec = new ExCollection();
            // ランダムなマップ
            ec.showFeature(new HashMap(), "HashMap", out);
            // ソートされたマップ
            ec.showFeature(new TreeMap(), "TreeMap", out);
            // 追加された順のマップ
            ec.showFeature(new LinkedHashMap(), "LinkedHashMap", out);
            
            SimpleDateFormat endFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date endTime = new Date();
            String sEndNow = endFormat.format(endTime);
            //上書き書き込み
            FileWriter wEndLog = new FileWriter(log, true);
            //上書き書き込み
            wEndLog.write(sEndNow + " 終了" + "\r\n");
            //上書きクローズ
            wEndLog.close();
            FileReader logfile = new FileReader(log);
            //読み込み用にバッファリング(高速化)
            BufferedReader blog = new BufferedReader(logfile);
            //一行読み込みして表示
            String logread;
            while((logread = blog.readLine()) != null){
               out.print("<br>" + logread);
            }
            //ファイルクローズ
            blog.close();
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

class ExCollection {

    void showFeature(Map exMap, String s, PrintWriter out) {
        String[] tel = {"092", "060", "052", "030", "011"};  //(4)
        String[] area = {"Fukuoka", "Osaka", "Nagoya", "Tokyo", "Hokkaido"}; //(5)
        for (int i = 0; i < 5; i++) {
            exMap.put(tel[i], area[i]);  //(6)Mapに要素を追加
        }
        out.println("<br>" + s + " = " + exMap);  //(7)各Mapの要素を表示
    }   
}
