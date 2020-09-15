/**
* Implements the game 20 Questions
*
* @author Tishya Khanna
* GuessingGame.java
* @version 1
*/

import java.io.*;
import java.util.Scanner;

public class GuessingGame{
  public static GameTreeReader gameTree;

  /**
  * constructor for GuessingGame
  *
  * @param file String
  *
  */
  public GuessingGame(String file){
    this.gameTree=new GameTreeReader(file);
  }

  /**
  * main function of UnrestrictedGuessingGame
  *
  * @param String[] args
  *
  * @return void
  */
  public static void main(String[] args) throws FileNotFoundException {
    GuessingGame object=new GuessingGame(args[0]);
    GameTree<String> tree=gameTree.buildGameTree();
    Scanner input = new Scanner(System.in);
    BinaryTreeNode<String> currentNode;
    String yesno;
    String choice;

    System.out.println("Do you wish to play?");
    System.out.println("Enter y/n:");
    choice = input.next();  // Read user input

    /**
    * This program features my favourite
    * duck from this class
    */


    while(choice.equals("y") || choice.equals("Y")){
      /**
      * The loop runs until the user wishes
      */
      currentNode = tree.getRoot();
      System.out.println("Let's start playing!");
      System.out.println("Think of an element from [New York, Paris, Agra, South Hadley, Hyderabad, Queen, Oasis, ");
      System.out.println("The Beatles, The Smiths, The Local Train, Cage The Elephant, Guns 'n Roses, Led Zepplin, ");
      System.out.println("Pink Floyd, U2, Isabel Kadel Garcia, Unspecial Duck]");
      System.out.println(currentNode.getData());

      /**
      * The loop runs until the tree isn't empty
      * and until a leaf isn't reached
      */
      while(!currentNode.isLeaf() && !tree.isEmpty()){
        System.out.println("Enter y/n:");
        yesno = input.next();  // Read user input
        if (yesno.equals("y") || yesno.equals("Y")){
          /**
          * goes to the left child if the answer is yes
          */
          currentNode=currentNode.getLeftChild();
          if (currentNode.isLeaf()){
            /**
            * if a leaf is reached
            */
            System.out.println("Do you mean "+ currentNode.getData() + "?");
            System.out.println("Enter y/n:");
            yesno = input.next();  // Read user input
            if (yesno.equals("y") || yesno.equals("Y")){
              System.out.println("Yay!");
              System.out.println("Do you wish to play again?");
              choice = input.next();  // Read user input
            }
            else{
              System.out.println("Oh no :(");
              System.out.println("Do you wish to play again?");
              choice = input.next();  // Read user input
            }
          }
          else{
            System.out.println(currentNode.getData());
          }
        }
        else{
          /**
          * goes to the right child if the answer is no
          */
          currentNode=currentNode.getRightChild();
          if (currentNode.isLeaf()){
            /**
            * if a leaf is reached
            */
            System.out.println("Do you mean "+ currentNode.getData() + "?");
            System.out.println("Enter y/n:");
            yesno = input.next();  // Read user input
            if (yesno.equals("y") || yesno.equals("Y")){
              System.out.println("Yay!");
              System.out.println("Do you wish to play again?");
              choice = input.next();  // Read user input
            }
            else{
              System.out.println("Oh no :(");
              System.out.println("Do you wish to play again?");
              choice = input.next();  // Read user input
            }
          }
          else{
            System.out.println(currentNode.getData());
          }
        }
      }
    }
  }
}
