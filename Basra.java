//Youssef Helal 900142332
import javax.swing.JOptionPane;
public class Basra {

    public static void main(String[] args) {
        final int maxCards = 52;
        Deck main = new Deck(maxCards); //initialize complete decks and player decks
        Deck player1 = new Deck();
        Deck player2 = new Deck();
        Deck floor = new Deck(); //cards on the table
        int player1Score = 0; //cards collected for score
        int player2Score = 0;
        boolean player1turn = true;
        boolean player2turn = false;
        Card jackDiamond = new Card(0, 11); //important cards
        Card jackClub = new Card(1, 11);
        Card jackHeart = new Card(2, 11);
        Card jackSpade = new Card(3, 11);
        Card SevenDiamonds = new Card(0, 7);

        player1 = main.deal(4);  //first dealing in game
        player2 = main.deal(4);
        floor = main.deal(4);
        while (floor.contains(jackDiamond) || floor.contains(jackSpade) || floor.contains(jackClub) || floor.contains(jackHeart) || floor.contains(SevenDiamonds)) {
            if (floor.contains(jackDiamond)) {
                floor.remove(jackDiamond);
                main.add(jackDiamond);
                floor = main.deal(1);
            }
            if (floor.contains(jackClub)) {
                floor.remove(jackClub);
                main.add(jackClub);
                floor = main.deal(1);
            }
            if (floor.contains(jackHeart)) {
                floor.remove(jackHeart);
                main.add(jackHeart);
                floor = main.deal(1);
            }
            if (floor.contains(jackSpade)) {
                floor.remove(jackSpade);
                main.add(jackSpade);
                floor = main.deal(1);
            }
            if (floor.contains(SevenDiamonds)) {
                floor.remove(SevenDiamonds);
                main.add(SevenDiamonds);
                floor = main.deal(1);
            }
        }

        JOptionPane.showMessageDialog(null, "Welcome to the Basra Simulator. Press Ok to view the starting hands of each player as well as the cards on the table.");
        JOptionPane.showMessageDialog(null, "Player 1 Cards: \n" + player1.toString());
        JOptionPane.showMessageDialog(null, "Player 2 Cards: \n" + player2.toString());
        JOptionPane.showMessageDialog(null, "Cards on the Table: \n" + floor.toString());
        while (main.hasCards()) {
            if (!player1.hasCards() && !player2.hasCards()) {
                player1 = main.deal(4);  //mid game dealing
                player2 = main.deal(4);
            }
            while (player1.getSize() > 0 || player2.getSize() > 0) {
                while (player1turn) {
                    int count = 0;
                    for (int i = 0; i < player1.getSize(); i++) {
                        for (int j = 0; j < floor.getSize(); j++) {
                            if (!player1turn) break;
                            else if (player1.get(i).getRank() == floor.get(j).getRank()) {
                                count++;  //number of cards on the floor that are same as current card in hand
                                floor.remove(floor.get(j));
                                break;
                            }

                        }
                        if (player1.get(i).getRank() == 11 || player1.get(i) == SevenDiamonds) //if jack remove all on floor
                        {
                            count = floor.getSize();
                            player1Score = count + 1;
                            player1.remove(player1.get(i));
                            for (int z = 0; z < floor.getSize(); i++)
                                floor.remove(floor.get(z));
                            player1turn = false;
                            player2turn = true;
                            break;
                        } else if (count > 0) {
                            player1.remove(player1.get(i));
                            player1turn = false; //don't check other cards
                            player2turn = true;
                            player1Score = count + 1;
                            if (floor.getSize() == 0)
                                player1Score += 10;
                            break;

                        } else {
                            floor = player1.deal(1); // if no similar cards just play a card
                            player1turn = false;
                            player2turn = true;

                        }

                    }

                }
                while (player2turn) {
                    int count = 0;
                    for (int i = 0; i < player2.getSize(); i++) {
                        for (int j = 0; j < floor.getSize(); j++) {
                            if (!player2turn) break;
                            else if (player2.get(i).getRank() == floor.get(j).getRank()) {
                                count++;  //number of cards on the floor that are same is current card in hand
                                floor.remove(floor.get(j));
                                break;
                            }

                        }
                        if (player2.get(i).getRank() == 11 || player2.get(i) == SevenDiamonds) //if jack remove all on floor
                        {
                            count = floor.getSize();
                            player2Score = count + 1;
                            player1.remove(player2.get(i));
                            for (int z = 0; z < floor.getSize(); i++)
                                floor.remove(floor.get(z));
                            player2turn = false;
                            player1turn = true;
                            break;
                        } else if (count > 0) {
                            player2.remove(player2.get(i));
                            player2turn = false; //don't check other cards
                            player1turn = true;
                            player2Score = count + 1;
                            if (floor.getSize() == 0)
                                player2Score += 10;
                            break;

                        } else {
                            floor = player2.deal(1); // if no similar cards just play a card
                            player2turn = false;
                            player1turn = true;

                        }

                    }

                }
                if (player1.hasCards())
                    JOptionPane.showMessageDialog(null, "Player 1 Cards: \n" + player1.toString());
                else JOptionPane.showMessageDialog(null, "Player 1 has no cards");
                if (player2.hasCards())
                    JOptionPane.showMessageDialog(null, "Player 2 Cards: \n" + player2.toString());
                else JOptionPane.showMessageDialog(null, "Player 2 has no cards");
                if (floor.hasCards())
                    JOptionPane.showMessageDialog(null, "Cards on the Table: \n" + floor.toString());
                else JOptionPane.showMessageDialog(null, "No Cards on Floor");
            }
        }


        if (player1Score > player2Score)
            JOptionPane.showMessageDialog(null, "Player 1 Wins!");
        else if (player2Score > player1Score)
            JOptionPane.showMessageDialog(null, "Player 2 Wins!");
        else JOptionPane.showMessageDialog(null, "It's a Draw!");
    }
    }

