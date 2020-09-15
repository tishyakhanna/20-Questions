/**
* Implements the unrestricted game 20 Questions
*
* @author Tishya Khanna
* UnrestricedGuessingGame.java
* @version 1
*/

import java.io.*;
import java.util.Scanner;

public class UnrestrictedGuessingGame extends GuessingGame{

  /**
  * constructor for UnrestrictedGuessingGame
  *
  * @param file String
  *
  */
  public UnrestrictedGuessingGame(String file){
    super(file);
  }

  /**
  * function to learn and add a new thing
  *
  * @param node BinaryTreeNode<String>
  *
  * @return void
  */
  public static void learnThing(BinaryTreeNode<String> node){
    Scanner inp = new Scanner(System.in);
    Scanner inpLong = new Scanner(System.in);
    inpLong.useDelimiter("/n");
    System.out.println("What thing were you thinking of?");
    String thing = inpLong.nextLine();
    System.out.println("Please give me a yes/no question that would have determined your thing.");
    String question = inpLong.nextLine();
    System.out.println("Is the answer to your question yes or no?");
    System.out.println("Enter y/n:");
    String yn = inp.next();

    GameTreeNode<String> newQuestion = new GameTreeNode<String>(question);
    BinaryTreeNode<String> right=node.getRightChild();
    node.setRightChild(newQuestion);
    GameTreeNode<String> newAnswer = new GameTreeNode<String>(thing);

    if (yn.equals("y") || yn.equals("Y")){
      newQuestion.setLeftChild(newAnswer);
      newQuestion.setRightChild(right);
    }
    else {
      newQuestion.setRightChild(newAnswer);
      newQuestion.setLeftChild(right);
    }
  }

  /**
  * main function of UnrestrictedGuessingGame
  *
  * @param String[] args
  *
  * @return void
  */
  public static void main(String[] args) throws FileNotFoundException {
    UnrestrictedGuessingGame object=new UnrestrictedGuessingGame(args[0]);
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
          BinaryTreeNode<String> temp=currentNode;
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
              object.learnThing(temp);
              System.out.println("Do you wish to play again?");
              choice = input.next();  // Read user input
              break;
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
          BinaryTreeNode<String> temp=currentNode;
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
              object.learnThing(temp);
              System.out.println("Do you wish to play again?");
              choice = input.next();  // Read user input
              break;

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
