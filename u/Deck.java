// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.*;

enum Suit {
    Spade(3), Heart(2), Diamond(1), Club(0); 
    int value;
    private Suit(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}

public class Deck<T extends Card> {
    int curIdx = 0;
    List<T> cards = new ArrayList<>();
    public int remaining() {
        return cards.size() - curIdx;
    }
    public void shuffle() {
        // random algorithm
    }
    public static void main(String[] args) {};
}

abstract class Card {
    Suit suit;
    int faceValue;
    public Card(Suit s, int v) {
        suit = s;
        faceValue = v;
    }
    public int getValue() {
        return faceValue;
    }
}

class Hand<T extends Card> {
    List<T> cards = new ArrayList<>();
    public int value() {
        int sum = 0;
        for(Card c : cards) {
            sum += c.getValue();
        }
        return sum;
    }
}

class BlackJackHand extends Hand<BlackJackCard> {
    public int value() {
        int sum = 0;
        for(BlackJackCard c : cards) {
            if(c.isAce()) {
                if(11 + sum > 21) {
                    sum += 1;
                } else {
                    sum += 11;
                }
            } else {
                sum += c.getValue();
            }
        } 
        return sum;
    }
}

class BlackJackCard extends Card {
    public BlackJackCard(Suit s, int v) {
        super(s, v);
    }
    public int value() {
        if(faceValue >= 11 && faceValue <= 13) return 10;
        else return faceValue;
    }
    public boolean isAce() {
        return this.faceValue == 1;
    }
}



