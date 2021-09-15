//Youssef Helal 900142332
import java.util.ArrayList;
import java.security.SecureRandom;
public class Deck {

    private static final int maxCards=52;

    ArrayList<Card> x;
    public Deck() //empty deck
    {
        x=new ArrayList<Card>();
    }

    public Deck(int n) // add n number of unique cards to deck
    {
        x=new ArrayList<Card>(n);
        SecureRandom rand= new SecureRandom(); // to use random numbers
        Card z;
        int r,s;       //rank and suit
        int count=0;
        while(count<n)
        {
            r= 1+ rand.nextInt(13);
            s= rand.nextInt(4);
            z= new Card(s,r);
            if(this.x.isEmpty())
            {
                this.x.add(z);
                count++;
            }

            else if(this.x.contains(z)==false) {   // checks if card already exists in deck
                this.x.add(z);
                count++;
            }

        }

    }

    public int getSize() //returns size of deck
    {
        return this.x.size();
    }

    public boolean hasCards() //checks to see if deck has cards
    {
        if(this.x.size()>0)
            return true;
        else return false;
    }

    public Card get(int pos) // get card at position pos
    {
        return this.x.get(pos);
    }

    public void add(Card c)  //add card to deck
    {
        this.x.add(c);

    }

    public void addAll(Deck other)  //add other deck to this deck and delete other deck
    {
        for (int i =0;i<other.x.size();i++)
        {
            this.x.add(other.x.get(0));
        }
        other.x.removeAll(x);
    }

    public Card removeLast()  //remove last card from deck
    {
        Card c;
        int s;
        s= (this.x.size())-1;  //size- 1 is last position
        c= this.x.get(s);
        this.x.remove(s);
        return c;
    }
    public Card removeFirst()  // remove first card from deck
    {
        Card c;
        c= this.x.get(0);
        this.x.remove(0);
        return c;

    }

    public boolean remove (Card c) //remove certain card
    {

        return this.x.remove(c);    //returns true if it exists and is removed
    }

    public void removeAll(Deck other)  //remove all cards that found in the other deck
    {
        for (int i=0;i<other.x.size();i++)
        {
            if(this.x.contains(other.x.get(i)))
                this.x.remove(other.x.get(i));
        }
    }

    public void shuffle()  //shuffle cards randomly
    {
        Card temp;
        SecureRandom rand= new SecureRandom();
        for (int i=0; i<this.x.size();i++)
        {
            int j = rand.nextInt(this.x.size());  //randomly select card
            temp =  this.x.get(i);        //swap cards
            this.x.add(i,this.x.get(j));
            this.x.add(j,temp);

        }
    }
    public Deck deal(int n)  //deal n cards into another deck
    {
        Deck second = new Deck();
        for (int i= 0; i<n;i++)
        {
            second.add(this.x.get(x.size()-1));
            this.x.remove(x.size()-1);
        }

        return second;

    }

    public boolean contains(Card card)  //check if card exists in deck
    {
        return this.x.contains(card);

    }

    public boolean containsAll(Deck other)  //check if this deck contains all cards in other deck
    {
       if (this.x.containsAll(other.x))
            return true;
       else return false;
    }

    public void sortBySuit()  //sort deck by suit
    {
        int min;
        Card temp;
        for (int i=0; i<this.x.size()-1;i++)
        {
            min = i;
            for(int j=i+1;j<this.x.size();j++)
                if(this.x.get(j).getSuit()<this.x.get(min).getSuit())
                    min=j;
            temp =  this.x.get(i);        //swap cards
            this.x.add(i,this.x.get(min));
            this.x.add(min,temp);
        }
    }

    public void sortByRank()  //sort deck by rank
    {
        int min;
        Card temp;
        for (int i=0; i<this.x.size()-1;i++)
        {
            min = i;
            for(int j=i+1;j<this.x.size();j++)
                if(this.x.get(j).getRank()<this.x.get(min).getRank())
                    min=j;
            temp =  this.x.get(i);        //swap cards
            this.x.add(i,this.x.get(min));
            this.x.add(min,temp);
        }

    }
    public void print() //print whole deck
    {
        for (int i=0;i<this.x.size();i++)
            System.out.println(this.x.get(i));
    }

    public String toString()
    {
        String s=this.get(0).toString();
        for (int i=1;i<this.x.size();i++)
            s=s+"\n"+this.x.get(i).toString();
        return s;
    }


}

