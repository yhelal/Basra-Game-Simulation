//Youssef Helal 900142332
//Ace = 1 Deuce = 2 Three= 3 Four = 4 Five = 5 Six = 6 Seven = 7 Eight = 8 Nine = 9 Ten = 10 Jack = 11 Queen =12 King = 13
public class Card {

    private int suit;  // card suit
    private int rank;  // card rank
    private final int diamond = 0;
    private final int club= 1;
    private final int heart = 2;
    private final int spade = 3;


    public Card(int suitNum, int rankNum)  //takes initial values for card suit and rank
    {
        this.suit=suitNum;
        this.rank=rankNum;
    }
    public int getSuit()  //returns suit number
    {
        return suit;
    }

    public int getRank() //returns rank number
    {
        return rank;
    }

    public boolean equals(Object x)
    {
        if(!(x instanceof Card)) // checks to see if x is an object of card
        {
            return false;
        }
        Card y;
        y= (Card) x;
        if (this.rank == y.rank && this.suit == y.suit) // checks to see if they are equal
            return true;
        else return false;
    }

    public String toString()
    {
        String cRank= "Null";
        String suitAndRank;
        if(this.rank==1)
            cRank = "Ace"; //convert rank to name
        if(this.rank==2)
            cRank = "Deuce";
        if(this.rank==3)
            cRank = "Three";
        if(this.rank==4)
            cRank = "Four";
        if(this.rank==5)
            cRank = "Five";
        if(this.rank==6)
            cRank = "Six";
        if(this.rank==7)
            cRank = "Seven";
        if(this.rank==8)
            cRank = "Eight";
        if(this.rank==9)
            cRank = "Nine";
        if(this.rank==10)
            cRank = "Ten";
        if(this.rank==11)
            cRank = "Jack";
        if(this.rank==12)
            cRank = "Queen";
        if(this.rank==13)
            cRank = "King";
        if (this.suit == diamond)
           return (cRank + " of " + "Diamonds"); //convert suit to name and return
        if(this.suit == club)
            return (cRank + " of " + "Clubs");
        if(this.suit == heart)
            return (cRank + " of " + "Hearts");
        if(this.suit == spade)
            return (cRank + " of " + "Spades");
        return "Error wrong suit number";



    }



}
