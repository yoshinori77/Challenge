
import static java.lang.System.out;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
public class Class {
    public int n;
    public String str;
    public void setValues(int n, String str) {
        this.n = n;
        this.str = str;
    }
    
    public void printValues() {
        out.print(n);
        out.print(str);
    }
    
    
}

class SubClass extends Class {
    public void clearValues() {
        n = 0;
        str = "";
    }
}

