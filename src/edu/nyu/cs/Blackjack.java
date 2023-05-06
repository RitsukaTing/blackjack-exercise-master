package edu.nyu.cs;

import java.util.Scanner;
import java.nio.file.SecureDirectoryStream;
import java.util.Random;


/**
 * A variation of the game of Blackjack.  
 * Complete this program according to the instructions in the README.md file as well as within the given comments below.
 */
public class Blackjack {

  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {

    // complete this function according to the instructions
    Random rand = new Random();

    int pCard1 = rand.nextInt(9) + 2;
    int pCard2 = rand.nextInt(9) + 2;
    int dCard1 = rand.nextInt(9) + 2;
    int dCard2 = rand.nextInt(9) + 2;
    int total = pCard1 + pCard2;
    int totalDealer = dCard1 + dCard2;
    int truth = 0;
    
    
    System.out.println("Welcome to Blackjack!");
    System.out.println("Your cards are: " + pCard1 + " and " + pCard2);
    
    String inputMod1 = ("Your cards are: " + pCard1 + ", "  + pCard2);
    StringBuilder inputMod2 = new StringBuilder(inputMod1); 
    String dealMod1 = ("The dealer's cards are: " + dCard1 + ", "  + dCard2);
    StringBuilder dealMod2 = new StringBuilder(dealMod1); 
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Would you like to hit or stand?");


    while(true){
      String input = scanner.nextLine();
      if (input.equals("hit")) {
        int rCard = rand.nextInt(10) + 2;
        total += rCard;

        inputMod2.append(", " + rCard);
        int lastSpace = inputMod2.lastIndexOf(" ");
        inputMod2.replace(lastSpace, lastSpace + 1, " and ");
        int firstAnd = inputMod2.indexOf("and");
        if (inputMod2.length() > 27){
          inputMod2.replace(firstAnd, firstAnd + 4, "");
        }
        System.out.println("Your cards are: " + inputMod2);

        if (total > 21) { 
          System.out.println("You have bust!");
          System.out.println("Dealer wins!");
          truth += 1;
          break;
        } else if (total == 21) {
          System.out.println("You win!");
          System.out.println(dealMod2);
          truth += 1;
          break;
        }
        
      } else {
        break;
      }

    }
    while(truth < 1) {
      int rng = rand.nextInt(10);
      int rCardD = rand.nextInt(10) + 2;

      if (rng > 4) {
        totalDealer += rCardD;
        dealMod2.append(", " + rCardD);
        
        int lastSpaceD = dealMod2.lastIndexOf(" ");
        dealMod2.replace(lastSpaceD, lastSpaceD + 1, " and ");
        int firstAndD = dealMod2.indexOf("and");
        if (dealMod2.length() > 35){
          dealMod2.replace(firstAndD, firstAndD + 4, "");
        }
        System.out.println("The dealer hits.");

      } else {
        System.out.println("The dealer stands.");
        break;
      }

      if (totalDealer > 21) {
        System.out.println("The dealer has bust!");
        System.out.println(dealMod2);
        truth += 1;
        System.out.println("You win!");
        break;
      } else if (total == 21) {
        System.out.println("Dealer wins!");
        break;
      }

    }
    if (truth < 1) {
      if (inputMod2.length() <= 22) {
        System.out.println("Your cards are: " + pCard1 + " and "  + pCard2);
      } else {
        System.out.println(inputMod2);  
      }
      if (dealMod2.length() <= 28) {
        System.out.println("The dealer's cards are: " + dCard1 + " and "  + dCard2);
      } else {
        System.out.println(dealMod2);  
      }
    }
    if (truth < 1) {
      if (total == totalDealer) {
        System.out.println("Tie!");
      } else if (total > totalDealer) {
        System.out.println("You win!");
      } else {
        System.out.println("Dealer wins!");
      }

    }
    scanner.close();

  } // main

}
