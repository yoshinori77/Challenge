
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
class Dealer extends Human {
    
    // 52枚のトランプを作成
    Dealer() {
        for (int i = 1; i<53; i++) {
            cards.add(i);
        }
        this.cards = cards;        
    }
    
    public ArrayList<Integer> deal() {
        Random rand = new Random();
        ArrayList<Integer> card1 = new ArrayList<Integer>();
        card1.add(rand.nextInt(cards.size()));
        
        // 2枚目のトランプを決定する
        // 1枚目と同じならもう一度選びなおす
        int n = rand.nextInt(cards.size());
        if(card1.get(0) != n){
            card1.add(rand.nextInt(cards.size()));
        } else {
            n = rand.nextInt(cards.size());
            card1.add(rand.nextInt(cards.size()));
        }
        return  card1;
    }
    
    public ArrayList<Integer> hit(ArrayList<Integer> card) {
        // 1枚目のトランプを決定する
        Random rand = new Random();
        card.add(rand.nextInt(cards.size()));
        return  card;
    }
    
    public ArrayList<Integer> setCard(ArrayList<Integer> card1) {
        ArrayList<Integer> mycard = new ArrayList<Integer>();
        // 手札を評価して、nullでなければmyCardsに加える
        for(int i = 0; i<card1.size(); i++) {
            mycard.add(card1.get(i));
        }
        return mycard;
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
        
        // 得点が17点以上になったら終了
        // 16点以下ならカードを配る
        if (sum > 16) {
            return true;
        } else {
            return false;
        }
    }
}
