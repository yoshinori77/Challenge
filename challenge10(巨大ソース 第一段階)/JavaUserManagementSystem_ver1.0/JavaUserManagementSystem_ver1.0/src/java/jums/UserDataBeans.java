/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import static java.lang.System.out;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yoshi
 */
public class UserDataBeans {
   
    private int userID;
    private String name;
    private Date birthday;
    private String tell;
    private int type;
    private String comment;
    private Timestamp newDate;
    private String year;
    private String month;
    private String day;
    
    
    public static UserDataBeans getInstance(){
        return new UserDataBeans();
    }
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getYear(){
        return year;
    }
    public void setYear(String year){
        this.year = year;
    }
    
    public String getMonth(){
        return month;
    }
    public void setMonth(String month){
        this.month = month;
    }
    
    public String getDay(){
        return day;
    }
    public void setDay(String day){
        this.day = day;
    }
    
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    
}

