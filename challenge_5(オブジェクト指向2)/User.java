
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
class User extends Human {
    
    public ArrayList<Integer> setCard(ArrayList<Integer> card2) {
        for(int i = 0; i<card2.size(); i++) {
            if (card2.get(i) == null) {
                break;
            } else {
                myCards.add(card2.get(i));
            }
        }
        return myCards;
    }
    
    public Integer calculation(ArrayList<Integer> myCards) {
        // 14から52までの数字を1から13に直す
        // 得点が10点より上ならエースは1
        // 10点以下なら11として扱う
        // カードの数値を得点に足す
        Integer sum = 0;
        for (int i = 0; i < myCards.size(); i++) {
            // 
            if (myCards.get(i) < 14) {
            } else if (myCards.get(i) < 27) {
                myCards.set(i, myCards.get(i) -13);
            } else if (myCards.get(i) < 40) {
                myCards.set(i, myCards.get(i) - 26);
            } else {
                myCards.set(i, myCards.get(i) -39);
            }
            
            if (myCards.get(i) == 1 && sum > 10) {
                myCards.set(i, 1);
            } else if (myCards.get(i) == 1) {
                myCards.set(i, 11);
            } else if (myCards.get(i) > 10) {
                myCards.set(i, 10);
            } 
            sum += myCards.get(i);
        }    
        return sum;
    }
    
    public Integer open(int sum) {
        return sum;
    }
    
    public boolean checkSum(int sum) {
        
        if (sum > 16) {
            return true;
        } else {
            return false;
        }
    }
}