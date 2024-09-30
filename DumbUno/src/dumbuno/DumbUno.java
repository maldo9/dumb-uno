//This is an Uno game simulation.
//Created by James Vanderhyde, 30 September 2024
//Modified by Christian Maldonado, 30 September 2024

package dumbuno;

import java.util.Random;

public class DumbUno
{
    private static final Random rng = new Random();
    
    public static void main(String[] args) 
    {
        final int maxHandSize = 12;
        final int minHandSize = 3;
        
        //Put the players into a circular linked list
        IntNode startPlayer = new IntNode(0,null);
        IntNode current = startPlayer;
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(startPlayer);
        
        //Deal every player a hand
        current = startPlayer;
        while (current.getNext() != startPlayer)
        {
            current.setData(rng.nextInt(minHandSize, maxHandSize+1));
            current = current.getNext();
        }
        
        printGame(startPlayer);
        
        //Play the game
        boolean gameOver = false;
        current = startPlayer;
        while (current.getData() > 1)
        {
            //Student implementation
            current.setData(current.getData() - 1);
            
            if (current.getData() == 1) {
                System.out.println("Uno!");
            } 
            if (current.getData() <= 0) {
                gameOver = true;
                System.out.println("I win!");
            }
            current = current.getNext();     
            printGame(startPlayer);
        }
        
        System.out.println("Game over!");
    }
            
        
    
    private static void printGame(IntNode startPlayer)
    {
        //Student implementation
         IntNode current = startPlayer;
        System.out.println("Current game state:");
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != startPlayer);
        System.out.println();
    }
    
}
