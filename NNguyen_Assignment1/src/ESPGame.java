/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: You will guess colors the program is thnking of 
 * Due: 09/11/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
*/

import java.util.Scanner;

public class ESPGame {
    public static void main(String[] args){
        //final variables
        final String RED = "red",
                     GREEN = "green",
                     BLUE = "blue",
                     ORANGE = "orange",
                     YELLOW = "yellow";
        //variables
        String name, 
               description, 
               dueDate,
               color,
               actualColor = null;
               
        int correctColors = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = input.nextLine();
        System.out.print("Describe yourself: ");
        description = input.nextLine();
        System.out.print("Due date: ");
        dueDate = input.nextLine();
        System.out.println("CMSC203 Assignment1: Test your ESP skills!\n");

        for(int i = 1; i < 11; i++){
            System.out.print( "\nRound " + i + "\n"
                            + "I am thinking of a color.\n"
                            + "Is it Red, Green, Blue, Orange, or Yellow?\n"
                            + "Enter your guess: ");
            color = input.nextLine();

            int max = 5,
                min = 1,
                range = max - min + 1,
                randomNumber = (int)(Math.random() * range) + min; //I learned to generate random numbers using the Math class from AP Java.
            
            switch (randomNumber){
                case 1:
                    actualColor = RED;
                    break;
                case 2:
                    actualColor = GREEN;
                    break;
                case 3:
                    actualColor = BLUE;
                    break;
                case 4:
                    actualColor = ORANGE;
                    break;
                case 5:
                    actualColor = YELLOW;
                    break;
        }
        System.out.println("I was thinking of " + actualColor );
        if (color.toLowerCase().equals(actualColor))
            correctColors++;
    }
        System.out.println("\nGame Over\n\n" 
                         + "You guessed " + correctColors + " out of 10 correctly.\n"
                         + "User Name: " + name + "\n"
                         + "User Description: " + description + "\n"
                         + "Due Date: " + dueDate);

            
        input.close();
    }
    
}